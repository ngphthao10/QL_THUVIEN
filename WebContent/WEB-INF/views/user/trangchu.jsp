<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<!doctype html>
<html lang="en">
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Trang chủ</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
</head>
<body>
	<%@include file="/WEB-INF/views/user/userNavbar.jsp"%>
	<div class="container-fluid">

		<div class="container">
			<div class="mt-4" id="exampleModalToggleLabel" style="text-align: center;">
				<h3>Thông tin độc giả</h3>
			</div>
			<hr>
			<form:form class="d-flex" role="search" method="POST" action="user/trang-chu.htm" modelAttribute="docgia">
				<table class="table ALIGN table-hover table-bordered mt-4" style="vertical-align: middle;">
					<tbody>
						<tr>
							<th scope="row">Mã độc giả</th>
							<td class="align-middle">
								<form:input path="maDocGia" class="form-control me-2" readonly="true" />
							</td>
						</tr>
						<tr>
							<th scope="row">Loại độc giả</th>
							<td class="align-middle">
								<form:input path="loaiDocGia.tenLoaiDocGia" class="form-control me-2" readonly="true" />
							</td>
						</tr>
						<tr>
							<th scope="row">Họ tên</th>
							<td class="align-middle">
								<form:input path="nguoiDung.tenNguoiDung" class="form-control me-2" readonly="true" />
							</td>
						</tr>
						<tr>
							<th scope="row">Ngày sinh</th>
							<td class="align-middle">
								<form:input path="nguoiDung.ngaySinh" class="form-control me-2" readonly="true" />
							</td>
						</tr>
						<tr>
							<th scope="row">Địa chỉ</th>
							<td class="align-middle">
								<form:input path="diaChi" class="form-control me-2" readonly="true" />
							</td>
						</tr>
						<tr>
							<th scope="row">Email</th>
							<td class="align-middle">
								<form:input path="email" class="form-control me-2" readonly="true" />
							</td>
						</tr>
						<tr>
							<th scope="row">Ngày lập thẻ</th>
							<td class="align-middle">
								<form:input path="ngayLapThe" class="form-control me-2" readonly="true" />
							</td>
						</tr>
						<tr>
							<th scope="row">Ngày hết hạn</th>
							<td class="align-middle">
								<form:input path="ngayHetHan" class="form-control me-2" readonly="true" />
							</td>
						</tr>
						<tr>
							<th scope="row">Tổng nợ hiện tại</th>	
							<td class="align-middle">
								<form:input path="tongNoHienTai" class="form-control me-2" readonly="true" />
							</td>
						</tr>
					</tbody>
				</table>
				
				
			</form:form>
		</div>
	</div>
	
</body>
</html>
