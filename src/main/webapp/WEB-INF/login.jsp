<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Login and Register</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
        <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    

</head>
<body>
	<div>
		<div class="d-flex justify-content-evenly">
			<div class="col-4 p-4 bg-dark text-light m-4">
				<h2>New Customer</h2>
				<form:form action="/register" method="post" modelAttribute="newUser" class="col-4 p-4 bg-dark text-light">
					<div class="form-group">
						<form:label path="firstName">First Name:</form:label>
						<form:input type="text" path="firstName"/>
						<form:errors path="firstName"/>
					</div>
					<div class="form-group">
						<form:label path="lastName">Last Name:</form:label>
						<form:input type="text" path="lastName"/>
						<form:errors path="lastName"/>
					</div>
					<div class="form-group">
						<form:label path="email">Email:</form:label>
						<form:input type="text" path="email"/>
						<form:errors path="email"/>
					</div>
					<div class="form-group">
						<form:label path="password">Password:</form:label>
						<form:input type="password" path="password"/>
						<form:errors path="password"/>
					</div>
					<div class="form-group">
						<form:label path="confirmPassword">Confirm Password:</form:label>
						<form:input type="password" path="confirmPassword"/>
						<form:errors path="confirmPassword"/>
					</div>
					<input type="submit" value="Register" class="btn btn-primary"/>	
				</form:form>
			</div>
			<div class="col-4 p-4 bg-dark text-light m-4">
				<h2>Login</h2>
				<form:form action="/login" method="post" modelAttribute="newLogin" class="col-4 p-4 bg-dark text-light">
					<div class="form-group">
						<form:label path="email">Email:</form:label>
						<form:input type="text" path="email"/>
						<form:errors path="email"/>
					</div>
					<div class="form-group">
						<form:label path="password">Password:</form:label>
						<form:input type="password" path="password"/>
						<form:errors path="password"/>
					</div>
					<input type="submit" value="Login" class="btn btn-primary"/>
					<form:errors class="text-danger" path="email" />	
					<form:errors class="text-danger" path="password" />	
				</form:form>
			</div>
		</div>		
	<h3 class="text-danger"><c:out value="${error}"/></h3>
	</div>
</body>
</html>

