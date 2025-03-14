<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Modal them nguoi dung -->
<div class="modal fade" id="exampleModalToggle" tabindex="-1"
	aria-labelledby="exampleModalToggleLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered modal-dialog-scrollable ">
		<div class="modal-content ">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalToggleLabel">Thêm người dùng</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form:form class="was-validated" action="nguoidung/insert.htm" method="post" modelAttribute="nguoidung">
					<div class="mb-3">
						<label class="form-label">Họ tên*</label> 
						<form:input path="tenNguoiDung" class="form-control" type="text" placeholder="Họ tên người dùng" required="true"/>
						<div class="invalid-feedback">Vui lòng nhập họ tên người dùng.</div>
					</div>
					<div class="mb-3">
						<div class="row">
							<div class="col-sm-5">
								<label class="form-label">Nhóm người dùng*</label>
									<form:select path="nhomNguoiDung.id" class="form-select me-2">
									<form:option value="1">Quản lý</form:option>
									<form:option value="2">Thủ thư</form:option>
								</form:select>
								<div class="invalid-feedback">Vui lòng chọn nhóm người dùng.</div>
							</div>
							<div class="col-sm-7">
								<label for="validationTextarea" class="form-label ">Ngày sinh:</label> 
								<form:input path="ngaySinh" class="form-control datepicker" placeholder="Ngày sinh (có thể trống)"/>
							</div>
						</div>
					</div>
					<div class="mb-3">
						<label class="form-label">Chức vụ</label> 
						<form:input path="chucVu" class="form-control"  type="text" placeholder="Chức vụ (có thể bỏ trống)" />
					</div>

					<div class="mb-3">
						<label class="form-label">Tên đăng nhập*</label>
						<form:input path="tenDangNhap" class="form-control" type="text" placeholder="Tên đăng nhập" required="true" id="tenDangNhapInput"/>
						<div class="invalid-feedback"><form:errors path="tenDangNhap" id="tenDangNhapErrors" /></div>
						<div class="invalid-feedback">Vui lòng nhập tên đăng nhập.</div>
						
					</div>
					<div class="mb-3">
						<label class="form-label">Mật khẩu*</label> 
						<form:input path="matKhau" class="form-control" type="password" placeholder="Mật khẩu" required="true" id="matKhauInput"/>
						<div class="invalid-feedback"><form:errors path="matKhau" id="matKhauErrors"/></div>
						<div class="invalid-feedback">Vui lòng nhập mật khẩu.</div>
					</div>
					<div class="mb-3">
						<div style="text-align: right;">
							<button class="btn btn-warning" type="submit">Lưu thông tin</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>
