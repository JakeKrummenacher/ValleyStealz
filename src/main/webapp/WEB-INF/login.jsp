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
<%--    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
<%--    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>--%>
        <!-- for Bootstrap CSS -->
<%--    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />--%>
	<link rel="apple-touch-icon" sizes="180x180" href="/images/apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="/images/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="/images/favicon-16x16.png">
	<link rel="manifest" href="/images/site.webmanifest">
	<link rel="mask-icon" href="/images/safari-pinned-tab.svg" color="#5bbad5">
	<link rel="stylesheet" href="/css/login.css" />
	<link rel="stylesheet" href="/css/index.css" />
    

</head>
<body>
	<nav>
		<a href="/"><img src="https://i.ibb.co/ng4cSgp/White.png" class="logo"></a>
		<ul>
			<li><a href="/">Home</a></li>
			<!-- Implement For Each in Products -->
			<!-- And Provide Links -->
			<li><a href="/products">Products</a></li>
		</ul>
	</nav>
	<div>
		<div>
			<div class="form-container">
				<h2>Login</h2>
				<form:form action="/login" method="post" modelAttribute="newLogin">
					<div>
						<form:label path="email">Email:</form:label>
						<form:input type="text" path="email"/>
					</div>
					<div>
						<form:label path="password">Password:</form:label>
						<form:input type="password" path="password"/>
					</div>
					<input type="submit" value="Login" class="btn btn-primary"/>
					<div class="validation-message">
						<form:errors class="text-danger" path="email" />
						<form:errors class="text-danger" path="password" />
					</div>

				</form:form>
			</div>
			<div class="form-container">
				<h2>New Customer</h2>
				<form:form action="/register" method="post" modelAttribute="newUser">
					<div>
						<form:label path="firstName">First Name:</form:label>
						<form:input type="text" path="firstName"/>
					</div>
					<div>
						<form:label path="lastName">Last Name:</form:label>
						<form:input type="text" path="lastName"/>
					</div>
					<div>
						<form:label path="email">Email:</form:label>
						<form:input type="text" path="email"/>
					</div>
					<div>
						<form:label path="password">Password:</form:label>
						<form:input type="password" path="password"/>
					</div>
					<div>
						<form:label path="confirmPassword">Confirm Password:</form:label>
						<form:input type="password" path="confirmPassword"/>
					</div>
					<input type="submit" value="Register"/>

					<div class="validation-message">
						<form:errors path="firstName" />
						<form:errors path="lastName" />
						<form:errors path="email" />
						<form:errors path="password" />
						<form:errors path="confirmPassword" />
					</div>
				</form:form>

			</div>

		</div>		
	<h3 class="text-danger"><c:out value="${error}"/></h3>
	</div>
</body>
</html>

