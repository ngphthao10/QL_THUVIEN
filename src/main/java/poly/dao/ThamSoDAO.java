package poly.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.ThamSo;

@Repository
public class ThamSoDAO {
	@Autowired
	SessionFactory sessionFactory;

	public ThamSo getAll() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from ThamSo";
		Query query = session.createQuery(hql);
		ThamSo list = (ThamSo) query.list().get(0);
		return list;
	}
}