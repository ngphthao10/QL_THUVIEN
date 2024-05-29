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
	
	public DocGia getDocGiaTheoIdNguoiDung(int idNguoiDung) {
		return docGiaDAO.getDocGiaTheoIdNguoiDung(idNguoiDung);
				
	}
	public List<DocGia> getAllDocGia() {
		return docGiaDAO.getAllDocGia();
	}
	public Long getSoLuongDG() {
		return docGiaDAO.getSoLuongDG();
	}
	public DocGia getDocGiaFromMaDG(String maDocGia) {
		return docGiaDAO.getDocGiaFromMaDG(maDocGia);
	}
	public int editDocGia(DocGia docgia) {
		return docGiaDAO.editDocGia(docgia);
	}
	public long getSoSachDGMuon(String maDG) {
		return docGiaDAO.getSoSachDGMuon(maDG);
	}
}