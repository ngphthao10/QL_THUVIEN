package poly.controller;

import java.time.Year;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.MediaType;
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
import org.springframework.web.multipart.MultipartFile;

import poly.dao.*;
import poly.dto.SachDTO;
import poly.entity.*;
import poly.service.*;

@Transactional
@Controller
@RequestMapping("/sach/sach/")
public class SachController {
	@Autowired
	SachService sachService;
	
	@Autowired
	PhieuNhapSachService phieuNhapSachService;
	
	@Autowired
	CT_PhieuNhapService ctPhieuNhapService;
	
	@Autowired
	TuaSachService tuaSachService;
	
	@Autowired
	ThamSoDAO thamSoDAO;
	
	@Autowired
	ServletContext context;

	public void fillData(ModelMap model) {
		List<TuaSach> tuaSachList = tuaSachService.getAllTuaSach();
		model.addAttribute("dsTuaSach", tuaSachList);
		
		List<Sach> sachList = sachService.getAllSach();
		model.addAttribute("dsSach", sachList);
	}
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap model,
			@ModelAttribute("sachDTO") SachDTO sachDTO) {
		fillData(model);
		List<Sach> sachList = sachService.getAllSach();
		PagedListHolder pagedListHolder = sachService.paging(sachList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		
		List<CT_PhieuNhapId> ctPhieuNhapList = ctPhieuNhapService.getAllPhieuNhap();
		model.addAttribute("dsCT_PhieuNhap", ctPhieuNhapList);
		return "admin/sach/sach/sach";
	}

	@RequestMapping(value = "search")
	public String search(HttpServletRequest request, ModelMap model, @RequestParam("keyword") String keyword,
			@ModelAttribute("sachDTO") SachDTO sachDTO) {
		fillData(model);
		if (!keyword.trim().isEmpty()) {
			List<Sach> sachList = sachService.getSearch(keyword);
			model.addAttribute("keyword", keyword);
			model.addAttribute("sachList", sachList);
			PagedListHolder pagedListHolder = sachService.paging(sachList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
		} else {
			List<Sach> sachList = sachService.getAllSach();
			PagedListHolder pagedListHolder = sachService.paging(sachList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
		}

		return "admin/sach/sach/sach";
	}

	@RequestMapping(value = "filter")
	public String filter(HttpServletRequest request, ModelMap model, @ModelAttribute("sachDTO") SachDTO sachDTO,
			@RequestParam("filter") int daAn) {
		fillData(model);
		List<Sach> sachList = sachService.getAllSachTheoTinhTrang(daAn);
		PagedListHolder pagedListHolder = sachService.paging(sachList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);

		return "admin/sach/sach/sach";
	}
	
	//them sach moi
	@RequestMapping(value = "insertSachMoi")
	public String insertSachMoi(ModelMap model) {
		fillData(model);
		model.addAttribute("sachDTO", new SachDTO());
		return "admin/sach/sach/sach";
	}

	@RequestMapping(value = "insertSachMoi", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public String insertSachMoi(ModelMap model, @Valid @ModelAttribute("sachDTO") SachDTO sachDTO,
			@RequestParam("file") MultipartFile file, BindingResult errors, HttpServletRequest request) {
		fillData(model);
		// Lấy quy định khoang cach xuat ban
		ThamSo ts = thamSoDAO.getAll();
		int namHienTai = Year.now().getValue();
		int namXB = sachDTO.getSach().getNamXB();
		
		if (!String.valueOf(namXB).matches("\\d{4}")) {
	        errors.rejectValue("sach.NamXB", "sachDTO", "Nhập sai định dạng năm!");
	    }
		if (namXB > namHienTai || namXB <= namHienTai - ts.getKhoangCachXuatBan()) {
	        errors.rejectValue("sach.NamXB", "sachDTO", "Năm xuất bản sách không hợp lệ!");
	    }
		
		if(sachDTO.getSach().getNhaXB().length() > 200) {
			errors.rejectValue("sach.NhaXB", "sachDTO", "Nhà xuất bản không được quá 200 ký tự!");
		}
		
	    try {
	        int soLuongNhap = sachDTO.getCtpn().getSoLuongNhap();
	        if (soLuongNhap < 1) {
	        	errors.rejectValue("ctpn.SoLuongNhap", "sachDTO", "Số lượng nhập phải lớn hơn 0!");
	        }
	    } catch (NumberFormatException e) {
	    	errors.rejectValue("ctpn.SoLuongNhap", "sachDTO", "Số lượng không hợp lệ! Vui lòng nhập một số.");
	    }
	    
		try {
		    int donGia = sachDTO.getSach().getDonGia();
		    if (donGia < 1000) {
		        errors.rejectValue("sach.DonGia", "sachDTO", "Đơn giá phải lớn hơn 1000đ!");
		    }
		} catch (NumberFormatException e) {
		    errors.rejectValue("sach.DonGia", "sachDTO", "Đơn giá không hợp lệ! Vui lòng nhập một số.");
		}
	    if (errors.hasErrors()) {
	    	List<FieldError> fieldErrors = errors.getFieldErrors();
	    	for (FieldError error : fieldErrors) {
	    		model.addAttribute(error.getField(), error.getDefaultMessage());
	    	}
	    	List<Sach> sachList = sachService.getAllSach();
			PagedListHolder pagedListHolder = sachService.paging(sachList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
	    	model.addAttribute("message", -1);
	        return "admin/sach/sach/sach";
	    } else {
	    	int result = sachService.themSachMoi(sachDTO, file);
			model.addAttribute("message", result);
	        if (result == 1) {
	        	List<Sach> sachList = sachService.getAllSach();
	        	PagedListHolder pagedListHolder = sachService.paging(sachList, request);
	        	model.addAttribute("pagedListHolder", pagedListHolder);
	        	return "redirect:/sach/sach/insertSach.htm";
	        }
	        List<Sach> sachList = sachService.getAllSach();
        	PagedListHolder pagedListHolder = sachService.paging(sachList, request);
        	model.addAttribute("pagedListHolder", pagedListHolder);
	    }
	    
	    return "admin/sach/sach/sach";
	}
	
	//them sach da co
	@RequestMapping(value = "insertSachDaCo", method = RequestMethod.GET)
	public String insertSachDaCo(ModelMap model) {
		model.addAttribute("sachDTO", new SachDTO());
		return "admin/sach/sach/sach";
	}

	@RequestMapping(value = "insertSachDaCo", method = RequestMethod.POST)
	public String insertSachDaCo(ModelMap model, @Valid @ModelAttribute("sachDTO") SachDTO sachDTO, BindingResult errors,
	        HttpServletRequest request) {
		
		fillData(model);
		try {
	        int soLuongNhap = sachDTO.getCtpn().getSoLuongNhap();
	        if (soLuongNhap < 1) {
	        	errors.rejectValue("ctpn.SoLuongNhap", "sachDTO", "Số lượng nhập phải lớn hơn 0!");
	        }
	    } catch (NumberFormatException e) {
	    	errors.rejectValue("ctpn.SoLuongNhap", "sachDTO", "Số lượng không hợp lệ! Vui lòng nhập một số.");
	    }
		
		if (errors.hasErrors()) {
			List<FieldError> fieldErrors = errors.getFieldErrors();
	    	for (FieldError error : fieldErrors) {
	    		model.addAttribute(error.getField(), error.getDefaultMessage());
	    	}
	    	List<Sach> sachList = sachService.getAllSach();
			PagedListHolder pagedListHolder = sachService.paging(sachList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
	    	model.addAttribute("message", -2);
	        return "admin/sach/sach/sach";
	    } else {
	    	int result = sachService.themSachDaCo(sachDTO);
	        model.addAttribute("message", result);
	        if (result == 1) {
	        	List<Sach> sachList = sachService.getAllSach();
	        	PagedListHolder pagedListHolder = sachService.paging(sachList, request);
	        	model.addAttribute("pagedListHolder", pagedListHolder);
	        	return "redirect:/sach/sach/insertSach.htm";
	        }
	        List<Sach> sachList = sachService.getAllSach();
        	PagedListHolder pagedListHolder = sachService.paging(sachList, request);
        	model.addAttribute("pagedListHolder", pagedListHolder);
	    }
	    return "admin/sach/sach/sach";
	}
	
	@RequestMapping(value = "insertSach", method = RequestMethod.GET)
	public String insertReloadSachDaCo(ModelMap model, @Valid @ModelAttribute("sachDTO") SachDTO sachDTO, BindingResult errors,
	        HttpServletRequest request) {
		fillData(model);
        model.addAttribute("message", 1);
        List<Sach> sachList = sachService.getAllSach();
		PagedListHolder pagedListHolder = sachService.paging(sachList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		List<CT_PhieuNhapId> ctPhieuNhapList = ctPhieuNhapService.getAllPhieuNhap();
		model.addAttribute("dsCT_PhieuNhap", ctPhieuNhapList);
	    return "admin/sach/sach/sach";
	}
	
	//sửa sách
	@RequestMapping(value = "index/{id}.htm", params="linkEditSach", method = RequestMethod.GET)
	public String editTheLoai(ModelMap model, @ModelAttribute("sachDTO") SachDTO sachDTO, @PathVariable("id") int id,
			HttpServletRequest request) {
		fillData(model);
		sachDTO.setSach(sachService.getSachTheoId(id));
		model.addAttribute("sachDTO", sachDTO);
		List<Sach> sachList = sachService.getAllSach(); 
		PagedListHolder pagedListHolder = sachService.paging(sachList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/sach/sach/sach";
	}
		
	@RequestMapping(value = "index", params="editbtn", method = RequestMethod.POST)
	public String saveEdit(ModelMap model, @Valid @ModelAttribute("sachDTO") SachDTO sachDTO,
			@RequestParam("file") MultipartFile file, BindingResult errors, HttpServletRequest request) {
		
	    if(errors.hasErrors()) {
	    	model.addAttribute("message2", -1); 
	        return "admin/sach/sach/sach";
	    }
	    else
	    {
	    	Sach sach = sachDTO.getSach();
	    	int message = sachService.editSach(sachDTO, file);
	    	List<Sach> sachList = sachService.getAllSach();
	    	PagedListHolder pagedListHolder = sachService.paging(sachList, request);
	    	model.addAttribute("pagedListHolder", pagedListHolder);
	    	model.addAttribute("message2", message); 
	    }
	    fillData(model);
	    return "admin/sach/sach/sach";
	}
}