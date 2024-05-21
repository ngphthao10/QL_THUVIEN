package poly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poly.dao.CTTacGiaDAO;
import poly.entity.CT_TacGiaId;

@Service
@Transactional
public class CTTacGiaService {
	@Autowired
	CTTacGiaDAO ctTacGiaDAO;
	
	public int themCTTacGia(CT_TacGiaId cttg) {
		return ctTacGiaDAO.themCTTacGia(cttg);
	}
	
	public int suaCTTacGia(CT_TacGiaId cttg) {
		return ctTacGiaDAO.editCTTacGia(cttg);
	}
	
	public int xoaCTTGCuaTuaSach(int id) {
		return ctTacGiaDAO.xoaCTTGCuaTuaSach(id);
	}
}
