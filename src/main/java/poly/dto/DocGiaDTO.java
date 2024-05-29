package poly.dto;

import poly.entity.DocGia;
import poly.entity.NguoiDung;

public class DocGiaDTO {
	private DocGia docgia;
	private NguoiDung nguoidung;
	
	public DocGiaDTO() {
		super();
	}

	public DocGiaDTO(DocGia docgia, NguoiDung nguoidung) {
		super();
		this.docgia = docgia;
		this.nguoidung = nguoidung;
	}

	public DocGia getDocgia() {
		return docgia;
	}

	public void setDocgia(DocGia docgia) {
		this.docgia = docgia;
	}

	public NguoiDung getNguoidung() {
		return nguoidung;
	}

	public void setNguoidung(NguoiDung nguoidung) {
		this.nguoidung = nguoidung;
	}
	
}