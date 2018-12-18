<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Spring MVC demo project!</h1>
<sec:authorize access="isAuthenticated()">
	<div class="ui segment">
	User: <sec:authentication property="principal.username" />, Role: <sec:authentication property="principal.authorities"/>
	</div>
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" />
		</form:form>
</sec:authorize>
<a href="<c:url value="/showForm"></c:url>">Show Form</a>
</body>
</html>