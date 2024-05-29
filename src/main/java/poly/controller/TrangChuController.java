package poly.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import poly.entity.*;
import poly.service.*;

@Transactional
@Controller
@RequestMapping("/trangchu/")
public class TrangChuController {
	@Autowired
	DocGiaService docGiaService;
	
	@Autowired
	TuaSachService tuaSachService;
	
	@Autowired
	SachService sachService;
		
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap model) {
		Date htai = new Date();
        
        SimpleDateFormat monthYearFormat = new SimpleDateFormat("'Tháng' M, yyyy");
        String monthYearString = monthYearFormat.format(htai);
        
        SimpleDateFormat dayTimeFormat = new SimpleDateFormat("E, HH:mm");
        String dayTimeString = dayTimeFormat.format(htai);
        
        String result = monthYearString + " | " + dayTimeString;
        
        model.addAttribute("thoigian", result);
		
		List<TuaSach> tuasachList = tuaSachService.getAllTuaSach();
		model.addAttribute("tuasachList", tuasachList);
		
		List<DocGia> docgiaList = docGiaService.getAllDocGia();
		model.addAttribute("docgiaList", docgiaList);
		
		Long soLuongSach = sachService.getSoLuongSach();
		model.addAttribute("soLuongSach", soLuongSach);
		
		Long soDocGia = docGiaService.getSoLuongDG();
		model.addAttribute("soDocGia", soDocGia);
		
		//phần minh thư :) (này là hiện lên số lượt mượn và mượn quá hạn tháng và năm hiện tại
//		Long soLuotMuon = phieuMuonTraService.getSoLuongPhieu(htai.getMonth(), htai.getYear());
//		model.addAttribute("soLuotMuon", soLuotMuon);
//		
//		Long muonQuaHan = phieuMuonTraService.getSoLuongPhieu(htai.getMonth(), htai.getYear());
//		model.addAttribute("muonQuaHan", muonQuaHan);
		
		return "include/trangchu";
	}
	
	@RequestMapping(value = "thongtin", method = RequestMethod.GET)
	public String info(HttpServletRequest request, ModelMap model) {
		return "include/thongtinnhom";
	}
	
	//thêm hàm sau khi bấm nút lọc nữa
}	