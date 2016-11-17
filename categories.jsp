<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Category</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
.cat{
margin-left:600px;
}
</style>
</head>
<%@include file="admin.jsp" %>
<body>
<div class="cat">
	<h1>Categories</h1>

	<c:url var="addAction" value="/addcategory"></c:url>

	<form:form action="${addAction}" commandName="category">
		<table style="width:100%">
			<tr>
				<td><form:label path="cid">
						<spring:message text="Category Id" />
					</form:label></td>
				<c:choose>
					<c:when test="${!empty category.cid}">
						<td><form:input path="cid" disabled="true" readonly="true" />
						</td>
					</c:when>

					<c:otherwise>
						<td><form:input path="cid" required="true"/></td>
					</c:otherwise>
				</c:choose>
			<tr>
			<form:input path="cid" hidden="true"  />
				<td><form:label path="cname">
						<spring:message text="Category Name" />
					</form:label></td>
				<td><form:input path="cname" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="cdescription">
						<spring:message text="Category Description" />
					</form:label></td>
				<td><form:input path="cdescription" required="true" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty category.cname}">
						<input type="submit"
							value="<spring:message text="Edit Category"/>" />
					</c:if> <c:if test="${empty category.cname}">
						<input type="submit" value="<spring:message text="Add Category"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	</div>
	<br>
	<h3>Categories List</h3>
	<c:if test="${!empty categoryList}">
	<div class="table-responsive">
			<table class="table">
			<tr>
				<th width="80">Category ID</th>
				<th width="120">Category Name</th>
				<th width="120">Category Description</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.cid}</td>
					<td>${category.cname}</td>
					<td>${category.cdescription}</td>
					<td><a href="<c:url value='editcategory/${category.cid}' />">Edit</a></td>
					<td><a href="<c:url value='removecategory/${category.cid}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</c:if>
</body>
<%@include file="common-footer.jsp" %>
</html>