package ptithcm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ptithcm.entity.LoaiDocGia;

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
	
//	public List<LoaiDocGia> searchLoaiDocGia (String name){
//		Session session = factory.getCurrentSession();
//		String hql = "FROM LoaiDocGia where name like :name";
//		Query query = session.createQuery(hql);
//		query.setParameter("name", "%" + name + "%");
//		List<LoaiDocGia> list = query.list();
//		return list;
//	}
	
//	public int insertLoaiDG (String tenLoaiDocGia) {
//		Session session = factory.openSession();
//		Transaction t = session.beginTransaction();
//		LoaiDocGia loaidocgia = new LoaiDocGia();
//		try {
//			loaidocgia.setTenLoaiDocGia(tenLoaiDocGia);
//			session.save(loaidocgia);
//			t.commit();
//		} catch (Exception e) {
//			t.rollback();
//			return 0;
//		}finally {
//			session.close();
//		}
//		return 1;
//	}
	
//	public int deleteLoaiDG (LoaiDocGia loaiDocGia) {
//		Session session = factory.openSession();
//		Transaction t = session.beginTransaction();
//		try {
//			session.delete(loaiDocGia);
//			t.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			t.rollback();
//			return 0;
//		}finally {
//			session.close();
//		}
//		return 1;
//	}
	
}
