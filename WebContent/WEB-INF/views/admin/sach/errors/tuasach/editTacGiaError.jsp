<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<!doctype html>
<html lang="en">
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Quản lý tựa sách</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
<style>
.button-container {
	text-align: right;
}

.button-container .modal-body {
	text-align: left;
}

.modal-content {
	background-color: #ece0d1;
}

.modal-header {
	background-color: #634832;
	color: #fff;
}

.center-table {
	vertical-align: middle;
}

.centered-column {
	text-align: center;
}

.form-control.is-valid, .was-validated .form-control.is-invalid:valid {
	background-image: none !important;
	border-color: var(--bs-form-invalid-border-color) !important;
}
.form-control.is-invalid:focus, .was-validated .form-control.is-invalid:valid:focus {
    border-color: var(--bs-form-invalid-border-color) !important;
    box-shadow: 0 0 0 .25rem rgba(var(--bs-danger-rgb), .25) !important;
}

</style>
</head>
<body>
	<%@include file="/WEB-INF/views/include/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="/WEB-INF/views/include/sidebar.jsp"%>
			<div class="main-content col-md-10">
				<div class="container">
					<div class="row">
						<div class="col-6 mt-4 ps-4 mt-4"> <h3>QUẢN LÝ TỰA SÁCH</h3></div>
						<div class="col-6 d-grid gap-2 button-container d-md-block mt-4">
							<button class="btn btn-secondary"
								data-bs-target="#exampleModalToggle" data-bs-toggle="modal">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-plus-circle mb-1" viewBox="0 0 16 16">
                        			<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                        			<path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4" />
                      			</svg>
								Thêm tựa sách
							</button>
							<button class="btn btn-secondary" type="button"
								data-bs-target="#exampleModalToggle2" data-bs-toggle="modal">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-x-circle mb-1" viewBox="0 0 16 16">
                        			<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                        			<path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                      			</svg>
								Quản lý tác giả
							</button>
						</div>
					</div>
					<div class="d-flex justify-content-end mt-3">
						<form:form class="d-flex col-6" role="search" method="POST"
							action="sach/tuasach/search.htm" modelAttribute="tuasachdto">
							<input class="form-control me-2" type="text" name="keyword"
								placeholder="Mã, tên, tác giả" aria-label="Search" value="${keyword}">
							<button class="btn btn-outline-success" style="min-width: 120px;"
								type="submit">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-search mb-1" viewBox="0 0 16 16">
				            		<path
										d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
				        		</svg>
								Tìm kiếm
							</button>
						</form:form>
						
						<form:form class="d-flex col-6 ps-4" role="search" method="POST"
							action="sach/tuasach/filter.htm" modelAttribute="tuasachdto">
							<form:select path="tuasach.theloai.id" items="${dsTheLoai}"
								itemLabel="tenTheLoai" itemValue="id" class="form-select me-2"></form:select>
							<button class="btn btn-outline-success" style="min-width: 150px;" type="submit">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-funnel mb-1" viewBox="0 0 16 16">
                      				<path d="M1.5 1.5A.5.5 0 0 1 2 1h12a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.128.334L10 8.692V13.5a.5.5 0 0 1-.342.474l-3 1A.5.5 0 0 1 6 14.5V8.692L1.628 3.834A.5.5 0 0 1 1.5 3.5zm1 .5v1.308l4.372 4.858A.5.5 0 0 1 7 8.5v5.306l2-.666V8.5a.5.5 0 0 1 .128-.334L13.5 3.308V2z" />
                    			</svg>
								Lọc thể loại
							</button>
						</form:form>
					</div>
				</div>
			</div>
			
			<!-- Model sua tac gia -->
			<div class="modal fade" id="ModalEditTG" aria-hidden="true"
				aria-labelledby="exampleModalToggleLabel2"
				tabindex="-1">
				<div class="modal-dialog modal-dialog-centered">
					<div class="modal-content">
						<div class="modal-header">
							<h1 class="modal-title fs-5" id="ModalToggleLabel">Sửa thông
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
										class="form-control is-invalid me-2" placeholder="Họ và tên tác giả" required="true" />
									<div  class="invalid-feedback"> 
										<form:errors  path="tacgia[0].TenTacGia" />
									</div>
								</div>
								<div style="text-align:left;">
									<button name="editTGbtn" class="btn btn-warning" type="submit">Lưu thông tin</button>
								</div>
							</form:form>
						</div>
						<div class="modal-footer">
							<button class="btn btn-secondary" data-bs-target="#exampleModalToggle2"
								data-bs-toggle="modal">Quay lại</button>
						</div>
					</div>
				</div>
			</div>
			<script>
			    window.onload = function() {
			        if (window.location.href.includes("index")) {
			            var myModal = new bootstrap.Modal(document.getElementById('ModalEditTG'));
			            myModal.show();
			        }
			
			    }
			</script>

</body>
</html>
