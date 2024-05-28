package poly.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.ServletRequestUtils;

import poly.dao.DocGiaDAO;
import poly.entity.DocGia;

@Service
@Transactional
public class DocGiaService {
	@Autowired
	DocGiaDAO docGiaDAO;
	
	public PagedListHolder<DocGia> paging2(List<DocGia> list, HttpServletRequest request) {
		// bỏ dữ liệu vào pagedListHolder rồi sau đó trả về cho model
		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(5);
		return pagedListHolder;
	}
	public DocGia getDocGiaTheoIdNguoiDung(int idNguoiDung) {
		return docGiaDAO.getDocGiaTheoIdNguoiDung(idNguoiDung);
				
	}
	public List<DocGia> getTop5DocGia() {
		return docGiaDAO.getTop5DocGia();
	}
	public Long getSoLuongDG() {
		return docGiaDAO.getSoLuongDG();
	}
}