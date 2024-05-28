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
							<form:input path="MaCuonSach" type="text" class="form-control me-2" readonly="true" />
						</div>
					</div>
					<div class="mb-1">
						<div class="row">
							<label class="col-sm-4">Tình trạng:</label>
							<div class="form-check col-sm-4">
						    	<form:radiobutton class="form-check-input" value="1" id="validationFormCheck2" path="TinhTrang" required="true"/>
						    	<label class="form-check-label" for="validationFormCheck2">Đã được mượn</label>
						  	</div>
						  	<div class="form-check mb-3 col-sm-4">
						    	<form:radiobutton class="form-check-input" value="0" id="validationFormCheck3" path="TinhTrang" required="true"/>
						    	<label class="form-check-label" for="validationFormCheck3">Hiện có</label>
						  	</div>
						</div>
					</div>
					<div class="mb-3">
						<div class="row">
							<label class="col-sm-4">Sách ẩn:</label>
							<div class="form-check col-sm-4">
						    	<form:radiobutton class="form-check-input" value="1" id="validationFormCheck2" path="DaAn" required="true"/>
						    	<label class="form-check-label" for="validationFormCheck2">Ẩn sách</label>
						  	</div>
						  	<div class="form-check mb-3 col-sm-4">
						    	<form:radiobutton class="form-check-input" value="0" id="validationFormCheck3" path="DaAn" required="true"/>
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