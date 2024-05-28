<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="modal2" tabindex="-1"
	aria-labelledby="exampleModalLabel2" aria-hidden="true">
	<div
		class="modal-dialog modal-lg modal-dialog-centered modal-dialog-scrollable ">
		<div class="modal-content ">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalLabel2">Phiếu nhập sách</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form:form class="was-validated" action="sach/sach/insertSachDaCo.htm" method="post" modelAttribute="sachDTO">
					<div class="container-fluid">
						<div class="row">
							<div class="mb-3">
								<label for="validationTextarea" class="form-label ">Ngày nhập sách:</label> 
								<form:input path="pns.NgayNhap" class="form-control datepicker" placeholder="Ngày nhập sách" required="true" />
								<div class="invalid-feedback">Vui lòng chọn ngày nhập.</div>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-sm-9">
								<label for="validationTextarea" class="form-label ">Sách nhập:</label>
								<form:select path="sach.id" items="${dsSach}"
									itemLabel="TenHienThi" itemValue="id" class="form-select me-2">
								</form:select>
								<div class="invalid-feedback">Vui lòng chọn sách.</div>
							</div>
							<div class="col-sm-3">
								<label for="validationTextarea" class="form-label ">Số lượng nhập:</label> 
								<form:input path="ctpn.SoLuongNhap" type="text" class="form-control" id="soLuongNhap"
									placeholder="Số lượng nhập" required="true" />
								<div class="invalid-feedback"><form:errors path="ctpn.SoLuongNhap" id="soluongNhapErrors"/></div>
								<div class="invalid-feedback">Vui lòng nhập số lượng.</div>
							</div>

						</div>
						<hr>
						<div class="mb-3" style="text-align: right;">
							<button class="btn btn-warning" type="submit">Lưu thông tin</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>
