package poly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import poly.entity.CuonSach;
import poly.entity.Sach;
import poly.entity.TheLoai;
import poly.service.CuonSachService;

@Transactional
@Controller
@RequestMapping("/sach/cuonsach/")
public class CuonSachController {
	@Autowired
	CuonSachService cuonSachService;

	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap model,
			@ModelAttribute("cuonsach") CuonSach cs) {
		List<CuonSach> cuonSachList = cuonSachService.getAllCuonSach();
		PagedListHolder pagedListHolder = cuonSachService.paging(cuonSachList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/sach/cuonsach/cuonsach";
	}

	@RequestMapping(value = "search")
	public String search(HttpServletRequest request, ModelMap model, @RequestParam("keyword") String keyword,
			@ModelAttribute("cuonsach") CuonSach cs) {
		
		if (!keyword.trim().isEmpty()) {
			List<CuonSach> cuonSachList = cuonSachService.getSearch(keyword);
			model.addAttribute("keyword", keyword);
			model.addAttribute("cuonSachList", cuonSachList);
			PagedListHolder pagedListHolder = cuonSachService.paging(cuonSachList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
		} else {
			List<CuonSach> cuonSachList = cuonSachService.getAllCuonSach();
			PagedListHolder pagedListHolder = cuonSachService.paging(cuonSachList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
		}

		return "admin/sach/cuonsach/cuonsach";
	}

	@RequestMapping(value = "filter")	
	public String filter(HttpServletRequest request, ModelMap model, @ModelAttribute("cuonsach") CuonSach cs,
			@RequestParam("filter") int tinhTrang) {
		List<CuonSach> cuonSachList = cuonSachService.getAllCuonSachTheoTinhTrang(tinhTrang);
		PagedListHolder pagedListHolder = cuonSachService.paging(cuonSachList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);

		return "admin/sach/cuonsach/cuonsach";
	}
	
	@RequestMapping(value = "index/{id}.htm", params="linkEdit", method = RequestMethod.GET)
	public String editTheLoai(ModelMap model,@ModelAttribute("cuonsach") CuonSach cs, @PathVariable("id") Integer id,
			HttpServletRequest request) {
		model.addAttribute("cuonsach", cuonSachService.getCuonSachTheoId(id));
		List<CuonSach> cuonSachList = cuonSachService.getAllCuonSach();
		PagedListHolder pagedListHolder = cuonSachService.paging(cuonSachList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/sach/cuonsach/cuonsach";
	}
	
	@RequestMapping(value = "index", params="editbtn", method = RequestMethod.POST)
	public String saveEdit(ModelMap model, @ModelAttribute("cuonsach") CuonSach cs, BindingResult errors,
			HttpServletRequest request) {	    
	    if(errors.hasErrors())
	        return "admin/sach/cuonsach/cuonsach";
	    else
	    {
	        int message = cuonSachService.editCuonSach(cs);
	        List<CuonSach> cuonSachList = cuonSachService.getAllCuonSach();
			PagedListHolder pagedListHolder = cuonSachService.paging(cuonSachList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
			model.addAttribute("message", message); 
	    }
	    
	    return "admin/sach/cuonsach/cuonsach";
	}
}