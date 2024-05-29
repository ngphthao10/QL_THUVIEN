package ptithcm.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ptithcm.entity.NguoiDung;

@Repository
public class NguoiDungDAO {
	@Autowired
	SessionFactory factory;
	
	public NguoiDung getNguoiDungByID (int id) {
//		Session session = factory.getCurrentSession();
		Session session = factory.openSession();
		String hql = "FROM NguoiDung where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);

		NguoiDung list = (NguoiDung) query.list().get(0);
		session.close();
		return list;
	}
	
	public int updateNguoiDung (NguoiDung nguoiDung) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(nguoiDung);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return 0;
		}finally {
			session.close();
		}
		return 1;
	}
	
	public int insertNguoiDung (NguoiDung nguoiDung) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(nguoiDung);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		}finally {
			session.close();
		}
		return 1;
	}

}
