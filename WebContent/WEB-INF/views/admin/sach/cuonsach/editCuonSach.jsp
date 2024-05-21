<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Modal sửa cuốn sách -->
<div class="modal fade" style="text-align: left;" id="ModalToggle"
	tabindex="-1" aria-labelledby="exampleModalToggleLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered modal-dialog-scrollable ">
		<div class="modal-content ">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalToggleLabel">Sửa cuốn sách</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form:form class="was-validated" action="sach/cuonsach/index.htm"
					method="post" modelAttribute="cuonsach">
					<div class="mb-3 row">
						<form:input path="id" type="hidden" />
						<form:input path="sach1.id" type="hidden" />
						<div class="col-sm-4">
							<label for="validationTextarea" class="form-label mt-2">Mã cuốn sách:</label>
						</div>
						<div class="col-sm-8">
							<form:input path="MaCuonSach" type="text"
								class="form-control me-2" readonly="true" />
						</div>
					</div>
					<div class="mb-3">
						<label class="form-label">Tình trạng:</label>
						<form:select path="TinhTrang" class="form-select me-2">
							<form:option value="0">Hiện có</form:option>
							<form:option value="1">Đã được mượn</form:option>
						</form:select>
					</div>
					<div class="mb-3">
						<label class="form-label">Sách ẩn:</label>
						<form:select path="DaAn" class="form-select me-2">
							<form:option value="0">Hiện sách</form:option>
							<form:option value="1">Ẩn sách</form:option>
						</form:select>
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