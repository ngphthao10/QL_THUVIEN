<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Modal xóa nguoi dung -->
<div class="modal fade" id="ModalDelete" tabindex="-1"
	aria-labelledby="exampleModalToggleLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered modal-dialog-scrollable ">
		<div class="modal-content ">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalToggleLabel">Xóa người dùng</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form:form class="was-validated" action="nguoidung/index.htm" method="post" modelAttribute="nguoidung">
					<div class="mb-3">
						<label class="form-label">Họ tên*</label> 
						<form:input path="tenNguoiDung" class="form-control" type="text" placeholder="Họ tên người dùng" readonly="true"/>
						<div class="invalid-feedback">Vui lòng nhập họ tên người dùng.</div>
					</div>
					<form:hidden path="id"/>
					<form:hidden path="nhomNguoiDung.id"/>
					<form:hidden path="ngaySinh"/>
					<form:hidden path="chucVu"/>
					<form:hidden path="matKhau"/>
					<div class="mb-3">
						<label class="form-label">Tên đăng nhập*</label> 
						<form:input path="tenDangNhap" class="form-control" type="text" placeholder="Tên đăng nhập" required="true"/>
						<div class="invalid-feedback">Vui lòng nhập tên đăng nhập.</div>
					</div>
					<hr>
					<div class="mb-3">
						<label class="form-label">Bạn có chắc chắn muốn xóa người dùng này?</label>
						<div style="text-align: right;">
							<button name="delbtn" class="btn btn-danger" type="submit">Ok</button>
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Cancel</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>
