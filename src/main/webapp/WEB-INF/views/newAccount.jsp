<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/newAccount" var="myUrl" />

<html>

<head>
<link rel="stylesheet" type="text/css"
	href="resources/newAccountStyle.css">
<title>NewAccount</title>

</head>

<body>

	<div class="div">
		<h1 class="title">Create New Account</h1>
		<form:form action="${myUrl}" commandName="user" method="POST">
			<table class="myTable">
				<tr>
					<td>Username:</td>
					<td><form:input path="userName" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>Birthdate:</td>
					<td><form:input path="birthdate" /></td>
					<td>
				</tr>
				<tr>
					<td>Phone:</td>
					<td><form:input path="phone" /></td>
				</tr>
				<tr>
					<td>First name:</td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td>Last name:</td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" /></td>
				</tr>
			</table>
			<a href="http://localhost:8080/usermanagement/login"><button class="cancelButton" type="button">Cancel</button></a>
			<input class="createButton" type="submit" value="Create account" />
		</form:form>

	</div>

</body>
</html>
