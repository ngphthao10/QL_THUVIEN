package poly.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.ServletRequestUtils;

import poly.dao.NguoiDungDAO;
import poly.entity.NguoiDung;
import poly.entity.NhomNguoiDung;

@Service
@Transactional
public class NguoiDungService {
	@Autowired
	NguoiDungDAO nguoiDungDAO;
	
	public PagedListHolder<NguoiDung> paging(List<NguoiDung> list, HttpServletRequest request) {
		// bỏ dữ liệu vào pagedListHolder rồi sau đó trả về cho model
		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(8);
		return pagedListHolder;
	}
	
	public List<NguoiDung> getAllNguoiDung() {
		return nguoiDungDAO.getAllNguoiDung();
	}

	public List<NguoiDung> getSearch(String keyword) {
		return nguoiDungDAO.getSearch(keyword);
	}

	public int themNguoiDung(NguoiDung nguoidung) {
		return nguoiDungDAO.themNguoiDung(nguoidung);
	}

	public NguoiDung getNDTheoTenDN(String ten) {
		return nguoiDungDAO.getNDTheoTenDN(ten);
	}

	public NguoiDung getNDTheoId(int id) {
		return nguoiDungDAO.getNDTheoId(id);
	}

	public int delNguoiDung(NguoiDung nguoidung) {
		return nguoiDungDAO.delNguoiDung(nguoidung);
	}

	public int editNguoiDung(NguoiDung nguoidung) {
		return nguoiDungDAO.editNguoiDung(nguoidung);
	}

	public List<NguoiDung> getNDTheoNND(int id) {
		return nguoiDungDAO.getNDTheoNND(id);
	}
}