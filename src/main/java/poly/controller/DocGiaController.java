package poly.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import poly.dto.DocGiaDTO;
import poly.entity.DocGia;
import poly.entity.LoaiDocGia;
import poly.entity.NguoiDung;
import poly.entity.PhieuMuonTra;
import poly.service.DocGiaService;
import poly.service.LoaiDocGiaService;
import poly.service.NguoiDungService;
import poly.service.NhomNguoiDungService;
import poly.service.PhieuMuonTraService;
import poly.service.ThamSoService;

@Controller
@Transactional
@RequestMapping("/docgia/")
public class DocGiaController {
	@Autowired
	DocGiaService docGiaService;

	@Autowired
	PhieuMuonTraService phieuMuonTraService;

	@Autowired
	NguoiDungService nguoiDungService;

	@Autowired
	LoaiDocGiaService loaiDocGiaService;
	
	@Autowired
	NhomNguoiDungService nhomNguoiDungService;
	
	@Autowired
	ThamSoService thamSoService;

	@Autowired
	SessionFactory factory;

	@RequestMapping("listDocGia")
	public String showListDocGia(HttpServletRequest request, ModelMap model) {
		int thoiHanThe = thamSoService.getThamSo().getThoiHanThe();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date ngayLapThe = java.sql.Date.valueOf(LocalDate.now());
		String formattedNgayLapThe = simpleDateFormat.format(ngayLapThe);
		model.addAttribute("ngayLapThe", formattedNgayLapThe);
		
		Date ngayHetHan = java.sql.Date.valueOf(LocalDate.now().plusDays(thoiHanThe*30));
		String formattedNgayHetHan = simpleDateFormat.format(ngayHetHan);
		model.addAttribute("ngayHetHan", formattedNgayHetHan);
		
		List<LoaiDocGia> listLDG = loaiDocGiaService.getAllLoaiDocGia();
		model.addAttribute("listLDG", listLDG);

		List<DocGia> list = docGiaService.getAllDocGia();
		PagedListHolder pagedListHolder = docGiaService.paging(list, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/docgia/listDocGia";
	}

	@RequestMapping(value="listDocGia", params = "search")
	public String searchDocGia(HttpServletRequest request, ModelMap model, @RequestParam("searchInput") String input) {
		int thoiHanThe = thamSoService.getThamSo().getThoiHanThe();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date ngayLapThe = java.sql.Date.valueOf(LocalDate.now());
		String formattedNgayLapThe = simpleDateFormat.format(ngayLapThe);
		model.addAttribute("ngayLapThe", formattedNgayLapThe);
		
		Date ngayHetHan = java.sql.Date.valueOf(LocalDate.now().plusDays(thoiHanThe*30));
		String formattedNgayHetHan = simpleDateFormat.format(ngayHetHan);
		model.addAttribute("ngayHetHan", formattedNgayHetHan);
		
		List<LoaiDocGia> listLDG = loaiDocGiaService.getAllLoaiDocGia();
		model.addAttribute("listLDG", listLDG);
		
		List<DocGia> list = docGiaService.searchDocGia(input);
		PagedListHolder pagedListHolder = docGiaService.paging(list, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/docgia/listDocGia";
	}

	@RequestMapping(value = "thongtinDG", method = RequestMethod.GET)
	public String showThongTin(HttpServletRequest request, ModelMap model, @RequestParam("id") Integer id) {
		DocGiaDTO docgiaDTO = new DocGiaDTO();
		DocGia docgia = docGiaService.getDocGiaByID(id);
		NguoiDung nguoidung = nguoiDungService.getNguoiDungByID(docgia.getNguoiDung().getId());

		docgiaDTO.setDocgia(docgia);
		docgiaDTO.setNguoidung(nguoidung);
		model.addAttribute("docgiaDTO", docgiaDTO);

		List<LoaiDocGia> listLDG = loaiDocGiaService.getAllLoaiDocGia();
		model.addAttribute("listLDG", listLDG);
		
		List<PhieuMuonTra> listSach = phieuMuonTraService.getPhieuMuonTra_IDDocGia(id);
		
		List<PhieuMuonTra> listSachDangMuon = phieuMuonTraService.getPhieuMuonTraByIDDG_DangMuon(listSach);
		model.addAttribute("listSach_DangMuon", listSachDangMuon);

		List<PhieuMuonTra> listSachDaMuon = phieuMuonTraService.getPhieuMuonTraByIDDG_DaMuon(listSach);
		int soSachDaMuon = phieuMuonTraService.soSachDaMuon(listSachDaMuon);
		model.addAttribute("soSachDaMuon", soSachDaMuon);
		
		PagedListHolder pagedListHolder = phieuMuonTraService.paging(listSachDaMuon, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		model.addAttribute("id", id);
		return "admin/docgia/thongtinDG";
	}

	@RequestMapping(value = "thongtinDG", params = { "edit", "id" }, method = RequestMethod.POST)
	public String editThongTinDG(HttpServletRequest request, ModelMap model,
			@ModelAttribute("docgiaDTO") DocGiaDTO docgiaDTO, BindingResult errors) throws ParseException {
		
		DocGia docgia = docGiaService.getDocGiaByMaDG(docgiaDTO.getDocgia().getMaDocGia());
		int id = docgia.getId();

		if (docgiaDTO.getDocgia().getTenDocGia().length() > 50) {
			errors.rejectValue("docgia.tenDocGia", "docgiaDTO", "Tên độc giả không được dài quá 50 ký tự!");
		}
		if (docgiaDTO.getDocgia().getTenDocGia().matches(".*\\d+.*")) {
			errors.rejectValue("docgia.tenDocGia", "docgiaDTO", "Tên độc giả không được chứa số!");
		}
		if (docgiaDTO.getDocgia().getTenDocGia().matches(".*[:;/{}*<>=()!.#$@_+,?-]+.*")) {
			errors.rejectValue("docgia.tenDocGia", "docgiaDTO", "Tên độc giả không được chứa ký tự đặc biệt!");
		}
		if (docgiaDTO.getDocgia().getTenDocGia().length() == 0 || docgiaDTO.getDocgia().getTenDocGia() == null) {
			errors.rejectValue("docgia.tenDocGia", "docgiaDTO", "Tên độc giả không được để trống!");
		} else {
			docgia.setTenDocGia(docgiaDTO.getDocgia().getTenDocGia());
		}
		
		int tuoiToiThieu = thamSoService.getThamSo().getTuoiToiThieu();
		int tuoiToiDa = thamSoService.getThamSo().getTuoiToiDa();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		//Lấy ngày giờ hiện tại -> format sang ngày -> ép kiểu dữ liệu Date
//		Date currentDate = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
//		 if (docgiaDTO.getDocgia().getNgaySinh() == null) {
//			 errors.rejectValue("docgia.ngaySinh", "docgiaDTO", "Ngày sinh không được để trống!");
//		 } else if(docgiaDTO.getDocgia().getNgaySinh().after(currentDate) || docgiaDTO.getDocgia().getNgaySinh().equals(currentDate)) {
//			 errors.rejectValue("docgia.ngaySinh", "docgiaDTO", "Ngày sinh không hợp lệ!");
//		 }
		
		LocalDate currentDate = LocalDate.now();
		LocalDate namtoiThieu = currentDate.minusYears(tuoiToiThieu); // Trừ đi tuổi tối thiểu 
		
		LocalDate namToiDa = currentDate.minusYears(tuoiToiDa); // Trừ đi tuổi tối đa
		
		Date toiThieuDate = Date.from(namtoiThieu.atStartOfDay(ZoneId.systemDefault()).toInstant());

		Date toiDaDate = Date.from(namToiDa.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		if (docgiaDTO.getDocgia().getNgaySinh() == null) {
		    errors.rejectValue("docgia.ngaySinh", "docgiaDTO", "Ngày sinh không được để trống hoặc không đúng định dạng!");
		} else if(docgiaDTO.getDocgia().getNgaySinh().after(toiThieuDate) || docgiaDTO.getDocgia().getNgaySinh().equals(toiThieuDate)
				|| docgiaDTO.getDocgia().getNgaySinh().before(toiDaDate) || docgiaDTO.getDocgia().getNgaySinh().equals(toiDaDate)) {
		    errors.rejectValue("docgia.ngaySinh", "docgiaDTO", "Ngày sinh không hợp lệ!");
		}
		 else {
			 docgia.setNgaySinh(docgiaDTO.getDocgia().getNgaySinh());
		 }

		if (docgiaDTO.getDocgia().getDiaChi().length() > 100) {
			errors.rejectValue("docgia.diaChi", "docgiaDTO", "Địa chỉ không được dài quá 100 ký tự!");
		} else {
			docgia.setDiaChi(docgiaDTO.getDocgia().getDiaChi());
		}

		if (docgiaDTO.getDocgia().getEmail().length() > 50) {
			errors.rejectValue("docgia.email", "docgiaDTO", "Email không được dài quá 50 ký tự!");
		} else {
			docgia.setEmail(docgiaDTO.getDocgia().getEmail());
		}

		if (errors.hasErrors()) {
			List<FieldError> fieldErrors = errors.getFieldErrors();
			for (FieldError error : fieldErrors) {
				String errorMessage = error.getDefaultMessage();
				model.addAttribute("errorMessage", errorMessage);
			}
			model.addAttribute("message", 0);
			
			DocGiaDTO errordocgiaDTO = new DocGiaDTO();
			DocGia errorDocgia = docGiaService.getDocGiaByID(id);
			NguoiDung errorNguoidung = nguoiDungService.getNguoiDungByID(docgia.getNguoiDung().getId());

			errordocgiaDTO.setDocgia(errorDocgia);
			errordocgiaDTO.setNguoidung(errorNguoidung);
			model.addAttribute("docgiaDTO", errordocgiaDTO);

			List<LoaiDocGia> listLDG = loaiDocGiaService.getAllLoaiDocGia();
			model.addAttribute("listLDG", listLDG);

			List<PhieuMuonTra> listSach = phieuMuonTraService.getPhieuMuonTra_IDDocGia(id);
			
			List<PhieuMuonTra> listSachDangMuon = phieuMuonTraService.getPhieuMuonTraByIDDG_DangMuon(listSach);
			model.addAttribute("listSach_DangMuon", listSachDangMuon);

			List<PhieuMuonTra> listSachDaMuon = phieuMuonTraService.getPhieuMuonTraByIDDG_DaMuon(listSach);
			int soSachDaMuon = phieuMuonTraService.soSachDaMuon(listSachDaMuon);
			model.addAttribute("soSachDaMuon", soSachDaMuon);
			PagedListHolder pagedListHolder = phieuMuonTraService.paging(listSachDaMuon, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
			model.addAttribute("id", docgia.getId());
			
			return "admin/docgia/thongtinDG";
		}

		int loaiDocGiaId = Integer.valueOf(request.getParameter("docgia.loaiDocGia.id"));
		docgia.setLoaiDocGia(loaiDocGiaService.getLoaiDGByID(loaiDocGiaId));

		int result = docGiaService.editDocGia(docgia);
		System.out.println(result);
		
		NguoiDung nguoidung = nguoiDungService.getNguoiDungByID(docgia.getNguoiDung().getId());

		if (result == 1) {
			nguoidung.setTenNguoiDung(docgia.getTenDocGia());
			nguoidung.setNgaySinh(docgia.getNgaySinh());
			nguoiDungService.updateNguoiDung(nguoidung);
		}

		model.addAttribute("message", result);
		
		DocGiaDTO updatedocgiaDTO = new DocGiaDTO();
		updatedocgiaDTO.setDocgia(docgia);
		updatedocgiaDTO.setNguoidung(nguoidung);
		model.addAttribute("docgiaDTO", updatedocgiaDTO);

		List<LoaiDocGia> listLDG = loaiDocGiaService.getAllLoaiDocGia();
		model.addAttribute("listLDG", listLDG);

		List<PhieuMuonTra> listSach = phieuMuonTraService.getPhieuMuonTra_IDDocGia(id);
		
		List<PhieuMuonTra> listSachDangMuon = phieuMuonTraService.getPhieuMuonTraByIDDG_DangMuon(listSach);
		model.addAttribute("listSach_DangMuon", listSachDangMuon);

		List<PhieuMuonTra> listSachDaMuon = phieuMuonTraService.getPhieuMuonTraByIDDG_DaMuon(listSach);
		int soSachDaMuon = phieuMuonTraService.soSachDaMuon(listSachDaMuon);
		model.addAttribute("soSachDaMuon", soSachDaMuon);
		PagedListHolder pagedListHolder = phieuMuonTraService.paging(listSachDaMuon, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		model.addAttribute("id", docgia.getId());

		return "admin/docgia/thongtinDG";
	}

	// @RequestMapping(value = "listDocGia", params = "insert", method =
	// RequestMethod.GET)
	// public String insertDocGia(HttpServletRequest request, ModelMap model) {
	// System.out.println("insert, get");
	// model.addAttribute("docgiaDTO", new DocGiaDTO());
	//
	// List <DocGia> list = docGiaService.getAllDocGia();
	// PagedListHolder pagedListHolder = docGiaService.paging(list, request);
	// model.addAttribute("pagedListHolder", pagedListHolder);
	// return "admin/docgia/listDocGia";
	// }

	@RequestMapping(value = "listDocGia", params = "insert", method = RequestMethod.POST)
	public String insertDocGia(HttpServletRequest request, ModelMap model, @ModelAttribute("docgia") DocGia docgia,
			BindingResult errors) throws ParseException {

		String tenDocGia = request.getParameter("docgia.tenDocGia");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String ngaySinhAsString = request.getParameter("docgia.ngaySinh");
		
		int loaiDocGiaId = Integer.valueOf(request.getParameter("docgia.loaiDocGia.id"));
		String diaChi = request.getParameter("docgia.diaChi");
		String email = request.getParameter("docgia.email");
		
		String ngayLapTheAsString = request.getParameter("docgia.ngayLapThe");
		Date ngayLapThe = simpleDateFormat.parse(ngayLapTheAsString);
		
		String ngayHetHanAsString = request.getParameter("docgia.ngayHetHan");
		Date ngayHetHan = simpleDateFormat.parse(ngayHetHanAsString);
		
		if (tenDocGia.length() > 50) {
			errors.rejectValue("tenDocGia", "docgia", "Tên độc giả không được dài quá 50 ký tự!");
		}
		if (tenDocGia.matches(".*\\d+.*")) {
			errors.rejectValue("tenDocGia", "docgia", "Tên độc giả không được chứa số!");
		}
		if (tenDocGia.matches(".*[:;/{}*<>=()!.#$@_+,?-]+.*")) {
			errors.rejectValue("tenDocGia", "docgia", "Tên độc giả không được chứa ký tự đặc biệt!");
		}
		if (tenDocGia.length() == 0 || tenDocGia == null) {
			errors.rejectValue("tenDocGia", "docgia", "Tên độc giả không được để trống!");
		}
		
		if (ngaySinhAsString == null || ngaySinhAsString.trim().isEmpty()) {
			errors.rejectValue("ngaySinh", "docgia", "Ngày sinh không được để trống!");
		}

//		//Lấy ngày giờ hiện tại -> format sang ngày -> ép kiểu dữ liệu Date
//		Date currentDate = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
//		 if (ngaySinh == null) {
//			 errors.rejectValue("ngaySinh", "docgia", "Ngày sinh không được để trống!");
//		 } else if(ngaySinh.after(currentDate) || ngaySinh.equals(currentDate)) {
//			 errors.rejectValue("ngaySinh", "docgia", "Ngày sinh không hợp lệ!");
//		 }
		
		int tuoiToiThieu = thamSoService.getThamSo().getTuoiToiThieu();
		int tuoiToiDa = thamSoService.getThamSo().getTuoiToiDa();
		
		LocalDate currentDate = LocalDate.now();
		LocalDate namtoiThieu = currentDate.minusYears(tuoiToiThieu); // Trừ đi tuổi tối thiểu 
		
		LocalDate namToiDa = currentDate.minusYears(tuoiToiDa); // Trừ đi tuổi tối đa
		
		Date toiThieuDate = Date.from(namtoiThieu.atStartOfDay(ZoneId.systemDefault()).toInstant());

		Date toiDaDate = Date.from(namToiDa.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		Date ngaySinh = null;
        if (ngaySinhAsString != null && !ngaySinhAsString.trim().isEmpty()) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            try {
                ngaySinh = formatter.parse(ngaySinhAsString);
            } catch (ParseException e) {
                errors.rejectValue("ngaySinh", "docgia", "Định dạng ngày sinh không hợp lệ!");
            }
        }

        if (ngaySinh == null) {
            errors.rejectValue("ngaySinh", "docgia", "Ngày sinh trống hoặc không hợp lệ!");
        } else { 

            if (ngaySinh.after(toiThieuDate) || ngaySinh.equals(toiThieuDate) || ngaySinh.before(toiDaDate) || ngaySinh.equals(toiDaDate)) {
                errors.rejectValue("ngaySinh", "docgia", "Ngày sinh không hợp lệ!");
            }
        }

		if (diaChi.length() > 100) {
			errors.rejectValue("diaChi", "docgia", "Địa chỉ không được dài quá 100 ký tự!");
		}

		if (email.length() > 50) {
			errors.rejectValue("email", "docgia", "Email không được dài quá 50 ký tự!");
		}
		
		if (errors.hasErrors()) {
			List<FieldError> fieldErrors = errors.getFieldErrors();
			for (FieldError error : fieldErrors) {
				String errorMessage = error.getDefaultMessage();
				model.addAttribute("errorMessage", errorMessage);
			}
			model.addAttribute("message", 0);
			
			model.addAttribute("ngayLapThe", ngayLapTheAsString);
			model.addAttribute("ngayHetHan", ngayHetHanAsString);
			
			List<LoaiDocGia> listLDG = loaiDocGiaService.getAllLoaiDocGia();
			model.addAttribute("listLDG", listLDG);

			List<DocGia> list = docGiaService.getAllDocGia();
			PagedListHolder pagedListHolder = docGiaService.paging(list, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
			
			return "admin/docgia/listDocGia";
		}
		
		int result = 0;
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			NguoiDung nguoiDung = new NguoiDung();
			nguoiDung.setTenNguoiDung(tenDocGia);
			nguoiDung.setNgaySinh(ngaySinh);
			nguoiDung.setTenDangNhap("");
			nguoiDung.setMatKhau("123");
			nguoiDung.setNhomNguoiDung(nhomNguoiDungService.getNhomNguoiDungByID(3));
			
			int resultInsertND = nguoiDungService.insertNguoiDung(nguoiDung);
			System.out.println("addND");
			System.out.println(resultInsertND);
			
			nguoiDung.setTenDangNhap("docgia" + String.valueOf(nguoiDung.getId()));
			int resultUpdateND = nguoiDungService.updateNguoiDung(nguoiDung);
			System.out.println("updateND");
			System.out.println(resultUpdateND);

			DocGia docGia = new DocGia();
			docGia.setTenDocGia(tenDocGia);
			docGia.setNgaySinh(ngaySinh);
			docGia.setDiaChi(diaChi);
			docGia.setEmail(email);
			docGia.setNgayLapThe(ngayLapThe);
			docGia.setNgayHetHan(ngayHetHan);
			docGia.setTongNoHienTai(0);
			docGia.setNguoiDung(nguoiDung);
			
			docGia.setLoaiDocGia(loaiDocGiaService.getLoaiDGByID(loaiDocGiaId));
			
			result = docGiaService.insertDocGia(docGia);
			System.out.println("addDG");
			System.out.println(result);

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		
		model.addAttribute("message", result);
		
		model.addAttribute("ngayLapThe", ngayLapTheAsString);
		model.addAttribute("ngayHetHan", ngayHetHanAsString);
		
		List<LoaiDocGia> listLDG = loaiDocGiaService.getAllLoaiDocGia();
		model.addAttribute("listLDG", listLDG);

		List<DocGia> list = docGiaService.getAllDocGia();
		PagedListHolder pagedListHolder = docGiaService.paging(list, request);
		model.addAttribute("pagedListHolder", pagedListHolder);

		return "admin/docgia/listDocGia";
	}

}
