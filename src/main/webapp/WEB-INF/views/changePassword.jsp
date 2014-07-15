<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.io.*,java.util.*" %>

<html>

<head>
	<link rel="stylesheet" type="text/css" href="resources/style.css">
	
	<title>Change Password</title>
	
</head>


<body>
	
	
	<div class="div">

		<form:form action="${myUrl}" commandName="user" method="POST"
			cssClass="form">
			
			<% String user = request.getParameter("userName"); %>
			
			Current password: <input type="password" name="currentPassword" />
			<br>
			New password: <input type="password" name="newPassword">
			<br>
  			Confirm password: <input type="password" name="confirmPassword"><br>
  			
  			<input class="buton" type="submit" value="Save" />
  			
  			<%-- <button class="signout" type="button">Save</button> --%>
  			
  			

		<%-- <a href="http://localhost:8080/usermanagement/login"></a> --%>	


		</form:form>

	</div>
	
	 
</body>
</html>
