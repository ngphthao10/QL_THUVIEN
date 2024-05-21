package poly.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import poly.entity.TheLoai;
import poly.entity.TuaSach;

@Repository
public class TheLoaiDAO {
    @Autowired
    SessionFactory sessionFactory;

    public List<TheLoai> getAllTheLoai() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM TheLoai";
        Query query = session.createQuery(hql);

        List<TheLoai> list = query.list();
        return list;
    }

	public int themTheLoai(TheLoai tl) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(tl);
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

	public TheLoai getTLTheoId(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from TheLoai where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		TheLoai list = (TheLoai) query.list().get(0);
		return list;
	}

	public Integer updateTheLoai(TheLoai tl) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(tl);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
    
	public Integer deleteTheLoai(TheLoai tl) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(tl);
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

	public TheLoai getTLTheoTen(String tenTheLoai) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from TheLoai where TenTheLoai = :tenTheLoai";
		Query query = session.createQuery(hql);
		query.setParameter("tenTheLoai", tenTheLoai);
	    List<TheLoai> resultList = query.list();
	    if (resultList != null && !resultList.isEmpty()) {
	        return resultList.get(0);
	    } else {
	        return null;
	    }
	}
 }

