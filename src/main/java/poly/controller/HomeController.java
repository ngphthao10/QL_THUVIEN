package poly.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import poly.entity.NguoiDung;
import poly.recaptcha.VerifyUtils;
import poly.service.NguoiDungService;
import poly.service.OTPVerifyService;

@Transactional
@Controller
//@RequestMapping("/")
public class HomeController {
	
	@Autowired
	NguoiDungService nguoiDungService;
	
	@Autowired
    private OTPVerifyService otpService;
	
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
		if(nguoidung.getNhomNguoiDung().getId() == 3) {
			return "redirect:/user/trang-chu.htm";
		}
//		model.addAttribute("userId", nguoidung.getNhomNguoiDung().getId());
		
		return "include/trangchu";
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
			return "redirect:/login.htm";
		} else {
			if (nguoidung == null) {
				model.addAttribute("message", "Sai thông tin đăng nhập!\nVui lòng kiểm tra lại!");
				return "account/login";
			}
			session.setAttribute("nguoidunglogin", nguoidung);
			session.setAttribute("docgia", 1);
			session.setAttribute("sach", 1);
			session.setAttribute("phieumuontra", 1);
			session.setAttribute("phieuthu", 1);
			session.setAttribute("nguoidung", 1);
			session.setAttribute("trangchu", 1);
			session.setAttribute("user", 1);
			session.setAttribute("quydinh", 1);
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
	
	@RequestMapping(value="doiMKMoi", method=RequestMethod.POST) 
	public String changePasswordQ(ModelMap model, HttpServletRequest request) {
		
		String mkMoi = request.getParameter("mkMoi");
		NguoiDung nguoidung = (NguoiDung) request.getSession().getAttribute("nguoidunglogin");
		
		nguoidung.setMatKhau(mkMoi);
		nguoiDungService.editNguoiDung(nguoidung);
		model.addAttribute("showModalXN", true);
		
		return "account/doiMKMoi";
		
	}
	
	
	@RequestMapping(value="xacnhanOTP", method=RequestMethod.GET)
	public String verifyOTP(HttpServletRequest request, ModelMap model) {
		
		NguoiDung nguoidung = (NguoiDung) request.getSession().getAttribute("nguoidunglogin");
		
		String email = nguoidung.getDocGia().getEmail();
		if(email == null) {
			model.addAttribute("message", "Độc giả hiện chưa có email!");
        	return "account/nhapUsername";
		}
        String otp = otpService.generateOTP();
        int result = otpService.sendOTPEmail(email, otp);
        
        if (result == 0) {
        	model.addAttribute("message", "Gửi email thất bại!");
        	return "account/nhapUsername";
        }
        
        model.addAttribute("message", "Mã OTP đã được gửi đến email của bạn");
        model.addAttribute("otp", otp);
		return "account/xacNhanOTP";
	}
	
	@RequestMapping(value="xacnhanOTP", method=RequestMethod.POST)
	public String verifyOTPPOST(HttpServletRequest request, ModelMap model, @RequestParam("otp") String otp) {
		String maOTP = request.getParameter("input1") + request.getParameter("input2") + request.getParameter("input3") + 
				request.getParameter("input4") + request.getParameter("input5") + request.getParameter("input6");
		System.out.println(otp);
		System.out.println("nHẬP " +maOTP);
		
		NguoiDung nguoidung = (NguoiDung) request.getSession().getAttribute("nguoidunglogin");
		if (!maOTP.equals(otp)) {
			model.addAttribute("message", "Mã OTP không chính xác. Gửi lại.");
			return "redirect:/xacnhanOTP.htm";
		}
		model.addAttribute("message", "Xác nhận thành công. Vui lòng nhập mật khẩu mới");
		return "account/doiMKMoi";
	}
	
	@RequestMapping(value="XNUsername", method=RequestMethod.GET) 
	public String nhapUsername() {
		return "account/nhapUsername";
	}
	
	@RequestMapping(value="XNUsername", method=RequestMethod.POST) 
	public String nhapUsername(ModelMap model, HttpServletRequest request, HttpSession session, @RequestParam("username") String username) {
		
		System.out.println(username);
		if (username == null) {
			model.addAttribute("message", "Bạn chưa nhập tên đăng nhập");
			return "account/nhapUsername";
		} else if (username.trim().equals("")) {
			model.addAttribute("message", "Bạn chưa nhập tên đăng nhập");
			return "account/nhapUsername";
		}
		NguoiDung nguoidung = nguoiDungService.getNDTheoTenDN(username);
		if (nguoidung == null) {
			model.addAttribute("message", "Tên đăng nhập không tồn tại!");
			return "account/nhapUsername";
		}
		
		session.setAttribute("nguoidunglogin", nguoidung);
		return "redirect:/xacnhanOTP.htm";
	}
	
	
}
