<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<base href="${pageContext.servletContext.contextPath}/">
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

.center-table {
	vertical-align: middle;
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
						<div class="col-6 mt-4 ps-4 mt-4"> <h3>QUẢN LÝ NGƯỜI DÙNG</h3></div>
						<div class="col-6 d-grid gap-2 button-container d-md-block mt-4">
							<button class="btn btn-secondary"
								data-bs-target="#exampleModalToggle" data-bs-toggle="modal">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-plus-circle mb-1" viewBox="0 0 16 16">
                        			<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                        			<path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4" />
                      			</svg>
								Thêm người dùng
							</button>
						</div>
					</div>

					
					<c:if test="${not empty message}">
						<c:choose>
							<c:when test="${message == 0}">
								<div class="alert alert-warning mt-2" role="alert">
									Thêm người dùng thất bại!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<c:when test="${message == 1}">
								<div class="alert alert-success mt-2" role="alert">
									Thêm người dùng thành công!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
						</c:choose>
					</c:if>
					<c:if test="${not empty message1}">
						<c:choose>
							<c:when test="${message1 == 0}">
								<div class="alert alert-warning mt-2" role="alert">
									Sửa người dùng thất bại!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<c:when test="${message1 == 1}">
								<div class="alert alert-success mt-2" role="alert">
									Sửa người dùng thành công!
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
									Xóa người dùng thất bại!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<c:when test="${message2 == 1}">
								<div class="alert alert-success mt-2" role="alert">
									Xóa người dùng thành công!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
						</c:choose>
					</c:if>
				
					
				<div class="d-flex justify-content-end mt-3">
					<form:form class="d-flex col-6" role="search" method="POST"
						action="nguoidung/search.htm" modelAttribute="tuasachdto">
						<input class="form-control me-2" type="text" name="keyword"
							placeholder="Mã, tên người dùng, tên đăng nhập" aria-label="Search" value="${keyword}">
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
				</div>
				<div class="container">

					<!-- Khai báo pagedListHolder với param p -->
					<jsp:useBean id="pagedListHolder" scope="request"
						type="org.springframework.beans.support.PagedListHolder" />
					<c:url value="nguoidung/index.htm" var="pagedLink">
						<c:param name="p" value="~" />
					</c:url>
					<!-- Bảng dữ liệu -->
					<table class="table table-hover table-bordered mt-2" style="vertical-align: middle;">
						<!-- Tiêu đề -->
						<thead>
							<tr>
								<th style="text-align:center;" scope="col">Mã người dùng</th>
								<th style="text-align:center;" scope="col">Tên người dùng</th>
								<th style="text-align:center;" scope="col">Chức vụ</th>
								<th style="text-align:center;" scope="col">Tên đăng nhập</th>
								<th style="text-align:center;" scope="col">Nhóm người dùng</th>
								<th style="text-align:center;" scope="col-2">Chức năng</th>
							</tr>
						</thead>
						<!-- Dữ liệu -->
						<tbody class="table-group-divider">
							<c:forEach var="p" items="${pagedListHolder.pageList}">
								<tr>
									<td style="text-align:center;">${p.maNguoiDung}</td>
									<td>${p.tenNguoiDung}</td>
									<td>${p.chucVu}</td>
									<td>${p.tenDangNhap}</td>
									<td>${p.nhomNguoiDung.tenNhomNguoiDung}</td>
									<td class="centered-column"> 
									<div>
										<a  style="text-decoration: none;" class="col-sm-4" style="text-align: right;"
												href="nguoidung/index/${p.id}.htm?linkEdit">
											<button type="button"  class="btn btn-outline-primary"
												>Chỉnh sửa</button>
										</a>
										<a class="col-sm-4" href="nguoidung/index/${p.id}.htm?linkDelete"
										 style="text-decoration: none;">
											<button type="button" class="btn btn-outline-danger"  
											> Xóa</button>
										</a>
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
 			<%@include file="/WEB-INF/views/admin/nguoidung/insertNguoiDung.jsp"%>
 			<%@include file="/WEB-INF/views/admin/nguoidung/delNguoiDung.jsp"%>
 			<%@include file="/WEB-INF/views/admin/nguoidung/editNguoiDung.jsp"%>
<%-- 
			<%@include file="/WEB-INF/views/admin/sach/tuasach/quanlyTacGia.jsp"%>
			<%@include file="/WEB-INF/views/admin/sach/tuasach/editTacGia.jsp"%>
		 	<%@include file="/WEB-INF/views/admin/sach/tuasach/delTacGia.jsp"%>
 --%>

			<script>
			    window.onload = function() {
			        if (window.location.href.includes("linkEdit")) {
			            var myModal = new bootstrap.Modal(document.getElementById('editNguoiDung'));
			            myModal.show();
			        }
			
			        if (window.location.href.includes("linkEditTG")) {
			            var myModalEditTG = new bootstrap.Modal(document.getElementById('ModalEditTG'));
			            myModalEditTG.show();
			        }
			        if (window.location.href.includes("linkDelete")) {
			            var myModalDelTG = new bootstrap.Modal(document.getElementById('ModalDelete'));
			            myModalDelTG.show();
			        }
			    }
			</script>
			<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
			<script src="https://code.jquery.com/ui/1.13.3/jquery-ui.js"></script>
			<script>
				  $( function() {
				    $( ".datepicker" ).datepicker({
				   	  maxDate: "-18Y",
				      changeMonth: true,
				      changeYear: true
				    });
				  } );
		    </script>
</body>
</html>
