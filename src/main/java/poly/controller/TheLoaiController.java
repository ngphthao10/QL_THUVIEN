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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.entity.TheLoai;
import poly.service.TheLoaiService;

@Transactional
@Controller
@RequestMapping("/sach/theloai/")
public class TheLoaiController {
	@Autowired
	TheLoaiService theLoaiService;
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap model,
			@ModelAttribute("theloai") TheLoai tl) {
		
		List<TheLoai> theLoaiList = theLoaiService.getAllTheLoai();
		PagedListHolder pagedListHolder = theLoaiService.paging(theLoaiList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/sach/theloai/theloai";
	}
	
	// themtheloai
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(@ModelAttribute("theloai") TheLoai tl) {
		return "admin/sach/theloai/theloai";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertTuaSach(ModelMap model,@Valid @ModelAttribute("theloai") TheLoai tl, BindingResult errors,
	        HttpServletRequest request) {
		System.out.println(tl.getTenTheLoai());
		
		if (theLoaiService.getTLTheoTen(tl.getTenTheLoai()) != null) {
			errors.rejectValue("TenTheLoai", "theloai", "Tên thể loại này đã tồn tại!"); 
		}
		
	    if (tl.getTenTheLoai().length() > 100  || tl.getTenTheLoai().length() <= 0) {
	        errors.rejectValue("TenTheLoai", "theloai", "Tên thể loại không được để trống hoặc quá 100 ký tự!");
	    }

	    if (errors.hasErrors()) {
	    	model.addAttribute("message", -1);
	        return "sach/theloai/insertTheLoai";
	    } else {
	    	int result = theLoaiService.themTheLoai(tl);
	    	model.addAttribute("message", result);

	    	List<TheLoai> theLoaiList = theLoaiService.getAllTheLoai();
	    	PagedListHolder pagedListHolder = theLoaiService.paging(theLoaiList, request);
	    	model.addAttribute("pagedListHolder", pagedListHolder);
	    }
	    
	    return "admin/sach/theloai/theloai";
	}
	
	//sửa thể loại
	@RequestMapping(value = "index/{id}.htm", params="linkEditTL", method = RequestMethod.GET)
	public String editTheLoai(ModelMap model,@ModelAttribute("theloai") TheLoai tl, @PathVariable("id") Integer id,
			HttpServletRequest request) {
		model.addAttribute("theloai", theLoaiService.getTLTheoId(id));
		List<TheLoai> theLoaiList = theLoaiService.getAllTheLoai();
		PagedListHolder pagedListHolder = theLoaiService.paging(theLoaiList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/sach/theloai/theloai";
	}
	
	@RequestMapping(value = "index", params="editbtn", method = RequestMethod.POST)
	public String saveEdit(ModelMap model, @ModelAttribute("theloai") TheLoai tl, BindingResult errors,
			HttpServletRequest request) {
	    if (tl.getTenTheLoai().length() > 200) {
	    	errors.rejectValue("TenTheLoai", "theloai", "Tên thể loại không được dài quá 200 ký tự!");
	    }
	    
	    if(errors.hasErrors())
	        return "admin/sach/theloai/theloai";
	    else
	    {
	    	int message = theLoaiService.editTheLoai(tl);
	    	List<TheLoai> theLoaiList = theLoaiService.getAllTheLoai();
	    	PagedListHolder pagedListHolder = theLoaiService.paging(theLoaiList, request);
	    	model.addAttribute("pagedListHolder", pagedListHolder);
	    	model.addAttribute("message2", message);
	    }
	    
	    return "admin/sach/theloai/theloai";
	}
	
	//xóa thể loại
	@RequestMapping(value = "index/{id}.htm", params="linkDelete", method = RequestMethod.GET)
	public String deleteTheLoai(ModelMap model,@ModelAttribute("theloai") TheLoai tl, @PathVariable("id") Integer id,
			HttpServletRequest request) {
		model.addAttribute("theloai", theLoaiService.getTLTheoId(id));
		List<TheLoai> theLoaiList = theLoaiService.getAllTheLoai();
		PagedListHolder pagedListHolder = theLoaiService.paging(theLoaiList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/sach/theloai/theloai";
	}
	
	@RequestMapping(value = "index", params="delbtn", method = RequestMethod.POST)
	public String delEdit(ModelMap model, @ModelAttribute("theloai") TheLoai tl, BindingResult errors,
			HttpServletRequest request) {
	    
	    if(errors.hasErrors())
	        return "admin/sach/theloai/theloai";
	    else
	    {
	        int message = theLoaiService.delTheLoai(tl);
	        List<TheLoai> theLoaiList = theLoaiService.getAllTheLoai();
			PagedListHolder pagedListHolder = theLoaiService.paging(theLoaiList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
			
			model.addAttribute("message3", message); 
	    }
	    
	    return "admin/sach/theloai/theloai";
	}
}

