<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Suppliers</title>
</head>
<body>
<form:form action="addsupplier" method="POST" commandName="supplier">

		<center>
			<h1>Suppliers</h1>
			<p>${msg}</p>
		</center>
		<center>
		<table>
		<tr>
		<td>Supplier id</td>
		<td><input type="text" name="sid"/></td>
		</tr>
		<tr>
		<td>Supplier Name</td>
		<td><input type="text" name="name"/></td>
		</tr>
		<tr>
		<td>Supplier Address</td>
		<td><input type="text" name="address"/></td>
		</tr>
		<tr>
		<td></td>
		<td><input type="submit" value="Addsupplier"/></td>
		</tr>
		</table>
		</center>
	</form:form>
	<table>
	<tr>
	<th>Supplier Id</th>
	<th>Supplier Name</th>
	<th>Supplier Address</th>
	</tr>
	<c:forEach items="${supplierList}" var="supplier">
	<tr>
	<td>"${supplier.sid}"</td>
	<td>"${supplier.name}"</td>
	<td>"${supplier.address}"</td>
	<td><a href="<c:url value='/editsupplier/${supplier.sid}' />">Edit</a></td>
	<td><a href="<c:url value='/removesupplier/${supplier.sid}' />">remove</a></td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>