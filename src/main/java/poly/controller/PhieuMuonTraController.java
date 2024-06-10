package poly.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import poly.dao.ThamSoDAO;
import poly.entity.CuonSach;
import poly.entity.DocGia;
import poly.entity.PhieuMuonTra;
import poly.entity.Sach;
import poly.service.CuonSachService;
import poly.service.DocGiaService;
import poly.service.PhieuMuonTraService;
import poly.service.SachService;

@Transactional
@Controller
@RequestMapping("/phieumuontra/")
public class PhieuMuonTraController {
	
	@Autowired
	PhieuMuonTraService phieuMuonTraService;
	
	@Autowired
	DocGiaService docGiaService;
	
	@Autowired
	CuonSachService cuonSachService;
	
	@Autowired
	SachService sachService;
	
	@Autowired
	ThamSoDAO thamSoDAO;

	@RequestMapping("listPhieuMuonTra")
	public String showListPhieuMuonTra(HttpServletRequest request, ModelMap model) {
		try {
			int message1 = Integer.parseInt(request.getParameter("message1"));
			model.addAttribute("message1", message1);
		} catch(Exception e) {
		}
		
		List<PhieuMuonTra> list = phieuMuonTraService.getAllPhieuMuonTra();
		PagedListHolder pagedListHolder = phieuMuonTraService.paging(list, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		model.addAttribute("songaymuontoida", thamSoDAO.getAll().getSoNgayMuonToiDa());
		return "admin/PhieuMuonTra/listPhieuMuonTra";
	}
	
	
	@RequestMapping(value = "listPhieuMuonTra", params = "insert", method = RequestMethod.GET)
	public String insertPhieuMuonTra(ModelMap model, HttpServletRequest request) {
		model.addAttribute("phieumuontra", new PhieuMuonTra());
		

		List<PhieuMuonTra> list = phieuMuonTraService.getAllPhieuMuonTra();
		PagedListHolder pagedListHolder = phieuMuonTraService.paging(list, request);
		model.addAttribute("pagedListHolder", pagedListHolder);

		return "admin/PhieuMuonTra/listPhieuMuonTra";
	}
	
	@RequestMapping(value = "listPhieuMuonTra", params = "insert", method = RequestMethod.POST)
	public String insertPhieuMuonTra(ModelMap model, @ModelAttribute("phieumuontra") PhieuMuonTra phieumuontra,
			BindingResult errors ,HttpServletRequest request) {
		LocalDate localDate = LocalDate.now();
	    java.util.Date now = new java.util.Date(java.sql.Date.valueOf(localDate).getTime());
		
		DocGia docgia = docGiaService.getDocGiaFromMaDG(phieumuontra.getDocGia().getMaDocGia());
		if (docgia == null) {
			errors.rejectValue("docGia.maDocGia", "phieumuontra", "Mã độc giả không tồn tại!");
		}
		else {
			if (docgia.getNgayHetHan().compareTo(now) < 0) {
				errors.rejectValue("docGia.maDocGia", "phieumuontra", "Thẻ độc giả đã hết hạn!");
			}
			else if (docGiaService.getSoSachDGMuon(docgia.getMaDocGia()) == thamSoDAO.getAll().getSoSachMuonToiDa()) {
				errors.rejectValue("docGia.maDocGia", "phieumuontra", "Số lượng sách đã mượn của độc giả đã đạt tối đa!");
			}
		}
		
		CuonSach cuonsach = cuonSachService.getCuonSachFromMaCS(phieumuontra.getCuonSach().getMaCuonSach());
		if (cuonsach == null ) {
			errors.rejectValue("cuonSach.maCuonSach", "phieumuontra", "Mã cuốn sách không tồn tại!");
		}
		else {
			if (cuonsach.getDaAn() == 1) {
				errors.rejectValue("cuonSach.maCuonSach", "phieumuontra", "Cuốn sách này đã ẩn!");
			}
			else if (cuonsach.getTinhTrang() == 1) {
				errors.rejectValue("cuonSach.maCuonSach", "phieumuontra", "Cuốn sách này đã được cho mượn!");
			}
		}
			
		if (errors.hasErrors()) {
			
			List<FieldError> fieldErrors = errors.getFieldErrors();
	        for (FieldError error : fieldErrors) {
	            // In ra tên trường và thông báo lỗi
	        	String fieldName = error.getField();
	            String errorMessage = error.getDefaultMessage();
	        	model.addAttribute(fieldName + "Error", errorMessage);
	        }
	        
	        List<PhieuMuonTra> list = phieuMuonTraService.getAllPhieuMuonTra();
			PagedListHolder pagedListHolder = phieuMuonTraService.paging(list, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
			model.addAttribute("message", -1);
			model.addAttribute("songaymuontoida", thamSoDAO.getAll().getSoNgayMuonToiDa());
			return "admin/PhieuMuonTra/listPhieuMuonTra";
		}
		
		cuonsach.setTinhTrang(1);
		int result1 = cuonSachService.editCuonSach(cuonsach);
		
		Sach sach = sachService.getSachFromMaSach(cuonsach.getSach1().getMaSach());
		sach.setSoLuongConLai(sach.getSoLuongConLai() - 1);
		int result3 = sachService.editSach(sach);
		
		
		phieumuontra.setDocGia(docgia);
		phieumuontra.setCuonSach(cuonsach);
		
		int result = phieuMuonTraService.insertPhieuMuonTra(phieumuontra);
		List<PhieuMuonTra> list = phieuMuonTraService.getAllPhieuMuonTra();
		PagedListHolder pagedListHolder = phieuMuonTraService.paging(list, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		model.addAttribute("songaymuontoida", thamSoDAO.getAll().getSoNgayMuonToiDa());
		model.addAttribute("message", result);

		return "admin/PhieuMuonTra/listPhieuMuonTra";
	}
	
	@RequestMapping(value="listPhieuMuonTra", params = {"edit", "id"}, method = RequestMethod.GET) 
	public String editPhieuMuonTra(HttpServletRequest request, ModelMap model,
			@RequestParam("id") int soPhieuMuonTra) {
		
		PhieuMuonTra phieumuontra = phieuMuonTraService.getPhieuMuonTraID(soPhieuMuonTra);
		long date;
        long songaytratre = 0;
        long dongiaphat = thamSoDAO.getAll().getDonGiaPhat();
        long tienphat;
        
        if (phieumuontra.getNgayTra() == null || phieumuontra.getNgayTra().equals("")) {
        	LocalDate localDate = LocalDate.now();
    	    java.util.Date now = new java.util.Date(java.sql.Date.valueOf(localDate).getTime());
    	    if (phieumuontra.getHanTra().compareTo(now) < 0) {
    	    	date = Math.abs(now.getTime() - phieumuontra.getHanTra().getTime());
    	        songaytratre = TimeUnit.DAYS.convert(date, TimeUnit.MILLISECONDS);
            	tienphat = songaytratre * dongiaphat;
            }else tienphat = 0;
        }
        else {
        	if (phieumuontra.getHanTra().compareTo(phieumuontra.getNgayTra()) < 0) {
    	    	date = Math.abs(phieumuontra.getNgayTra().getTime() - phieumuontra.getHanTra().getTime());
    	        songaytratre = TimeUnit.DAYS.convert(date, TimeUnit.MILLISECONDS);
            	tienphat = songaytratre * dongiaphat;
            } else tienphat = 0;
        }
        
        long tongnomoi = phieumuontra.getDocGia().getTongNoHienTai();
        System.out.println(tongnomoi);
		
        model.addAttribute("songaytratre", songaytratre);
        model.addAttribute("dongiaphat", dongiaphat);
        model.addAttribute("tienphat", tienphat);
        model.addAttribute("tongnomoi", tongnomoi);
        model.addAttribute("showModalEdit", true);
        model.addAttribute("phieumuontra", phieumuontra);
        
        List<PhieuMuonTra> list = phieuMuonTraService.getAllPhieuMuonTra();
		PagedListHolder pagedListHolder = phieuMuonTraService.paging(list, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		model.addAttribute("songaymuontoida", thamSoDAO.getAll().getSoNgayMuonToiDa());
        
        return "admin/PhieuMuonTra/listPhieuMuonTra";
	}
	
	@RequestMapping(value="listPhieuMuonTra", params = "edit", method = RequestMethod.POST) 
	public String editPhieuMuonTra(HttpServletRequest request, ModelMap model,
			@Valid @ModelAttribute("phieumuontra") PhieuMuonTra phieumuontra, BindingResult errors) {
		

		
		LocalDate localDate = LocalDate.now();
	    java.util.Date now = new java.util.Date(java.sql.Date.valueOf(localDate).getTime());
	    
	    Date ngaytra = phieumuontra.getNgayTra();
		Date hantra = phieumuontra.getHanTra();
		
		
		int sophieumuontra = phieumuontra.getSoPhieuMuonTra(); 
		PhieuMuonTra phieumuontra_new = phieuMuonTraService.getPhieuMuonTraID(sophieumuontra);
		DocGia docgia = docGiaService.getDocGiaFromMaDG(phieumuontra.getDocGia().getMaDocGia());
		DocGia docgia_old = phieumuontra_new.getDocGia();

		
		if (docgia == null) {
			errors.rejectValue("docGia.maDocGia", "phieumuontra", "Mã độc giả không tồn tại!");
		}
		else {
		
			long sosachdocgiamuon = docGiaService.getSoSachDGMuon(docgia.getMaDocGia());
			if (docgia.getNgayHetHan().compareTo(now) < 0) {
				errors.rejectValue("docGia.maDocGia", "phieumuontra", "Thẻ độc giả đã hết hạn!");
			}
			else if (sosachdocgiamuon == thamSoDAO.getAll().getSoSachMuonToiDa() && docgia.getId() != docgia_old.getId()) {
				errors.rejectValue("docGia.maDocGia", "phieumuontra", "Số lượng sách đã mượn của độc giả đã đạt tối đa!");
			}
		}
		CuonSach cuonsach = cuonSachService.getCuonSachFromMaCS(phieumuontra.getCuonSach().getMaCuonSach());
		CuonSach cuonsach_old = cuonSachService.getCuonSachFromMaCS(phieumuontra_new.getCuonSach().getMaCuonSach());
		if (cuonsach == null ) {
			errors.rejectValue("cuonSach.MaCuonSach", "phieumuontra", "Mã cuốn sách không tồn tại!");
		}
		else {
			if (cuonsach.getMaCuonSach().equalsIgnoreCase(cuonsach_old.getMaCuonSach()) == false) {
				if (cuonsach.getDaAn() == 1) {
					errors.rejectValue("cuonSach.MaCuonSach", "phieumuontra", "Cuốn sách này đã ẩn!");
				}
				else if (cuonsach.getTinhTrang() == 1) {
					errors.rejectValue("cuonSach.MaCuonSach", "phieumuontra", "Cuốn sách này đã được cho mượn!");
				}
				else {
					cuonsach.setTinhTrang(1);
					cuonsach_old.setTinhTrang(0);
				}
			}
		}

		if (ngaytra != null && ngaytra.compareTo(phieumuontra.getNgayMuon()) < 0) {
			errors.rejectValue("ngayTra", "phieumuontra", "Ngày trả không thể nhỏ hơn ngày mượn!");
			phieumuontra.setNgayTra(phieumuontra_new.getNgayTra());
		}
		
		if (errors.hasErrors()) {
			List<FieldError> fieldErrors = errors.getFieldErrors();
	        for (FieldError error : fieldErrors) {
	            // In ra tên trường và thông báo lỗi
	        	String fieldName = error.getField();
	            String errorMessage = error.getDefaultMessage();
	        	model.addAttribute(fieldName + "Error", errorMessage);
	        }

	        List<PhieuMuonTra> list = phieuMuonTraService.getAllPhieuMuonTra();
			PagedListHolder pagedListHolder = phieuMuonTraService.paging(list, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
			model.addAttribute("songaymuontoida", thamSoDAO.getAll().getSoNgayMuonToiDa());
			model.addAttribute("message1", -1);
			return "admin/PhieuMuonTra/listPhieuMuonTra";
		}

		
		int sotienphat = Integer.parseInt(request.getParameter("tienphat"));
		
		long date;
		int songaytratre;
		if(ngaytra != null) {
			cuonsach.setTinhTrang(0); // sach da duoc tra
		}
		else {
			cuonsach.setTinhTrang(1);
		}
		
		int tongnohientai = docgia.getTongNoHienTai() + sotienphat;
		
		if (docgia_old.getId() != docgia.getId()) {
			docgia.setTongNoHienTai(tongnohientai);
			docgia_old.setTongNoHienTai(phieumuontra.getDocGia().getTongNoHienTai());
			int result5 = docGiaService.editDocGia(docgia_old);
		}
		
		
		if (cuonsach_old.getId() != cuonsach.getId()) {
			int result4 = cuonSachService.editCuonSach(cuonsach_old);
			Sach sach = sachService.getSachFromMaSach(cuonsach.getSach1().getMaSach());
			Sach sach1 = sachService.getSachFromMaSach(cuonsach_old.getSach1().getMaSach());
			sach.setSoLuongConLai(sach.getSoLuongConLai() - 1);
			sach1.setSoLuongConLai(sach1.getSoLuongConLai() + 1);
			int result3 = sachService.editSach(sach);
			int result6 = sachService.editSach(sach1);
		}
		
		int result2 = cuonSachService.editCuonSach(cuonsach);
		int result1 = docGiaService.editDocGia(docgia);

		phieumuontra_new.setDocGia(docgia);
		phieumuontra_new.setCuonSach(cuonsach);
		phieumuontra_new.setNgayTra(ngaytra);
		phieumuontra_new.setSoTienPhat(sotienphat);
		
		int result = phieuMuonTraService.editPhieuMuonTra(phieumuontra_new);
		List<PhieuMuonTra> list = phieuMuonTraService.getAllPhieuMuonTra();
		PagedListHolder pagedListHolder = phieuMuonTraService.paging(list, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		model.addAttribute("songaymuontoida", thamSoDAO.getAll().getSoNgayMuonToiDa());
		model.addAttribute("message1", result);

		return "admin/PhieuMuonTra/listPhieuMuonTra";
	}
	
	
	@RequestMapping(value="listPhieuMuonTra", params="delete")
	public String deletePhieuMuonTra(HttpServletRequest request, ModelMap model) {
		int id = Integer.parseInt(request.getParameter("soPhieuMuon"));
		PhieuMuonTra p = phieuMuonTraService.getPhieuMuonTraID(id);
		int result = phieuMuonTraService.deletePhieuMuonTra(p);
		model.addAttribute("message2", result);
		List<PhieuMuonTra> list = phieuMuonTraService.getAllPhieuMuonTra();
		PagedListHolder pagedListHolder = phieuMuonTraService.paging(list, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/PhieuMuonTra/listPhieuMuonTra";
	}
	
	@RequestMapping(value = "listPhieuMuonTra", params = "search")
	public String filterListPhieuThu(HttpServletRequest request, ModelMap model,
			@RequestParam("keyword") String keyword) {
		List<PhieuMuonTra> list = phieuMuonTraService.getPhieuMuonTra_Search(keyword);
		PagedListHolder pagedListHolder = phieuMuonTraService.paging(list, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		model.addAttribute("songaymuontoida", thamSoDAO.getAll().getSoNgayMuonToiDa());
		return "admin/PhieuMuonTra/listPhieuMuonTra";
	}
	
	@RequestMapping(value = "listPhieuMuonTra", params = "filter")
	public String filterListPhieuThu(HttpServletRequest request, ModelMap model,
			@RequestParam("filter_date") @DateTimeFormat(pattern="dd/MM/yyyy") Date date) {
		List<PhieuMuonTra> list = phieuMuonTraService.getPhieuMuonTra_Filter(date);
		PagedListHolder pagedListHolder = phieuMuonTraService.paging(list, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		model.addAttribute("songaymuontoida", thamSoDAO.getAll().getSoNgayMuonToiDa());
		return "admin/PhieuMuonTra/listPhieuMuonTra";
	}
	
}
