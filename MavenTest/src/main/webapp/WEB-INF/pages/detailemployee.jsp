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
</head>
<body>
	<center>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">

				<form:form   method="post" action="updatehibernate" modelAttribute="newEmp" commandName="newEmp">
					<table>
						<tr>
							<td>Name</td>
							<td><form:input class="form-control" path="name" /></td>
							<td><form:errors path="name"></form:errors></td>
						</tr>

						<tr>
							<td>Age</td>
							<td><form:input class="form-control" path="age" /></td>
							<td><form:errors path="age"></form:errors></td>
						</tr>

						<tr>
							<form:hidden path="id" />
						</tr>
					</table>
					<input class="btn btn-primary" type="submit" value="Save">
				</form:form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</center>
</body>
</html>