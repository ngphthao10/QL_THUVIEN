package poly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "CUONSACH")
public class CuonSach {
	
	@Id @GeneratedValue
	private int id;
	@Column(updatable=false, insertable=false)
	private String MaCuonSach;
	
	@ManyToOne
	@JoinColumn(name="idSach", referencedColumnName="id")
	private Sach sach1;
	
	@ColumnDefault("0")
	private int TinhTrang;
	
	@ColumnDefault("0")
	private int DaAn;
	
	public CuonSach() {
		super();
	}
	
	public CuonSach(Sach sach) {
		super();
		this.sach1 = sach;
	}
	
	public CuonSach(int id, String maCuonSach, Sach sach1, int tinhTrang, int daAn) {
		super();
		this.id = id;
		MaCuonSach = maCuonSach;
		this.sach1 = sach1;
		TinhTrang = tinhTrang;
		DaAn = daAn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaCuonSach() {
		return MaCuonSach;
	}

	public void setMaCuonSach(String maCuonSach) {
		MaCuonSach = maCuonSach;
	}

	public Sach getSach1() {
		return sach1;
	}
	
	public String getMaSach() {
		return sach1.getMaSach();
	}

	public String getTenTuaSach() {
		return sach1.getTuaSach1().getTenTuaSach();
	}

	public void setSach1(Sach sach1) {
		this.sach1 = sach1;
	}

//	public String getTinhTrang() {
//		if((Integer)this.TinhTrang == 0) {
//			return "Chưa được mượn";
//		}
//		return "Đã được mượn";
//	}
	
	public void setTinhTrang(int tinhTrang) {
		TinhTrang = tinhTrang;
	}

	public int getTinhTrang() {
		return TinhTrang;
	}

	public int getDaAn() {
		return DaAn;
	}

	public void setDaAn(int daAn) {
		DaAn = daAn;
	}

}
