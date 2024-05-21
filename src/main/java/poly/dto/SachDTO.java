package poly.dto;

import poly.entity.*;

public class SachDTO {
	private Sach sach;
    private CT_PhieuNhapId ctpn;
    private PhieuNhapSach pns;
    
    
	public SachDTO() {
		super();
	}
	public SachDTO(Sach sach, CT_PhieuNhapId ctpn, PhieuNhapSach pns) {
		super();
		this.sach = sach;
		this.ctpn = ctpn;
		this.pns = pns;
	}
	public PhieuNhapSach getPns() {
		return pns;
	}
	public void setPns(PhieuNhapSach pns) {
		this.pns = pns;
	}
	public Sach getSach() {
		return sach;
	}
	public void setSach(Sach sach) {
		this.sach = sach;
	}
	public CT_PhieuNhapId getCtpn() {
		return ctpn;
	}
	public void setCtpn(CT_PhieuNhapId ctpn) {
		this.ctpn = ctpn;
	}
}
