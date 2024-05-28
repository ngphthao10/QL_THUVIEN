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

	public List<DocGia> getTop5DocGia() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM DocGia";
		Query query = session.createQuery(hql);
		query.setMaxResults(6); 
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
}