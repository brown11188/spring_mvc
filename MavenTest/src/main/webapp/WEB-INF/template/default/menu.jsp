<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management</title>
</head>
<body>
	<div class="menu bs-example">
		<div class="text-center">
			<h3>
				<span class="label label-default"><spring:message
						code="label.Menu" text="defaultText"></spring:message> </span>
			</h3>
		</div>
		<ul id="menuList" class="nav nav-pills nav-stacked"
			style="border: 15px;">
			<li id="liHome" class = "test"><a href="home">Home</a></li>
			<li id="liList"><spring:url value="/listhibernate" var="listUrl"
					htmlEscape="true" /> <a href="${listUrl }">List Employee</a></li>
			<li id="liAdd"><spring:url value="/addpage" var="addUrl"
					htmlEscape="true" /> <a href="${addUrl }">Add Employee</a></li>
		</ul>
	</div>

</body>

</html>