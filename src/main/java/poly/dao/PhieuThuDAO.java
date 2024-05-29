package poly.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.PhieuThu;

@Repository
public class PhieuThuDAO {

	@Autowired
	SessionFactory factory;
	
	public List<PhieuThu> getAllPhieuThu() {
		Session session = factory.openSession();
		String hql = "FROM PhieuThu";
		Query query = session.createQuery(hql);
		List<PhieuThu> list = query.list();
		session.close();
		return list;
	}
	
	public Integer insertPhieuThu(PhieuThu pt) {
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(pt);
			t.commit();
		} catch (Exception e) {
			System.out.println("Thêm thất bại!" + e.getMessage());
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public Integer editPhieuThu (PhieuThu pt) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(pt);
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
	
	public Integer deletePhieuThu (PhieuThu pt) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(pt);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;	
	}
	
	public List<PhieuThu> getPhieuThu_ID(int soPhieuThu ) {
		Session session = factory.openSession();
		String hql = "FROM PhieuThu pt WHERE pt.soPhieuThu = :soPhieuThu";
		Query query = session.createQuery(hql);
		query.setParameter("soPhieuThu", soPhieuThu);
		List<PhieuThu> list = query.list();
		session.close();
		return list;
	}
	
	public List<PhieuThu> getPhieuThu_MaDocGia(String maDocGia) {
		Session session = factory.openSession();
		String hql = "FROM PhieuThu pt WHERE LOWER(pt.docGia.maDocGia) = LOWER(:maDocGia)";
		Query query = session.createQuery(hql);
		query.setParameter("maDocGia", maDocGia);
		List<PhieuThu> list = query.list();
		session.close();
		return list;
	}

	public List<PhieuThu> getPhieuThu_TenDocGia(String tenDocGia) {
		Session session = factory.openSession();
		String hql = "FROM PhieuThu pt WHERE LOWER(pt.docGia.tenDocGia) LIKE LOWER(CONCAT('%', :tenDocGia, '%'))";
		Query query = session.createQuery(hql);
		query.setParameter("tenDocGia", tenDocGia);
		List<PhieuThu> list = query.list();
		session.close();
//		System.out.println(query);
		return list;	
	}
	
	public Integer getTongNoHienTai(String maDocGia ) {
		Session session = factory.openSession();
		String hql = "SELECT COALESCE(SUM(pt.soTienThu), 0) FROM PhieuThu pt WHERE LOWER(pt.docGia.maDocGia) = LOWER(:maDocGia)";
		Query query = session.createQuery(hql);
		query.setParameter("maDocGia", maDocGia);
		Integer result = Integer.valueOf(query.uniqueResult().toString());
		session.close();
		return result;
	}
	
	public List<PhieuThu> getPhieuThu_Filter(Date date) {
		Session session = factory.openSession();
		String hql = "FROM PhieuThu WHERE ngayLap = :ngaylap";
		Query query = session.createQuery(hql);
		query.setParameter("ngaylap", date);
		List<PhieuThu> list = query.list();
		session.close();
		return list;
	}
}
