package poly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import poly.dto.TuaSachDTO;
import poly.entity.NguoiDung;
import poly.entity.NhomNguoiDung;
import poly.entity.TheLoai;
import poly.entity.TuaSach;
import poly.service.NguoiDungService;
import poly.service.NhomNguoiDungService;


@Transactional
@Controller
@RequestMapping("/nguoidung/")
public class NguoiDungController {
	@Autowired
	NguoiDungService nguoiDungService;
	
	@Autowired 
	NhomNguoiDungService nhomNguoiDungService;

	
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap model,
			@ModelAttribute("nguoidung") NguoiDung nguoidung) {
		List<NguoiDung> nguoiDungList = nguoiDungService.getAllNguoiDung();
		PagedListHolder pagedListHolder = nguoiDungService.paging(nguoiDungList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		
		return "admin/nguoidung/nguoidung";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String search(HttpServletRequest request, ModelMap model, @RequestParam("keyword") String keyword,
			@ModelAttribute("nguoidung") NguoiDung nguoidung) {
		if (!keyword.trim().isEmpty()) {
			List<NguoiDung> nguoiDungList = nguoiDungService.getSearch(keyword);
			System.out.println(nguoiDungList);
			model.addAttribute("keyword", keyword);
			model.addAttribute("nguoiDungList", nguoiDungList);
			PagedListHolder pagedListHolder = nguoiDungService.paging(nguoiDungList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
		} else {
			List<NguoiDung> nguoiDungList = nguoiDungService.getAllNguoiDung();
			PagedListHolder pagedListHolder = nguoiDungService.paging(nguoiDungList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
		}

		return "admin/nguoidung/nguoidung";
	}
	
	// themnguoidung
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(@ModelAttribute("nguoidung") NguoiDung nguoidung) {
		return "admin/nguoidung/nguoidung";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertTuaSach(ModelMap model,@Valid @ModelAttribute("nguoidung") NguoiDung nguoidung, BindingResult errors,
	        HttpServletRequest request) {
		System.out.println(nguoidung.getTenNguoiDung());
		
		if (nguoiDungService.getNDTheoTenDN(nguoidung.getTenDangNhap()) != null) {
			errors.rejectValue("tenDangNhap", "nguoidung", "Tên đăng nhập này đã tồn tại!"); 
		}
		
	    if (nguoidung.getMatKhau().length() > 10  || nguoidung.getMatKhau().length() < 4) {
	        errors.rejectValue("TenTheLoai", "theloai", "Mật khẩu phải từ 4-10 ký tự!");
	    }

	    if (errors.hasErrors()) {
	    	model.addAttribute("message", -1);
	        return "admin/nguoidung/errors/insertNguoidungError";
	    } else {
	    	int result = nguoiDungService.themNguoiDung(nguoidung);
	    	model.addAttribute("message", result);

	    	List<NguoiDung> nguoiDungList = nguoiDungService.getAllNguoiDung();
			PagedListHolder pagedListHolder = nguoiDungService.paging(nguoiDungList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
	    }
	    return "admin/nguoidung/nguoidung";
	}
	
	//sửa nguoi dung
	@RequestMapping(value = "index/{id}.htm", params="linkEdit", method = RequestMethod.GET)
	public String edit(ModelMap model,@ModelAttribute("nguoidung") NguoiDung nguoidung, @PathVariable("id") Integer id,
			HttpServletRequest request) {
		model.addAttribute("nguoidung", nguoiDungService.getNDTheoId(id));
		List<NguoiDung> nguoiDungList = nguoiDungService.getAllNguoiDung();
		PagedListHolder pagedListHolder = nguoiDungService.paging(nguoiDungList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/nguoidung/nguoidung";
	}
	
	@RequestMapping(value = "index", params="editbtn", method = RequestMethod.POST)
	public String saveEdit(ModelMap model, @ModelAttribute("nguoidung") NguoiDung nguoidung, BindingResult errors,
			HttpServletRequest request) {
	    
	    if(errors.hasErrors())
	        return "admin/nguoidung/nguoidung";
	    else
	    {
	        int message = nguoiDungService.editNguoiDung(nguoidung);
	        List<NguoiDung> nguoiDungList = nguoiDungService.getAllNguoiDung();
			PagedListHolder pagedListHolder = nguoiDungService.paging(nguoiDungList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
			
			model.addAttribute("message1", message); 
	    }
	    return "admin/nguoidung/nguoidung";
	}

	//xóa nguoi dung
	@RequestMapping(value = "index/{id}.htm", params="linkDelete", method = RequestMethod.GET)
	public String deleteTheLoai(ModelMap model,@ModelAttribute("nguoidung") NguoiDung nguoidung, @PathVariable("id") Integer id,
			HttpServletRequest request) {
		model.addAttribute("nguoidung", nguoiDungService.getNDTheoId(id));
		List<NguoiDung> nguoiDungList = nguoiDungService.getAllNguoiDung();
		PagedListHolder pagedListHolder = nguoiDungService.paging(nguoiDungList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/nguoidung/nguoidung";
	}
	
	@RequestMapping(value = "index", params="delbtn", method = RequestMethod.POST)
	public String delEdit(ModelMap model, @ModelAttribute("nguoidung") NguoiDung nguoidung, BindingResult errors,
			HttpServletRequest request) {
	    
	    if(errors.hasErrors())
	        return "admin/nguoidung/nguoidung";
	    else
	    {
	        int message = nguoiDungService.delNguoiDung(nguoidung);
	        List<NguoiDung> nguoiDungList = nguoiDungService.getAllNguoiDung();
			PagedListHolder pagedListHolder = nguoiDungService.paging(nguoiDungList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
			
			model.addAttribute("message2", message); 
	    }
	    
	    return "admin/nguoidung/nguoidung";
	}
}