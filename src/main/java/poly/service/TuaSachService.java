package poly.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.ServletRequestUtils;

import poly.dao.TuaSachDAO;
import poly.dto.TuaSachDTO;
import poly.entity.TuaSach;

@Service
@Transactional
public class TuaSachService {
	@Autowired
	TuaSachDAO tuaSachDAO;
	
	public PagedListHolder<TuaSach> paging(List<TuaSach> list, HttpServletRequest request) {
		// bỏ dữ liệu vào pagedListHolder rồi sau đó trả về cho model
		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(8);
		return pagedListHolder;
	}
	
	public PagedListHolder<TuaSach> paging2(List<TuaSach> list, HttpServletRequest request) {
		// bỏ dữ liệu vào pagedListHolder rồi sau đó trả về cho model
		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(5);
		return pagedListHolder;
	}
	
	public List<TuaSach> getAllTuaSach() {
		return tuaSachDAO.getAllTuaSach();
	}
	
	public List<TuaSach> getSearch(String keyword){
		return tuaSachDAO.getSearch(keyword);
	}
	
	public List<TuaSach> getTSTheoIdTheLoai(int id){
		return tuaSachDAO.getTuaSachByIdTheLoai(id);
	}
	
	public int themTuaSach(TuaSachDTO ts) {
		return tuaSachDAO.themTuaSach(ts);
	}

	public TuaSach getTSTheoId(int id) {
		return tuaSachDAO.getTSTheoId(id);
	}
	
	public TuaSach getTSTheoTen(String ten) {
		TuaSach ts;
		try
		{
			ts = tuaSachDAO.getTSTheoTen(ten);
		}
		catch (Exception e) {
			ts = null;
		}
		return ts;
	}

	public int editTuaSach(TuaSach ts) {
		return tuaSachDAO.updateTuaSach(ts);
	}

	public List<TuaSach> getTop5TuaSach() {
		return tuaSachDAO.getTop5TuaSach();
	}
}
