<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC Form Handling</title>
	</head>
	<body>
		<h2>Add Employee Data</h2>
		<form:form method="POST" action="/ceok/save.html" commandName="users">
	   		<table>
			    <tr>
			        <td><form:label path="username">users Name:</form:label></td>
			        <td><form:input path="username" value="${users.username}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="password">Password:</form:label></td>
			        <td><form:input path="password" value="${users.password}"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
		
  <c:if test="${!empty employees}">
		<h2>List Employees</h2>
	<table align="left" border="1">
		<tr>
			<th>Users ID</th>
			<th>Users Name</th>
			<th>Users Password</th>
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${employees}" var="users">
			<tr>
				<td><c:out value="${users.id}"/></td>
				<td><c:out value="${users.username}"/></td>
				<td><c:out value="${users.password}"/></td>
				<td align="center"><a href="edit.html?id=${users.id}">Edit</a> | <a href="delete.html?id=${users.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
	</body>
</html>