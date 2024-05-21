package poly.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.CT_PhieuNhapId;
import poly.entity.PhieuNhapSach;



@Repository
public class CT_PhieuNhapDAO {
	@Autowired
    SessionFactory sessionFactory;
	
	public int themChiTietPhieuNhap(CT_PhieuNhapId ctpn) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(ctpn);
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

	public List<CT_PhieuNhapId> getAllCTPhieuNhap() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM CT_PhieuNhapId";
		Query query = session.createQuery(hql);

		List<CT_PhieuNhapId> list = query.list();
		return list;
	}

	public List<CT_PhieuNhapId> getAllCTPhieuNhapTheoId(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM CT_PhieuNhapId where phieuNhap.SoPhieuNhap = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<CT_PhieuNhapId> list = query.list();
		return list;
	}

	public List<CT_PhieuNhapId> getAllPhieuNhapTheoMaSach(int maSach) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM CT_PhieuNhapId where sach2.id = :maSach";
		Query query = session.createQuery(hql);
		query.setParameter("maSach", maSach);
		List<CT_PhieuNhapId> list = query.list();
		return list;
	}

}