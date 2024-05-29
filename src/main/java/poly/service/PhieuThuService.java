package poly.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.ServletRequestUtils;

import poly.dao.PhieuThuDAO;
import poly.entity.PhieuThu;

@Service
@Transactional
public class PhieuThuService {
	
	@Autowired
	PhieuThuDAO phieuThuDAO;
	
	@Autowired
	ServletContext context;
	
	public PagedListHolder<PhieuThu> paging(List<PhieuThu> list, HttpServletRequest request) {
		PagedListHolder<PhieuThu> pagedListHolder = new PagedListHolder<PhieuThu>(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(8);
		return pagedListHolder;
	}
	
	public List<PhieuThu> getAllPhieuThu() {
		return phieuThuDAO.getAllPhieuThu();
	}
	
	public List<PhieuThu> getPhieuThu_Search(String keyword) {
		try {
//			System.out.println(keyword);
			int new_keyword = Integer.parseInt(keyword);
			return phieuThuDAO.getPhieuThu_ID(new_keyword);
		} catch(NumberFormatException ex) {
			List<PhieuThu> list = phieuThuDAO.getPhieuThu_MaDocGia(keyword);
			if (list.isEmpty() == false) {
				return list;
			}
			else {
				list.clear();
				list = phieuThuDAO.getPhieuThu_TenDocGia(keyword);
				return list;
			}
		}
	}
	
	public Integer getTongNoHienTai(String maDocGia) {
		return phieuThuDAO.getTongNoHienTai(maDocGia);
	}
	
	public PhieuThu getPhieuThuByID(Integer id) {
		return phieuThuDAO.getPhieuThu_ID(id).get(0);
	}
	
	public int insertPhieuThu(PhieuThu phieuthu) {
		return phieuThuDAO.insertPhieuThu(phieuthu);
	}
	
	public int editPhieuThu(PhieuThu phieuthu) {
		return phieuThuDAO.editPhieuThu(phieuthu);
	}
	
	public int deletePhieuThu(PhieuThu phieuthu) {
		return phieuThuDAO.deletePhieuThu(phieuthu);
	}
	
	public List<PhieuThu> getPhieuThu_Filter(java.util.Date date) {
		return phieuThuDAO.getPhieuThu_Filter(date);
	}

}
