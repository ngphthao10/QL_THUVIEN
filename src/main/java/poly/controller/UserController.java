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
import org.springframework.web.bind.annotation.RequestParam;

import poly.dto.DocGiaDTO;
import poly.dto.SachDTO;
import poly.entity.*;
import poly.service.*;


@Transactional
@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	DocGiaService docGiaService;
	
	@Autowired
	SachService sachService;
	
	@Autowired
	TheLoaiService theLoaiService;
	
	@Autowired
	PhieuMuonTraService phieuMuonTraService;
	
	
	public void fillData(ModelMap model) {
		List<TheLoai> theLoaiList = theLoaiService.getAllTheLoai();
		model.addAttribute("dsTheLoai", theLoaiList);
	}
	
	@RequestMapping(value = "trang-chu", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap model, @ModelAttribute("docgia") DocGia dg) {
		NguoiDung nguoidung = (NguoiDung) request.getSession().getAttribute("nguoidunglogin");
		DocGia docGia = docGiaService.getDocGiaTheoIdNguoiDung(nguoidung.getId());
		model.addAttribute("docgia", docGia);
		model.addAttribute("nguoidunglogin", nguoidung);
		return "user/trangchu";
	}
	
	@RequestMapping(value = "tra-cuu", method = RequestMethod.GET)
	public String traCuu(HttpServletRequest request, ModelMap model, @ModelAttribute("sach") Sach sach) {
		fillData(model);
		List<Sach> sachList = sachService.getAllSachChoUser();
		PagedListHolder pagedListHolder = sachService.paging(sachList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "user/tracuusach";
	}
	
	@RequestMapping(value = "tra-cuu/filterTL")
	public String filterTL(HttpServletRequest request, ModelMap model, @ModelAttribute("sach") Sach sach,
			@RequestParam("filter") int idTL) {
		fillData(model);
		System.out.println(idTL);
		List<Sach> sachList = sachService.getAllSachTheoTheLoai(idTL);
		PagedListHolder pagedListHolder = sachService.paging(sachList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);

		return "user/tracuusach";
	}
	
	@RequestMapping(value = "tra-cuu/filterTT")
	public String filterTT(HttpServletRequest request, ModelMap model, @ModelAttribute("sach") Sach sach,
			@RequestParam("filterSL") int slConLai) {
		fillData(model);
		System.out.println(slConLai);
		List<Sach> sachList = sachService.getAllSachTheoSLCL(slConLai);
		PagedListHolder pagedListHolder = sachService.paging(sachList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		
		return "user/tracuusach";
	}
	
	@RequestMapping(value = "tra-cuu/search")
	public String search(HttpServletRequest request, ModelMap model, @RequestParam("keyword") String keyword,
			@ModelAttribute("sach") Sach sach) {
		fillData(model);
		if (!keyword.trim().isEmpty()) {
			List<Sach> sachList = sachService.getSearchChoUser(keyword);
			model.addAttribute("keyword", keyword);
			model.addAttribute("sachList", sachList);
			PagedListHolder pagedListHolder = sachService.paging(sachList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
		} else {
			List<Sach> sachList = sachService.getAllSach();
			PagedListHolder pagedListHolder = sachService.paging(sachList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
		}

		return "user/tracuusach";
	}
	
//	@RequestMapping(value="sachdamuon")
//	public String daMuon(HttpServletRequest request, ModelMap model, @ModelAttribute("nguoidung") NguoiDung nguoidung) {
//		//load table lên
//		DocGia docGia = docGiaService.getDocGiaTheoIdNguoiDung(nguoidung.getId());
//		List<PhieuMuonTra> list = get
//		model.addAttribute("docgia", docGia);
//		return "user/sachdamuon";
//	}
	
	@RequestMapping(value = "sachdamuon")
	public String daMuon(HttpServletRequest request, ModelMap model) {

		NguoiDung nguoidung = (NguoiDung) request.getSession().getAttribute("nguoidunglogin");
		DocGia docGia = docGiaService.getDocGiaTheoIdNguoiDung(nguoidung.getId());
		
		List<PhieuMuonTra> listSach = phieuMuonTraService.getPhieuMuonTra_IDDocGia(docGia.getId());
		
		List<PhieuMuonTra> listSachDangMuon = phieuMuonTraService.getPhieuMuonTraByIDDG_DangMuon(listSach);
		model.addAttribute("listSach_DangMuon", listSachDangMuon);

		List<PhieuMuonTra> listSachDaMuon = phieuMuonTraService.getPhieuMuonTraByIDDG_DaMuon(listSach);
		int soSachDaMuon = phieuMuonTraService.soSachDaMuon(listSachDaMuon);
		model.addAttribute("soSachDaMuon", soSachDaMuon);
		
		PagedListHolder pagedListHolder = phieuMuonTraService.paging(listSachDaMuon, request);
		model.addAttribute("pagedListHolder", pagedListHolder);

		if (listSachDangMuon.size()==0 && pagedListHolder.getPageList().size()==0) {
			model.addAttribute("message", -1);
		}
//		model.addAttribute("id", id);
		return "user/sachdamuon";
	}

}	