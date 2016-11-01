<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>customers</title>
</head>
<body>
<%@include file="admin.jsp" %>
<center><h3>Customer Details</h3></center>
<c:if test="${!empty customerList}">
		<table>
			<tr>
			     <th width="80">FirstName</th>
			     <th width="80">LastName</th>
				<th width="80">Username</th>
				<th width="120">Mobilenumber</th>
				<th width="120">Emailid</th>
				<th width="120">Address</th>
				<th width="120">Role</th>
			</tr>
			<c:forEach items="${customerList}" var="register">
				<tr>
				    <td>${register.firstname}</td>
				    <td>${register.lastname}</td>
					<td>${register.username}</td>
					<td>${register.mobilenumber}</td>
					<td>${register.emailid}</td>
					<td>${register.address}</td>
					<td>${register.role}</td>
					
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
<%@include file="footer.jsp" %>
</html>
