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
public class TacGiaService {
	@Autowired
	TacGiaDAO tacGiaDAO;

	public List<TacGia> getAllTacGia() {
		return tacGiaDAO.getTacGia();
	}
	
	public int themTacGia(TacGia tg) {
		return tacGiaDAO.themTacGia(tg);
	}

	public TacGia getTGTheoId(Integer id) {
		return tacGiaDAO.getTGTheoId(id);
	}

	public int editTacGia(TacGia tacgia) {
		return tacGiaDAO.editTacGia(tacgia);
	}

	public int delTacGia(TacGia tacGia) {
		return tacGiaDAO.delTacGia(tacGia);
	}
	public List<TacGia> getCTTGTheoId(Integer id) {
		return tacGiaDAO.getCTTGTheoId(id);
	}

	public TacGia getIdTheoTenTG(String tenTG) {
		return tacGiaDAO.getIdTheoTenTG(tenTG);
	}

}
