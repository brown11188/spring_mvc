<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
</head>
<body>
	<center>
		<!--  
		
		-->
		
		<div id="main">
			<form:form  method="post"
				action="addhibernate" modelAttribute="newEmp" commandName="newEmp">
				<table>
					<tr>
						<td>Employees name:</td>
						<td><form:input class="form-control" path="name" /></td>
						<td><form:errors path="name"></form:errors></td>
					</tr>

					<tr>
					
						<td>Employees age:</td>
						<td><form:input class="form-control" path="age" /></td>
						<td><form:errors path="age"></form:errors></td>
					</tr>
					<tr>
						<td></td>
						<td><input class="btn btn-primary" type="submit" value="ADD"></td>
						
					</tr>
				</table>
			</form:form>
		</div>

	</center>
</body>

</html>