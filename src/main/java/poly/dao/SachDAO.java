package poly.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.CuonSach;
import poly.entity.DocGia;
import poly.entity.Sach;

@Repository
public class SachDAO {

	@Autowired
	SessionFactory factory;
	
	public Integer editSach (Sach sach) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(sach);
			t.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Sach getSachFromMaSach(String maSach) {
		Session session = factory.openSession();
		String hql = "FROM Sach WHERE MaSach = :maSach";
		Query query = session.createQuery(hql);
		query.setParameter("maSach", maSach);
		Sach sach = (Sach)query.uniqueResult();
		session.close();
		return sach;
	}
	
}
