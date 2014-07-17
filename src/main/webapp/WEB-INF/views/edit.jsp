<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/edit" var="myUrl" />

<html>

<head>
<link rel="stylesheet" type="text/css" href="resources/editStyle.css">
<title>Edit Information</title>

</head>

<body>


	<div class="div">
		<h1 class="title">Edit information</h1>
		<form:form action="${myUrl}" commandName="destUser" method="POST">
			<table class="myTable">
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>Birthdate:</td>
					<td><form:input action="demo_form.asp" type="date"
							path="birthdate" /></td>
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
			</table>
			<a href="http://localhost:8080/usermanagement/sucess">
				<button class="butons" type="submit">Cancel</button>
			</a>
			<button class="butons" type="submit">Edit</button>
		</form:form>
		
		<c:if test="${no ==0}">
			<p class="wrong">
				Please complete correctly all fields!!!<br> Please try again.
			</p>
		</c:if>
		
	</div>

</body>
</html>
