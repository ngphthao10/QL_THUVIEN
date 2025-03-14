<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Phiếu thu</title>
    <base href="${pageContext.servletContext.contextPath}/">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.18.0/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.3/themes/base/jquery-ui.css">
	<style>
	.invalid-feedback {
			display: block;
			margin-top: 5px;
			margin-bottom: 5px
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
	              <div class="col-6 mt-4 ps-4 mt-4"><h3><a href="phieuthu/listPhieuThu.htm" style="text-decoration: none; 	color: black">QUẢN LÝ PHIẾU THU</a></h3></div>
	              <div class="col-6 d-grid gap-2 d-md-block button-container mt-4">
	                <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#insertPhieuThuModal" onclick="showModal()">
	                  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
	                    <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
	                    <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4"/>
	                  </svg>
	                  <!-- <a href="phieuthu/listPhieuThu.htm?insert" style="text-decoration: none; color: white;">Thêm phiếu</a> -->Thêm phiếu</button>
					
	                 
	                  
	              </div>
	             </div>
	             
	             <c:if test="${not empty message}">
						<c:choose>
							<c:when test="${message == 0}">
								<div class="alert alert-warning mt-2" role="alert">
									Thêm phiếu thu thất bại!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<c:when test="${message == 1}">
								<div class="alert alert-success mt-2" role="alert">
									Thêm phiếu thu thành công!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<c:when test="${message == -1}">
								<script>
							        window.onload = function showModal() {
							            var myModal = new bootstrap.Modal(document.getElementById('insertPhieuThuModal'), {});
							            myModal.show();
							        }
							    </script>
							</c:when>
						</c:choose>
					</c:if>
					
					<c:if test="${not empty message1}">
						<c:choose>
							<c:when test="${message1 == 0}">
								<div class="alert alert-warning mt-2" role="alert">
									Sửa phiếu thu thất bại!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<c:when test="${message1 == 1}">
								<div class="alert alert-success mt-2" role="alert">
									Sửa phiếu thu thành công!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<%-- <c:when test="${message1 == -1}">
								<script>
							        window.onload = function showModal() {
							            var myModal = new bootstrap.Modal(document.getElementById('editPhieuThuModal'), {});
							            myModal.show();
							        }
							    </script>
							</c:when> --%>
						</c:choose>
					</c:if>
					
					<c:if test="${not empty message2}">
						<c:choose>
							<c:when test="${message2 == 0}">
								<div class="alert alert-warning mt-2" role="alert">
									Xóa phiếu thu thất bại!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<c:when test="${message2 == 1}">
								<div class="alert alert-success mt-2" role="alert">
									Xóa phiếu thu thành công!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
						</c:choose>
					</c:if>
					

	          <div class="d-flex justify-content-end mt-3">
	            <form:form action="phieuthu/searchPhieuThu.htm" method="post" class="d-flex col-6" role="search">
	                <input class="form-control me-2" name="keyword" type="search" placeholder="Số phiếu, mã độc giả, tên độc giả" aria-label="Search" required>
	                <button class="btn btn-outline-success" style="min-width: 120px;" type="submit">
	                  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
	                    <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
	                  </svg>
	                  Tìm kiếm
	                </button>
	            </form:form>
	            <form:form class="d-flex col-6 ps-4" role="search" method="POST"
					action="phieuthu/listPhieuThu.htm?filter">
					<input class="form-control me-2" id="datepicker" name="filter_date" type="search" placeholder="Chọn ngày, tháng, năm" required>
					<button class="btn btn-outline-success" style="min-width: 150px;" type="submit">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-funnel mb-1" viewBox="0 0 16 16">
                    				<path d="M1.5 1.5A.5.5 0 0 1 2 1h12a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.128.334L10 8.692V13.5a.5.5 0 0 1-.342.474l-3 1A.5.5 0 0 1 6 14.5V8.692L1.628 3.834A.5.5 0 0 1 1.5 3.5zm1 .5v1.308l4.372 4.858A.5.5 0 0 1 7 8.5v5.306l2-.666V8.5a.5.5 0 0 1 .128-.334L13.5 3.308V2z" />
                  			</svg>
						Lọc ngày
					</button>
				</form:form>
	          </div> 
	        </div>
	         <div class="container">
	         	<jsp:useBean id="pagedListHolder" scope="request" type="org.springframework.beans.support.PagedListHolder" />
	    
			    <c:choose>
					<c:when test="${not empty param.keyword }">
						<c:url value="phieuthu/listPhieuThu.htm?search" var="pagedLink">
							<c:param name="p" value="~" />
							<c:param name="keyword" value="${param.keyword }" />
						</c:url>
					</c:when>
					<c:when test="${not empty param.filter_date }">
						<c:url value="phieuthu/listPhieuThu.htm?filter" var="pagedLink">
							<c:param name="p" value="~" />
							<c:param name="filter_date" value="${param.filter_date }" />
						</c:url>
					</c:when>
					<c:otherwise>
						<c:url value="phieuthu/listPhieuThu.htm" var="pagedLink">
					   		<c:param name="p" value="~"></c:param>
					    </c:url>
					</c:otherwise>
				</c:choose>
	            <table class="table table-hover table-bordered mt-4 text-center" style="vertical-align: middle;" id="tablePhieuThu">
	              <thead>
	                <tr>
	                  <th scope="col" class="col-1">Số phiếu thu</th>
	                  <th scope="col" class="col-2">Mã độc giả</th>
	                  <th scope="col" class="col-3">Tên độc giả</th>
	                  <th scope="col" class="col-2">Số tiền thu</th>
	                  <th scope="col" class="col-2">Ngày lập</th>
	                  <th scope="col" class="col-2">Chức năng</th>
	                </tr>
	              </thead>
	              <tbody class="table-group-divider">
	             	
	                <c:forEach var="phieuthu" items="${pagedListHolder.pageList}">
	                	<tr>
	                		<td>${phieuthu.soPhieuThu }</td>
	                		<td>${phieuthu.docGia.maDocGia }</td>
	                		<td>${phieuthu.docGia.tenDocGia }</td>
	                		<td> <fmt:setLocale value="vi_VN"/> <fmt:formatNumber value="${phieuthu.soTienThu}" type="currency" currencySymbol="đ" maxFractionDigits="0"/></td>
	                		<td><fmt:formatDate value="${phieuthu.ngayLap}" pattern="dd/MM/yyyy"/></td>
	                		<td>
								<a href="${pageContext.request.contextPath}/phieuthu/listPhieuThu.htm?edit&id=${phieuthu.soPhieuThu }" class="btn btn-outline-success">Chỉnh sửa</a>
	                		<!-- 	<button type="button" class="btn btn-outline-danger delete" data-bs-toggle="modal" data-bs-target="#xoaPhieuThuModal">Xóa</button> -->
	                			<input type="hidden" name="soPhieuThu" id="soPhieuThu" value="${phieuthu.soPhieuThu }">
                			</td>
	                 	</tr>
	                 </c:forEach>
	              </tbody>
	            </table>
	            <tg:paging pagedLink="${pagedLink }" pagedListHolder="${pagedListHolder}"></tg:paging>
	            
	          </div>
	    </div>
	  </div>
	 </div>

	 <script>
		window.onload = function showModal() {
			if (window.location.href.indexOf("edit") !== -1) {
				// Kích hoạt modal khi trang đã được tải xong
				var myModal = new bootstrap.Modal(document
						.getElementById('editPhieuThuModal'));
				myModal.show();
			}
		}
	</script>

	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://code.jquery.com/ui/1.13.3/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#datepicker").datepicker({
				dateFormat : 'dd/mm/yy',
				maxDate : "+0D"
			});
		});
	</script>
	
	<jsp:include page="editPhieuThu.jsp"></jsp:include>
	<jsp:include page="deletePhieuThu.jsp"></jsp:include>
	<jsp:include page="insertPhieuThu.jsp"></jsp:include>
  </body>
</html>