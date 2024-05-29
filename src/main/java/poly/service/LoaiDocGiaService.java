package poly.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import poly.dao.LoaiDocGiaDAO;
import poly.entity.LoaiDocGia;

@Service
@Transactional
public class LoaiDocGiaService {
	@Autowired
	LoaiDocGiaDAO loaiDocGiaDAO;
	
	public PagedListHolder paging (List<LoaiDocGia> list, HttpServletRequest request) {
		PagedListHolder pagedListHolder = new PagedListHolder (list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(8);
		return pagedListHolder;
	}
	
	public List<LoaiDocGia> getAllLoaiDocGia(){
		return loaiDocGiaDAO.getAllLoaiDocGia();
	}
	
	public LoaiDocGia getLoaiDGByName (String name) {
		LoaiDocGia loaiDocGia;
		try {
			loaiDocGia = loaiDocGiaDAO.getLoaiDGByName(name);
		} catch (Exception e) {
			loaiDocGia = null;
		}
		return loaiDocGia;
	}
	
	public LoaiDocGia getLoaiDGByID (int id) {
		return loaiDocGiaDAO.getLoaiDGByID(id);
	}

	
}