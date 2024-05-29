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
</head>
<body>
	<%@include file="/WEB-INF/views/include/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="/WEB-INF/views/include/sidebar.jsp"%>
			<div class="main-content col-md-10">
				<div class="container">
					<div class="row">
						<div class="col-6 mt-4 ps-4 mt-4"> <h3>THÔNG TIN NHÓM NGƯỜI DÙNG</h3></div>
					</div>
				</div>

				<div class="container">
					<!-- Bảng dữ liệu -->
					<table class="table table-hover table-bordered mt-4" style="vertical-align: middle;">
						<!-- Tiêu đề -->
						<thead>
							<tr>
								<th style="text-align:center;" scope="col">Mã nhóm người dùng</th>
								<th style="text-align:center;" scope="col">Tên nhóm người dùng</th>
							</tr>
						</thead>
						<!-- Dữ liệu -->
						<tbody class="table-group-divider">
							<c:forEach var="p" items="${nguoiDungList}">
								<tr>
									<td style="text-align:center;">${p.maNhomNguoiDung}</td>
									<td style="text-align:center;">${p.tenNhomNguoiDung}</td>
								</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</div>
			

</body>
</html>
