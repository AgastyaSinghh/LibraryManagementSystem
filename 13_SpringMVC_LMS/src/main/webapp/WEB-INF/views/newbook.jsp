<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Book</title>
</head>
<body>
	<h3>Add New Book</h3>
	<hr>
	<f:form action="/lms/book/add" modelAttribute="book" method="post">
		<table>
			<tr>
				<td>ID:</td>
				<td><f:input path="id" /></td>
			</tr>
			<tr>
				<td>Title:</td>
				<td><f:input path="title" /></td>
			</tr>
			<tr>
				<td>Author:</td>
				<td><f:input path="author" /></td>
			</tr>
			<tr>
				<td>Issuable:</td>
				<td><f:input path="issuable" /></td>
			</tr>
			<tr>
				<td><a href="/lms/book/">Back</a></td>
				<td><input type="submit" value="Add Book"></td>
			</tr>
		</table>
	</f:form>
</body>
</html>