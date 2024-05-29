package poly.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.NguoiDung;

@Repository
public class NguoiDungDAO {
	@Autowired
	SessionFactory sessionFactory;
	public List<NguoiDung> getAllNguoiDung() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM NguoiDung";
		Query query = session.createQuery(hql);

		List<NguoiDung> list = query.list();
		return list;
	}

	public List<NguoiDung> getSearch(String keyword) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT td FROM NguoiDung td WHERE "
				+ "td.maNguoiDung LIKE :keyword OR td.tenNguoiDung LIKE :keyword OR td.tenDangNhap LIKE :keyword";
		Query query = session.createQuery(hql);
		query.setParameter("keyword", "%" + keyword + "%");
		List<NguoiDung> list = query.list();
		return list;
	}

	public int themNguoiDung(NguoiDung nguoidung) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(nguoidung);
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

	public NguoiDung getNDTheoTenDN(String ten) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from NguoiDung where tenDangNhap = :ten";
		Query query = session.createQuery(hql);
		query.setParameter("ten", ten);
		List<NguoiDung> resultList = query.list();
	    if (resultList != null && !resultList.isEmpty()) {
	        return resultList.get(0);
	    } else {
	        return null;
	    }
	}

	public NguoiDung getNDTheoId(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from NguoiDung where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<NguoiDung> resultList = query.list();
	    if (resultList != null && !resultList.isEmpty()) {
	        return resultList.get(0);
	    } else {
	        return null;
	    }
	}

	public int delNguoiDung(NguoiDung nguoidung) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(nguoidung);
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

	public List<NguoiDung> getNDTheoNND(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM NguoiDung where nhomNguoiDung.id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<NguoiDung> list = query.list();
		return list;
	}


	public NguoiDung getNguoiDung_LOGIN(String tendangnhap, String matkhau) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM NguoiDung WHERE tenDangNhap = :tenDangNhap AND matKhau = :matKhau";
		Query query = session.createQuery(hql);
		query.setParameter("tenDangNhap", tendangnhap);
		query.setParameter("matKhau", matkhau);
		NguoiDung nguoidung = (NguoiDung) query.uniqueResult();
		return nguoidung;
	}

	public Integer editNguoiDung (NguoiDung nd) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(nd);
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
	public NguoiDung getNguoiDungByID (int id) {
		Session session = sessionFactory.openSession();
		String hql = "FROM NguoiDung where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);

		NguoiDung list = (NguoiDung) query.list().get(0);
		session.close();
		return list;
	}
	
	public int updateNguoiDung (NguoiDung nguoiDung) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(nguoiDung);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return 0;
		}finally {
			session.close();
		}
		return 1;
	}
	
	public int insertNguoiDung (NguoiDung nguoiDung) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(nguoiDung);
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
