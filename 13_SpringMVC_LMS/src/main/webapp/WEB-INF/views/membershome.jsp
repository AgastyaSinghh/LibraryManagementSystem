<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Member List</title>
</head>
<body>
	<h2>Welcome to LMS</h2>
	<hr>
	<br>
	<h3>Member Details</h3>

	<table border="1">
		<tr>
			<th>Member ID</th>
			<th>Name</th>
			<th>Type</th>
			<th>Status</th>
			<th>Issue Count</th>
		</tr>

		<c:forEach var="member" items="${memberList}">
			<tr>
				<td>${ member.id }</td>
				<td>${ member.name }</td>
				<td>${ member.type }</td>
				<td>${ member.status }</td>
				<td>${ member.issueCount }</td>
			</tr>
		</c:forEach>
	</table>
	<table></table>
	<br>
	<br>
	<br>
	<br>
	<a href="/lms/">Back</a>
	<br>
	<a href="new">New</a>
</body>
</html>