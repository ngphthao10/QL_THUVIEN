package poly.dto;

import java.util.List;

import poly.entity.*;

public class TuaSachDTO {
	private TuaSach tuasach;
	private List<TacGia> tacgia;
    private CT_TacGiaId cttacgia;
    
	public TuaSachDTO() {
		super();
	}

	public TuaSachDTO(TuaSach tuasach, List<TacGia> tacgialist, CT_TacGiaId cttacgia) {
		super();
		this.tuasach = tuasach;
		this.tacgia = tacgialist;
		this.cttacgia = cttacgia;
	}

	public TuaSach getTuasach() {
		return tuasach;
	}

	public void setTuasach(TuaSach tuasach) {
		this.tuasach = tuasach;
	}

	public CT_TacGiaId getCttacgia() {
		return cttacgia;
	}

	public void setCttacgia(CT_TacGiaId cttacgia) {
		this.cttacgia = cttacgia;
	}

	public List<TacGia> getTacgia() {
		return tacgia;
	}

	public void setTacgia(List<TacGia> tacgialist) {
		this.tacgia = tacgialist;
	}
	
}