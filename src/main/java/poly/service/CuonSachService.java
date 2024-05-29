package poly.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.ServletRequestUtils;

import poly.dao.CuonSachDAO;
import poly.entity.CuonSach;



@Service
@Transactional
public class CuonSachService {
	@Autowired
	CuonSachDAO cuonSachDAO;
	
	public PagedListHolder<CuonSach> paging(List<CuonSach> list, HttpServletRequest request) {
		// bỏ dữ liệu vào pagedListHolder rồi sau đó trả về cho model
		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(8);
		return pagedListHolder;
	}

	public int themCuonSach(CuonSach cuonsach) {
		return cuonSachDAO.themCuonSach(cuonsach);
				
	}

	public List<CuonSach> getAllCuonSach() {
		return cuonSachDAO.getAllCuonSach();
	}

	public List<CuonSach> getSearch(String keyword) {
		return cuonSachDAO.getSearch(keyword);
	}

	public List<CuonSach> getAllCuonSachTheoTinhTrang(int tinhTrang) {
		return cuonSachDAO.getAllCuonSachTheoTinhTrang(tinhTrang);
	}

	public CuonSach getCuonSachTheoId(Integer id) {
		return cuonSachDAO.getCuonSachTheoId(id);
	}

	public int editCuonSach(CuonSach cs) {
		return cuonSachDAO.editCuonSach(cs);
	}

	public CuonSach getCuonSachFromMaCS(String maCuonSach) {
		return cuonSachDAO.getCuonSachFromMaCS(maCuonSach);
	}

	
	
}

