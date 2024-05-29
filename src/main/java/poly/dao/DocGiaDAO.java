package poly.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.DocGia;


@Repository
public class DocGiaDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public DocGia getDocGiaTheoIdNguoiDung(int idNguoiDung) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM DocGia where nguoiDung.id = :idNguoiDung";
		Query query = session.createQuery(hql);
		query.setParameter("idNguoiDung", idNguoiDung);
		DocGia list = (DocGia) query.list().get(0);
		return list;
	}

	public List<DocGia> getAllDocGia() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM DocGia";
		Query query = session.createQuery(hql);
		List<DocGia> list = query.list();
		return list;
	}

	public Long getSoLuongDG() {
		Session session = sessionFactory.getCurrentSession();
	    String hql = "SELECT count(*) FROM DocGia";
	    Query query = session.createQuery(hql);
        Long result = (Long) query.uniqueResult();
	    return result;
	}

	public DocGia getDocGiaFromMaDG(String maDocGia) {
		Session session = sessionFactory.openSession();
		String hql = "FROM DocGia WHERE maDocGia = :maDocGia";
		Query query = session.createQuery(hql);
		query.setParameter("maDocGia", maDocGia);
		DocGia docgia = (DocGia)query.uniqueResult();
		session.close();
		return docgia;
	}
	
	public int getTongNoHienTai(String maDocGia) {
		Session session = sessionFactory.openSession();
		String hql = "SUM(p.docGia.soTienPhat) FROM PhieuMuonTra p WHERE p.docGia.maDocGia = :maDocGia";
		Query query = session.createQuery(hql);
		query.setParameter("maDocGia", maDocGia);
		int sotienphat = (int)query.uniqueResult();
		session.close();
		return sotienphat;
	}
	
	public Integer editDocGia (DocGia dg) {
		Session session = sessionFactory.openSession();
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
	
	public long getSoSachDGMuon(String maDG) {
		Session session = sessionFactory.openSession();
		String hql = "SELECT COUNT(soPhieuMuonTra) FROM PhieuMuonTra WHERE docGia.maDocGia = :maDocGia AND ngayTra IS NULL";
		Query query = session.createQuery(hql);
		query.setParameter("maDocGia", maDG);
		long result = (long)query.uniqueResult();
		session.close();
		return result;
	}

		
	public List<DocGia> searchDocGiaByName (String tenDocGia){
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM DocGia where LOWER(tenDocGia) like LOWER(:tenDocGia)";
		Query query = session.createQuery(hql);
		query.setParameter("tenDocGia", "%" + tenDocGia + "%");
		List<DocGia> list = query.list();
		return list;
	}
	
	public List<DocGia> searchDocGiaByMaDG (String maDocGia){
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM DocGia where maDocGia like :maDocGia";
		Query query = session.createQuery(hql);
		query.setParameter("maDocGia", "%" + maDocGia + "%");
		List<DocGia> list = query.list();
		return list;
	}
	
	public DocGia getDocGiaByID(int id) {
		Session session = sessionFactory.openSession();
		String hql = "FROM DocGia where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);

		DocGia list = (DocGia) query.list().get(0);
		session.close();
		return list;
	}
	
	public DocGia getDocGiaByMaDG(String maDocGia) {
		Session session = sessionFactory.openSession();
		String hql = "FROM DocGia where maDocGia = :maDocGia";
		Query query = session.createQuery(hql);
		query.setParameter("maDocGia", maDocGia);

		DocGia list = (DocGia) query.list().get(0);
		session.close();
		return list;
	}
	
	public int updateDocGia (DocGia docgia) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(docgia);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		}finally {
			session.close();
		}
		return 1;
	}
	
	public int insertDocGia (DocGia docgia) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(docgia);
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
