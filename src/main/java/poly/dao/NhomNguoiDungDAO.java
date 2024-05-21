package poly.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.NhomNguoiDung;

@Repository
public class NhomNguoiDungDAO {
	@Autowired
	SessionFactory sessionFactory;

	public List<NhomNguoiDung> getNhomNguoiDung() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM NhomNguoiDung";
		Query query = session.createQuery(hql);

		List<NhomNguoiDung> list = query.list();
		return list;
	}
}