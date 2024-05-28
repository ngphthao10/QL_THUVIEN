package poly.dao;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

	public int edit(ThamSo ts) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(ts);
			t.commit();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			t.rollback();
			return 0;
		}
		finally {
			session.close();
		}
		return 1;
	}
}