<jsp:include page="../jspf/header.jspf" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Add a Customer</h3>

	<form:form action="saveCustomer" modelAttribute="customer" method="POST" class="ui form">
		<div class="field">
			<label>First Name</label> 
			<form:input path="firstName"/>
		</div>
		<div class="field">
			<label>Last Name</label>
			<form:input path="lastName"/>
		</div>
		<div class="field">
			<label>Email</label> 
			<form:input path="email"/>
		</div>
		<button class="ui button" type="submit">Save</button>
	</form:form>

</div>
<jsp:include page="../jspf/footer.jspf" />
