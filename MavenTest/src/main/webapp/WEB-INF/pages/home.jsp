<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="body">
		
			<h2>This is my homepage</h2>
			<p>This current Locale of client is: <c:if test="${currentLocale == 'en_US' }">
				<img alt="image" src="<c:url value="/resources/image/ic_england.jpg" />" class="img-circle" height="30" width="30"/>
			</c:if></p>
			
			<p>The time on server is ${serverTime }</p>
			<p class="text">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore
                magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
			</p>
			
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
</body>
</html>
