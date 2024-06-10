<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
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