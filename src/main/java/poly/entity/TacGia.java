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
@Table(name = "TACGIA")
public class TacGia {
	@Id @GeneratedValue
	private int id;
	@Column(updatable=false, insertable=false)
	private String MaTacGia;
	private String TenTacGia;

	@OneToMany(mappedBy="tacGia", fetch=FetchType.EAGER)
	private Collection<CT_TacGiaId> ctTacGia;

	public TacGia() {
		super();
	}

	public TacGia(int id, String maTacGia, String tenTacGia, Collection<CT_TacGiaId> ctTacGia) {
		super();
		this.id = id;
		MaTacGia = maTacGia;
		TenTacGia = tenTacGia;
		this.ctTacGia = ctTacGia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaTacGia() {
		return MaTacGia;
	}

	public void setMaTacGia(String maTacGia) {
		MaTacGia = maTacGia;
	}

	public String getTenTacGia() {
		return TenTacGia;
	}

	public void setTenTacGia(String tenTacGia) {
		TenTacGia = tenTacGia;
	}

	public Collection<CT_TacGiaId> getCtTacGia() {
		return ctTacGia;
	}

	public void setCtTacGia(Collection<CT_TacGiaId> ctTacGia) {
		this.ctTacGia = ctTacGia;
	}
	
	
}
