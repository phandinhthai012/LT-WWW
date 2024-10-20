<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Thông tin sinh viên</h2>
	<form:form action="save" method="post">
		<table>
			<tr>
				<td>First name</td>
				<td><form:input path="fname" /></td>
			</tr>
			<tr>
				<td>last name</td>
				<td><form:input path="lname" /></td>
			</tr>
			<tr>
				<td>Diem TB(*)</td>
				<td><form:input path="diemtb" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save" /></td>
			</tr>
		</table>


	</form:form>
</body>
</html>