<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List</h1>

	<table border="1" class="table table-condensed">
		<tr>
			<td>Id</td>
			<td>Full Name</td>
			<td>Age</td>
			<td>Detail</td>
			<td>Delete</td>
		</tr>
		<c:forEach var="i" items="${listEmployee}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${i.name}</td>
				<td>${i.age}</td>
				<td><form action="list" method="post">
						<a href="updatepage?id=${i.id }">Detail</a></td>
				<td><a href="delete?id=${i.id}">Delete</a>
				</form></td>
			</tr>
		</c:forEach>

	</table>

	<center>
		<a href="addpage"><button class="btn btn-primary">ADD</button></a>
	</center>


</body>
</html>