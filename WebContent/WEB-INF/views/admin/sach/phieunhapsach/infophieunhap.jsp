<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="ModalToggle" tabindex="-1"
	aria-labelledby="exampleModalToggleLabel" aria-hidden="true">
	<div
		class="modal-dialog modal-lg modal-dialog-centered modal-dialog-scrollable ">
		<div class="modal-content ">
			<div class="modal-header">
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<div class="modal-title fs-5" id="exampleModalToggleLabel"
					style="text-align: center;">
					<h3>Thông tin phiếu nhập</h3>
				</div>
				<hr>
				<form:form class="d-flex" role="search" method="POST"
							action="sach/phieunhapsach/index.htm" modelAttribute="phieunhapsach">
				<table class="table align-middle table-hover table-bordered mt-4">
					<tbody>
						<tr>
							<th scope="row">Số phiếu nhập</th>
							<td class="align-middle">
								<form:input path="pns.SoPhieuNhap"
									class="form-control me-2" readonly="true" />
							</td>
						</tr>
						<tr>
							<th scope="row">Ngày nhập</th>
							<td class="align-middle">
								<form:input path="pns.NgayNhap"
									class="form-control me-2" readonly="true" />
							</td>
						</tr>
						<tr>
							<th scope="row">Tổng tiền</th>
							<td class="align-middle">
								<form:input path="pns.TongTien" 
									class="form-control me-2" readonly="true" />
							</td>
						</tr>
					</tbody>
				</table>
				</form:form>
				<div class="modal-title fs-5 mt-3" id="exampleModalToggleLabel"
					style="text-align: center;">
					<h3>Chi tiết phiếu nhập</h3>
				</div>
				<hr>
				<table class="table table-hover table-bordered mt-4">
					<thead>
						<tr>
							<th scope="col">Mã sách</th>
							<th scope="col">Tên tựa sách</th>
							<th scope="col">Đơn giá</th>
							<th scope="col">Số lượng nhập</th>
							<th scope="col">Thành tiền</th>
						</tr>
					</thead>
					<tbody class="table-group-divider">
						<c:forEach var="p" items="${dsCTPN}">
							<tr>
								<td>${p.sach2.maSach}</td>
								<td>${p.sach2.tuaSach1.tenTuaSach}</td>
								<td><fmt:setLocale value="vi_VN"/> <fmt:formatNumber value="${p.donGia}" type="currency" currencySymbol="đ" maxFractionDigits="0"/></td>
								<td>${p.soLuongNhap}</td>
								<td><fmt:setLocale value="vi_VN"/> <fmt:formatNumber value="${p.thanhTien}" type="currency" currencySymbol="đ" maxFractionDigits="0"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>