package poly.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}