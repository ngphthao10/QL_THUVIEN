package poly.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PHIEUMUONTRA")
public class PhieuMuonTra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SoPhieuMuonTra")
	private int soPhieuMuonTra;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "NgayMuon")
	private Date ngayMuon;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "ngayTra")
	private Date ngayTra;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "HanTra")
	private Date hanTra;
	
	@Column(name = "SoTienPhat")
	private int soTienPhat;
	
	@ManyToOne
	@JoinColumn(name="idDocGia")
	private DocGia docGia;
	
	@ManyToOne
	@JoinColumn(name="idCuonSach")
	private CuonSach cuonSach;

	public PhieuMuonTra() {
		super();
	}
	
	public PhieuMuonTra(int soPhieuMuonTra, Date ngayMuon, Date ngayTra, Date hanTra, int soTienPhat, DocGia docGia,
			CuonSach cuonSach) {
		super();
		this.soPhieuMuonTra = soPhieuMuonTra;
		this.ngayMuon = ngayMuon;
		this.ngayTra = ngayTra;
		this.hanTra = hanTra;
		this.soTienPhat = soTienPhat;
		this.docGia = docGia;
		this.cuonSach = cuonSach;
	}

	public int getSoPhieuMuonTra() {
		return soPhieuMuonTra;
	}

	public void setSoPhieuMuonTra(int soPhieuMuonTra) {
		this.soPhieuMuonTra = soPhieuMuonTra;
	}

	public Date getNgayMuon() {
		return ngayMuon;
	}

	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

	public Date getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}

	public Date getHanTra() {
		return hanTra;
	}

	public void setHanTra(Date hanTra) {
		this.hanTra = hanTra;
	}

	public int getSoTienPhat() {
		return soTienPhat;
	}

	public void setSoTienPhat(int soTienPhat) {
		this.soTienPhat = soTienPhat;
	}

	public DocGia getDocGia() {
		return docGia;
	}

	public void setDocGia(DocGia docGia) {
		this.docGia = docGia;
	}

	public CuonSach getCuonSach() {
		return cuonSach;
	}

	public void setCuonSach(CuonSach cuonSach) {
		this.cuonSach = cuonSach;
	}
	
	public String getFormattedNgayMuon() {
		return formatDate(getNgayMuon());
	}

	public String getFormattedNgayTra() {
		return formatDate(getNgayTra());
	}

	public String getFormattedHanTra() {
		return formatDate(getHanTra());
	}

	private String formatDate(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return simpleDateFormat.format(date);
	}
	
}
