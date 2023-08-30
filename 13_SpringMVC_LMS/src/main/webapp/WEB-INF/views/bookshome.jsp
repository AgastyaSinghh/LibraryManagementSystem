<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book List</title>
</head>
<body>
	<h2>Welcome to LMS</h2>
	<hr>
	<br>
	<h3>Book Details</h3>

	<table border="1">
		<tr>
			<th>Book ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Issuable</th>
		</tr>

		<c:forEach var="book" items="${bookList}">
			<tr>
				<td>${ book.id }</td>
				<td>${ book.title }</td>
				<td>${ book.author }</td>
				<td>${ book.issuable }</td>
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