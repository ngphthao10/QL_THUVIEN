package poly.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.NhomNguoiDung;
import poly.entity.PhieuMuonTra;

@Repository
public class PhieuMuonTraDAO {
	@Autowired
	SessionFactory factory;
	
	public List<PhieuMuonTra> getPhieuMuonTra_IDDocGia(int id){
		Session session = factory.getCurrentSession();
		String hql = "FROM PhieuMuonTra where idDocGia = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<PhieuMuonTra> list = query.list();
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
		Query query = session.createQuery(hql);
		query.setParameter("soPhieuMuonTra", soPhieuMuonTra);
		List<PhieuMuonTra> list = query.list();
		session.close();
		return list;
	}
	public PhieuMuonTra getPhieuMuonTraID(int soPhieuMuonTra ) {
		Session session = factory.getCurrentSession();
		String hql = "FROM PhieuMuonTra p WHERE p.soPhieuMuonTra = :soPhieuMuonTra";
		Query query = session.createQuery(hql);
		query.setParameter("soPhieuMuonTra", soPhieuMuonTra);
		PhieuMuonTra list = (PhieuMuonTra)query.uniqueResult();
//		session.close();
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

	public Long getSoLuongPhieuMuon(int month, int year) {
		Session session = factory.openSession();
		String hql = "SELECT COUNT(SoPhieuMuonTra) FROM PhieuMuonTra WHERE MONTH(ngayMuon) = :month AND YEAR(ngayMuon) = :year";
		Query query = session.createQuery(hql);
		query.setParameter("month", month);
		query.setParameter("year", year);
		Long result = (long)query.uniqueResult();
		session.close();
		return result;
	}
	
	public Long getSoLuotMuonQuaHan(int month, int year) {
		Session session = factory.openSession();
		String hql = "SELECT COUNT(SoPhieuMuonTra) FROM PhieuMuonTra WHERE MONTH(ngayMuon) = :month AND YEAR(ngayMuon) = :year"
				+ " AND ( ngayTra > hanTra or hanTra < current_date())";
		Query query = session.createQuery(hql);
		query.setParameter("month", month);
		query.setParameter("year", year);
		Long result = (long)query.uniqueResult();
		session.close();
		return result;
	}

	public List<PhieuMuonTra> getPhieuMuonTra_Filter(Date date) {
		Session session = factory.openSession();
		String hql = "FROM PhieuMuonTra WHERE ngayMuon = :ngaymuon";
		Query query = session.createQuery(hql);
		query.setParameter("ngaymuon", date);
		List<PhieuMuonTra> list = query.list();
		session.close();
		return list;
	}
	public List<PhieuMuonTra> getAllPhieuMuonTra() {
		Session session = factory.getCurrentSession();
		String hql = "FROM PhieuMuonTra";
		Query query = session.createQuery(hql);

		List<PhieuMuonTra> list = query.list();
		return list;
	}

}
