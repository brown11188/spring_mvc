<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

			<center>
				<div id="main">
					<form:form method="post" action="addhibernate"
						modelAttribute="newEmp" commandName="newEmp">
						<table>
							<tr>
								<td>Employees name:</td>
								<td><form:input class="form-control" path="name" /></td>
								<td><form:errors path="name" cssStyle="color: red"></form:errors></td>
							</tr>

							<tr>

								<td>Employees age:</td>
								<td><form:input class="form-control" path="age" /></td>
								<td><form:errors path="age" cssStyle="color: red"></form:errors></td>
							</tr>
						</table>

						<input class="btn btn-primary" type="submit" value='<spring:message code="label.Add" />'>
					</form:form>
				</div>


			</center>


</body>

</html>