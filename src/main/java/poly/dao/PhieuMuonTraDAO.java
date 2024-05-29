package poly.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.PhieuMuonTra;
import poly.entity.PhieuThu;

@Repository
public class PhieuMuonTraDAO {

	@Autowired
	SessionFactory factory;
	
	public List<PhieuMuonTra> getAllPhieuMuonTra() {
		Session session = factory.openSession();
		String hql = "FROM PhieuMuonTra";
		Query query = session.createQuery(hql);
		List<PhieuMuonTra> list = query.list();
		session.close();
		return list;
	}

	public Integer insertPhieuMuonTra(PhieuMuonTra p) {
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(p);
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
	
	public Integer editPhieuMuonTra (PhieuMuonTra p) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(p);
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
	
	public Integer deletePhieuMuonTra (PhieuMuonTra p) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(p);
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

	public List<PhieuMuonTra> getPhieuMuonTraByID(int soPhieuMuonTra ) {
		Session session = factory.openSession();
		String hql = "FROM PhieuMuonTra p WHERE p.soPhieuMuonTra = :soPhieuMuonTra";
		System.out.println(soPhieuMuonTra);
		Query query = session.createQuery(hql);
		query.setParameter("soPhieuMuonTra", soPhieuMuonTra);
		List<PhieuMuonTra> list = query.list();
		session.close();
		return list;
	}
	
	public List<PhieuMuonTra> getPhieuMuonTraByMaDG(String madocgia ) {
		Session session = factory.openSession();
		String hql = "FROM PhieuMuonTra p WHERE LOWER(p.docGia.maDocGia) = LOWER(:maDocGia)";
		System.out.println("mã độc giả");
		Query query = session.createQuery(hql);
		query.setParameter("maDocGia", madocgia);
		List<PhieuMuonTra> list = query.list();
		session.close();
		return list;
	}
	
	public List<PhieuMuonTra> getPhieuMuonTraByTenDocGia(String tendocgia) {
		Session session = factory.openSession();
		String hql = "FROM PhieuMuonTra p WHERE LOWER(p.docGia.tenDocGia) LIKE LOWER(CONCAT('%', :tenDocGia, '%'))";
		System.out.println("tên độc giả");
		Query query = session.createQuery(hql);
		query.setParameter("tenDocGia", tendocgia);
		List<PhieuMuonTra> list = query.list();
		session.close();
		return list;
	}
	
	public List<PhieuMuonTra> getPhieuMuonTraByMaCS(String maCS ) {
		Session session = factory.openSession();
		String hql = "FROM PhieuMuonTra p WHERE LOWER(p.cuonSach.MaCuonSach) = LOWER(:macuonsach)";
		System.out.println("mã cuốn sách");
		Query query = session.createQuery(hql);
		query.setParameter("macuonsach", maCS);
		List<PhieuMuonTra> list = query.list();
		session.close();
		return list;
	}
	
	public List<PhieuMuonTra> getPhieuMuonTraByTenSach(String tenTuaSach) {
		Session session = factory.openSession();
		String hql = "FROM PhieuMuonTra WHERE LOWER(cuonSach.sach1.tuaSach1.TenTuaSach) LIKE LOWER(CONCAT('%', :tenTuaSach, '%'))";
		System.out.println("tên tựa sách");
		System.out.println(tenTuaSach);
		Query query = session.createQuery(hql);
		query.setParameter("tenTuaSach", tenTuaSach);
		System.out.println(query.getQueryString());
		List<PhieuMuonTra> list = query.list();
		session.close();
		return list;
	}

}
