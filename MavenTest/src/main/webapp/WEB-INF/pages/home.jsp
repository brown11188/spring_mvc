<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>

			<div class="body">
				<h2>This is my homepage</h2>
				
				<p>
					This current Locale of client is:
					<c:choose>
					<c:when test="${currentLocale == 'en' }">
						<img alt="image"
							src="<c:url value="/resources/image/ic_england.jpg" />"
							class="img-circle" height="30" width="30" />
					</c:when>
					<c:when test="${currentLocale == 'vi' }">
					<img alt="image"
							src="<c:url value="/resources/image/ic_vietnam.png" />"
							class="img-circle" height="30" width="30" />
					</c:when>
				</c:choose>
				</p>
				<p>The time on server is ${serverTime }</p>
				<p class="text">Lorem ipsum dolor sit amet, consectetur
					adipisicing elit, sed do eiusmod tempor incididunt ut labore et
					dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
					exercitation ullamco laboris nisi ut aliquip ex ea commodo
					consequat. Duis aute irure dolorin reprehenderit in voluptate
					velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint
					occaecat cupidatat non proident, sunt in culpa qui officia deserunt
					mollit anim id est laborum.</p>
					
				<a class="more">Read more</a> 
			</div>
</body>
</html>
