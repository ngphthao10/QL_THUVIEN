<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- Modal sửa tựa sách -->
<div class="modal fade" style="text-align: left;" id="ModalToggle"
	tabindex="-1" aria-labelledby="exampleModalToggleLabel" aria-hidden="true">
	<div
		class="modal-dialog modal-dialog-centered modal-dialog-scrollable ">
		<div class="modal-content ">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalToggleLabel">Sửa tựa sách</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form:form class="was-validated" action="sach/tuasach/index.htm" method="post" modelAttribute="tuasachdto">
					<div class="mb-3 row">
						<div class="col-sm-3">
							<label for="validationTextarea" class="form-label mt-2">ID tựa sách:</label>
						</div>
						<form:input type="hidden" path="tuasach.id" />
						<form:input type="hidden" path="tuasach.theloai.TenTheLoai" />
						<div class="col-sm-9">
							<form:input path="tuasach.MaTuaSach" type="text" class="form-control me-2" readonly="true" />
						</div>
					</div>
					<div class="mb-3">
						<label for="tenTuaSachInput" class="form-label">Tên tựa sách*</label>
						<form:input path="tuasach.TenTuaSach" type="text" class="form-control me-2" placeholder="Tên tựa sách" required="true"/>
						<div class="invalid-feedback">Vui lòng nhập tựa sách.</div>
					</div>
					<div class="mb-3">
						<label for="theLoaiSelect" class="form-label">Thể loại*</label>
						<form:select path="tuasach.theloai.id" items="${dsTheLoai}" itemLabel="TenTheLoai" itemValue="id" class="form-select me-2"></form:select>
						<div class="invalid-feedback">Vui lòng chọn thể loại.</div>
					</div>

					<div class="mb-3">
						<label for="tacGiaDaChon" class="form-label">Danh sách tác giả</label>
						<!-- <textarea name="tacgia.TenTacGia" style="min-height: 50px;" id="tacGiaDaChon" class="form-control"
						 placeholder="Bấm Thêm tác giả để thêm tác giả vào Danh sách tác giả" required="true"></textarea>  -->
						 <textarea name="listEditTacGia" style="min-height: 50px;" id="tacGiaDaChon" class="form-control"
						 placeholder="Bấm Thêm tác giả để thêm tác giả vào Danh sách tác giả" required="true"
						  ><c:forEach var="tacGia" items="${dsTacGiaTheoId}">${tacGia}
</c:forEach></textarea>
						<div class="invalid-feedback">Vui lòng chọn tác giả.</div>
					</div>
					<div class="mb-3">
						<label for="validationTextarea" class="form-label">Tác giả*</label>
						<div class="row">
							<div class="col-sm-8">
								<form:select id="chonTacGia" path="tacgia[0].id" items="${dsTacGia}"
									itemLabel="TenTacGia" itemValue="id" class="form-select me-2"></form:select>
							</div>
							<div class="col-sm-4" style="text-align: right;">
								<button class="btn btn-secondary" type="button"
									onclick="addAuthorToTextareaEdit()" name="addAuthor">
									<svg xmlns="http://www.w3.org/2000/svg" width="12" height="12"
										fill="currentColor" class="bi bi-x-circle mb-1" viewBox="0 0 16 16">
		                       			<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
		                       			<path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
		                     		</svg>
									Thêm tác giả
								</button>
							</div>
						</div>
					</div>
					<input type="hidden" name="dsTacGiaDaChon" id="dsTacGiaDaChon" />
					<div class="mb-3">
						<label class="form-label">Tình trạng*</label>
						<form:select path="tuasach.DaAn" class="form-select me-2">
							<form:option value="0">Hiện tựa sách</form:option>
							<form:option value="1">Ẩn tựa sách</form:option>
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

			<script>
				window.onload = function showModal() {
					if (window.location.href.includes("linkEdit")) {
						// Kích hoạt modal khi trang đã được tải xong
						var myModal = new bootstrap.Modal(document
								.getElementById('ModalToggle'));
						myModal.show();
					}
				}
			</script>