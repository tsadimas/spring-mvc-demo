<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Login</h3>
	

	<form:form action="${pageContext.request.contextPath}/authUser" method="POST">
	<c:if test="${param.error != null}">
		<i>Sorry! Invalid username/password!</i>
	</c:if>
	<div class="field">
			<label>User Name</label> 
			<input type="text" name="username"/>
		</div>
		<div class="field">
			<label>Password</label> 
			<input type="password" name="password"/>
		</div>
		<div class="field">
				<input type="submit" value="Login" />
			</div>
	</form:form>
	
</div>