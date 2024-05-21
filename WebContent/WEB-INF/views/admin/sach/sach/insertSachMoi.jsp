<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Modal them sach moi  -->
<div class="modal fade" id="modal1" tabindex="-1"
	aria-labelledby="exampleModalLabel1" aria-hidden="true">
	<div
		class="modal-dialog modal-lg modal-dialog-centered modal-dialog-scrollable ">
		<div class="modal-content ">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalLabel1">Phiếu nhập
					sách</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form:form class="was-validated"
					action="sach/sach/insertSachMoi.htm" method="post"
					modelAttribute="sachDTO">
					<label for="validationTextarea" class="form-label"><h4>Thông
							tin sách</h4></label>
					<div class="row">
						<div class="col-sm-8">
							<div class="mb-3">
								<label for="validationTextarea" class="form-label">Tựa
									sách*</label>
								<form:select path="sach.tuaSach1.id" items="${dsTuaSach}"
									itemLabel="tenTuaSach" itemValue="id" class="form-select me-2"></form:select>
								<div class="invalid-feedback">Vui lòng chọn tựa sách.</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="mb-3">
								<label for="validationTextarea" class="form-label">Năm xuất bản*</label> 
								<form:input path="sach.NamXB" class="form-control"
									id="validationTextarea" placeholder="Năm xuất bản" required="true" />
								<div class="invalid-feedback">Vui lòng nhập năm xuất bản.</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-8">
							<div class="mb-3">
								<label for="validationTextarea" class="form-label">Nhà
									xuất bản*</label> <form:input path="sach.NhaXB" class="form-control"
									id="validationTextarea" placeholder="Nhà xuất bản" required="true" />
								<div class="invalid-feedback">Vui lòng nhập nhà xuất bản.</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="mb-3">
								<label for="validationTextarea" class="form-label">Đơn
									giá*</label> <form:input path="sach.DonGia" class="form-control" id="donGia"
									placeholder="Đơn vị: VNĐ" required="true" onchange="tinhThanhTien()" />
								<div class="invalid-feedback">Vui lòng nhập đơn giá.</div>
							</div>
						</div>
					</div>
					<label for="validationTextarea" class="form-label"><h4>Thông
							tin nhập</h4></label>
					<div class="row">
						<div class="col-sm-6">
							<div class="mb-3">
								<label for="validationTextarea" class="form-label">Ngày
									nhập*</label> <form:input path="pns.NgayNhap"
									class="form-control datepicker" placeholder="Ngày nhập"
									required="true" />
								<div class="invalid-feedback">Vui lòng chọn ngày nhập.</div>
							</div>
						</div>
						<div class="col-sm-6 mb-3">
							<label for="validationTextarea" class="form-label">Số
								lượng nhập*</label> <form:input path="ctpn.SoLuongNhap" class="form-control"
								id="soLuong" placeholder="Đơn vị: VNĐ" required="true"
								onchange="tinhThanhTien()" />
							<div class="invalid-feedback">Vui lòng nhập số lượng.</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">
							<label for="validationTextarea" class="form-label">Thành
								tiền:</label>
						</div>
						<div class="col-sm-10">
							<p name="ctpn.ThanhTien" id="thanhTien">0đ</p>
						</div>
					</div>
					<div class="mb-3" style="text-align: right;">
						<button class="btn btn-warning" type="submit">Lưu thông
							tin</button>
					</div>
				</form:form>
				<script>
					function tinhThanhTien() {
						var donGia = document.getElementById('donGia').value;
						var soLuong = document.getElementById('soLuong').value;
						var thanhTien = donGia * soLuong;
						// Định dạng thành tiền thành tiền tệ
						var formatter = new Intl.NumberFormat('vi-VN', {
							style : 'currency',
							currency : 'VND'
						});

						// Gán giá trị đã định dạng vào phần tử HTML
						document.getElementById('thanhTien').innerText = formatter
								.format(thanhTien);
					}
				</script>
			</div>
		</div>
	</div>
</div>
