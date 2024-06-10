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
<title>Các sách đã mượn</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
</head>
<body>
	<%@include file="/WEB-INF/views/user/userNavbar.jsp"%>
	<div class="container-fluid">
          <div class="container">
              <div class="mt-4" id="exampleModalToggleLabel" style="text-align: center;">
              <h3>Các sách đã mượn</h3></div>
              <hr>
              <c:choose>
              	<c:when test="${message == -1 }">
		         <div class="alert alert-info alert-dismissible fade show" role="alert">
                  	Bạn chưa mượn sách nào!
              		<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                  </div>		
              	</c:when>
              	<c:otherwise>
				<div class="row mt-2">
					<div class="col-6 mt-4 ps-4 mt-4"><h3>SÁCH ĐANG MƯỢN</h3></div>
          		</div>
          
				<div class="container">
					<table class="table table-hover table-bordered mt-4" style="vertical-align: middle;">
						 <thead>
						   <tr align="center">
						     <th scope="col" class="col-1">Số phiếu mượn</th>
						     <th scope="col" class="col-">Mã cuốn sách</th>
						     <th scope="col" class="col-6">Tên sách</th>
						     <th scope="col" class="col-2">Ngày mượn</th>
						     <th scope="col" class="col-2">Hạn trả</th>
						   </tr>
						 </thead>
					  <tbody class="table-group-divider">
					 
					  	<c:forEach var="phieumuontra" items="${listSach_DangMuon}">
					     <tr>
					       <th scope="row" class="text-center">${phieumuontra.soPhieuMuonTra}</th>
					       <td class="text-center">${phieumuontra.cuonSach.maCuonSach}</td>
					       <td>${phieumuontra.cuonSach.sach1.tuaSach1.tenTuaSach}</td>
					       <td class="text-center">${phieumuontra.formattedNgayMuon}</td>
					       <td class="text-center">${phieumuontra.formattedHanTra}</td>
					     </tr>
					    </c:forEach>
					    
					  </tbody>
					</table>
				</div>
          
		          <div class="row mt-2">
		            <div class="col-6 mt-4 ps-4 mt-4"><h3>SÁCH ĐÃ MƯỢN</h3></div>
		          </div>
		  
				  <div class="row g-3 align-items-center justify-content-end">
					  <div class="col-auto">
					    <label for="inputSoSachDaMuon" class="col-form-label">Số sách đã mượn: </label>
					  </div>
					  <div class="col-auto">
					  	<div class="col-5">
					    	<input type="text" id="soSachDaMuon" value="${soSachDaMuon}" class="form-control text-center" >
						</div>
						</div>
					</div>
		          
		          <div class="container">
		          	<jsp:useBean id="pagedListHolder" scope="request"
							type="org.springframework.beans.support.PagedListHolder" />
						<c:url value="user/sachdamuon.htm" var="pagedLink">
							<c:param name="p" value="~" />
						</c:url>
		            <table class="table table-hover table-bordered mt-4" style="vertical-align: middle;">
		              <thead>
		                <tr align="center">
		                  <th scope="col" class="col-1">Số phiếu mượn</th>
		                  <th scope="col" class="col-1">Mã cuốn sách</th>
		                  <th scope="col" class="col-5">Tên sách</th>
		                  <th scope="col" class="col-2">Ngày mượn</th>
		                  <th scope="col" class="col-2">Ngày trả</th>
		                  <th scope="col" class="col-1">Tiền phạt</th>
		                </tr>
		              </thead>
		              <tbody class="table-group-divider">
		             
		              	<c:forEach var="phieumuontra" items="${pagedListHolder.pageList}">
			                <tr>
			                  <th scope="row" class="text-center">${phieumuontra.soPhieuMuonTra}</th>
			                  <td class="text-center">${phieumuontra.cuonSach.maCuonSach}</td>
			                  <td>${phieumuontra.cuonSach.sach1.tuaSach1.tenTuaSach}</td>
			                  <td class="text-center">${phieumuontra.formattedNgayMuon}</td>
			                  <td class="text-center">${phieumuontra.formattedNgayTra}</td>
			                  <td class="text-center">${phieumuontra.soTienPhat}</td>
			                </tr>
		                </c:forEach>
		                
		              </tbody>
		            </table>
		            <tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}" />
		          </div>
    
              	</c:otherwise>
              </c:choose>
         </div>
    </div>   
</body>
</html>
