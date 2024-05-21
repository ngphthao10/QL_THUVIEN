package poly.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import poly.dto.TuaSachDTO;
import poly.entity.*;

@Repository
public class TuaSachDAO {
	@Autowired
	SessionFactory sessionFactory;

	public List<TuaSach> getAllTuaSach() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM TuaSach";
		Query query = session.createQuery(hql);

		List<TuaSach> list = query.list();
		return list;
	}


	public List<TuaSach> getTuaSachByIdTheLoai(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from TuaSach where theloai.id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<TuaSach> list = query.list();
		return list;
	}

	public List<TuaSach> getSearch(String keyword) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT ts FROM poly.entity.TuaSach ts JOIN ts.CTTacGia ctg WHERE "
				+ "ts.MaTuaSach LIKE :keyword OR ts.TenTuaSach LIKE :keyword OR ctg.tacGia.TenTacGia LIKE :keyword";
		Query query = session.createQuery(hql);
		query.setParameter("keyword", "%" + keyword + "%");
		List<TuaSach> list = query.list();
		return list;
	}

	public int themTuaSach(TuaSachDTO tsDTO) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {
			TuaSach ts = tsDTO.getTuasach();
			session.save(ts);
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


	public TuaSach getTSTheoId(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from TuaSach where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		TuaSach list = (TuaSach) query.list().get(0);
		return list;
	}
	
	public TuaSach getTSTheoTen(String TenTuaSach) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from TuaSach where TenTuaSach = :TenTuaSach";
		Query query = session.createQuery(hql);
		query.setParameter("TenTuaSach", TenTuaSach);
		TuaSach list = (TuaSach) query.list().get(0);
		return list;
	}
	
	public int updateTuaSach(TuaSach ts) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(ts);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public int getSoLuongTS(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT COUNT(t) FROM TuaSach t WHERE t.theloai.id = :theLoaiId";
		Query query = session.createQuery(hql);
        query.setParameter("theLoaiId", id);
        Long result = (Long) query.uniqueResult();
        return result.intValue();
	}
	
}
