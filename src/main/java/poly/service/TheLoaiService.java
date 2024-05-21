package poly.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.ServletRequestUtils;

import poly.dao.TheLoaiDAO;
import poly.entity.TheLoai;

@Service
@Transactional
public class TheLoaiService {
	@Autowired
	TheLoaiDAO theLoaiDAO;
	
	public PagedListHolder<TheLoai> paging(List<TheLoai> list, HttpServletRequest request) {
		// bỏ dữ liệu vào pagedListHolder rồi sau đó trả về cho model
		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(8);
		return pagedListHolder;
	}
	
	public List<TheLoai> getAllTheLoai() {
		return theLoaiDAO.getAllTheLoai();
	}

	public int themTheLoai(TheLoai tl) {
		return theLoaiDAO.themTheLoai(tl);
	}

	public TheLoai getTLTheoId(Integer id) {
		return theLoaiDAO.getTLTheoId(id);
	}

	public int editTheLoai(TheLoai tl) {
		return theLoaiDAO.updateTheLoai(tl);
	}
	
	public Integer delTheLoai(TheLoai tl) {
		return theLoaiDAO.deleteTheLoai(tl);
	}

	public TheLoai getTLTheoTen(String tenTheLoai) {
		return theLoaiDAO.getTLTheoTen(tenTheLoai);
	}
	
}
	