package poly.entity;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PHIEUTHU")
public class PhieuThu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SoPhieuThu")
	private Integer soPhieuThu;
	
	@Column(name = "SoTienThu")
	private Integer soTienThu;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "NgayLap")
	private Date ngayLap;
	
	@ManyToOne
	@JoinColumn(name="idDocGia")
	private DocGia docGia;

	public PhieuThu() {
		super();
	}


	public PhieuThu(Integer soPhieuThu, Integer soTienThu, Date ngayLap, DocGia docGia) {
		super();
		this.soPhieuThu = soPhieuThu;
		this.soTienThu = soTienThu;
		this.ngayLap = ngayLap;
		this.docGia = docGia;
	}



	public Integer getSoPhieuThu() {
		return soPhieuThu;
	}


	public void setSoPhieuThu(Integer soPhieuThu) {
		this.soPhieuThu = soPhieuThu;
	}


	public Integer getSoTienThu() {
		return soTienThu;
	}


	public void setSoTienThu(Integer soTienThu) {
		this.soTienThu = soTienThu;
	}


	public Date getNgayLap() {
		return ngayLap;
	}


	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}


	public DocGia getDocGia() {
		return docGia;
	}


	public void setDocGia(DocGia docGia) {
		this.docGia = docGia;
	}
	
	
}
