<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../header/header.jsp"></jsp:include>
	<div class="content">
		<table>
			<tr>
				<th>ID</th>
				<th>ID Danh Mục</th>
				<th>TIEUDE</th>
				<th>NOIDUNGTT</th>
				<th>LIENKET</th>
				<th>Action</th>
			</tr>
			<c:forEach var="tt" items="${tinTuc}">
				<tr>
					<td>${tt.maTT}</td>
					<td>${tt.maDM}</td>
					<td>${tt.tieuDe}</td>
					<td>${tt.noiDungTT}</td>
					<td>${tt.lienKet}</td>
					<td><a href="QuanLyFormServlet?maTT=${tt.maTT}&action=re" class="remove">Delete</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>
	<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
<style>
.content {
	margin-top: 32px;
	margin-bottom: 50px;
	margin-left: 10px;
	margin-right: 10px;
	
}

table {
	width: 100%;
	border-collapse: collapse;
	align: center;
	padding: 15px;
}

table, th, td {
	border: 1px solid black;
}

.remove {
	color: red;
}
</style>
</html>