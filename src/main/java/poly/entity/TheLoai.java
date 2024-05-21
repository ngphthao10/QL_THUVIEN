package poly.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;

import poly.dao.TuaSachDAO;

@Entity
@Table(name = "THELOAI")
public class TheLoai {
	
	@Id @GeneratedValue
	private int id;
	
	@Column(updatable=false, insertable=false)
	private String MaTheLoai;
	
//	@Length(max = 4, message = "Tên thể loại không dài quá 100 ký tự!")
	private String TenTheLoai;

	@OneToMany(mappedBy="theloai", fetch=FetchType.EAGER)
	private Collection<TuaSach> tuaSach;

	public TheLoai() {
		super();
	}

	public TheLoai(int id, String maTheLoai, String tenTheLoai, Collection<TuaSach> tuaSach) {
		super();
		this.id = id;
		MaTheLoai = maTheLoai;
		TenTheLoai = tenTheLoai;
		this.tuaSach = tuaSach;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaTheLoai() {
		return MaTheLoai;
	}

	public void setMaTheLoai(String maTheLoai) {
		MaTheLoai = maTheLoai;
	}

	public String getTenTheLoai() {
		return TenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		TenTheLoai = tenTheLoai;
	}

	public Collection<TuaSach> getTuaSach() {
		return tuaSach;
	}

	public void setTuaSach(Collection<TuaSach> tuaSach) {
		this.tuaSach = tuaSach;
	}
}
