package poly.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "THAMSO")
public class ThamSo {
	@Id @GeneratedValue
	private int id;
	
	private int TuoiToiThieu;
	private int TuoiToiDa;
	private int ThoiHanThe;
	private int KhoangCachXuatBan;
	private int SoSachMuonToiDa;
	private int SoNgayMuonToiDa;
	private int DonGiaPhat;
	private int AD_QDKTTienThu;
	
	public ThamSo() {
		super();
	}
	
	public ThamSo(int id, int tuoiToiThieu, int tuoiToiDa, int thoiHanThe, int khoangCachXuatBan, int soSachMuonToiDa,
			int soNgayMuonToiDa, int donGiaPhat, int aD_QDKTTienThu) {
		super();
		this.id = id;
		TuoiToiThieu = tuoiToiThieu;
		TuoiToiDa = tuoiToiDa;
		ThoiHanThe = thoiHanThe;
		KhoangCachXuatBan = khoangCachXuatBan;
		SoSachMuonToiDa = soSachMuonToiDa;
		SoNgayMuonToiDa = soNgayMuonToiDa;
		DonGiaPhat = donGiaPhat;
		AD_QDKTTienThu = aD_QDKTTienThu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTuoiToiThieu() {
		return TuoiToiThieu;
	}

	public void setTuoiToiThieu(int tuoiToiThieu) {
		TuoiToiThieu = tuoiToiThieu;
	}

	public int getTuoiToiDa() {
		return TuoiToiDa;
	}

	public void setTuoiToiDa(int tuoiToiDa) {
		TuoiToiDa = tuoiToiDa;
	}

	public int getThoiHanThe() {
		return ThoiHanThe;
	}

	public void setThoiHanThe(int thoiHanThe) {
		ThoiHanThe = thoiHanThe;
	}

	public int getKhoangCachXuatBan() {
		return KhoangCachXuatBan;
	}

	public void setKhoangCachXuatBan(int khoangCachXuatBan) {
		KhoangCachXuatBan = khoangCachXuatBan;
	}

	public int getSoSachMuonToiDa() {
		return SoSachMuonToiDa;
	}

	public void setSoSachMuonToiDa(int soSachMuonToiDa) {
		SoSachMuonToiDa = soSachMuonToiDa;
	}

	public int getSoNgayMuonToiDa() {
		return SoNgayMuonToiDa;
	}

	public void setSoNgayMuonToiDa(int soNgayMuonToiDa) {
		SoNgayMuonToiDa = soNgayMuonToiDa;
	}

	public int getDonGiaPhat() {
		return DonGiaPhat;
	}

	public void setDonGiaPhat(int donGiaPhat) {
		DonGiaPhat = donGiaPhat;
	}

	public int getAD_QDKTTienThu() {
		return AD_QDKTTienThu;
	}

	public void setAD_QDKTTienThu(int aD_QDKTTienThu) {
		AD_QDKTTienThu = aD_QDKTTienThu;
	}
	
}
