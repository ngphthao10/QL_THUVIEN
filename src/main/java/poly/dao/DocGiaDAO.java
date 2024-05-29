package poly.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.DocGia;
import poly.entity.PhieuMuonTra;

@Repository
public class DocGiaDAO {
	
	@Autowired
	SessionFactory factory;
	
	public List<DocGia> getAllDocGia() {
		Session session = factory.openSession();
		String hql = "FROM DocGia";
		Query query = session.createQuery(hql);
		List<DocGia> list = query.list();
		session.close();
		return list;
	}
	
	public DocGia getDocGiaFromMaDG(String maDocGia) {
		Session session = factory.openSession();
		String hql = "FROM DocGia WHERE maDocGia = :maDocGia";
		Query query = session.createQuery(hql);
		query.setParameter("maDocGia", maDocGia);
		DocGia docgia = (DocGia)query.uniqueResult();
		session.close();
		return docgia;
	}
	
	public int getTongNoHienTai(String maDocGia) {
		Session session = factory.openSession();
		String hql = "SUM(p.docGia.soTienPhat) FROM PhieuMuonTra p WHERE p.docGia.maDocGia = :maDocGia";
		Query query = session.createQuery(hql);
		query.setParameter("maDocGia", maDocGia);
		int sotienphat = (int)query.uniqueResult();
		session.close();
		return sotienphat;
	}
	
	public Integer editDocGia (DocGia dg) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(dg);
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
