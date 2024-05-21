package poly.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CT_TACGIA")
public class CT_TacGiaId implements Serializable {
	@Id
	@ManyToOne
	@JoinColumn(name="idTuaSach", referencedColumnName="id")
	private TuaSach tuaSach2;
	
	@Id
	@ManyToOne
	@JoinColumn(name="idTacGia", referencedColumnName="id")
	private TacGia tacGia;

	public CT_TacGiaId() {
		super();
	}
	
	public CT_TacGiaId(TuaSach tuaSach, TacGia tacGia) {
		super();
		this.tuaSach2 = tuaSach;
		this.tacGia = tacGia;
	}
	
	public TuaSach getTuaSach() {
		return tuaSach2;
	}
	
	public String getTenTacGia() {
		return tacGia.getTenTacGia();
	}


	public void setIdTuaSach(int id) {
		tuaSach2 = new TuaSach();
		tuaSach2.setId(id);
	}
	
	public TacGia getTacGia() {
		return tacGia;
	}


	public void setIdTacGia(int id) {
		tacGia = new TacGia();
		tacGia.setId(id);
	}
	

	public int getIdTacGia() {
		return tacGia.getId();
	}

	public int getIdTuaSach() {
		return tuaSach2.getId();
	}

}
