package poly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.entity.NguoiDung;
import poly.entity.NhomNguoiDung;
import poly.service.NhomNguoiDungService;

@Transactional
@Controller
@RequestMapping("/nhomnguoidung/")
public class NhomNguoiDungController {
	@Autowired 
	NhomNguoiDungService nhomNguoiDungService;

	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap model,
			@ModelAttribute("nguoidung") NguoiDung nguoidung) {
		List<NhomNguoiDung> nguoiDungList = nhomNguoiDungService.getNhomNguoiDung();
		model.addAttribute("nguoiDungList", nguoiDungList);
		
		return "admin/quanlynguoidung/nhomnguoidung/nhomnguoidung";
	}
}