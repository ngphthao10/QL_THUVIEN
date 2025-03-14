<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Modal sửa thể loại -->
<div class="modal fade" style="text-align: left;" id="ModalToggleTL"
	tabindex="-1" aria-labelledby="exampleModalToggleLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered modal-dialog-scrollable ">
		<div class="modal-content ">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalToggleLabel">Sửa thể loại</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form:form class="was-validated" action="sach/theloai/index.htm"
					method="post" modelAttribute="theloai">
					<div class="mb-3 row">
						<form:input path="id" type="hidden" />
						<div class="col-sm-3">
							<label for="validationTextarea" class="form-label mt-2">Mã thể loại:</label>
						</div>
						<div class="col-sm-9">
							<form:input path="MaTheLoai" type="text"
								class="form-control me-2" readonly="true" />
						</div>
					</div>
					<div class="mb-3">
						<label for="tenTuaSachInput" class="form-label">Tên thể loại:</label>
						<form:input path="TenTheLoai" type="text"
							class="form-control me-2" placeholder="Tên thể loại" required="true" />
						<div class="invalid-feedback">Vui lòng nhập thể loại.</div>
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

