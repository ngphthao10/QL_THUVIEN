<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<base href="${pageContext.servletContext.contextPath}/">

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/views/include/navbar.jsp"%>
	
	<div class="container-fluid">
	    <div class="row">
			<%@include file="/WEB-INF/views/include/sidebar.jsp"%>
			
			<div class="main-content col-md-10">
			
				<jsp:useBean id="pagedListHolder" scope="request"
					type="org.springframework.beans.support.PagedListHolder" />
				<c:url value="loaidocgia/listLoaiDocGia.htm" var="pagedLink">
					<c:param name="p" value="~" />
				</c:url>
			
              <div class="container">
				
                <div class="row mt-2">
                  <div class="col-6 mt-4 ps-4 mt-4"><h3>QUẢN LÝ LOẠI ĐỘC GIẢ</h3></div>
                </div>
                
                <!--
                %@include file="/WEB-INF/views/loaidocgia/newLoaiDocGia.jsp"%>
                -->
                
                
                <!--
                <div class="d-flex justify-content-first mt-3">
                  <form class="d-flex col-6" role="search">
                      <input name="tenLDGInput" class="form-control me-2"  type="text" placeholder="Tên loại độc giả" aria-label="Search">
                  </form>
                  <div class="col-6 d-grid gap-2 d-md-block button-container">
                    <button id="btnInsert" class="btn btn-secondary" type="button" >
                      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
                        <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4"/>
                      </svg>
                      Thêm loại độc giả
                    </button>
                  </div>
                </div>
              </div>
              -->
              
              <div class="container">
                <table class="table table-hover table-bordered mt-4">
                  <thead>
                    <tr align="center">
                      <th scope="col" class = "col-4">Mã loại độc giả</th>
                      <th scope="col" class = "col-8">Tên loại độc giả</th>
                      <!--
                      <th scope="col" class = "col-3"></th>
                      -->
                    </tr>
                  </thead>
                  <tbody class="table-group-divider">
                  
                  	<c:forEach var="ldg" items="${pagedListHolder.pageList}">
	                  	<tr>
	                      <td class="text-center">${ldg.maLoaiDocGia}</td>
	                      <td class="text-center">${ldg.tenLoaiDocGia}</td>
	                      <!--
	                      <td class="text-center">
	                      	<button name="btnUpdate" type="button" class="btn btn-outline-secondary">Chỉnh sửa</button>
	                      	<button type="button" class="btn btn-outline-danger delete" data-bs-toggle="modal" data-bs-target="#xoaLoaiDocGiaModal">Xóa</button>
	                      	<input type="hidden" name="id" id="id" value="${ldg.id}">
	                      </td>
	                      -->
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