package poly.entity;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "NGUOIDUNG")
public class NguoiDung {
	
	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "MaNguoiDung", insertable=false, updatable=false)
	private String maNguoiDung;
	
	@Column(name = "TenNguoiDung")
	private String tenNguoiDung;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngaySinh;
	
	@Column(name = "ChucVu")
	private String chucVu;
	
	@Column(name = "TenDangNhap")
	private String tenDangNhap;
	
	@Column(name = "MatKhau")
	private String matKhau;
	
	@ManyToOne
	@JoinColumn(name = "idNhomNguoiDung")
	private NhomNguoiDung nhomNguoiDung;

	@OneToOne(mappedBy = "nguoiDung", cascade = CascadeType.ALL)
	private DocGia docGia;
	
	public NguoiDung() {
		super();
	}

	public NguoiDung(int id, String maNguoiDung, String tenNguoiDung, Date ngaySinh, String chucVu, String tenDangNhap,
			String matKhau, NhomNguoiDung nhomNguoiDung, DocGia docGia) {
		super();
		this.id = id;
		this.maNguoiDung = maNguoiDung;
		this.tenNguoiDung = tenNguoiDung;
		this.ngaySinh = ngaySinh;
		this.chucVu = chucVu;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.nhomNguoiDung = nhomNguoiDung;
		this.docGia = docGia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(String maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public String getTenNguoiDung() {
		return tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public NhomNguoiDung getNhomNguoiDung() {
		return nhomNguoiDung;
	}

	public void setNhomNguoiDung(NhomNguoiDung nhomNguoiDung) {
		this.nhomNguoiDung = nhomNguoiDung;
	}

	public DocGia getDocGia() {
		return docGia;
	}

	public void setDocGia(DocGia docGia) {
		this.docGia = docGia;
	}
}
