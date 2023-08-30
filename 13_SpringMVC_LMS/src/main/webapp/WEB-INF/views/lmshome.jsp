<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LMS Home</title>
<style>
td, th, table {
	padding: 5px 20px;
}
</style>
</head>
<body>
	<h2>Welcome to LMS</h2>
	<hr>
	<br>
	<h3>Issue Details</h3>
	
	<table border="1">
		<tr>
			<th>Issue ID</th>
			<th>Member ID</th>
			<th>Member Name</th>
			<th>Book Name</th>
			<th>Book Name</th>
			<th>Issue Date</th>
			<th>Due Date</th>
			<th>Action</th>
		</tr>
		
		<c:forEach var="issue" items="${issueList}">
			<tr>
			<td>${ issue.issueId}</td>
			<td>${ issue.member.id }</td>
			<td>${ issue.member.name}</td>
			<td>${ issue.book.id }</td>
			<td>${ issue.book.title}</td>
			<td>${ issue.issueDate }</td>
			<td>${ issue.dueDate }</td>
			<td><a href="return/${issue.issueId}">Return</a></td>
			</tr>		
		</c:forEach>
	</table>
	<table></table>
	<br>
	<br>
	<br>
	<br>
	<table>
		<tr>
			<td><a href="book/">Book</a></td>
			<td><a href="member/">Member</a></td>
			<td><a href="new">New</a></td>
		</tr>
	</table>
</body>
</html>