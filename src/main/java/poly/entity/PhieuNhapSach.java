package poly.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PhieuNhapSach")
public class PhieuNhapSach {

	@Id @GeneratedValue
	private int SoPhieuNhap;
	private int TongTien;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date NgayNhap;
	
	@OneToMany(mappedBy="phieuNhap", fetch=FetchType.EAGER)
	private Collection<CT_PhieuNhapId> ctPhieuNhap;

	public int getSoPhieuNhap() {
		return SoPhieuNhap;
	}

	public void setSoPhieuNhap(int soPhieuNhap) {
		SoPhieuNhap = soPhieuNhap;
	}

	public int getTongTien() {
		return TongTien;
	}

	public void setTongTien(int tongTien) {
		TongTien = tongTien;
	}

	public Date getNgayNhap() {
		return NgayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		NgayNhap = ngayNhap;
	}

	public Collection<CT_PhieuNhapId> getCtPhieuNhap() {
		return ctPhieuNhap;
	}

	public void setCtPhieuNhap(Collection<CT_PhieuNhapId> ctPhieuNhap) {
		this.ctPhieuNhap = ctPhieuNhap;
	}
	
}
