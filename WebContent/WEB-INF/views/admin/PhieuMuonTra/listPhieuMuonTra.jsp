<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/views/include/Header.jsp"></jsp:include>
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
	<jsp:include page="/WEB-INF/views/include/navbar.jsp" ></jsp:include>
	<div class="container-fluid">
		
	    
	    <div class="row">
	
			<jsp:include page="/WEB-INF/views/include/sidebar.jsp"></jsp:include> 
	
	        <div class="main-content col-md-10">
	          <div class="container">
	            <div class="row">
	              <div class="col-6 mt-4 ps-4 mt-4"><h3><a href="phieumuontra/listPhieuMuonTra.htm" style="text-decoration: none; 	color: black">QUẢN LÝ PHIẾU MƯỢN TRẢ</a></h3></div>
	              <div class="col-6 d-grid gap-2 d-md-block button-container mt-4">
	                <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#insertPhieuMuonTraModal" onclick="showModal()">
	                  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
	                    <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
	                    <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4"/>
	                  </svg>
	                  Thêm phiếu</button>
					
	                 
	                  
	              </div>
	             </div>
	             
	             <c:if test="${not empty message}">
						<c:choose>
							<c:when test="${message == 0}">
								<div class="alert alert-warning mt-2" role="alert">
									Thêm phiếu mượn trả thất bại!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<c:when test="${message == 1}">
								<div class="alert alert-success mt-2" role="alert">
									Thêm phiếu mượn trả thành công!
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
									Sửa phiếu mượn trả thất bại!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<c:when test="${message1 == 1}">
								<div class="alert alert-success mt-2" role="alert">
									Sửa phiếu mượn trả thành công!
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
									Xóa phiếu mượn trả thất bại!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
							<c:when test="${message2 == 1}">
								<div class="alert alert-success mt-2" role="alert">
									Xóa phiếu mượn trả thành công!
									<button type="button" class="btn-close" style="float: right;"
										data-bs-dismiss="alert" aria-label="Close"></button>
								</div>
							</c:when>
						</c:choose>
					</c:if>
					

	          <div class="d-flex justify-content-end mt-3">
	            <form:form action="phieumuontra/listPhieuMuonTra.htm?search" method="post" class="d-flex col-6" role="search">
	                <input class="form-control me-2" name="keyword" type="search" placeholder="Số phiếu mượn, mã độc giả, tên độc giả, mã cuốn sách, tên sách" aria-label="Search" required>
	                <button class="btn btn-outline-success" style="min-width: 120px;" type="submit">
	                  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
	                    <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
	                  </svg>
	                  Tìm kiếm
	                </button>
	            </form:form>
	          </div> 
	         	<div class="container">
	         	<jsp:useBean id="pagedListHolder" scope="request" type="org.springframework.beans.support.PagedListHolder" />
	    
			    <c:url value="phieumuontra/listPhieuMuonTra.htm" var="pagedLink">
			    <c:param name="p" value="~"></c:param>
			    </c:url>
	            <table class="table table-hover table-bordered mt-4 text-center" style="vertical-align: middle" id="tablePhieuMuonTra">
	              <thead>
	                <tr>
	                  <th scope="col" class="col-1">Số phiếu mượn</th>
	                  <th scope="col" class="col-1">Mã cuốn sách</th>
	                  <th scope="col" class="col-3">Tên sách</th>
	                  <th scope="col" class="col-1">Mã độc giả</th>
	                  <th scope="col" class="col-1">Ngày mượn</th>
	                  <th scope="col" class="col-1">Hạn trả</th>
	                  <th scope="col" class="col-1">Ngày trả</th>
	                  <th scope="col" class="col-1">Số tiền phạt</th>
	                  <th scope="col" class="col-2">Chức năng</th>
	                  
	                </tr>
	              </thead>
	              <tbody class="table-group-divider">
	             	
	                <c:forEach var="phieumuontra" items="${pagedListHolder.pageList}">
	                	<tr>
	                		<td>${phieumuontra.soPhieuMuonTra }</td>
	                		<td>${phieumuontra.cuonSach.maCuonSach }</td>
	                		<td>${phieumuontra.cuonSach.sach1.tuaSach1.tenTuaSach }</td>
	                		<td>${phieumuontra.docGia.maDocGia}</td>
	                		<td><fmt:formatDate value="${phieumuontra.ngayMuon}" pattern="dd/MM/yyyy"/></td>
	                		<td><fmt:formatDate value="${phieumuontra.hanTra}" pattern="dd/MM/yyyy"/></td>
	                		<td><fmt:formatDate value="${phieumuontra.ngayTra}" pattern="dd/MM/yyyy"/></td>
	                		<td> <fmt:setLocale value="vi_VN"/> <fmt:formatNumber value="${phieumuontra.soTienPhat}" type="currency" currencySymbol="đ" maxFractionDigits="0"/></td>
	                		<td>
								<a href="${pageContext.request.contextPath}/phieumuontra/listPhieuMuonTra.htm?edit&id=${phieumuontra.soPhieuMuonTra }" class="btn btn-outline-success">Chỉnh sửa</a>
	                			<button type="button" class="btn btn-outline-danger delete" data-bs-toggle="modal" data-bs-target="#xoaPhieuMuonTraModal">Xóa</button>
	                			<input type="hidden" name="soPhieuMuon" id="soPhieuMuon" value="${phieumuontra.soPhieuMuonTra }">
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
	 </div>
	 
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>	
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
	 
	 <jsp:include page="insertPhieuMuonTra.jsp"></jsp:include>
	 <jsp:include page="deletePhieuMuonTra.jsp"></jsp:include>
	 <jsp:include page="editPhieuMuonTra.jsp"></jsp:include>
</body>
</html>