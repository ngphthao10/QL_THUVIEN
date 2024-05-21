<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Model2 -->
<div class="modal fade" id="ModalDelTG" aria-hidden="true"
	aria-labelledby="exampleModalToggleLabel2"
	tabindex="-1">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="ModalToggleLabel">Xóa thông
					tin tác giả</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form:form class="was-validated" action="sach/tuasach/index.htm" method="post" modelAttribute="tuasachdto">
					<div class="mb-3 row">
						<form:input path="tacgia[0].id" type="hidden" />
						<div class="col-sm-3">
							<label for="validationTextarea" class="form-label mt-2">Mã tác giả:</label>
						</div>
						<div class="col-sm-9">
							<form:input path="tacgia[0].MaTacGia" type="text" class="form-control me-2" readonly="true" />
						</div>
					</div>
					<div class="mb-4">
						<label class="form-label">Tên tác giả:</label>
						<form:input path="tacgia[0].TenTacGia" type="text"
							class="form-control me-2" placeholder="Tên tác giả" readonly="true" />
						<div class="invalid-feedback">Vui lòng nhập tên tác giả.</div>
					</div>
					<hr>
					<div>
						<label class="form-label">Bạn có chắc chắn muốn xóa tác giả này?</label>
						<div style="text-align: right;">
							<button name="delTGbtn" class="btn btn-danger" type="submit">Ok</button>
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Cancel</button>
						</div>
					</div>
				</form:form>
			</div>
			<div class="modal-footer" style="text-align: left;">
				<button  class="btn btn-outline-secondary" data-bs-target="#exampleModalToggle2"
					data-bs-toggle="modal">Quay lại</button>
			</div>
		</div>
	</div>
</div>