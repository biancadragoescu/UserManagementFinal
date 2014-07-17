<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<link rel="stylesheet" type="text/css" href="resources/success.css">

<title>LOGIN</title>

</head>


<body>
	<ul class="meniu">
		<li><a href="https://www.google.ro/?gws_rd=cr&ei=aCnFU4zzA4e0ywPAzoGQCw">Home</a></li>
		<li><a href="http://localhost:8080/usermanagement/changePassword">Change Password</a></li>
		<li><a href="http://localhost:8080/usermanagement/edit">Edit User Information</a></li>
		<li class="logout"><a href="http://localhost:8080/usermanagement/login">Logout</a></li>
	</ul>
	<h1 class="username" >${user.userName }</h1>
	<c:if test="${isOk ==0}">
   				<p class="username">Your password has been successfully changed!</p>
  	</c:if>
	<img class="image" src='http://www.geckorecruitment.com/wp-content/uploads/2013/10/smiley_face.jpg' alt="Smiley face">

</body>
</html>
