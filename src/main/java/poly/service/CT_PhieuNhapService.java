package poly.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.ServletRequestUtils;

import poly.dao.CT_PhieuNhapDAO;
import poly.entity.CT_PhieuNhapId;

@Service
@Transactional
public class CT_PhieuNhapService {
	@Autowired
	CT_PhieuNhapDAO ctPhieuNhapDAO;
	
	public PagedListHolder<CT_PhieuNhapId> paging(List<CT_PhieuNhapId> list, HttpServletRequest request) {
		// bỏ dữ liệu vào pagedListHolder rồi sau đó trả về cho model
		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(8);
		return pagedListHolder;
	}

	public List<CT_PhieuNhapId> getAllPhieuNhap() {
		return ctPhieuNhapDAO.getAllCTPhieuNhap();
	}

	public List<CT_PhieuNhapId> getAllPhieuNhapTheoId(Integer id) {
		return ctPhieuNhapDAO.getAllCTPhieuNhapTheoId(id);
	}

	public List<CT_PhieuNhapId> getAllPhieuNhapTheoMaSach(int maSach) {
		return ctPhieuNhapDAO.getAllPhieuNhapTheoMaSach(maSach);
	}
}