package poly.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.ServletRequestUtils;

import poly.dao.*;
import poly.entity.*;

@Service
@Transactional
public class NhomNguoiDungService {
	@Autowired
	NhomNguoiDungDAO NhomNguoiDungDAO;
	
	public PagedListHolder<NhomNguoiDung> paging(List<NhomNguoiDung> list, HttpServletRequest request) {
		// bỏ dữ liệu vào pagedListHolder rồi sau đó trả về cho model
		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(8);
		return pagedListHolder;
	}
	
	public List<NhomNguoiDung> getNhomNguoiDung() {
		return NhomNguoiDungDAO.getNhomNguoiDung();
	}

	public NhomNguoiDung getNhomNguoiDungByID(int i) {
		return NhomNguoiDungDAO.getNhomNguoiDungByID(i);
	}

}
	