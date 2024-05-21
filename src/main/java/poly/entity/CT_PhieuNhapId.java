package poly.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CT_PHIEUNHAP")
public class CT_PhieuNhapId implements Serializable {
	@Id
	@ManyToOne
	@JoinColumn(name="SoPhieuNhap", referencedColumnName="SoPhieuNhap")
	private PhieuNhapSach phieuNhap;
	
	@Id
	@ManyToOne
	@JoinColumn(name="idSach", referencedColumnName="id")
	private Sach sach2;

	private int DonGia;
	private int ThanhTien;
	private int SoLuongNhap;
	
	public int getSoPhieuNhap() {
		return phieuNhap.getSoPhieuNhap();
	}
	
	public void setSoPhieuNhap(int soPhieuNhap) {
		if(phieuNhap == null) {
			phieuNhap = new PhieuNhapSach();
		}
		phieuNhap.setSoPhieuNhap(soPhieuNhap);
	}
	public String getMaSach() {
		return sach2.getMaSach();
	}
	
	public String getTenTuaSach() {
		return sach2.getTenTuaSach();
	}
	
	public Sach getSach2() {
		return sach2;
	}
	public void setSach2(Sach sach2) {
		this.sach2 = sach2;
	}
	public int getDonGia() {
		return DonGia;
	}
	public void setDonGia(int donGia) {
		DonGia = donGia;
	}
	public int getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(int thanhTien) {
		ThanhTien = thanhTien;
	}
	public int getSoLuongNhap() {
		return SoLuongNhap;
	}
	public void setSoLuongNhap(int soLuongNhap) {
		SoLuongNhap = soLuongNhap;
	}
}
