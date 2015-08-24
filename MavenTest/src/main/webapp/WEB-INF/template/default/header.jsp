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
	
</body>
</html>

