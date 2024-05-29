package ptithcm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ptithcm.entity.PhieuMuonTra;

@Repository
public class PhieuMuonTraDAO {
	@Autowired
	SessionFactory factory;
	
	public List<PhieuMuonTra> getPhieuMuonTra_IDDocGia(int id){
		Session session = factory.getCurrentSession();
		String hql = "FROM PhieuMuonTra where idDocGia = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<PhieuMuonTra> list = query.list();
		return list;
	}
}
