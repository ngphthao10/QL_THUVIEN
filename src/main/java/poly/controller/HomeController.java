package poly.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import poly.entity.NguoiDung;
import poly.recaptcha.VerifyUtils;
import poly.service.NguoiDungService;

@Transactional
@Controller
@RequestMapping("/home/")
public class HomeController {
	
	@Autowired
	NguoiDungService nguoiDungService;
	
	@ModelAttribute
    public void addAttributes(ModelMap model) {
        if (!model.containsAttribute("nguoidunglogin")) {
            model.addAttribute("message", "");
        }
    }
	
	@RequestMapping(value="home")
	public String index(ModelMap model, HttpServletRequest request, @ModelAttribute("nguoidunglogin") NguoiDung nguoidung, HttpSession session) {
		session.setAttribute("nguoidunglogin", nguoidung);
		model.addAttribute("nguoidunglogin", nguoidung);
//		model.addAttribute("message", "Đăng nhập thành công!");
		
		if(nguoidung.getNhomNguoiDung().getId() == 3) {
			return "redirect:/user/trang-chu.htm";
		}
		return "redirect:/trangchu/index.htm";
	}
	
	@RequestMapping(value = "login", method=RequestMethod.GET)
	public String login() {
		return "account/login";
	}
	
	@RequestMapping(value = "login", method=RequestMethod.POST)
	public String login(ModelMap model, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
		boolean valid = false;
		String tendangnhap = request.getParameter("tendangnhap");
		String matkhau = request.getParameter("matkhau");
		String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
		
		// Verify recaptcha
		valid = VerifyUtils.verify(gRecaptchaResponse);
		
		NguoiDung nguoidung = nguoiDungService.getNguoiDung_LOGIN(tendangnhap, matkhau);
		boolean dangnhaplai = request.getParameter("dangnhaplai") != null;
		if (dangnhaplai == true) {
			return "redirect:/home/login.htm";
		} else {
			if (nguoidung == null) {
				model.addAttribute("message", "Sai thông tin đăng nhập!\nVui lòng kiểm tra lại!");
				return "account/login";
			}
			session.setAttribute("nguoidunglogin", nguoidung);
			if(nguoidung.getNhomNguoiDung().getId() == 3) {
				return "redirect:/user/trang-chu.htm";
			}
			return "redirect:/trangchu/index.htm";
		}
	}
	
	@RequestMapping(value="doimatkhau", method=RequestMethod.GET)
	public String changePassword() {
		return "account/doimatkhau";
	}
	
	@RequestMapping(value="doimatkhau", method=RequestMethod.POST) 
	public String changePassword(ModelMap model, HttpServletRequest request) {
		String mkHT = request.getParameter("mkHT");
		String mkMoi = request.getParameter("mkMoi");
		
		NguoiDung nguoidung = (NguoiDung) request.getSession().getAttribute("nguoidunglogin");
		
		if (mkHT.equals(nguoidung.getMatKhau()) == false) {
			model.addAttribute("message", "Sai mật khẩu hiện tại!");
			return "account/doimatkhau";
		}
		
		nguoidung.setMatKhau(mkMoi);
		nguoiDungService.editNguoiDung(nguoidung);
		model.addAttribute("showModalXN", true);
		
		return "account/doimatkhau";
		
	}
	
	
	
	
	
}
