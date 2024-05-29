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
	
	private Integer TuoiToiThieu;
	private Integer TuoiToiDa;
	private Integer ThoiHanThe;
	private Integer KhoangCachXuatBan;
	private Integer SoSachMuonToiDa;
	private Integer SoNgayMuonToiDa;
	private Integer DonGiaPhat;
	
	public ThamSo() {
		super();
	}

	public ThamSo(int id, Integer tuoiToiThieu, Integer tuoiToiDa, Integer thoiHanThe, Integer khoangCachXuatBan,
			Integer soSachMuonToiDa, Integer soNgayMuonToiDa, Integer donGiaPhat) {
		super();
		this.id = id;
		TuoiToiThieu = tuoiToiThieu;
		TuoiToiDa = tuoiToiDa;
		ThoiHanThe = thoiHanThe;
		KhoangCachXuatBan = khoangCachXuatBan;
		SoSachMuonToiDa = soSachMuonToiDa;
		SoNgayMuonToiDa = soNgayMuonToiDa;
		DonGiaPhat = donGiaPhat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getTuoiToiThieu() {
		return TuoiToiThieu;
	}

	public void setTuoiToiThieu(Integer tuoiToiThieu) {
		TuoiToiThieu = tuoiToiThieu;
	}

	public Integer getTuoiToiDa() {
		return TuoiToiDa;
	}

	public void setTuoiToiDa(Integer tuoiToiDa) {
		TuoiToiDa = tuoiToiDa;
	}

	public Integer getThoiHanThe() {
		return ThoiHanThe;
	}

	public void setThoiHanThe(Integer thoiHanThe) {
		ThoiHanThe = thoiHanThe;
	}

	public Integer getKhoangCachXuatBan() {
		return KhoangCachXuatBan;
	}

	public void setKhoangCachXuatBan(Integer khoangCachXuatBan) {
		KhoangCachXuatBan = khoangCachXuatBan;
	}

	public Integer getSoSachMuonToiDa() {
		return SoSachMuonToiDa;
	}

	public void setSoSachMuonToiDa(Integer soSachMuonToiDa) {
		SoSachMuonToiDa = soSachMuonToiDa;
	}

	public Integer getSoNgayMuonToiDa() {
		return SoNgayMuonToiDa;
	}

	public void setSoNgayMuonToiDa(Integer soNgayMuonToiDa) {
		SoNgayMuonToiDa = soNgayMuonToiDa;
	}

	public Integer getDonGiaPhat() {
		return DonGiaPhat;
	}

	public void setDonGiaPhat(Integer donGiaPhat) {
		DonGiaPhat = donGiaPhat;
	}

}
