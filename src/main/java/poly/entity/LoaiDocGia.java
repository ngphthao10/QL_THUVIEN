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
@Table(name = "LOAIDOCGIA")
public class LoaiDocGia {
	
	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "MaLoaiDocGia", insertable=false, updatable=false)
	private String maLoaiDocGia;
	
	@Column(name = "TenLoaiDocGia")
	private String tenLoaiDocGia;
	
	@OneToMany(mappedBy="loaiDocGia", fetch=FetchType.EAGER)
	private Collection<DocGia> listDocGia;

	public LoaiDocGia() {
		super();
	}

	public LoaiDocGia(int id, String maLoaiDocGia, String tenLoaiDocGia, Collection<DocGia> listDocGia) {
		super();
		this.id = id;
		this.maLoaiDocGia = maLoaiDocGia;
		this.tenLoaiDocGia = tenLoaiDocGia;
		this.listDocGia = listDocGia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaLoaiDocGia() {
		return maLoaiDocGia;
	}

	public void setMaLoaiDocGia(String maLoaiDocGia) {
		this.maLoaiDocGia = maLoaiDocGia;
	}

	public String getTenLoaiDocGia() {
		return tenLoaiDocGia;
	}

	public void setTenLoaiDocGia(String tenLoaiDocGia) {
		this.tenLoaiDocGia = tenLoaiDocGia;
	}

	public Collection<DocGia> getListDocGia() {
		return listDocGia;
	}

	public void setListDocGia(Collection<DocGia> listDocGia) {
		this.listDocGia = listDocGia;
	}

	
}
