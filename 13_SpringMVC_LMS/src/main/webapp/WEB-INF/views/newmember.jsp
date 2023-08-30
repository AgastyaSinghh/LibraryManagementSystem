<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Member</title>
</head>
<body>
	<h3>Add New Member</h3>
	<hr>
	<f:form action="/lms/member/add" modelAttribute="member" method="post">
		<table>
			<tr>
				<td>ID:</td>
				<td><f:input path="id" /></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><f:input path="name" /></td>
			</tr>
			<tr>
				<td>Type:</td>
				<td><f:input path="type" /></td>
			</tr>
			<tr>
				<td>Status:</td>
				<td><f:input path="status" /></td>
			</tr>
			<tr>
				<td>Issue Count:</td>
				<td><f:input path="issueCount" /></td>
			</tr>
			<tr>
				<td><a href="/lms/member/">Back</a></td>
				<td><input type="submit" value="Add Member"></td>
			</tr>
		</table>
	</f:form>
</body>
</html>