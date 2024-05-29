package poly.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.CuonSach;
import poly.entity.DocGia;

@Repository
public class CuonSachDAO {
	
	@Autowired
	SessionFactory factory;

	public CuonSach getCuonSachFromMaCS(String maCuonSach) {
		Session session = factory.openSession();
		String hql = "FROM CuonSach WHERE maCuonSach = :maCuonSach";
		Query query = session.createQuery(hql);
		query.setParameter("maCuonSach", maCuonSach);
		CuonSach cuonsach = (CuonSach)query.uniqueResult();
		session.close();
		return cuonsach;
	}
	
	public Integer editCuonSach (CuonSach cs) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(cs);
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
	
}
