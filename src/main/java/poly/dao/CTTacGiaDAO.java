package poly.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.CT_TacGiaId;

@Repository
public class CTTacGiaDAO {
	@Autowired
    SessionFactory sessionFactory;
	
	public int themCTTacGia(CT_TacGiaId cttg) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(cttg);
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

	public int editCTTacGia(CT_TacGiaId cttg) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(cttg);
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
	
	public int xoaCTTGCuaTuaSach(int idTuaSach) {
	    Session session = sessionFactory.openSession();
	    Transaction t = session.beginTransaction();

	    try {
	        Query query = session.createQuery("DELETE FROM CT_TacGiaId WHERE tuaSach2.id = :idTuaSach");
	        query.setParameter("idTuaSach", idTuaSach);
	        query.executeUpdate();
	        t.commit();
	    } catch (Exception e) {
	        t.rollback();
	        return 0; 
	    } finally {
	        session.close();
	    }
	    return 1;
	}

}
