<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
<%@include file="admin.jsp" %>
<form:form action="addproduct" method="POST" commandName="product">
<center>
<h1>Products</h1>
<table>
<tr>
<td>Product Id</td>
<td><input type="text" name="pid"/></td>
</tr>
<tr>
<td>Product Name</td>
<td><input type="text" name="name"/></td>
</tr>
<tr>
<td>Product Price</td>
<td><input type="text" name="price"/></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="AddProduct"/></td>
</tr>
</table>
</center>
</form:form>
</body>
</html> 