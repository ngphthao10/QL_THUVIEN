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
@Table(name = "CHUCNANG")
public class ChucNang {
	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "MaChucNang", insertable=false, updatable=false)
	private String maChucNang;
	
	@Column(name = "TenChucNang")
	private String tenChucNang;
	
	@Column(name = "TenManHinh")
	private String tenManHinh;
	
	@OneToMany(mappedBy="chucNang", fetch=FetchType.EAGER)
	private Collection<PhanQuyen> listPhanQuyen;

	

	public ChucNang(int id, String maChucNang, String tenChucNang, String tenManHinh, Collection<PhanQuyen> listPhanQuyen) {
		super();
		this.id = id;
		this.maChucNang = maChucNang;
		this.tenChucNang = tenChucNang;
		this.tenManHinh = tenManHinh;
		this.listPhanQuyen = listPhanQuyen;
	}

	public ChucNang() {
		super();
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getMaChucNang() {
		return maChucNang;
	}

	public void setMaChucNang(String maChucNang) {
		this.maChucNang = maChucNang;
	}

	public String getTenChucNang() {
		return tenChucNang;
	}

	public void setTenChucNang(String tenChucNang) {
		this.tenChucNang = tenChucNang;
	}

	public String getTenManHinh() {
		return tenManHinh;
	}

	public void setTenManHinh(String tenManHinh) {
		this.tenManHinh = tenManHinh;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<PhanQuyen> getPhanQuyen() {
		return listPhanQuyen;
	}

	public void setPhanQuyen(Collection<PhanQuyen> listPhanQuyen) {
		this.listPhanQuyen = listPhanQuyen;
	}
	
}
