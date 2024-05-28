<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/Header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home</title>
</head>
<body>
	<jsp:include page="../include/navbar.jsp" ></jsp:include>
	<div class="container-fluid">
		
	    
	    <div class="row">
	
			<jsp:include page="../include/sidebar.jsp"></jsp:include> 
	
	        <div class="main-content col-md-10">
	          <div class="container">
	             
	             <c:if test="${not empty message}">
				  	<div class="alert alert-success mt-2" role="alert">
						${message}
						<button type="button" class="btn-close" style="float: right;"
							data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
				</c:if>
	             
	        </div>
	    </div>
	  </div>
	 </div>
	
</body>
</html>