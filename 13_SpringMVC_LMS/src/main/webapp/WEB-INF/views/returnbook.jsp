<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Return book</title>
</head>
<body>
	<h3>Return Book</h3>
	<hr>
	<br>
	<f:form action="/lms/return" modelAttribute="issue" method="post">
		<table>
			<tr>
				<td>Member ID:</td>
				<td><f:input path="member.id" readonly="true" /></td>
			</tr>
			<tr>
				<td>Member Name:</td>
				<td><f:input path="member.name" readonly="true" /></td>
			</tr>
			<tr>
				<td>Member Type:</td>
				<td><f:input path="member.type" readonly="true" /></td>
			</tr>
			<tr>
				<td>Member Status:</td>
				<td><f:input path="member.status" readonly="true" /></td>
			</tr>
			<tr>
				<td>Member Issue Count:</td>
				<td><f:input path="member.issueCount" readonly="true" /></td>
			</tr>
		</table>
		<br>
		<br>
		<table>
			<tr>
				<td>Book ID:</td>
				<td><f:input path="book.id" readonly="true" /></td>
			</tr>
			<tr>
				<td>Title:</td>
				<td><f:input path="book.title" readonly="true" /></td>
			</tr>
			<tr>
				<td>Author:</td>
				<td><f:input path="book.author" readonly="true" /></td>
			</tr>
			<tr>
				<td>Issuable:</td>
				<td><f:input path="book.issuable" readonly="true" /></td>
			</tr>
		</table>

		<br>
		<br>
		<table>
			<tr>
				<td>Issue ID:</td>
				<td><f:input path="issueId" readonly="true"/></td>
			</tr>
			<tr>
				<td>Issue Date:</td>
				<td><f:input path="issueDate" readonly="true" /></td>
			</tr>
			<tr>
				<td>Due Date:</td>
				<td><f:input path="dueDate" readonly="true" /></td>
			</tr>
			<tr>
				<td>Return Date:</td>
				<td><f:input path="returnDate" type="date" /></td>
			</tr>
			<tr>
				<td><a href="/lms/">Back</a></td>
				<td><input type="submit" value="Return Book"></td>
			</tr>
		</table>
		
	</f:form>

</body>
</html>