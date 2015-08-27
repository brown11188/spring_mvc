<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management</title>
</head>
<body>
	<div class="header">

		<h2 class="text-center">
			<spring:message code="label.Title" text="default text" />


			Language : <img alt="image" id="langEN"
				src="<c:url value="/resources/image/ic_england.jpg" />"
				class="img-circle" height="30" width="30" /> | <img alt="image"
				id="langVN" src="<c:url value="/resources/image/ic_vietnam.png" />"
				class="img-circle" height="30" width="30" />
		</h2>
	</div>
	<div class="text-right">
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h4>
				<spring:message code="label.Welcome" text="Welcome" /> : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> <button class="btn btn-primary" ><spring:message code="label.Logout" text="Log out" /></button></a>
			</h4>
		</c:if>
	</div>

</body>
</html>

