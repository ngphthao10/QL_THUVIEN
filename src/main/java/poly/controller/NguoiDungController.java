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
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import poly.dto.TuaSachDTO;
import poly.entity.NguoiDung;
import poly.entity.NhomNguoiDung;
import poly.entity.TacGia;
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

	public void fillData(ModelMap model) {
		List<NhomNguoiDung> nndList = nhomNguoiDungService.getNhomNguoiDung();
		model.addAttribute("dsNhomNguoiDung", nndList);
	}
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap model,
			@ModelAttribute("nguoidung") NguoiDung nguoidung) {
		fillData(model);
		List<NhomNguoiDung> nndList = nhomNguoiDungService.getNhomNguoiDung();
		model.addAttribute("dsNhomNguoiDung", nndList);
		List<NguoiDung> nguoiDungList = nguoiDungService.getAllNguoiDung();
		PagedListHolder pagedListHolder = nguoiDungService.paging(nguoiDungList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		
		System.out.println("thảo");
		return "admin/quanlynguoidung/nguoidung/nguoidung";
	}
	
	@RequestMapping(value = "search")
	public String search(HttpServletRequest request, ModelMap model, @RequestParam("keyword") String keyword,
			@ModelAttribute("nguoidung") NguoiDung nguoidung) {
		fillData(model);
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

		return "admin/quanlynguoidung/nguoidung/nguoidung";
	}
	
	@RequestMapping(value = "filter")
	public String filter(HttpServletRequest request, ModelMap model, @ModelAttribute("nguoidung") NguoiDung nguoidung,
			@RequestParam("filter") int id) {
		fillData(model);
		model.addAttribute("nguoidung", nguoidung);
		List<NguoiDung> nguoiDungList = nguoiDungService.getNDTheoNND(id);
		PagedListHolder pagedListHolder = nguoiDungService.paging(nguoiDungList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);

		return "admin/quanlynguoidung/nguoidung/nguoidung";
	}
	
	// themnguoidung
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(@ModelAttribute("nguoidung") NguoiDung nguoidung) {
		return "admin/quanlynguoidung/nguoidung/nguoidung";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertTuaSach(ModelMap model,@Valid @ModelAttribute("nguoidung") NguoiDung nguoidung, BindingResult errors,
	        HttpServletRequest request) {
		fillData(model);
		if (nguoiDungService.getNDTheoTenDN(nguoidung.getTenDangNhap()) != null) {
			errors.rejectValue("tenDangNhap", "nguoidung", "Tên đăng nhập này đã tồn tại!"); 
		}
		
	    if (nguoidung.getMatKhau().length() > 10  || nguoidung.getMatKhau().length() < 3) {
	        errors.rejectValue("matKhau", "nguoidung", "Mật khẩu phải từ 3-10 ký tự!");
	    }

	    if (errors.hasErrors()) {
	    	List<FieldError> fieldErrors = errors.getFieldErrors();
	    	for (FieldError error : fieldErrors) {
	    		model.addAttribute(error.getField(), error.getDefaultMessage());
	    	}
	    	List<NguoiDung> nguoiDungList = nguoiDungService.getAllNguoiDung();
			PagedListHolder pagedListHolder = nguoiDungService.paging(nguoiDungList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
	    	model.addAttribute("message", -1);
	        return "admin/quanlynguoidung/nguoidung/nguoidung";
	    } else {
	    	int result = nguoiDungService.themNguoiDung(nguoidung);
	    	model.addAttribute("message", result);

	    	List<NguoiDung> nguoiDungList = nguoiDungService.getAllNguoiDung();
			PagedListHolder pagedListHolder = nguoiDungService.paging(nguoiDungList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
	    }
	    return "admin/quanlynguoidung/nguoidung/nguoidung";
	}
	
	//sửa nguoi dung
	@RequestMapping(value = "index/{id}.htm", params="linkEdit", method = RequestMethod.GET)
	public String edit(ModelMap model,@ModelAttribute("nguoidung") NguoiDung nguoidung, @PathVariable("id") Integer id,
			HttpServletRequest request) {
		fillData(model);
		model.addAttribute("nguoidung", nguoiDungService.getNDTheoId(id));
		List<NguoiDung> nguoiDungList = nguoiDungService.getAllNguoiDung();
		PagedListHolder pagedListHolder = nguoiDungService.paging(nguoiDungList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/quanlynguoidung/nguoidung/nguoidung";
	}
	
	@RequestMapping(value = "index", params="editbtn", method = RequestMethod.POST)
	public String saveEdit(ModelMap model, @ModelAttribute("nguoidung") NguoiDung nguoidung, BindingResult errors,
			HttpServletRequest request) {
		fillData(model);
		if (nguoiDungService.getNDTheoTenDN(nguoidung.getTenDangNhap()) != null) {
			errors.rejectValue("tenDangNhap", "nguoidung", "Tên đăng nhập này đã tồn tại!"); 
		}
		
		if (nguoidung.getMatKhau().length() > 10  || nguoidung.getMatKhau().length() < 3) {
	        errors.rejectValue("matKhau", "nguoidung", "Mật khẩu phải từ 3-10 ký tự!");
	    }

	    if (errors.hasErrors()) {
	    	List<FieldError> fieldErrors = errors.getFieldErrors();
	    	for (FieldError error : fieldErrors) {
	    		model.addAttribute(error.getField(), error.getDefaultMessage());
	    	}
	    	List<NguoiDung> nguoiDungList = nguoiDungService.getAllNguoiDung();
			PagedListHolder pagedListHolder = nguoiDungService.paging(nguoiDungList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
	    	model.addAttribute("message1", -1);
	        return "admin/quanlynguoidung/nguoidung/nguoidung";
	    }
	    else
	    {
	        int message = nguoiDungService.editNguoiDung(nguoidung);
	        List<NguoiDung> nguoiDungList = nguoiDungService.getAllNguoiDung();
			PagedListHolder pagedListHolder = nguoiDungService.paging(nguoiDungList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
			model.addAttribute("message1", message); 
	    }
	    return "admin/quanlynguoidung/nguoidung/nguoidung";
	}

	//xóa nguoi dung
	@RequestMapping(value = "index/{id}.htm", params="linkDelete", method = RequestMethod.GET)
	public String deleteTheLoai(ModelMap model,@ModelAttribute("nguoidung") NguoiDung nguoidung, @PathVariable("id") Integer id,
			HttpServletRequest request) {
		fillData(model);
		model.addAttribute("nguoidung", nguoiDungService.getNDTheoId(id));
		List<NguoiDung> nguoiDungList = nguoiDungService.getAllNguoiDung();
		PagedListHolder pagedListHolder = nguoiDungService.paging(nguoiDungList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/quanlynguoidung/nguoidung/nguoidung";
	}
	
	@RequestMapping(value = "index", params="delbtn", method = RequestMethod.POST)
	public String delEdit(ModelMap model, @ModelAttribute("nguoidung") NguoiDung nguoidung, BindingResult errors,
			HttpServletRequest request) {
		fillData(model);
	    if(errors.hasErrors())
	        return "admin/quanlynguoidung/nguoidung/nguoidung";
	    else
	    {
	        int message = nguoiDungService.delNguoiDung(nguoidung);
	        List<NguoiDung> nguoiDungList = nguoiDungService.getAllNguoiDung();
			PagedListHolder pagedListHolder = nguoiDungService.paging(nguoiDungList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
			
			model.addAttribute("message2", message); 
	    }
	    
	    return "admin/quanlynguoidung/nguoidung/nguoidung";
	}
}