<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
	<link rel="stylesheet" type="text/css" href="resources/style.css">
	
	<title>Change Password</title>
	
</head>


<body>
	
	
	<div class="div">

		<form:form action="${myUrl}" commandName="user" method="POST"
			cssClass="form">
			
			Current password: <form:password path="password" />
			<br>
			New password: <input type="password" name="password">
			<br>
  			Confirm password: <input type="password" name="password"><br>

			<a href="http://localhost:8080/usermanagement/login"><button class="signout" type="button">Save</button></a>


		</form:form>

	</div>
	
	 
</body>
</html>
