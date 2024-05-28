package poly.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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

import poly.dao.*;
import poly.dto.SachDTO;
import poly.dto.TuaSachDTO;
import poly.entity.*;
import poly.service.CTTacGiaService;
import poly.service.TacGiaService;
import poly.service.TuaSachService;

@Transactional
@Controller
@RequestMapping("/sach/tuasach/")
public class TuaSachController {
	@Autowired
	TheLoaiDAO theLoaiDAO;

	@Autowired
	TacGiaDAO tacGiaDAO;

	@Autowired
	TuaSachService tuaSachService;
	
	@Autowired
	CTTacGiaService ctTacGiaService;
	
	@Autowired
	TacGiaService tacGiaService;

	public void fillData(ModelMap model) {
		List<TheLoai> theLoaiList = theLoaiDAO.getAllTheLoai();
		model.addAttribute("dsTheLoai", theLoaiList);

		List<TacGia> tacGiaList = tacGiaDAO.getTacGia();
		model.addAttribute("dsTacGia", tacGiaList);
	}
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap model,
			@ModelAttribute("tuasachdto") TuaSachDTO tsDTO) {
		fillData(model);
		
		List<TuaSach> tuaSachList = tuaSachService.getAllTuaSach();
		PagedListHolder pagedListHolder = tuaSachService.paging(tuaSachList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		
		List<TacGia> tacGiaList = tacGiaService.getAllTacGia();
		model.addAttribute("dsTacGia", tacGiaList);
		return "admin/sach/tuasach/tuasach";
	}

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String search(HttpServletRequest request, ModelMap model, @RequestParam("keyword") String keyword,
			@ModelAttribute("tuasachdto") TuaSachDTO tsDTO) {
		fillData(model);
		
		if (!keyword.trim().isEmpty()) {
			List<TuaSach> tuaSachList = tuaSachService.getSearch(keyword);
			model.addAttribute("keyword", keyword);
			model.addAttribute("tuaSachList", tuaSachList);
			PagedListHolder pagedListHolder = tuaSachService.paging(tuaSachList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
		} else {
			List<TuaSach> tuaSachList = tuaSachService.getAllTuaSach();
			PagedListHolder pagedListHolder = tuaSachService.paging(tuaSachList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
		}

		return "admin/sach/tuasach/tuasach";
	}

	@RequestMapping(value = "filter", method = RequestMethod.POST)
	public String filter(HttpServletRequest request, ModelMap model, @ModelAttribute("tuasachdto") TuaSachDTO tsDTO) {
		fillData(model);
		model.addAttribute("tuasachdto", tsDTO);
		List<TuaSach> tuaSachList = tuaSachService.getTSTheoIdTheLoai(tsDTO.getTuasach().getIdTheLoai());
		PagedListHolder pagedListHolder = tuaSachService.paging(tuaSachList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);

		return "admin/sach/tuasach/tuasach";
	}

	// themtuasach
	@RequestMapping(value = "insertTS", method = RequestMethod.GET)
	public String insertTS( @ModelAttribute("tuasachdto") TuaSachDTO tsDTO) {
		return "admin/sach/tuasach/tuasach";
	}

	@RequestMapping(value = "insertTS", method = RequestMethod.POST)
	public String insertTuaSach(ModelMap model, @ModelAttribute("tuasachdto") TuaSachDTO tsDTO, BindingResult errors,
	        HttpServletRequest request) {
		fillData(model);
		int message;
	    String idTG = request.getParameter("selectedAuthors");
	    String[] dsIdTG = idTG.split(",");
        List<String> authorsList = Arrays.asList(dsIdTG);
        
	    if (errors.hasErrors()) {
	        return "admin/sach/tuasach/tuasach";
	    } else {
	    	int result1 = tuaSachService.themTuaSach(tsDTO);
	    	System.out.println(result1);
	    	
        	int idTuaSach = tsDTO.getTuasach().getId();
        	CT_TacGiaId cttg = new CT_TacGiaId();
	        cttg.setIdTuaSach(idTuaSach);
	        for (String id : authorsList) {
	        	cttg.setIdTacGia(Integer.parseInt(id.trim()));
	        	int result2 = ctTacGiaService.themCTTacGia(cttg);
	        	
	        	 if (result1 == 1 && result2 == 1) message = 1;
			        else message = 0;
	        	
	        	 model.addAttribute("message", message);
	        }
	        
	        List<TuaSach> tuaSachList = tuaSachService.getAllTuaSach();
			PagedListHolder pagedListHolder = tuaSachService.paging(tuaSachList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
	    }
	    
	    return "admin/sach/tuasach/tuasach";
	}

	//them tác giả
	@RequestMapping(value = "insertTG", method = RequestMethod.GET)
	public String insertTG(@ModelAttribute("tuasachdto") TuaSachDTO tsDTO) {
		return "admin/sach/tuasach/tuasach";
	}

	@RequestMapping(value = "insertTG", method = RequestMethod.POST)
	public String insertTacGia(ModelMap model, @ModelAttribute("tuasachdto") TuaSachDTO tsDTO, BindingResult errors,
			HttpServletRequest request) {

		fillData(model);
	    if (tsDTO.getTacgia().get(0).getTenTacGia().length() > 100) {
	        errors.rejectValue("tacgia[0].TenTacGia", "tuasachdto", "Tên tác giả không được dài quá 100 ký tự!");
	    }

	    if (errors.hasErrors()) {
	        return "admin/sach/tuasach/tuasach";
	    } else {
	        int result = tacGiaService.themTacGia(tsDTO.getTacgia().get(0));
	        model.addAttribute("message2", result);
	        
        	List<TacGia> tacGiaList = tacGiaService.getAllTacGia();
    		model.addAttribute("dsTacGia", tacGiaList);
    		List<TuaSach> tuaSachList = tuaSachService.getAllTuaSach();
			PagedListHolder pagedListHolder = tuaSachService.paging(tuaSachList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
	    }
	    
	    return "admin/sach/tuasach/tuasach";
	}
	
	//sửa tac gia
	@RequestMapping(value = "index/{id}.htm", params="linkEditTG", method = RequestMethod.GET)
	public String editTacGia(ModelMap model,@ModelAttribute("tuasachdto") TuaSachDTO tsDTO, @PathVariable("id") Integer id,
			HttpServletRequest request) {
		fillData(model);
		TacGia tg = tacGiaService.getTGTheoId(id);
		List<TacGia> lst = new ArrayList<TacGia>();
		lst.add(tg);
		tsDTO.setTacgia(lst);
		model.addAttribute("tuasachdto", tsDTO);
		List<TacGia> tacGiaList = tacGiaService.getAllTacGia();
		model.addAttribute("dsTacGia", tacGiaList);
		List<TuaSach> tuaSachList = tuaSachService.getAllTuaSach();
		PagedListHolder pagedListHolder = tuaSachService.paging(tuaSachList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/sach/tuasach/tuasach";
	}
	
	@RequestMapping(value = "index", params="editTGbtn", method = RequestMethod.POST)
	public String saveEdit(ModelMap model, @ModelAttribute("tuasachdto") TuaSachDTO tsDTO, BindingResult errors,
			HttpServletRequest request) {

	    if(errors.hasErrors())
	        return "admin/sach/tuasach/tuasach";
	    else
	    {
	        int message = tacGiaService.editTacGia(tsDTO.getTacgia().get(0));
	        
	        List<TacGia> tacGiaList = tacGiaService.getAllTacGia();
			model.addAttribute("dsTacGia", tacGiaList);
			List<TuaSach> tuaSachList = tuaSachService.getAllTuaSach();
			PagedListHolder pagedListHolder = tuaSachService.paging(tuaSachList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
			
			model.addAttribute("message4", message); 
	    }
	    fillData(model);
	    return "admin/sach/tuasach/tuasach";
	}
	
	
	//xóa tac gia
	@RequestMapping(value = "index/{id}.htm", params="linkDeleteTG", method = RequestMethod.GET)
	public String delTacGia(ModelMap model,@ModelAttribute("tuasachdto") TuaSachDTO tsDTO, @PathVariable("id") Integer id,
			HttpServletRequest request) {
		fillData(model);
		TacGia tg = tacGiaService.getTGTheoId(id);
		List<TacGia> lst = new ArrayList<TacGia>();
		lst.add(tg);
		tsDTO.setTacgia(lst);
		model.addAttribute("tuasachdto", tsDTO);
		List<TacGia> tacGiaList = tacGiaService.getAllTacGia();
		model.addAttribute("dsTacGia", tacGiaList);
		List<TuaSach> tuaSachList = tuaSachService.getAllTuaSach();
		PagedListHolder pagedListHolder = tuaSachService.paging(tuaSachList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/sach/tuasach/tuasach";
	}
	
	@RequestMapping(value = "index", params="delTGbtn", method = RequestMethod.POST)
	public String deleteEdit(ModelMap model, @ModelAttribute("tuasachdto") TuaSachDTO tsDTO, BindingResult errors,
			HttpServletRequest request) {
		fillData(model);
	    if(errors.hasErrors())
	        return "admin/sach/tuasach/tuasach";
	    else
	    {
	        int message = tacGiaService.delTacGia(tsDTO.getTacgia().get(0));
	        List<TacGia> tacGiaList = tacGiaService.getAllTacGia();
			model.addAttribute("dsTacGia", tacGiaList);
			List<TuaSach> tuaSachList = tuaSachService.getAllTuaSach();
			PagedListHolder pagedListHolder = tuaSachService.paging(tuaSachList, request);
			model.addAttribute("pageListHolder", pagedListHolder);
			model.addAttribute("message5", message); 
	    }
	    
	    return "admin/sach/tuasach/tuasach";
	}
	
	//sửa tựa sách
	@RequestMapping(value = "index/{id}.htm", params="linkEditTS", method = RequestMethod.GET)
	public String editTuaSach(ModelMap model,@ModelAttribute("tuasachdto") TuaSachDTO tsDTO, @PathVariable("id") Integer id,
			HttpServletRequest request) {
		fillData(model);
		tsDTO.setTuasach(tuaSachService.getTSTheoId(id));
		List<TacGia> tacGiaListTheoId = tacGiaService.getCTTGTheoId(id);
		model.addAttribute("dsTacGiaTheoId", tacGiaListTheoId);
		model.addAttribute("tuasachdto", tsDTO);
		List<TuaSach> tuaSachList = tuaSachService.getAllTuaSach();
		PagedListHolder pagedListHolder = tuaSachService.paging(tuaSachList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "admin/sach/tuasach/tuasach";
	}
	
	@RequestMapping(value = "index", params="editbtn", method = RequestMethod.POST)
	public String saveEditTS(ModelMap model, @ModelAttribute("tuasachdto") TuaSachDTO tsDTO, BindingResult errors,
			HttpServletRequest request) {
	    fillData(model);
	    
	    int message = -1;
	    String tenTS = theLoaiDAO.getTLTheoId(tsDTO.getTuasach().getIdTheLoai()).getTenTheLoai();
	    tsDTO.getTuasach().setTenTheloai(tenTS);

	    if(errors.hasErrors()) {
	        return "admin/sach/tuasach/tuasach";
	    }
	    else
	    {
	    	int result1 = tuaSachService.editTuaSach(tsDTO.getTuasach());
	    	int idTuaSach = tsDTO.getTuasach().getId();
	    	
	    	int result2 = ctTacGiaService.xoaCTTGCuaTuaSach(idTuaSach);
	    	
	        String listEditTG = request.getParameter("listEditTacGia").trim();
		    if (listEditTG != null && !listEditTG.isEmpty()) {
		        List<String> dsTenTG = Arrays.asList(listEditTG.split("\\r?\\n"));
		        Set<String> dsTenTGKhongTrung = new HashSet<>(dsTenTG);
		        for (String tenTG : dsTenTGKhongTrung) {
		        	TacGia tg = tacGiaService.getIdTheoTenTG(tenTG);
		        	if (tg != null) {
			        	CT_TacGiaId cttg = new CT_TacGiaId();
				        cttg.setIdTuaSach(idTuaSach);
				        cttg.setIdTacGia(tg.getId());
				        int result3 = ctTacGiaService.themCTTacGia(cttg);
				        if (result1 == 1 && result2 == 1 && result3 == 1) message = 1;
				        else message = 0;
				        
				        model.addAttribute("message3", message); 
		        	}
		        }
		    } else {
		    	return "admin/sach/tuasach/tuasach";
		    }
	    	
		    if (message == 1) {
		    	List<TuaSach> tuaSachList = tuaSachService.getAllTuaSach();
				PagedListHolder pagedListHolder = tuaSachService.paging(tuaSachList, request);
				model.addAttribute("pagedListHolder", pagedListHolder);
	        	return "redirect:/sach/tuasach/insertTuaSach.htm";
	        }
		    List<TuaSach> tuaSachList = tuaSachService.getAllTuaSach();
			PagedListHolder pagedListHolder = tuaSachService.paging(tuaSachList, request);
			model.addAttribute("pagedListHolder", pagedListHolder);
	    }
	    
	    return "admin/sach/tuasach/tuasach";
	}
	
	@RequestMapping(value = "insertTuaSach", method = RequestMethod.GET)
	public String insertReloadSachDaCo(ModelMap model, @Valid  @ModelAttribute("tuasachdto") TuaSachDTO tsDTO, BindingResult errors,
	        HttpServletRequest request) {
		fillData(model);
        model.addAttribute("message3", 1);
        List<TuaSach> tuaSachList = tuaSachService.getAllTuaSach();
		PagedListHolder pagedListHolder = tuaSachService.paging(tuaSachList, request);
		model.addAttribute("pagedListHolder", pagedListHolder);
	    return "admin/sach/tuasach/tuasach";
	}
	



}