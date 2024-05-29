package poly.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.ServletRequestUtils;

import poly.dao.PhieuMuonTraDAO;
import poly.dao.PhieuThuDAO;
import poly.entity.PhieuMuonTra;
import poly.entity.PhieuThu;

@Service
@Transactional
public class PhieuMuonTraService {

	@Autowired
	PhieuMuonTraDAO phieuMuonTraDAO;
	
	@Autowired
	ServletContext context;
	
	public PagedListHolder<PhieuMuonTra> paging(List<PhieuMuonTra> list, HttpServletRequest request) {
		PagedListHolder<PhieuMuonTra> pagedListHolder = new PagedListHolder<PhieuMuonTra>(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(8);
		return pagedListHolder;
	}
	
	public List<PhieuMuonTra> getAllPhieuMuonTra() {
		return phieuMuonTraDAO.getAllPhieuMuonTra();
	}

	public int insertPhieuMuonTra(PhieuMuonTra phieumuontra) {
		return phieuMuonTraDAO.insertPhieuMuonTra(phieumuontra);
	}
	
	public int editPhieuMuonTra(PhieuMuonTra phieumuontra) {
		return phieuMuonTraDAO.editPhieuMuonTra(phieumuontra);
	}

	public int deletePhieuMuonTra(PhieuMuonTra p) {
		return phieuMuonTraDAO.deletePhieuMuonTra(p);
	}
	
	public PhieuMuonTra getPhieuMuonTraID(int id) {
		return phieuMuonTraDAO.getPhieuMuonTraID(id);
	}

	public List<PhieuMuonTra> getPhieuMuonTra_Search(String keyword) {
		try {
			int new_keyword = Integer.parseInt(keyword);
			return phieuMuonTraDAO.getPhieuMuonTraByID(new_keyword);
		} catch (NumberFormatException ex) {
			List<PhieuMuonTra> list = null;
			list = phieuMuonTraDAO.getPhieuMuonTraByMaDG(keyword);
			if (list == null || list.isEmpty()) {
				list = phieuMuonTraDAO.getPhieuMuonTraByMaCS(keyword);
				if (list == null || list.isEmpty()) {
					list = phieuMuonTraDAO.getPhieuMuonTraByTenDocGia(keyword);
					if (list == null || list.isEmpty()) {
						list = phieuMuonTraDAO.getPhieuMuonTraByTenSach(keyword);
					}
				}
			}
			return list;
		}
	}
	
	public List<PhieuMuonTra> getPhieuMuonTra_Filter(Date date) {
		return phieuMuonTraDAO.getPhieuMuonTra_Filter(date);
	}

	public Long getSoLuongPhieu(int month, int year) {
		return phieuMuonTraDAO.getSoLuongPhieuMuon(month, year);
	}
	
	public Long getSoLuotMuonQuaHan(int month, int year) {
		return phieuMuonTraDAO.getSoLuotMuonQuaHan(month, year);
	}

	public List<PhieuMuonTra> getPhieuMuonTra_IDDocGia(Integer id) {
		return phieuMuonTraDAO.getPhieuMuonTra_IDDocGia(id);
	}

	public List<PhieuMuonTra> getPhieuMuonTraByIDDG_DangMuon (List<PhieuMuonTra> listSach){
		List<PhieuMuonTra> listSach_DangMuon = new ArrayList<>();
		for (PhieuMuonTra phieuMuonTra : listSach) {
			if(phieuMuonTra.getNgayTra() == null) {
				listSach_DangMuon.add(phieuMuonTra);
			}
		}
		return listSach_DangMuon;
	}
	
	public List<PhieuMuonTra> getPhieuMuonTraByIDDG_DaMuon (List<PhieuMuonTra> listSach){
		List<PhieuMuonTra> listSach_DaMuon = new ArrayList<>();
		for (PhieuMuonTra phieuMuonTra : listSach) {
			if(phieuMuonTra.getNgayTra() != null) {
				listSach_DaMuon.add(phieuMuonTra);
			}
		}
		return listSach_DaMuon;
	}

	public int soSachDaMuon (List<PhieuMuonTra> listSach_DaMuon) {
		int i = 0;
		for (PhieuMuonTra phieuMuonTra : listSach_DaMuon) {
			i++;
		}
		return i;
	}

}
