<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/login" var="myUrl"/>

<html>

<head>
	<link rel="stylesheet" type="text/css" href="resources/style.css">
	
	<title>LOGIN</title>
	
</head>

<body>


<div class="div">




	<form:form action="${myUrl}" commandName="user" method="POST" cssClass="form">
	
	<h1 class="title">
	Create New Account
	</h1>
	
	 <form:input placeholder="Username" path="userName"/><br>
	 <form:password placeholder="Password" path="password"/><br>
	 <input class="buton" type="submit" value="Login" />
	
	
	
  </form:form>
 
 	<c:if test="${fail ==0}">
   <p class="wrong ">Invalid username or password.<br>
						Please try again.</p>
  	</c:if>
	
  </div>
  
  	
</body>
</html>