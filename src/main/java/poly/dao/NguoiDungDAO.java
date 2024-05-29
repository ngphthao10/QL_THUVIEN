package poly.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.NguoiDung;
import poly.entity.PhieuMuonTra;

@Repository
public class NguoiDungDAO {
	
	@Autowired
	SessionFactory factory;
	
	public NguoiDung getNguoiDung_LOGIN(String tendangnhap, String matkhau) {
		Session session = factory.openSession();
		String hql = "FROM NguoiDung WHERE tenDangNhap = :tenDangNhap AND matKhau = :matKhau";
		Query query = session.createQuery(hql);
		query.setParameter("tenDangNhap", tendangnhap);
		query.setParameter("matKhau", matkhau);
		NguoiDung nguoidung = (NguoiDung) query.uniqueResult();
		session.close();
		return nguoidung;
	}
	
	public Integer editNguoiDung (NguoiDung nd) {
		Session session = factory.openSession();
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
	
}
