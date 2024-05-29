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
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Độc giả</title>
    <base href="${pageContext.servletContext.contextPath}/">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.18.0/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
</head>
<body>
	<%@include file="/WEB-INF/views/include/navbar.jsp"%>
	
	<div class="container-fluid">
	    <div class="row">
			<%@include file="/WEB-INF/views/include/sidebar.jsp"%>
			
			<div class="main-content col-md-10">
			
				<jsp:useBean id="pagedListHolder" scope="request"
					type="org.springframework.beans.support.PagedListHolder" />
					
				<c:choose>
					<c:when test="${not empty param.searchInput }">
						<c:url value="docgia/listDocGia.htm?search" var="pagedLink">
							<c:param name="p" value="~" />
							<c:param name="searchInput" value="${param.searchInput }" />
							
						</c:url>
					</c:when>
					<c:otherwise>
						<c:url value="docgia/listDocGia.htm" var="pagedLink">
							<c:param name="p" value="~" />
						</c:url>
					</c:otherwise>
				</c:choose>
				
              <div class="container">
                <div class="row mt-2">
                  <div class="col-6 mt-4 ps-4 mt-4"><h3>QUẢN LÝ ĐỘC GIẢ</h3></div>
                </div>
                
                <c:if test="${not empty message}">
					<c:choose>
						<c:when test="${message == 0}">
							<div class="alert alert-warning mt-2" role="alert">
								Thêm độc giả thất bại!
								<button type="button" class="btn-close" style="float: right;"
									data-bs-dismiss="alert" aria-label="Close"></button>
								<div>${errorMessage}</div>
							</div>
							
						</c:when>
						<c:when test="${message == 1}">
							<div class="alert alert-success mt-2" role="alert">
								Thêm độc giả thành công!
								<button type="button" class="btn-close" style="float: right;"
									data-bs-dismiss="alert" aria-label="Close"></button>
							</div>
						</c:when>
					</c:choose>
				</c:if> 

                <div class="d-flex justify-content-first mt-3">
                  <form:form class="d-flex col-6" role="search" style="place-items: center"
                  		action="docgia/listDocGia.htm?search">
                      <input name="searchInput" class="form-control me-2"  type="search" placeholder="Mã, tên độc giả" aria-label="Search">
                      <button class="btn btn-outline-success" style="min-width: 120px" type="submit">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                          <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
                        </svg>
                        Tìm kiếm
                      </button>
                  </form:form>
                  
                  <div class="col-6 d-grid gap-2 d-md-block button-container ">
			        <button class="btn btn-secondary float-end" type="button" data-bs-toggle="modal" data-bs-target="#insertDocGiaModal">
			          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
			            <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
			            <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4"/>
			          </svg>
			          Thêm độc giả
			        </button>
                  
                  	<%@include file="/WEB-INF/views/admin/docgia/newDocGia.jsp"%>
                  
                  </div>
                  
                </div>
              </div>

              <div class="container">
              	
                <table class="table table-hover table-bordered mt-4">
                  <thead>
                    <tr align="center">
                      <th scope="col" class = "col-1">Mã độc giả</th>
                      <th scope="col" class = "col-4">Tên độc giả</th>
                      <th scope="col" class = "col-2">Loại độc giả</th>
                      <th scope="col" class = "col-2">Ngày hết hạn</th>
                      <th scope="col" class = "col-1">Tổng nợ</th>
                      <th scope="col" class = "col-2"></th>
                    </tr>
                  </thead>
                  <tbody class="table-group-divider">
                  
                  	<c:forEach var="docgia" items="${pagedListHolder.pageList}">
	                    <tr>
	                      <td class="text-center">${docgia.maDocGia}</td>
	                      <td>${docgia.tenDocGia}</td>
	                      <td class="text-center">${docgia.loaiDocGia.tenLoaiDocGia}</td>
	                      <td class="text-center">${docgia.formattedNgayHetHan}</td>
	                      <td class="text-center">${docgia.tongNoHienTai}</td>
	                      <td class= "text-center">
	                      	<a href="${pageContext.request.contextPath}/docgia/thongtinDG.htm?id=${docgia.id}" class="btn btn-outline-success">Thông tin</a>
	                      	<input type="hidden" name="id" id="id" value="${docgia.id}">
	                      </td>
	                    </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
              
              <tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}" />
            </div>
			
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>