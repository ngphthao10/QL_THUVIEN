package poly.entity;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "NHOMNGUOIDUNG")
public class NhomNguoiDung {

	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "MaNhomNguoiDung", insertable=false, updatable=false)
	private String maNhomNguoiDung;
	
	@Column(name = "TenNhomNguoiDung")
	private String tenNhomNguoiDung;

	@OneToMany(mappedBy="nhomNguoiDung", fetch=FetchType.EAGER)
	private Collection<NguoiDung> listNguoiDung;
	
	@OneToMany(mappedBy="nhomNguoiDung", fetch=FetchType.EAGER)
	private Collection<PhanQuyen> listPhanQuyen;
	
	public NhomNguoiDung() {
		super();
	}

	public NhomNguoiDung(int id, String maNhomNguoiDung, String tenNhomNguoiDung, Collection<NguoiDung> listNguoiDung,
			Collection<PhanQuyen> listPhanQuyen) {
		super();
		this.id = id;
		this.maNhomNguoiDung = maNhomNguoiDung;
		this.tenNhomNguoiDung = tenNhomNguoiDung;
		this.listNguoiDung = listNguoiDung;
		this.listPhanQuyen = listPhanQuyen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaNhomNguoiDung() {
		return maNhomNguoiDung;
	}

	public void setMaNhomNguoiDung(String maNhomNguoiDung) {
		this.maNhomNguoiDung = maNhomNguoiDung;
	}

	public String getTenNhomNguoiDung() {
		return tenNhomNguoiDung;
	}

	public void setTenNhomNguoiDung(String tenNhomNguoiDung) {
		this.tenNhomNguoiDung = tenNhomNguoiDung;
	}

	public Collection<NguoiDung> getListNguoiDung() {
		return listNguoiDung;
	}

	public void setListNguoiDung(Collection<NguoiDung> listNguoiDung) {
		this.listNguoiDung = listNguoiDung;
	}

	public Collection<PhanQuyen> getListPhanQuyen() {
		return listPhanQuyen;
	}

	public void setListPhanQuyen(Collection<PhanQuyen> listPhanQuyen) {
		this.listPhanQuyen = listPhanQuyen;
	}

	
	
	
}
