<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<base href="${pageContext.servletContext.contextPath}/">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<!doctype html>
<html lang="en">
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Quản lý sách</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.13.3/themes/base/jquery-ui.css">
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

.centered-column {
	text-align: center;
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
						<div class="col-6 mt-4 ps-4 mt-4">
							<h3>QUẢN LÝ SÁCH</h3>
						</div>
						<div class="col-6 d-grid gap-2 d-md-block button-container mt-4">
							<button class="btn btn-secondary" type="button"
								data-bs-toggle="modal" data-bs-target="#modal1">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-plus-circle mb-1"
									viewBox="0 0 16 16">
	                        <path
										d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
	                        <path
										d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4" />
	                      </svg>
								Nhập sách mới
							</button>

							<button class="btn btn-secondary" type="button"
								data-bs-toggle="modal" data-bs-target="#modal2">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-plus-circle mb-1"
									viewBox="0 0 16 16">
	                        <path
										d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
	                        <path
										d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4" />
	                      </svg>
								Nhập sách đã có
							</button>
						</div>
					</div>
					<c:if test="${not empty message}">
						<c:choose>
							<c:when test="${message == -1}">
								<div class="alert alert-info mt-2" role="alert">
									Sách đã tồn tại! Không thể thêm mới!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<c:when test="${message == 0}">
								<div class="alert alert-warning mt-2" role="alert">
									Thêm sách thất bại!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<c:when test="${message == 1}">
								<div class="alert alert-success mt-2" role="alert">
									Thêm sách thành công!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
						</c:choose>
					</c:if>
					<c:if test="${not empty message2}">
						<c:choose>
							<c:when test="${message2 == 0}">
								<div class="alert alert-warning mt-2" role="alert">
									Sửa sách thất bại!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<c:when test="${message2 == 1}">
								<div class="alert alert-success mt-2" role="alert">
									Sửa sách thành công!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
						</c:choose>
					</c:if>
					<c:if test="${not empty message3}">
						<c:choose>
							<c:when test="${message3 == 0}">
								<div class="alert alert-warning mt-2" role="alert">
									Update tựa sách thất bại!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<c:when test="${message3 == 1}">
								<div class="alert alert-success mt-2" role="alert">
									Update tựa sách thành công!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
						</c:choose>
					</c:if>
					<div class="d-flex justify-content-end mt-3">
						<form:form class="d-flex col-6" role="search" method="POST"
							action="sach/sach/search.htm" modelAttribute="sachDTO">
							<input class="form-control me-2" type="text" name="keyword"
								placeholder="Tựa sách, Năm xuất bản, Nhà xuất bản"
								aria-label="Search" value="${keyword}">
							<button class="btn btn-outline-success" style="min-width: 120px;"
								type="submit">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-search mb-1"
									viewBox="0 0 16 16">
				            		<path
										d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
				        </svg>
								Tìm kiếm
							</button>
						</form:form>
						<form:form class="d-flex col-6 ps-4" role="search" method="POST"
							action="sach/sach/filter.htm" modelAttribute="sachDTO">
							<form:select path="sach.DaAn" class="form-select me-2">
								<form:option value="0">Hiện có</form:option>
								<form:option value="1">Đã ẩn</form:option>
							</form:select>
							<button class="btn btn-outline-success" style="min-width: 150px;"
								type="submit">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-funnel mb-1"
									viewBox="0 0 16 16">
                      				<path
										d="M1.5 1.5A.5.5 0 0 1 2 1h12a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.128.334L10 8.692V13.5a.5.5 0 0 1-.342.474l-3 1A.5.5 0 0 1 6 14.5V8.692L1.628 3.834A.5.5 0 0 1 1.5 3.5zm1 .5v1.308l4.372 4.858A.5.5 0 0 1 7 8.5v5.306l2-.666V8.5a.5.5 0 0 1 .128-.334L13.5 3.308V2z" />
                    			</svg>
								Lọc tình trạng
							</button>
						</form:form>
					</div>
				</div>
				<div class="container">

					<!-- Khai báo pagedListHolder với param p -->
					<jsp:useBean id="pagedListHolder" scope="request"
						type="org.springframework.beans.support.PagedListHolder" />
					<c:url value="sach/sach/index.htm" var="pagedLink">
						<c:param name="p" value="~" />
					</c:url>
					<!-- Bảng dữ liệu -->
					<table class="table align-middle table-hover table-bordered mt-2">
						<!-- Tiêu đề -->
						<thead>
							<tr>
								<th scope="col">Mã sách</th>
								<th scope="col">Tựa sách</th>
								<th scope="col">Năm XB</th>
								<th scope="col">NXB</th>
								<th scope="col">Số lượng</th>
								<th scope="col">Còn lại</th>
								<th scope="col">Chức năng</th>
								<th scope="col">Ẩn sách</th>

							</tr>
						</thead>
						<!-- Dữ liệu -->
						<tbody class="table-group-divider">
							<c:forEach var="p" items="${pagedListHolder.pageList}">
								<tr>
									<td>${p.maSach}</td>
									<td>${p.getTenTuaSach()}</td>
									<td>${p.namXB}</td>
									<td>${p.nhaXB}</td>
									<td>${p.soLuong}</td>
									<td>${p.soLuongConLai}</td>
									<td class="centered-column"><a
										href="sach/sach/index/${p.id}.htm?linkEditSach">
											<button type="button" class="btn btn-outline-danger "
												onclick="showModal()">Chỉnh sửa</button>
									</a></td>

									<td class="centered-column">
									    <div>
									        <input class="form-check-input" type="checkbox" id="checkboxNoLabel${p.id}"
									         value="" aria-label="..." ${p.daAn == 1 ? 'checked' : ''} disabled	>
									    </div>
									</td>


								</tr>
							</c:forEach>
						</tbody>
					</table>
					<tg:paging pagedListHolder="${pagedListHolder}"
						pagedLink="${pagedLink}" />

				</div>
			</div>
			<script>
				window.onload = function showModal() {
					if (window.location.href.includes("linkEditSach")) {
						// Kích hoạt modal khi trang đã được tải xong
						var myModal = new bootstrap.Modal(document
								.getElementById('ModalToggle'));
						myModal.show();
					}
				}
			</script>
			<%@include file="/WEB-INF/views/admin/sach/sach/insertSachDaCo.jsp"%>
			<%@include file="/WEB-INF/views/admin/sach/sach/insertSachMoi.jsp"%>
			<%@include file="/WEB-INF/views/admin/sach/sach/editSach.jsp"%>

			<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
			<script src="https://code.jquery.com/ui/1.13.3/jquery-ui.js"></script>
			<script>
				$(function() {
					$(".datepicker").datepicker({
						dateFormat : 'dd/mm/yy',
						maxDate : "+0D"
					});
				});
			</script>
			<script>
				$(function() {
					$(".ngayNhap").datepicker({
						dateFormat : 'dd/mm/yy',
						maxDate : "+0D"
					});
				});
			</script>
</body>
</html>
