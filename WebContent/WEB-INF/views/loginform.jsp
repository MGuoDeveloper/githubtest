<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring3Example</title>
</head>
<body>
	<h3>Login Form</h3>
	<h4>User Name="Admin" and Password="root"</h4>
	
	<form:form action="login" commandName="loginForm">
		<table>
			<tr>
				<td>User Name:<FONT color="red">
				<form:errors path="username" /></FONT></td>
			</tr>
			<tr>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td>Password:<FONT color="red">
				<form:errors path="password" /></FONT></td>
			</tr>
			<tr>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>