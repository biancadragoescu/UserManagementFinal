<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.io.*,java.util.*"%>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="resources/changePassStyle.css">
	<title>Change Password</title>
</head>
<body>
	<div class="div">
		<h1 class="title">Change Password</h1>
		<form:form action="${myUrl}" commandName="user" method="POST"
			cssClass="form">

			<% String user = request.getParameter("userName"); %>

			<table class="myTable">
				<tr>
					<td>Current Password:</td>
					<td><input type="password" name="currentPassword" /></td>
				</tr>
				<tr>
					<td>New Password:</td>
					<td><input type="password" name="newPassword" /></td>
				</tr>
				<tr>
					<td>Confirm Password:</td>
					<td><input type="password" name="confirmPassword" /></td>
				</tr>
			</table>

			<button class="butons" type="submit">Cancel</button>
			<button class="butons" type="submit">Save Changes</button>
		</form:form>
	</div>
</body>
</html>
