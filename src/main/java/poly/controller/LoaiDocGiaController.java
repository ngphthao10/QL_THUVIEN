package poly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.entity.LoaiDocGia;
import poly.service.LoaiDocGiaService;

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
		return "admin/loaidocgia/listLoaiDocGia";
	}
}
