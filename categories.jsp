<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories</title>
</head>
<body>
<form:form action="addcategories" method="POST" commandName="category">

		<center>
			<h1>Categories</h1>
			<p>${msg}</p>
		</center>
		<center>
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
		</center>
	</form:form>
	<table>
	<tr>
	<th>Category Id</th>
	<th>Category Name</th>
	<th>Category Description</th>
	</tr>
	</table>
</body>
</html>