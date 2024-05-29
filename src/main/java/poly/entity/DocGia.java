package poly.entity;

import java.text.SimpleDateFormat;
import java.util.Collection;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "DOCGIA")
public class DocGia {
	
	@Id @GeneratedValue
	@Column(name = "ID")
	private int id;
	
	@Column(name = "MaDocGia", insertable=false, updatable=false)
	private String maDocGia;
	
	@Column(name = "TenDocGia")
	private String tenDocGia;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngaySinh;
	
	@Column(name = "DiaChi")
	private String diaChi;
	
	@Column(name = "Email")
	private String email;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngayLapThe;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngayHetHan;
	
	@Column(name = "TongNoHienTai")
	private int tongNoHienTai;
	
	@OneToOne
    @JoinColumn(name = "idNguoiDung", referencedColumnName = "id")
    private NguoiDung nguoiDung;

    @OneToMany(mappedBy="docGia", fetch=FetchType.LAZY)
//    @Fetch(FetchMode.SUBSELECT)
    private Collection<PhieuThu> listPhieuThu;

    @OneToMany(mappedBy="docGia", fetch=FetchType.LAZY)
//    @Fetch(FetchMode.SUBSELECT)
    private Collection<PhieuMuonTra> listPhieuMuonTra;
	
	@ManyToOne
	@JoinColumn(name="idLoaiDocGia")
	private LoaiDocGia loaiDocGia;

	public DocGia() {
		super();
	}

	public DocGia(int id, String maDocGia, String tenDocGia, Date ngaySinh, String diaChi, String email,
			Date ngayLapThe, Date ngayHetHan, int tongNoHienTai, NguoiDung nguoiDung, Collection<PhieuThu> listPhieuThu,
			Collection<PhieuMuonTra> listPhieuMuonTra, LoaiDocGia loaiDocGia) {
		super();
		this.id = id;
		this.maDocGia = maDocGia;
		this.tenDocGia = tenDocGia;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.email = email;
		this.ngayLapThe = ngayLapThe;
		this.ngayHetHan = ngayHetHan;
		this.tongNoHienTai = tongNoHienTai;
		this.nguoiDung = nguoiDung;
		this.listPhieuThu = listPhieuThu;
		this.listPhieuMuonTra = listPhieuMuonTra;
		this.loaiDocGia = loaiDocGia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaDocGia() {
		return maDocGia;
	}

	public void setMaDocGia(String maDocGia) {
		this.maDocGia = maDocGia;
	}

	public String getTenDocGia() {
		return tenDocGia;
	}

	public void setTenDocGia(String tenDocGia) {
		this.tenDocGia = tenDocGia;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNgayLapThe() {
		return ngayLapThe;
	}

	public void setNgayLapThe(Date ngayLapThe) {
		this.ngayLapThe = ngayLapThe;
	}

	public Date getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public int getTongNoHienTai() {
		return tongNoHienTai;
	}

	public void setTongNoHienTai(int tongNoHienTai) {
		this.tongNoHienTai = tongNoHienTai;
	}

	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	public Collection<PhieuThu> getListPhieuThu() {
		return listPhieuThu;
	}

	public void setListPhieuThu(Collection<PhieuThu> listPhieuThu) {
		this.listPhieuThu = listPhieuThu;
	}

	public Collection<PhieuMuonTra> getListPhieuMuonTra() {
		return listPhieuMuonTra;
	}

	public void setListPhieuMuonTra(Collection<PhieuMuonTra> listPhieuMuonTra) {
		this.listPhieuMuonTra = listPhieuMuonTra;
	}

	public LoaiDocGia getLoaiDocGia() {
		return loaiDocGia;
	}

	public void setLoaiDocGia(LoaiDocGia loaiDocGia) {
		this.loaiDocGia = loaiDocGia;
	}
	public String getFormattedNgaySinh() {
		return formatDate(getNgaySinh());
	}

	public String getFormattedNgayLapThe() {
		return formatDate(getNgayLapThe());
	}

	public String getFormattedNgayHetHan() {
		return formatDate(getNgayHetHan());
	}

	private String formatDate(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return simpleDateFormat.format(date);
	}
}
