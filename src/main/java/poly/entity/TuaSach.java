package poly.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenerationTime;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "TUASACH")
public class TuaSach {
	@Id @GeneratedValue
	private int id;
	@Column(updatable=false, insertable=false)
	private String MaTuaSach;
	
	private String TenTuaSach;

	@ManyToOne
	@JoinColumn(name = "idTheLoai", referencedColumnName = "id")
	private TheLoai theloai;
	
	@ColumnDefault("0")
	private int DaAn;

	@OneToMany(mappedBy = "tuaSach1", fetch = FetchType.EAGER)
	private Collection<Sach> Sach;

	@OneToMany(mappedBy = "tuaSach2", fetch = FetchType.EAGER)
	private Collection<CT_TacGiaId> CTTacGia;

	public TuaSach() {
		super();
	}

	public TuaSach(int id, String maTuaSach, String tenTuaSach, TheLoai theloai, int daAn,
			Collection<poly.entity.Sach> sach, Collection<CT_TacGiaId> cTTacGia) {
		super();
		this.id = id;
		MaTuaSach = maTuaSach;
		TenTuaSach = tenTuaSach;
		this.theloai = theloai;
		DaAn = daAn;
		Sach = sach;
		CTTacGia = cTTacGia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaTuaSach() {
		return MaTuaSach;
	}

	public void setMaTuaSach(String maTuaSach) {
		MaTuaSach = maTuaSach;
	}

	public String getTenTuaSach() {
		return TenTuaSach;
	}

	public void setTenTuaSach(String tenTuaSach) {
		TenTuaSach = tenTuaSach;
	}

	public String getTenTheloai() {
		return theloai.getTenTheLoai();
	}

	public void setIdTheLoai(int id) {
        if (theloai == null) {
            theloai = new TheLoai();
        }
        theloai.setId(id);
    }

	public int getDaAn() {
		return DaAn;
	}

	public void setDaAn(int daAn) {
		DaAn = daAn;
	}

	public Collection<Sach> getSach() {
		return Sach;
	}

	public void setSach(Collection<Sach> sach) {
		Sach = sach;
	}
	
	public List<String> getCTTacGia() {
//	    List<String> ct = new ArrayList<>();
//	    if (CTTacGia != null) {
//	        for (CT_TacGiaId cttg : CTTacGia) {
//	            TacGia tacGia = cttg.getTacGia();
//	            if (tacGia != null && cttg.getIdTuaSach() == this.id) {
//	                ct.add(tacGia.getTenTacGia().toString());
//	            }
//	        }
//	    }
//	    System.out.println(ct.size());
//	    return ct;
	    
	    List<String> ct = new ArrayList<>();
	    List<Integer> id = new ArrayList<>();
	    if (CTTacGia != null) {
	        for (CT_TacGiaId cttg : CTTacGia) {
	            int idtacGia = cttg.getIdTacGia();
	            if (idtacGia > 0 && !id.contains(idtacGia)) {
	                id.add(idtacGia);
	                ct.add(cttg.getTenTacGia().toString());
	            }
	        }
	    }
	    return ct;
	}

	public List<Integer> getIdTacGia() {
		List<Integer> id = new ArrayList<>();
	    if (CTTacGia != null) {
	        for (CT_TacGiaId cttg : CTTacGia) {
	            int idtacGia = cttg.getIdTacGia();
	            if (idtacGia > 0 && !id.contains(idtacGia)) {
	                id.add(idtacGia);
	            }
	        }
	    }
	    return id;
	}


	public void setCTTacGia(Collection<CT_TacGiaId> cTTacGia) {
		CTTacGia = cTTacGia;
	}

	public int getIdTheLoai() {
		if (theloai == null) {
            theloai = new TheLoai();
        }
		return theloai.getId();
	}

	public void setTenTheloai(String tenTheloai) {
		if (theloai == null) {
            theloai = new TheLoai();
        }
		this.theloai.setTenTheLoai(tenTheloai);
	}
	
	public void setTheloai(TheLoai theloai) {
		this.theloai = theloai;
	}

	public TheLoai getTheloai() {
		return theloai;
	}
	
}