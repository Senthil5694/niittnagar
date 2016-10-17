<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
body{
margin-top:200px;
}
.align
{
margin-top:200px;
}
</style>
</head>
<div class="align">
<body background="F:\project\E-commerce project/tree.jpg">
<center>
<h1>Login Form</h1>
<h>${msg}</h>
<br>
<c:url var="addAction" value="/check">
		</c:url>
<form:form action="${addAction}" method="post">		
Username<br>
<input type="text" name="username"/><br><br>
Password<br>
<input type="password" name="password"/><br>
<br><input type="submit" value="login"/><br>
</form:form>
</center>
</body>
</div>
</html>