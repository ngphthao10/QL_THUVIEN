<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
	.form-control.is-valid, .was-validated .form-control.is-invalid:valid {
		background-image: none !important;
		border-color: var(--bs-form-invalid-border-color) !important;
	}
	.form-control.is-invalid:focus, .was-validated .form-control.is-invalid:valid:focus {
	    border-color: var(--bs-form-invalid-border-color) !important;
	    box-shadow: 0 0 0 .25rem rgba(var(--bs-danger-rgb), .25) !important;
	} 
</style>
<!-- Modal sửa sách -->
<div class="modal fade" style="text-align: left;" id="ModalToggle"
	tabindex="-1" aria-labelledby="exampleModalToggleLabel" aria-hidden="true">
	<div
		class="modal-dialog modal-dialog-centered modal-dialog-scrollable ">
		<div class="modal-content ">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalToggleLabel">Sửa sách</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form:form class="was-validated" action="sach/sach/index.htm" method="post" modelAttribute="sachDTO">
					<div class="mb-3 row">
						<div class="col-sm-3">
							<label for="validationTextarea" class="form-label mt-2">ID sách:</label>
						</div>
						<div class="col-sm-9">
							<form:input path="sach.MaSach" type="text" class="form-control me-2" readonly="true" />
						</div>
						<form:input path="sach.id" type="hidden" />
						<form:input path="sach.tuaSach1.id" type="hidden" />
						<form:input path="sach.SoLuong" type="hidden" />
						<form:input path="sach.SoLuongConLai" type="hidden" />
						<form:input path="sach.DonGia" type="hidden" />
						<form:input path="sach.TenHienThi" type="hidden" />
						<form:input path="sach.NamXB" type="hidden" />
					</div>
					<div class="mb-3">
						<label for="tenTuaSachInput" class="form-label">Nhà xuất bản*</label>
						<form:input path="sach.NhaXB" type="text" class="form-control me-2" placeholder="Nhà xuất bản" required="true"/>
						<div class="invalid-feedback">Vui lòng nhập nhà xuất bản.</div>
					</div>
					<div class="mb-3">
						<div class="row">
							<label class="col-sm-4">Tình trạng:</label>
							<div class="form-check col-sm-4">
						    	<form:radiobutton class="form-check-input" value="1" id="validationFormCheck2" path="sach.DaAn" required="true"/>
						    	<label class="form-check-label" for="validationFormCheck2">Ẩn sách</label>
						  	</div>
						  	<div class="form-check mb-3 col-sm-4">
						    	<form:radiobutton class="form-check-input" value="0" id="validationFormCheck3" path="sach.DaAn" required="true"/>
						    	<label class="form-check-label" for="validationFormCheck3">Hiện sách</label>
						  	</div>
						</div>
					</div>
					<hr>
					<div class="mb-3">
						<div style="text-align: left;">
							<button name="editbtn" class="btn btn-warning" type="submit">Lưu thông tin</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>