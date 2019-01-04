<%@ include file="/WEB-INF/jspf/header.jspf" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	<h3>Login</h3>
	
<div class="form-group">

	<form:form action="${pageContext.request.contextPath}/authUser" method="POST">
	<c:if test="${param.error != null}">
		<i>Sorry! Invalid username/password!</i>
	</c:if>
	
			<label class="form-label">User Name</label> 
			<input type="text" name="username"/>
		
			<label class="form-label">Password</label> 
			<input type="password" name="password"/>
			<button class="btn" type="submit">Login</button>
			</div>
	</form:form>
	
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
	
