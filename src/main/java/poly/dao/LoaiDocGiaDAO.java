package poly.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.LoaiDocGia;

@Repository
public class LoaiDocGiaDAO {
	@Autowired
	SessionFactory factory;
	
	public List<LoaiDocGia> getAllLoaiDocGia(){
		Session session = factory.getCurrentSession();
		String hql = "FROM LoaiDocGia";
		Query query = session.createQuery(hql);
		List<LoaiDocGia> list = query.list();
		return list;
	}
	
	public LoaiDocGia getLoaiDGByName(String name) {
		Session session = factory.getCurrentSession();
		String hql = "FROM LoaiDocGia WHERE name = :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		LoaiDocGia list = (LoaiDocGia) query.list().get(0);
		return list;
	}
	
	public LoaiDocGia getLoaiDGByID(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM LoaiDocGia WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		LoaiDocGia list = (LoaiDocGia) query.list().get(0);
		return list;
	}
	
	
}
