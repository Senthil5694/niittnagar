<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories</title>
</head>
<body>
<center>
<form:form action="addcategories" method="POST" commandName="category">

		<center>
			<h1>Categories</h1>
			<p>${msg}</p>
		</center>
		<table>
		<tr>
		<td>Category id</td>
		<td><input type="text" name="cid"/></td>
		</tr>
		<tr>
		<td>Category name</td>
		<td><input type="text" name="cname"/></td>
		</tr>
		<tr>
		<td>Category description</td>
		<td><input type="text" name="cdescription"/></td>
		</tr>
		<tr>
		<td></td>
		<td><input type="submit" value="Addcategory"/></td>
		</tr>
		</table>
		</form:form>
		</center>
	<table>
	<tr>
	<th>Category Id</th>
	<th>Category Name</th>
	<th>Category Description</th>
	</tr>
	<c:forEach items="${categoryList}" var="category">
	<tr>
	<td>"${category.cid}"</td>
	<td>"${category.cname}"</td>
	<td>"${category.cdescription}"</td>
	<td><a href="<c:url value='/editcategory/${category.cid}' />">Edit</a></td>
	<td><a href="<c:url value='/removecategory/${category.cid}' />">remove</a></td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>