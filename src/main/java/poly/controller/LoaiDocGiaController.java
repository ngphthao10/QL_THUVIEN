package ptithcm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
//import javax.transaction.Transactional;

//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import ptithcm.entity.LoaiDocGia;
import ptithcm.service.LoaiDocGiaService;

@Controller
@RequestMapping("/loaidocgia/")
public class LoaiDocGiaController {
	@Autowired
	LoaiDocGiaService loaiDocGiaService;
	
	@RequestMapping("listLoaiDocGia")
	public String showListLoaiDG(HttpServletRequest request, ModelMap model) {
		List <LoaiDocGia> list = loaiDocGiaService.getAllLoaiDocGia();
		PagedListHolder pagedListHolder = loaiDocGiaService.paging(list, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "loaidocgia/listLoaiDocGia";
	}
	
//	@RequestMapping(value = "listLoaiDocGia", params="delete")
//	public String deleteLoaiDG (HttpServletRequest request, ModelMap model) {
//		int id = Integer.parseInt(request.getParameter("id"));
//		LoaiDocGia loaidocgia = loaiDocGiaService.getLoaiDGByID(id);
//		int result = loaiDocGiaService.deleteLoaiDocGia(loaidocgia);
//		model.addAttribute("message", result);
//		List<LoaiDocGia> list = loaiDocGiaService.getAllLoaiDocGia();
//		PagedListHolder pagedListHolder = loaiDocGiaService.paging(list, request);
//		model.addAttribute("pagedListHolder", pagedListHolder);
//		return "loaidocgia/listLoaiDocGia";
//	}
	
//	@RequestMapping(value = "newLoaiDocGia", params = "btnInsert")
//	public String addLoaiDG (HttpServletRequest request, ModelMap model, BindingResult errors) {
//		String input = request.getParameter("tenLDGInput");
//		if (loaiDocGiaService.getLoaiDGByName(input) != null) {
//			errors.rejectValue("name", "LoaiDocGia", "Tên loại độc giả đã tồn tại!");
//		}
//		if (input.length() > 50) {
//			errors.rejectValue("name", "LoaiDocGia", "Tên loại độc giả không được dài quá 50 ký tự!");
//		}
//		if (input == null) {
//			errors.rejectValue("name", "LoaiDocGia", "Tên loại độc giả không được để trống!");
//		}
//		if (errors.hasErrors()) {
//			return "loaidocgia/listLoaiDocGia";
//		}
//		else {
//			int result = loaiDocGiaService.addLoaiDocGia(input);
//			model.addAttribute("message", result);
//		}
//		return "loaidocgia/listLoaiDocGia";
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
}
