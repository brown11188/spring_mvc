<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management</title>
</head>
<body>
	<div class="row">
	
		<tiles:insertDefinition name="defaultTemplate">
			<tiles:putAttribute name="body">
				<div class="body">
					<h1>
						<spring:message code="label.List" text="List"></spring:message>
					</h1>

					<table class="table table-bordered">
						<tr>
							<td>Id</td>
							<td><spring:message code="label.Fullname" text="Full name" /></td>
							<td><spring:message code="label.Age" text="Age" /></td>
							<td><spring:message code="label.Detail" text="Detail" /></td>
							<td><spring:message code="label.Delete" text="Delete" /></td>
						</tr>

						<c:forEach var="i" items="${listEmployee}" varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td>${i.name}</td>
								<td>${i.age}</td>
								<td><a href="updatepage?id=${i.id }"><spring:message
											code="label.Moreinfo" text="Detail" /></a></td>
								<td><a href="deletehibernate?id=${i.id}"><spring:message
											code="label.Delete" text="Delete" /></a></td>
							</tr>
						</c:forEach>

					</table>

					<center>
						<a href="addpage"><button class="btn btn-primary">
								<spring:message code="label.Add" text="defaultText" />
							</button></a>
					</center>
				</div>
			</tiles:putAttribute>
		</tiles:insertDefinition>
	</div>
</body>
</html>