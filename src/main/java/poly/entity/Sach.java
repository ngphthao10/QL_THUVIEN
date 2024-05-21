package poly.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "SACH")
public class Sach {

	@Id @GeneratedValue()
	private int id;
	
	@Column(updatable=false, insertable=false)
	private String MaSach;
	
	@ManyToOne
	@JoinColumn(name="idTuaSach",  referencedColumnName="id")
	private TuaSach tuaSach1;
	
	private int SoLuong;
	private int SoLuongConLai;
	
	private int DonGia;
	private int NamXB;
	private String NhaXB;

	private String TenHienThi;
	
	@ColumnDefault("0")
	private int DaAn;

	@OneToMany(mappedBy="sach1", fetch=FetchType.EAGER)
	private Collection<CuonSach> cuonSach;
	
	@OneToMany(mappedBy="sach2", fetch=FetchType.EAGER)
	private Collection<CT_PhieuNhapId> ctPhieuNhap;

	public Sach() {
		super();
	}

	public Sach(int id, String maSach, TuaSach tuaSach1, int soLuong, int soLuongConLai, int donGia, int namXB,
			String nhaXB, int daAn, Collection<CuonSach> cuonSach, Collection<CT_PhieuNhapId> ctPhieuNhap) {
		super();
		this.id = id;
		MaSach = maSach;
		this.tuaSach1 = tuaSach1;
		SoLuong = soLuong;
		SoLuongConLai = soLuongConLai;
		DonGia = donGia;
		NamXB = namXB;
		NhaXB = nhaXB;
		DaAn = daAn;
		this.cuonSach = cuonSach;
		this.ctPhieuNhap = ctPhieuNhap;
		this.TenHienThi = maSach + " - " + this.tuaSach1.getTenTuaSach();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenHienThi() {
		return MaSach + " - " + this.tuaSach1.getTenTuaSach() + " (" + NamXB + ")";
	}

	public void setTenHienThi(String tenHienThi) {
		TenHienThi = tenHienThi;
	}

	public String getMaSach() {
		return MaSach;
	}

	public void setMaSach(String maSach) {
		MaSach = maSach;
	}

	public TuaSach getTuaSach1() {
		return tuaSach1;
	}
	
	public String getTenTuaSach() {
		return tuaSach1.getTenTuaSach();
	}

	public void setTuaSach1(TuaSach tuaSach1) {
		this.tuaSach1 = tuaSach1;
	}

	public int getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}

	public int getSoLuongConLai() {
		return SoLuongConLai;
	}

	public void setSoLuongConLai(int soLuongConLai) {
		SoLuongConLai = soLuongConLai;
	}

	public int getDonGia() {
		return DonGia;
	}

	public void setDonGia(int donGia) {
		DonGia = donGia;
	}

	public int getNamXB() {
		return NamXB;
	}

	public void setNamXB(int namXB) {
		NamXB = namXB;
	}

	public String getNhaXB() {
		return NhaXB;
	}

	public void setNhaXB(String nhaXB) {
		NhaXB = nhaXB;
	}

	public int getDaAn() {
		return DaAn;
	}

	public void setDaAn(int daAn) {
		DaAn = daAn;
	}

	public Collection<CuonSach> getCuonSach() {
		return cuonSach;
	}

	public void setCuonSach(Collection<CuonSach> cuonSach) {
		this.cuonSach = cuonSach;
	}

	public Collection<CT_PhieuNhapId> getCtPhieuNhap() {
		return ctPhieuNhap;
	}

	public void setCtPhieuNhap(Collection<CT_PhieuNhapId> ctPhieuNhap) {
		this.ctPhieuNhap = ctPhieuNhap;
	}
	
	public String getTinhTrang() {
		return (this.SoLuongConLai>0) ? "Còn" : "Hết";
	}
	
}
