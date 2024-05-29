package ptithcm.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ptithcm.entity.NhomNguoiDung;

@Repository
public class NhomNguoiDungDAO {
	@Autowired
	SessionFactory factory;
	
	public NhomNguoiDung getNhomNguoiDungByID (int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhomNguoiDung where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);

		NhomNguoiDung list = (NhomNguoiDung) query.list().get(0);
		return list;
	}
}
