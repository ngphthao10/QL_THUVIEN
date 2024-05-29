package poly.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.dto.SachDTO;
import poly.entity.CT_PhieuNhapId;
import poly.entity.CuonSach;
import poly.entity.PhieuNhapSach;
import poly.entity.Sach;
import poly.entity.TacGia;
import poly.entity.TuaSach;
import poly.service.*;

@Repository
public class SachDAO {
    @Autowired
    SessionFactory sessionFactory;
    
    @Autowired
	CuonSachService cuonSachService;
    
    @Autowired
    PhieuNhapSachService phieuNhapSachService;
    
    @Autowired
    CT_PhieuNhapService ctPhieuNhapService;

    public List<Sach> getAllSach() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Sach";
        Query query = session.createQuery(hql);
        List<Sach> list = query.list();
        return list;
    }

	public List<Sach> getSearch(String keyword) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT sa FROM Sach sa JOIN sa.tuaSach1 ts WHERE "
				+ "ts.TenTuaSach LIKE :keyword OR sa.NamXB LIKE :keyword OR sa.NhaXB LIKE :keyword";
		Query query = session.createQuery(hql);
		query.setParameter("keyword", "%" + keyword + "%");
		List<Sach> list = query.list();
		return list;
	}

	public List<Sach> getAllSachTheoTinhTrang(int daAn) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Sach where DaAn = :daAn";
		Query query = session.createQuery(hql);
		query.setParameter("daAn", daAn);
		List<Sach> list = query.list();
		return list;
	}
	
	public Sach getSachTheoId(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Sach where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		Sach list = (Sach) query.list().get(0);
		return list;
	}
	
	public List<Sach> getSachTheoIdTS(int id, int namxb) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Sach where tuaSach1.id = :id and NamXB = :namxb";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		query.setParameter("namxb", namxb);
		List<Sach> list =  query.list();
		return list;
	}

	public int themSachDaCo(SachDTO sachDTO) {
	    Session session = sessionFactory.openSession();
	    Transaction transaction = session.beginTransaction();

	    try {
	        Sach sach = sachDTO.getSach();
	        Sach sachTam = getSachTheoId(sach.getId());
	        System.out.println(sachTam.getId());
	        sach.setNhaXB(sachTam.getNhaXB());
	        sach.setNamXB(sachTam.getNamXB());
	        sach.setDonGia(sachTam.getDonGia());
	        sach.setTuaSach1(sachTam.getTuaSach1());
	        sach.setDaAn(sachTam.getDaAn());
	        sach.setSoLuong(sachTam.getSoLuong()+sachDTO.getCtpn().getSoLuongNhap());
	        sach.setSoLuongConLai(sachTam.getSoLuongConLai()+sachDTO.getCtpn().getSoLuongNhap());
	        session.update(sach);
	        int dongia = sach.getDonGia();
	        Date ngayNhap = sachDTO.getPns().getNgayNhap();
	        List<PhieuNhapSach> list = phieuNhapSachService.getPnsTheoNgay(ngayNhap);
	        
	        if(list.size()==0) {
	        	PhieuNhapSach pns = sachDTO.getPns();
		        session.save(pns);
		        int sophieunhap = pns.getSoPhieuNhap();
		        CT_PhieuNhapId ctphieuNhap = sachDTO.getCtpn();
		        ctphieuNhap.setDonGia(dongia);
		        ctphieuNhap.setSoPhieuNhap(sophieunhap);
		        ctphieuNhap.setThanhTien(dongia*ctphieuNhap.getSoLuongNhap());
		        ctphieuNhap.setSach2(sach);
		        session.save(ctphieuNhap);
		        pns.setTongTien(pns.getTongTien()+ctphieuNhap.getThanhTien());
		        
		        transaction.commit();
			       
		        for(int i=0; i<ctphieuNhap.getSoLuongNhap();i++) {
		        	CuonSach cuonsach = new CuonSach(sach);
		        	cuonSachService.themCuonSach(cuonsach);
		        }
	        }
	        else {
	        	PhieuNhapSach pns = list.get(0);
	        	int soPhieuNhap = pns.getSoPhieuNhap();
	        	List<CT_PhieuNhapId> ctList = ctPhieuNhapService.getAllPhieuNhapTheoMaSach(sach.getId());
	        	System.out.println(ctList.size());
	        	boolean daco = false; // đã nhập sách đó trong ngày nhập chưa
	        	CT_PhieuNhapId ctpn = null;
	        	for (CT_PhieuNhapId ct : ctList) {
	        		if (ct.getSoPhieuNhap() == soPhieuNhap) {
	        			daco = true;
	        			ctpn = ct;
	        			break;
	        		}
	        	}
	        	System.out.println(daco);
	        	if (!daco) {
	        		CT_PhieuNhapId ctphieuNhap = sachDTO.getCtpn();
			        ctphieuNhap.setDonGia(dongia);
			        ctphieuNhap.setSoPhieuNhap(soPhieuNhap);
			        ctphieuNhap.setThanhTien(dongia*ctphieuNhap.getSoLuongNhap());
			        ctphieuNhap.setSach2(sach);
			        session.save(ctphieuNhap);
			        
			        pns.setTongTien(pns.getTongTien()+ctphieuNhap.getThanhTien());
			        transaction.commit();
				       
			        for(int i=0; i<sachDTO.getCtpn().getSoLuongNhap();i++) {
			        	CuonSach cuonsach = new CuonSach(sach);
			        	cuonSachService.themCuonSach(cuonsach);
			        }
	        	}
	        	else {
	        		// sua ctpn, cong don so luong voi thanh tien
	        		ctpn.setSoLuongNhap(ctpn.getSoLuongNhap()+sachDTO.getCtpn().getSoLuongNhap());
			        ctpn.setThanhTien(dongia*ctpn.getSoLuongNhap());
			        session.update(ctpn);
			        
			        pns.setTongTien(pns.getTongTien()+dongia*sachDTO.getCtpn().getSoLuongNhap());
			        
			        transaction.commit();
				       
			        for(int i=0; i<sachDTO.getCtpn().getSoLuongNhap();i++) {
			        	CuonSach cuonsach = new CuonSach(sach);
			        	cuonSachService.themCuonSach(cuonsach);
			        }
	        	}
	        }
	        return 1;
	    } catch (HibernateException e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	        return 0;
	    } finally {
	        session.close();
	    }
	}
	
	public int themSachMoi(SachDTO sachDTO) {
	    Session session = sessionFactory.openSession();
	    Transaction transaction = session.beginTransaction();

	    try {
	        Sach sach = sachDTO.getSach();
	        List<Sach> sachList = this.getSachTheoIdTS(sach.getTuaSach1().getId(), sach.getNamXB());
	        if(sachList.size()!=0) {
	        	return -1;
	        }
	        session.save(sach);
	        int dongia = sach.getDonGia();
	        Date ngayNhap = sachDTO.getPns().getNgayNhap();
	        List<PhieuNhapSach> list = phieuNhapSachService.getPnsTheoNgay(ngayNhap);
	        
	        if(list.size()==0) {
	        	PhieuNhapSach pns = sachDTO.getPns();
		        session.save(pns);
		        int sophieunhap = pns.getSoPhieuNhap();
		        CT_PhieuNhapId ctphieuNhap = sachDTO.getCtpn();
		        ctphieuNhap.setDonGia(dongia);
		        ctphieuNhap.setSoPhieuNhap(sophieunhap);
		        ctphieuNhap.setThanhTien(dongia*ctphieuNhap.getSoLuongNhap());
		        ctphieuNhap.setSach2(sach);
		        session.save(ctphieuNhap);
		        
		        sach.setSoLuong(sach.getSoLuong() + ctphieuNhap.getSoLuongNhap());
		        sach.setSoLuongConLai(sach.getSoLuongConLai() + ctphieuNhap.getSoLuongNhap());
		        
		        pns.setTongTien(pns.getTongTien()+ctphieuNhap.getThanhTien());
		        
		        transaction.commit();
			       
		        for(int i=0; i<ctphieuNhap.getSoLuongNhap();i++) {
		        	CuonSach cuonsach = new CuonSach(sach);
		        	cuonSachService.themCuonSach(cuonsach);
		        }
	        }
	        else {
	        	PhieuNhapSach pns = list.get(0);
	        	int soPhieuNhap = pns.getSoPhieuNhap();
	        	List<CT_PhieuNhapId> ctList = ctPhieuNhapService.getAllPhieuNhapTheoMaSach(sach.getId());
	        	System.out.println(ctList.size());
	        	boolean daco = false; // đã nhập sách đó trong ngày nhập chưa
	        	CT_PhieuNhapId ctpn = null;
	        	for (CT_PhieuNhapId ct : ctList) {
	        		if (ct.getSoPhieuNhap() == soPhieuNhap) {
	        			daco = true;
	        			ctpn = ct;
	        			break;
	        		}
	        	}
	        	System.out.println(daco);
	        	if (!daco) {
	        		CT_PhieuNhapId ctphieuNhap = sachDTO.getCtpn();
			        ctphieuNhap.setDonGia(dongia);
			        ctphieuNhap.setSoPhieuNhap(soPhieuNhap);
			        ctphieuNhap.setThanhTien(dongia*ctphieuNhap.getSoLuongNhap());
			        ctphieuNhap.setSach2(sach);
			        session.save(ctphieuNhap);
			        
			        sach.setSoLuong(sach.getSoLuong() + ctphieuNhap.getSoLuongNhap());
			        sach.setSoLuongConLai(sach.getSoLuongConLai() + ctphieuNhap.getSoLuongNhap());
			        
			        pns.setTongTien(pns.getTongTien()+ctphieuNhap.getThanhTien());
			        transaction.commit();
				       
			        for(int i=0; i<ctphieuNhap.getSoLuongNhap();i++) {
			        	CuonSach cuonsach = new CuonSach(sach);
			        	cuonSachService.themCuonSach(cuonsach);
			        }
	        	}
	        	else {
	        		// sua ctpn, cong don so luong voi thanh tien
			        ctpn.setThanhTien(dongia*ctpn.getSoLuongNhap());
			        session.update(ctpn);
			        
			        sach.setSoLuong(sach.getSoLuong() + ctpn.getSoLuongNhap());
			        sach.setSoLuongConLai(sach.getSoLuongConLai() + ctpn.getSoLuongNhap());
			        
			        pns.setTongTien(pns.getTongTien()+ctpn.getThanhTien());
			        
			        transaction.commit();
				       
			        for(int i=0; i<ctpn.getSoLuongNhap();i++) {
			        	CuonSach cuonsach = new CuonSach(sach);
			        	cuonSachService.themCuonSach(cuonsach);
			        }
	        	}
	        }
	        return 1;
	    } catch (HibernateException e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	        return 0;
	    } finally {
	        session.close();
	    }
	}
	
	public int editSach(SachDTO sachDTO) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(sachDTO.getSach());
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	public int editSach(Sach sach) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(sach);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public List<Sach> getAllSachChoUser() {
		Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Sach where DaAn=0";
        Query query = session.createQuery(hql);
        List<Sach> list = query.list();
        return list;
	}

	public List<Sach> getAllSachTheoTheLoai(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Sach where tuaSach1.theloai.id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<Sach> list =  query.list();
		return list;
	}

	public List<Sach> getAllSachTheoSLCL(int conlai) {
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "";
		if(conlai == 0) {
			hql = "from Sach where SoLuongConLai = 0 and DaAn=0";
		}
		else {
			hql = "from Sach where SoLuongConLai > 0 and DaAn=0";
		}
		Query query = session.createQuery(hql);
		List<Sach> list =  query.list();
		return list;
	}

	public List<Sach> getSearchChoUser(String keyword) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT sa FROM Sach sa JOIN sa.tuaSach1 ts WHERE "
				+ "ts.TenTuaSach LIKE :keyword OR sa.NamXB LIKE :keyword OR sa.NhaXB LIKE :keyword and sa.DaAn=0";
		Query query = session.createQuery(hql);
		query.setParameter("keyword", "%" + keyword + "%");
		List<Sach> list = query.list();
		return list;
	}

	public Long getSoLuongSach() {
	    Session session = sessionFactory.getCurrentSession();
	    String hql = "SELECT count(*) FROM Sach";
	    Query query = session.createQuery(hql);
        Long result = (Long) query.uniqueResult();
	    return result;
	}

	public Sach getSachFromMaSach(String maSach) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Sach WHERE MaSach = :maSach";
		Query query = session.createQuery(hql);
		query.setParameter("maSach", maSach);
		Sach sach = (Sach)query.uniqueResult();
		session.close();
		return sach;
	}


 }
