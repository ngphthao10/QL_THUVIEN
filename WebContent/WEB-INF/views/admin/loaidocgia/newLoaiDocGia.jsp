<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<base href="${pageContext.servletContext.contextPath}/">
<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
</head>
<body>
	
	<div class="main-content col-md-10">
        <div class="container">
            	
           <div class="d-flex justify-content-first mt-3">
              <form class="d-flex col-6" role="search">
                   <input name="tenLDGInput" class="form-control me-2"  type="text" placeholder="Tên loại độc giả" aria-label="Search">
               </form>
               <div class="col-6 d-grid gap-2 d-md-block button-container">
                 <button class="btn btn-secondary" type="button" data-bs-target="#btnInsert">
                   <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
                     <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
                     <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4"/>
                   </svg>
                   Thêm loại độc giả
                 </button>
               </div>
             </div>
              
              
              
           <!--   
          <c:if test="${not empty message}">			
		  	<c:choose>
				<c:when test="${message == 0}">
					<div class="col-sm-8 alert alert-danger" role="alert">
					Thêm thất bại!
					<button type="button" class="rem" data-dismiss="alert" aria-label="Close"></button>
					</div>
				</c:when>
				<c:when test="${message == 1}">
					<div class="col-sm-8 alert alert-success" role="alert">
					Thêm thành công!
					<button type="button" class="rem" data-dismiss="alert" aria-label="Close"></button>
					</div>
				</c:when>
			</c:choose>		  	
		</c:if>
        -->
              
       </div>
    </div>
		
</body>
</html>