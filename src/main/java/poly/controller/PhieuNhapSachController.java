package poly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import poly.dao.TuaSachDAO;
import poly.dto.SachDTO;
import poly.dto.TuaSachDTO;
import poly.entity.CT_PhieuNhapId;
import poly.entity.PhieuNhapSach;
import poly.entity.Sach;
import poly.entity.TacGia;
import poly.entity.TheLoai;
import poly.entity.TuaSach;
import poly.service.CT_PhieuNhapService;
import poly.service.PhieuNhapSachService;
import poly.service.SachService;

@Transactional
@Controller
@RequestMapping("/sach/phieunhapsach/")
public class PhieuNhapSachController {
	@Autowired
	PhieuNhapSachService phieuNhapSachService;
	
	@Autowired
	CT_PhieuNhapService ctPhieuNhapService;
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap model,
			@ModelAttribute("phieunhapsach") SachDTO pns) {
		List<PhieuNhapSach> pnsList = phieuNhapSachService.getAllPhieuNhap();
		PagedListHolder pagedListHolder = phieuNhapSachService.paging(pnsList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		
		
		return "admin/sach/phieunhapsach/phieunhapsach";
	}

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String search(HttpServletRequest request, ModelMap model, @RequestParam("keyword") Integer keyword,
			@ModelAttribute("phieunhapsach") SachDTO pns) {
		if (keyword > 0) {
			List<PhieuNhapSach> pnsList = phieuNhapSachService.getSearch(keyword);
			model.addAttribute("keyword", keyword);
			model.addAttribute("pnsList", pnsList);
			PagedListHolder pagedListHolder = phieuNhapSachService.paging(pnsList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
		} else {
			List<PhieuNhapSach> pnsList = phieuNhapSachService.getAllPhieuNhap();
			PagedListHolder pagedListHolder = phieuNhapSachService.paging(pnsList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
		}

		return "admin/sach/phieunhapsach/phieunhapsach";
	}
	
	@RequestMapping(value = "filter", method = RequestMethod.POST)
	public String filter(HttpServletRequest request, ModelMap model, @ModelAttribute("phieunhapsach") SachDTO pns) {
		model.addAttribute("phieunhapsach", pns);
		List<PhieuNhapSach> pnsList = phieuNhapSachService.getPnsTheoNgay(pns.getPns().getNgayNhap());
		PagedListHolder pagedListHolder = phieuNhapSachService.paging(pnsList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);

		return "admin/sach/phieunhapsach/phieunhapsach";
	}
	
	//thông tin phiếu nhập sách
	@RequestMapping(value = "index/{id}.htm", params="info", method = RequestMethod.GET)
	public String editTheLoai(ModelMap model, @ModelAttribute("phieunhapsach") SachDTO pns, @PathVariable("id") Integer id,
			HttpServletRequest request) {
		
		pns.setPns(phieuNhapSachService.getPnsTheoId(id));
		model.addAttribute("phieunhapsach", pns);
		List<PhieuNhapSach> pnsList = phieuNhapSachService.getAllPhieuNhap();
		PagedListHolder pagedListHolder = phieuNhapSachService.paging(pnsList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		
		List<CT_PhieuNhapId> ctpnList = ctPhieuNhapService.getAllPhieuNhapTheoId(id);
		model.addAttribute("dsCTPN", ctpnList);
		return "admin/sach/phieunhapsach/phieunhapsach";
	}
}
