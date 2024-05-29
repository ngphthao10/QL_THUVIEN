package poly.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import poly.entity.DocGia;
import poly.entity.PhieuThu;
import poly.service.DocGiaService;
import poly.service.PhieuThuService;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;


@Transactional
@Controller
@RequestMapping("/phieuthu/")
public class PhieuThuController {
	
	@Autowired
	SessionFactory factory;
	
	@Autowired
	PhieuThuService phieuThuService;
	
	@Autowired
	DocGiaService docGiaService;
	
	@RequestMapping("listPhieuThu")
	public String showListPhieuThu(HttpServletRequest request, ModelMap model) {
		System.out.println("minh thu ne");
		try { 	
			int message1 = Integer.parseInt(request.getParameter("message1"));
			model.addAttribute("message1", message1);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		List<PhieuThu> list = phieuThuService.getAllPhieuThu();
		PagedListHolder pagedListHolder = phieuThuService.paging(list, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		
		return "admin/PhieuThu/listPhieuThu";
	}
	
	@RequestMapping(value = "listPhieuThu", params = "insert", method = RequestMethod.GET)
	public String insertPhieuThu(ModelMap model, HttpServletRequest request) {
		
		System.out.println("minh thu hahaha");
		model.addAttribute("phieuthu", new PhieuThu());
		model.addAttribute("showModalInsert", true);
		
		List<PhieuThu> list = phieuThuService.getAllPhieuThu();
		PagedListHolder pagedListHolder = phieuThuService.paging(list, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		
		return "admin/PhieuThu/listPhieuThu";
	}
	
	@RequestMapping(value = "listPhieuThu", params = "insert", method = RequestMethod.POST)
	public String insertPhieuThu(ModelMap model, @Valid @ModelAttribute("phieuthu") PhieuThu phieuthu,
			BindingResult errors, HttpServletRequest request) {
		System.out.println("hehehehe");
		
		PhieuThu phieuthu_new = new PhieuThu();
		int tongnohientai = -1;
		
		String maDG = phieuthu.getDocGia().getMaDocGia();
		DocGia docgia = docGiaService.getDocGiaFromMaDG(maDG);
		if (docgia == null) 
			errors.rejectValue("docGia.maDocGia", "phieuthu", "Mã độc giả không tồn tại!");
		else  {
			if(docgia.getTongNoHienTai() == 0) {
				errors.rejectValue("docGia.maDocGia", "phieuthu", "Độc giả này hiện không có tiền nợ!");
			}
			tongnohientai = docgia.getTongNoHienTai();
		}
		
		Integer sotienthu = Integer.valueOf(request.getParameter("soTienThu"));
		if (sotienthu <= 0) 
			errors.rejectValue("soTienThu", "phieuthu", "Số tiền thu phải lớn hơn 0!");
		else {
			if(tongnohientai < sotienthu && tongnohientai != -1)
				errors.rejectValue("soTienThu", "phieuthu", "Số tiền thu vượt quá số nợ hiện tại!");
		}

		if (errors.hasErrors()) {
			
			List<FieldError> fieldErrors = errors.getFieldErrors();
	        for (FieldError error : fieldErrors) {
	            // In ra tên trường và thông báo lỗi
	        	String fieldName = error.getField();
	            String errorMessage = error.getDefaultMessage();
	        	model.addAttribute(fieldName + "Error", errorMessage);
	            System.out.println("Field: " + fieldName + ", Error: " + errorMessage);
	        }
	        
	        List<PhieuThu> list = phieuThuService.getAllPhieuThu();
			PagedListHolder pagedListHolder = phieuThuService.paging(list, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
			model.addAttribute("message", -1);
			return "admin/PhieuThu/listPhieuThu";
		}
		
		docgia.setTongNoHienTai(docgia.getTongNoHienTai() - phieuthu.getSoTienThu());
		int result1 = docGiaService.editDocGia(docgia);
		System.out.println(result1);

		phieuthu_new.setDocGia(docgia);
		phieuthu_new.setNgayLap(phieuthu.getNgayLap());
		phieuthu_new.setSoTienThu(sotienthu);
		
		int result = phieuThuService.insertPhieuThu(phieuthu_new);
		List<PhieuThu> list = phieuThuService.getAllPhieuThu();
		PagedListHolder pagedListHolder = phieuThuService.paging(list, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		model.addAttribute("message", result);
		return "admin/PhieuThu/listPhieuThu"; 	
	}
	
	@RequestMapping(value="listPhieuThu", params="delete")
	public String deletePhieuThu(HttpServletRequest request, ModelMap model) {
		System.out.println("huhuhuhu");
		int id = Integer.parseInt(request.getParameter("soPhieuThu"));
		PhieuThu pt = phieuThuService.getPhieuThuByID(id);
		int result = phieuThuService.deletePhieuThu(pt);
		model.addAttribute("message2", result);
		List<PhieuThu> list = phieuThuService.getAllPhieuThu();
		PagedListHolder pagedListHolder = phieuThuService.paging(list, request);
		model.addAttribute("pagedListHolder", pagedListHolder);	
		return "admin/PhieuThu/listPhieuThu";
	}
	
	@RequestMapping("searchPhieuThu")
	public String filterListPhieuThu(HttpServletRequest request, ModelMap model,
			@RequestParam("keyword") String keyword) {
		List<PhieuThu> list = phieuThuService.getPhieuThu_Search(keyword);
		PagedListHolder pagedListHolder = phieuThuService.paging(list, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/PhieuThu/listPhieuThu";
	}
	
	@RequestMapping(value="listPhieuThu", params = {"edit", "id"}, method = RequestMethod.GET)
	public String editPhieuThu(HttpServletRequest request, ModelMap model, @RequestParam("id") int soPhieuThu) {
		System.out.println("ahehehe");
		
		PhieuThu phieuthu =  phieuThuService.getPhieuThuByID(soPhieuThu);
		List<PhieuThu> list = phieuThuService.getAllPhieuThu();
		PagedListHolder pagedListHolder = phieuThuService.paging(list, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		
		model.addAttribute("phieuthu", phieuthu);
		model.addAttribute("showModal", true);
		return "admin/PhieuThu/listPhieuThu";
	}
	
	@RequestMapping(value = "listPhieuThu", params = "edit", method = RequestMethod.POST)
	public String editPhieuThu(HttpServletRequest request, ModelMap model, 
			@RequestParam("soPhieuThu") int soPhieuThu, 
			@ModelAttribute("phieuthu") PhieuThu phieuthu,BindingResult errors) {
		
		int tongnohientai = -1;
		int tongnomoi = -1;
		PhieuThu phieuthu_new = phieuThuService.getPhieuThuByID(soPhieuThu);
		System.out.println(phieuthu.getNgayLap());
		DocGia docgia = docGiaService.getDocGiaFromMaDG(phieuthu.getDocGia().getMaDocGia());
		if (docgia == null) 
			errors.rejectValue("docGia.maDocGia", "phieuthu", "Mã độc giả không tồn tại!");
		else  {
			if(docgia.getTongNoHienTai() == 0) {
				errors.rejectValue("docGia.maDocGia", "phieuthu", "Độc giả này hiện không có tiền nợ!");
			}
			tongnohientai = docgia.getTongNoHienTai();
		}
		
		Integer sotienthu = phieuthu.getSoTienThu();
		if (sotienthu <= 0) 
			errors.rejectValue("soTienThu", "phieuthu", "Số tiền thu phải lớn hơn 0!");
		else {
			if (tongnohientai != -1) {
				tongnomoi = tongnohientai + phieuthu_new.getSoTienThu() - sotienthu;
				if (tongnomoi < 0) {
					errors.rejectValue("soTienThu", "phieuthu", "Số tiền thu vượt quá số nợ hiện tại!");
				}
			}
		}

		if (errors.hasErrors()) {
			
			List<FieldError> fieldErrors = errors.getFieldErrors();
	        for (FieldError error : fieldErrors) {
	            // In ra tên trường và thông báo lỗi
	        	String fieldName = error.getField();
	            String errorMessage = error.getDefaultMessage();
	        	model.addAttribute(fieldName + "Error", errorMessage);
	            System.out.println("Field: " + fieldName + ", Error: " + errorMessage);
	        }
	        
	        phieuthu.setSoTienThu(phieuthu_new.getSoTienThu());
			docgia.setTongNoHienTai(tongnohientai);
			phieuthu.setDocGia(docgia);
			
	        List<PhieuThu> list = phieuThuService.getAllPhieuThu();
			PagedListHolder pagedListHolder = phieuThuService.paging(list, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
			model.addAttribute("message1", -1);
			return "admin/PhieuThu/listPhieuThu";
		}
		
		docgia.setTongNoHienTai(tongnomoi);
		docGiaService.editDocGia(docgia);
		
		phieuthu_new.setDocGia(docgia);
		phieuthu_new.setSoTienThu(sotienthu);
		
		int result = phieuThuService.editPhieuThu(phieuthu_new);
		List<PhieuThu> list = phieuThuService.getAllPhieuThu();
		PagedListHolder pagedListHolder = phieuThuService.paging(list, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		model.addAttribute("message1", result);
		return "redirect:/phieuthu/listPhieuThu.htm";
	}
	
	@RequestMapping(value = "listPhieuThu", params = "filter")
	public String filterListPhieuThu(HttpServletRequest request, ModelMap model,
			@RequestParam("filter_date") @DateTimeFormat(pattern="dd/MM/yyyy") Date date) {
		System.out.println(date);
		List<PhieuThu> list = phieuThuService.getPhieuThu_Filter(date);
		PagedListHolder pagedListHolder = phieuThuService.paging(list, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/PhieuThu/listPhieuThu";
	}
	
}
