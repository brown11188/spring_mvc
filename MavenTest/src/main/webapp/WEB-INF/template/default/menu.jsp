<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="menu">
<center>
<h3><span class="label label-default">Menu</span></h3>
</center>
	<ul class="nav nav-pills nav-stacked">
		<li>
			<spring:url value="/listhibernate" var="listUrl" htmlEscape="true"></spring:url>
			<a href="${listUrl }">List Employee</a>
		</li>
		<li>
			<spring:url value="/addpage" var="addUrl" htmlEscape="true"></spring:url>
			<a href="${addUrl }">Add Employee</a>
		</li>
	</ul>
</div>

</body>
</html>