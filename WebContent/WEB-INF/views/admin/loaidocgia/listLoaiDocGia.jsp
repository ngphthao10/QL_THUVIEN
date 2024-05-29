<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<base href="${pageContext.servletContext.contextPath}/">

<!DOCTYPE html>
<html>
<head>
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