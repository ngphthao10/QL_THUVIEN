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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.dao.ThamSoDAO;
import poly.dto.SachDTO;
import poly.entity.Sach;
import poly.entity.ThamSo;


@Transactional
@Controller
@RequestMapping("/quydinh/")
public class QuyDinhController {
	@Autowired 
	ThamSoDAO thamSoDAO;
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap model, 
			@ModelAttribute("thamso") ThamSo ts) {
		ThamSo thamso = thamSoDAO.getAll();
		model.addAttribute("thamso", thamso);
		return "admin/quydinh/quydinh";
	}
	
	@RequestMapping(value = "index", params="editbtn", method = RequestMethod.POST)
	public String saveEdit(ModelMap model, @Valid @ModelAttribute("thamso") ThamSo ts, BindingResult errors,
			HttpServletRequest request) {
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			if(ts.getThoiHanThe() > 70) {
				errors.rejectValue("ThoiHanThe", "thamso", "Thời hạn thẻ không được quá 5 năm!");
			}
			
			if(ts.getThoiHanThe() < 0) {
				errors.rejectValue("ThoiHanThe", "thamso", "Thời hạn thẻ phải lớn hơn 0!");
			}
			
			if(ts.getTuoiToiDa() < 0) {
				errors.rejectValue("TuoiToiDa", "thamso", "Tuổi tối đa phải lớn hơn 0!");
			}
			
			if(ts.getTuoiToiThieu() < 0) {
				errors.rejectValue("TuoiToiThieu", "thamso", "Tuổi tối thiểu phải lớn hơn 0!");
			}
			
			if(ts.getTuoiToiThieu() > ts.getTuoiToiDa()) {
				errors.rejectValue("TuoiToiThieu", "thamso", "Tuổi tối thiểu không lớn hơn tuổi tối đa!");
			}
			
			if(ts.getSoNgayMuonToiDa() > 30 || ts.getSoNgayMuonToiDa() < 0) {
				errors.rejectValue("SoNgayMuonToiDa", "thamso", "Số ngày mượn không quá 1 tháng!");
			}
			
			if(ts.getDonGiaPhat() < 1000) {
				errors.rejectValue("DonGiaPhat", "thamso", "Đơn giá phạt phải lớn hơn 1000VNĐ!");
			}
			
			if(ts.getSoSachMuonToiDa() < 0 || ts.getSoSachMuonToiDa() > 20) {
				errors.rejectValue("SoSachMuonToiDa", "thamso", "Số sách mượn nằm trong khoản 0-20!");
			}
			
			if(ts.getKhoangCachXuatBan() < 0 || ts.getKhoangCachXuatBan() > 50) {
				errors.rejectValue("KhoangCachXuatBan", "thamso", "Khoảng cách xuất bản nằm trong khoản 0-50!");
			}
		}catch (Exception e){
			errors.rejectValue("ThoiHanThe", "thamso", "Vui lòng nhập một số!");
		}
	    if(errors.hasErrors()) {
	    	model.addAttribute("message", -1); 
	    	System.out.println(errors.getAllErrors());
	        return "admin/quydinh/quydinh";
	    }
	    else
	    {
	    	int message = thamSoDAO.edit(ts);
	    	model.addAttribute("message", message); 
	    }
	    return "admin/quydinh/quydinh";
	}
}