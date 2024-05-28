package poly.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.ServletRequestUtils;

import poly.dao.SachDAO;
import poly.dto.SachDTO;
import poly.entity.Sach;
import poly.entity.TacGia;
import poly.entity.TuaSach;

@Service
@Transactional
public class SachService {
	@Autowired
	SachDAO sachDAO;
	
	public PagedListHolder<Sach> paging(List<Sach> list, HttpServletRequest request) {
		// bỏ dữ liệu vào pagedListHolder rồi sau đó trả về cho model
		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(8);
		return pagedListHolder;
	}

	public List<Sach> getAllSach() {
		return sachDAO.getAllSach();
	}

	public List<Sach> getSearch(String keyword) {
		return sachDAO.getSearch(keyword);
	}

	public List<Sach> getAllSachTheoTinhTrang(int daAn) {
		return sachDAO.getAllSachTheoTinhTrang(daAn);
	}

	public int themSachMoi(SachDTO sachDTO) {
		return sachDAO.themSachMoi(sachDTO);
	}

	public int themSachDaCo(SachDTO sachDTO) {
		return sachDAO.themSachDaCo(sachDTO);
	}

	public Sach getSachTheoId(Integer id) {
		return sachDAO.getSachTheoId(id);
	}

	public int editSach(SachDTO sachDTO) {
		return sachDAO.editSach(sachDTO);
	}

	public List<Sach> getAllSachChoUser() {
		return sachDAO.getAllSachChoUser();
	}

	public List<Sach> getAllSachTheoTheLoai(int id) {
		return sachDAO.getAllSachTheoTheLoai(id);
	}

	public List<Sach> getAllSachTheoSLCL(int conlai) {
		return sachDAO.getAllSachTheoSLCL(conlai);
	}

	public List<Sach> getSearchChoUser(String keyword) {
		return sachDAO.getSearchChoUser(keyword);
	}

	public Long getSoLuongSach() {
		return sachDAO.getSoLuongSach();
	}

}
