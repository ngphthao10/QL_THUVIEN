package poly.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.PhieuNhapSach;
import poly.entity.Sach;
import poly.entity.TuaSach;

@Repository
public class PhieuNhapSachDAO {
	@Autowired
    SessionFactory sessionFactory;
	
	public int themPhieuNhap(PhieuNhapSach pns) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(pns);
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

	public List<PhieuNhapSach> getAllPhieuNhapSach() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM PhieuNhapSach";
		Query query = session.createQuery(hql);

		List<PhieuNhapSach> list = query.list();
		return list;
	}

	public List<PhieuNhapSach> getSearch(Integer keyword) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT pns FROM PhieuNhapSach pns where pns.SoPhieuNhap = :keyword";
		Query query = session.createQuery(hql);
		query.setParameter("keyword", keyword);
		List<PhieuNhapSach> list = query.list();
		return list;
	}

	public List<PhieuNhapSach> getPnsTheoNgay(Date ngayNhap) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from PhieuNhapSach where NgayNhap = :ngayNhap";
		Query query = session.createQuery(hql);
		query.setParameter("ngayNhap", ngayNhap);
		List<PhieuNhapSach> list = query.list();
		return list;
	}

	public PhieuNhapSach getPnsTheoId(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from PhieuNhapSach where SoPhieuNhap = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		PhieuNhapSach list = (PhieuNhapSach) query.list().get(0);
		return list;
	}

}
