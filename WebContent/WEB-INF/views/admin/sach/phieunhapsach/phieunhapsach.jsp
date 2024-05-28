<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<base href="${pageContext.servletContext.contextPath}/">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!doctype html>
<html lang="en">
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Quản lý phiếu nhập sách</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.3/themes/base/jquery-ui.css">
<style>
.button-container {
	text-align: right;
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
	                  <div class="col-6 mt-4 ps-4 mt-2">
	                  	<a style="text-decoration:none; color:black;" href="sach/phieunhapsach/index.htm"><h3>QUẢN LÝ PHIẾU NHẬP SÁCH</h3></a>
	                  </div>
	                  <div class="d-flex justify-content-end mt-3">
						<form:form class="d-flex col-6" role="search" method="POST"
							action="sach/phieunhapsach/search.htm" modelAttribute="phieunhapsach">
							<input class="form-control me-2" type="text" name="keyword"
								placeholder="Mã phiếu" aria-label="Search"
								value="${keyword}">
							<button class="btn btn-outline-success" style="min-width: 120px;"
								type="submit">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-search mb-1"
									viewBox="0 0 16 16">
				            		<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
				        </svg>
								Tìm kiếm
							</button>
						</form:form>
						<form:form class="d-flex col-6 ps-2" role="search" method="POST"
							action="sach/phieunhapsach/filter.htm" modelAttribute="phieunhapsach">
							<input name="NgayNhap" class="form-control datepicker me-2" placeholder="Ngày nhập sách" />
							<button class="btn btn-outline-success" style="min-width: 150px;"
								type="submit">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-funnel mb-1"
									viewBox="0 0 16 16">
                      				<path
										d="M1.5 1.5A.5.5 0 0 1 2 1h12a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.128.334L10 8.692V13.5a.5.5 0 0 1-.342.474l-3 1A.5.5 0 0 1 6 14.5V8.692L1.628 3.834A.5.5 0 0 1 1.5 3.5zm1 .5v1.308l4.372 4.858A.5.5 0 0 1 7 8.5v5.306l2-.666V8.5a.5.5 0 0 1 .128-.334L13.5 3.308V2z" />
                    			</svg>
								Lọc ngày nhập
							</button>
						</form:form>
					</div>
				<div class="container">
					<!-- Khai báo pagedListHolder với param p -->
					<jsp:useBean id="pagedListHolder" scope="request"
						type="org.springframework.beans.support.PagedListHolder" />
					<c:url value="sach/phieunhapsach/index.htm" var="pagedLink">
						<c:param name="p" value="~" />
					</c:url>
					<!-- Bảng dữ liệu -->
					<table class="table table-hover table-bordered mt-2" style="vertical-align: middle;">
						<!-- Tiêu đề -->
						<thead>
							<tr>
							  <th class="centered-column" scope="col" style="width: 150px;">Số phiếu nhập</th>
		                      <th class="centered-column" scope="col">Tổng tiền</th>
		                      <th class="centered-column" scope="col">Ngày nhập</th>
		                      <th class="centered-column" scope="col" style="width: 300px;">Thông tin phiếu nhập sách</th>
							</tr>
						</thead>
						<!-- Dữ liệu -->
						<tbody class="table-group-divider">
							<c:forEach var="p" items="${pagedListHolder.pageList}">
								<tr>
									<td style="text-align: right;">${p.soPhieuNhap}</td>
									<td style="text-align: right;"><fmt:setLocale value="vi_VN"/> 
									<fmt:formatNumber value="${p.tongTien}" type="currency" currencySymbol="đ" maxFractionDigits="0"/></td>
									<td style="text-align: right;"><fmt:formatDate value="${p.ngayNhap}" pattern="dd/MM/yyyy" /></td>
									<td class="centered-column"><a
										href="sach/phieunhapsach/index/${p.soPhieuNhap}.htm?info">
											<button type="button" class="btn btn-outline-primary "
												onclick="showModal()">Xem thông tin</button>
									</a></td>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<tg:paging pagedListHolder="${pagedListHolder}"
						pagedLink="${pagedLink}" />

				</div>
                </div>
			</div>
			<%@include file="/WEB-INF/views/admin/sach/phieunhapsach/infophieunhap.jsp"%>
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
			    window.onload = function() {
			        if (window.location.href.includes("info")) {
			            var myModal = new bootstrap.Modal(document.getElementById('ModalToggle'));
			            myModal.show();
			        }
			    }
			</script>
</body>
</html>
