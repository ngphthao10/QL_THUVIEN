package ptithcm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ptithcm.entity.DocGia;

@Repository
public class DocGiaDAO {
	@Autowired
	SessionFactory factory;
	
	public List<DocGia> getAllDocGia(){
		Session session = factory.getCurrentSession();
		String hql = "FROM DocGia";
		Query query = session.createQuery(hql);
		List<DocGia> list = query.list();
		return list;
	}
	
	public List<DocGia> searchDocGiaByName (String tenDocGia){
		Session session = factory.getCurrentSession();
		String hql = "FROM DocGia where LOWER(tenDocGia) like LOWER(:tenDocGia)";
		Query query = session.createQuery(hql);
		query.setParameter("tenDocGia", "%" + tenDocGia + "%");
		List<DocGia> list = query.list();
		return list;
	}
	
	public List<DocGia> searchDocGiaByMaDG (String maDocGia){
		Session session = factory.getCurrentSession();
		String hql = "FROM DocGia where maDocGia like :maDocGia";
		Query query = session.createQuery(hql);
		query.setParameter("maDocGia", "%" + maDocGia + "%");
		List<DocGia> list = query.list();
		return list;
	}
	
	public DocGia getDocGiaByID(int id) {
		Session session = factory.openSession();
		String hql = "FROM DocGia where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);

		DocGia list = (DocGia) query.list().get(0);
		session.close();
		return list;
	}
	
	public DocGia getDocGiaByMaDG(String maDocGia) {
		Session session = factory.openSession();
		String hql = "FROM DocGia where maDocGia = :maDocGia";
		Query query = session.createQuery(hql);
		query.setParameter("maDocGia", maDocGia);

		DocGia list = (DocGia) query.list().get(0);
		session.close();
		return list;
	}
	
	public int updateDocGia (DocGia docgia) {
		Session session = factory.openSession();
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
		Session session = factory.openSession();
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
