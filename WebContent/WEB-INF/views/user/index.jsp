<%@ page pageEncoding= "utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<! DOCTYPE html>
<html>
<head>
	<base href= "${pageContext.servletContext.contextPath}/">
	<meta charset="utf-8"/>
	<title>Tiêu đề</title>
	<style>
		table{
			border-collapse: collapse;
			width: 50%;
		}
		th,td{
			line-height:25px;
			border: 2px solid black;
			padding: 5px;
		}
		th{
			background-color: gray;
		}
	</style>
</head>
<body>
	<table class= "table table-hover">
		<tr>
			<th>Username</th>
			<th>Password</th>
			<th>Fullname</th>
			<th></th>
		</tr>
		<c:forEach var="u" items="${users}">
		<tr>
			<td>${u.username}</td>
			<td>${u.password}</td>
			<td>${u.fullname}</td>
			<td><a href="user/delete/${u.username}.htm">Delete</a> </td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>