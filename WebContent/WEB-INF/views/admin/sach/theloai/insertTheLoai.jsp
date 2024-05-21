<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<base href="${pageContext.servletContext.contextPath}/">
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
<title>Thêm thể loại</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
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
	text-align:center;
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
	                  <div class="col-6 ps-4 mt-4"><h3>QUẢN LÝ THỂ LOẠI</h3></div>
	                  <div class="col-6 mt-4">
		                  <form:form class="d-flex" role="search" method="POST"
								action="sach/theloai/insert.htm" modelAttribute="theloai">
								<div style="flex-grow:1; margin-right:15px; " >
									<form:input path="TenTheLoai" type="text" class="form-control me-2" style="height:100%"
										placeholder="Tên thể loại" required="true" />
									<div style="margin-top: 10px; position:relative;"> 
										<form:errors style ="position:absolute; width:100%;" cssClass="alert alert-danger" path="TenTheLoai" />
									</div>
								</div>
								<button class="btn btn-outline-success" style="min-width: 150px;"
									type="submit">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-plus-circle mb-1"
										viewBox="0 0 16 16">
						                       <path
											d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
						                       <path
											d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4" />
						                     </svg>
									Thêm thể loại
								</button>
							</form:form>
	                  </div>
	                </div>
	                <!-- <div class="alert alert-warning mt-2" role="alert">
						Thêm thể loại thất bại!
						<button type="button" class="btn-close" style="float: right;"
							data-bs-dismiss="alert" aria-label="Close"></button>
					</div> -->
	<%-- 	            	<c:if test="${not empty message}">
							<c:choose>
								<c:when test="${message == 0}">
									<div class="alert alert-warning mt-2" role="alert">
										Thêm thể loại thất bại!
										<button type="button" class="btn-close" style="float: right;"
											data-bs-dismiss="alert" aria-label="Close"></button>
									</div>
								</c:when>
								<c:when test="${message == 1}">
									<div class="alert alert-success mt-2" role="alert">
										Thêm thể loại thành công!
										<button type="button" class="btn-close" style="float: right;"
											data-bs-dismiss="alert" aria-label="Close"></button>
									</div>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${message == -2}">
									<div class="alert alert-warning mt-2" role="alert">
										Tên thể loại này đã có!
										<button type="button" class="btn-close" style="float: right;"
											data-bs-dismiss="alert" aria-label="Close"></button>
									</div>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${message == -3}">
									<div class="alert alert-warning mt-2" role="alert">
										Tên thể loại không được dài quá 100 ký tự!
										<button type="button" class="btn-close" style="float: right;"
											data-bs-dismiss="alert" aria-label="Close"></button>
									</div>
								</c:when>
							</c:choose>
						</c:if> --%>
            	</div>

			</div>
		</div>
	</div>

</body>
</html>

	



