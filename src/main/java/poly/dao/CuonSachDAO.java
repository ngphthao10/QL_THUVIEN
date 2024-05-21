package poly.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.CuonSach;
import poly.entity.Sach;
import poly.entity.TuaSach;
@Repository
public class CuonSachDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public int themCuonSach(CuonSach cuonsach) {
		
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(cuonsach);
			t.commit();
		} 
		catch (Exception e) {
			t.rollback();
			return 0;
		}
		finally {
			session.close();
		}
		return 1;
	}

	public List<CuonSach> getAllCuonSach() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM CuonSach";
		Query query = session.createQuery(hql);

		List<CuonSach> list = query.list();
		return list;
	}

	public List<CuonSach> getSearch(String keyword) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT cs FROM CuonSach cs JOIN cs.sach1 sach JOIN sach.tuaSach1 ts WHERE "
				+ "ts.TenTuaSach LIKE :keyword OR cs.MaCuonSach LIKE :keyword";
		Query query = session.createQuery(hql);
		query.setParameter("keyword", "%" + keyword + "%");
		List<CuonSach> list = query.list();
		return list;
	}

	public List<CuonSach> getAllCuonSachTheoTinhTrang(int tinhTrang) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from CuonSach where TinhTrang = :tinhTrang";
		Query query = session.createQuery(hql);
		query.setParameter("tinhTrang", tinhTrang);
		List<CuonSach> list = query.list();
		return list;
	}

	public CuonSach getCuonSachTheoId(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from CuonSach where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		CuonSach list = (CuonSach) query.list().get(0);
		return list;
	}

	public int editCuonSach(CuonSach cuonsach) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(cuonsach);
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
