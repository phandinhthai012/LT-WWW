<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Danh sach Sinh vien</h3>
	<table border="2" width="70%" cellspacing="0">
		<tr>
			<th>MSSV</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Diem Trung Binh</th>
		</tr>
		<c:forEach var="std" items="${list}">
			<tr>
				<td>${std.id}</td>
				<td>${std.fname}</td>
				<td>${std.lname}</td>
				<td>${std.diemtb}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>