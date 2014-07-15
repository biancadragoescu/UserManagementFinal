<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
	<link rel="stylesheet" type="text/css" href="resources/style.css">
	
	<title>LOGIN</title>
	
</head>


<body>
	<h2> ${user.userName } </h2>
	<a href="http://localhost:8080/usermanagement/login"><button class="signout" type="button">Logout</button></a>
	
<h1 class="rez">
	Success!!!
</h1>
	
	 
</body>
</html>
