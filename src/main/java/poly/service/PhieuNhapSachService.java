package poly.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.ServletRequestUtils;

import poly.dao.*;
import poly.entity.PhieuNhapSach;

@Service
@Transactional
public class PhieuNhapSachService {
	@Autowired
	PhieuNhapSachDAO phieuNhapSachDAO;
	
	public PagedListHolder<PhieuNhapSach> paging(List<PhieuNhapSach> list, HttpServletRequest request) {
		// bỏ dữ liệu vào pagedListHolder rồi sau đó trả về cho model
		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(8);
		return pagedListHolder;
	}

	public int themPhieuNhap(PhieuNhapSach pns) {
		return phieuNhapSachDAO.themPhieuNhap(pns);
				
	}

	public List<PhieuNhapSach> getAllPhieuNhap() {
		return phieuNhapSachDAO.getAllPhieuNhapSach();
	}

	public List<PhieuNhapSach> getSearch(Integer keyword) {
		return phieuNhapSachDAO.getSearch(keyword);
	}

	public List<PhieuNhapSach> getPnsTheoNgay(Date ngayNhap) {
		return phieuNhapSachDAO.getPnsTheoNgay(ngayNhap);
	}

	public PhieuNhapSach getPnsTheoId(Integer id) {
		return phieuNhapSachDAO.getPnsTheoId(id);
	}
}
