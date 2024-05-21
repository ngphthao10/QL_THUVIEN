package poly.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PHANQUYEN")
public class PhanQuyen implements Serializable {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "idNhomNguoiDung")
	private NhomNguoiDung nhomNguoiDung;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "idChucNang")
	private ChucNang chucNang;
	

	public PhanQuyen() {
		super();
	}


	public PhanQuyen(NhomNguoiDung nhomNguoiDung, ChucNang chucNang) {
		super();
		this.nhomNguoiDung = nhomNguoiDung;
		this.chucNang = chucNang;
	}


	public NhomNguoiDung getNhomNguoiDung() {
		return nhomNguoiDung;
	}


	public void setNhomNguoiDung(NhomNguoiDung nhomNguoiDung) {
		this.nhomNguoiDung = nhomNguoiDung;
	}


	public ChucNang getChucNang() {
		return chucNang;
	}


	public void setChucNang(ChucNang chucNang) {
		this.chucNang = chucNang;
	}
	
}
