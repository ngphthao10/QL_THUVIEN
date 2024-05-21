<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Model quan ly tác gia -->
<div class="modal fade" id="exampleModalToggle2" aria-hidden="true"
	aria-labelledby="exampleModalToggleLabel2" tabindex="-1">
	<div class="modal-dialog modal-dialog-scrollable">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalToggleLabel2">Quản lý tác giả</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form:form class="was-validated" action="sach/tuasach/insertTG.htm" method="post" modelAttribute="tuasachdto">
					<div class="mb-3">
						<label for="validationTextarea" class="form-label">Họ và tên:</label>
						<div class="row">
							<div class="col-sm-7">
								<form:input path="tacgia[0].TenTacGia" class="form-control"
									id="validationTextarea" placeholder="Họ và tên tác giả"  required="true"/>
								<div class="invalid-feedback">Vui lòng nhập họ và tên tác giả.</div>
							</div>
							<div class="col-sm-5" style="text-align: right;">
								<button class="btn btn-warning" type="submit">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-plus-circle mb-1" viewBox="0 0 16 16">
								        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
								        <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4" />
								    </svg>
									Thêm tác giả
								</button>
							</div>
						</div>
					</div>
					<table class="table center-table table-hover table-bordered mt-3"
						style="vertical-align: middle;">
						<thead>
							<tr>
								<th scope="col">Mã tác giả</th>
								<th scope="col">Tên tác giả</th>
								<th class="centered-column" scope="col">Chỉnh sửa</th>
								<th class="centered-column" scope="col">Xóa</th>
							</tr>
						</thead>
						<tbody class="table-group-divider">
							<c:forEach var="p" items="${dsTacGia}">
								<tr>
									<td>${p.maTacGia}</td>
									<td>${p.tenTacGia}</td>
									<td class="centered-column"><a
										href="sach/tuasach/index/${p.id}.htm?linkEditTG">
											<button type="button" class="btn btn-outline-primary">Chỉnh sửa</button>
									</a></td>
									<td class="centered-column"><a
										href="sach/tuasach/index/${p.id}.htm?linkDeleteTG">
											<button type="button" class="btn btn-outline-danger">Xóa</button>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form:form>
			</div>
		</div>
	</div>
</div>