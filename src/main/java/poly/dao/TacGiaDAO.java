package poly.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.TacGia;
import poly.entity.TheLoai;
import poly.entity.TuaSach;

@Repository
public class TacGiaDAO {
	@Autowired
	SessionFactory sessionFactory;

	public List<TacGia> getTacGia() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from TacGia t order by t.TenTacGia asc";
		Query query = session.createQuery(hql);
		List<TacGia> list = query.list();
		return list;
	}
	
	public int themTacGia(TacGia tg) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(tg);
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

	public TacGia getTGTheoId(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from TacGia where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		TacGia list = (TacGia) query.list().get(0);
		return list;
	}

	public int editTacGia(TacGia tacgia) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(tacgia);
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

	public int delTacGia(TacGia tacGia) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(tacGia);
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

	public List<TacGia> getCTTGTheoId(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT tg.TenTacGia FROM TacGia AS tg " +
					 "WHERE tg.id IN ( " +
					 	"SELECT ct.tacGia.id FROM CT_TacGiaId AS ct " +
						"WHERE ct.tuaSach2.id = :id)";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<TacGia> list = query.list();
		return list;
	}

	public TacGia getIdTheoTenTG(String TenTacGia) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from TacGia where TenTacGia = :TenTacGia";
		Query query = session.createQuery(hql);
		query.setParameter("TenTacGia", TenTacGia);
		TacGia list = (TacGia) query.list().get(0);
		return list;
	}
}
