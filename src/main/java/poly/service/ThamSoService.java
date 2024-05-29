package poly.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.dao.ThamSoDAO;
import poly.entity.ThamSo;

@Service
@Transactional
public class ThamSoService {
	@Autowired
	ThamSoDAO thamSoDAO;
	
	public ThamSo getThamSo() {
		return thamSoDAO.getAll();
	}
}