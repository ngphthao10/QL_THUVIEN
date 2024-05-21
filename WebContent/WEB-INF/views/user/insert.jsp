<%@ page pageEncoding= "utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<! DOCTYPE html>
<html>
<head>
	<base href= "${pageContext.servletContext.contextPath}/">
	<meta charset="utf-8"/>
	<title>Tiêu đề</title>
</head>
<body>
	<form:form action="user/insert.htm" modelAttribute="user">
		<div>
			<label>Username</label>
			<form:input path="username"/>
		</div>
		<div>
			<label>Password</label>
			<form:input path= "password"/>
		</div>
		<div>
			<label>Fullname</label>
			<form:input path= "fullname"/>
		</div>
		<div>
			<button class= "btn btn-default">Insert</button>
		</div>
	</form:form>
</body>
</html>