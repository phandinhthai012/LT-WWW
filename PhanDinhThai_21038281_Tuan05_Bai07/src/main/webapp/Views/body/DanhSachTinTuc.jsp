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
	<jsp:include page="../header/header.jsp"></jsp:include>
	<div class="content">
		<h3>Danh Mục</h3>
		<table>
			<tr>
				<th>ID</th>
				<th>Tên Danh Mục</th>
				<th>Người Quản Lí</th>
				<th>Tin Tức</th>
				<th>Ghi Chú</th>
			</tr>
			<c:forEach var="dm" items="${danhMuc}">
				<tr>
					<c:set var="mdm" value="${dm.maDM}" ></c:set>
					<td>${dm.maDM}</td>
					<td>${dm.tenDanhMuc}</td>
					<td>${dm.nguoiQuanLy}</td>
					<td>
						<h4>Tin Tức</h4>
						<ul> 
						<c:forEach var="tt" items="${tinTuc}">
                       		<c:if test="${tt.maDM == mdm}">
                       			<li>${tt.tieuDe} - nội dung:${tt.noiDungTT} </li><br>                     
                       		</c:if>
						</c:forEach>
						</ul>
					</td>
					<td>${dm.ghiChu}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
<style>
.body {
	margin: 0px;
	padding: 0px;
}

.content {
	margin: 20px;
}

.header {
	
}

.content {
	margin-top: 32px;
	margin-bottom: 50px;
}

table {
	width: 100%;
	border-collapse: collapse;
	border: 1px solid #ccc;
}

th, td, tr {
	border: 1px solid #ccc;
	text-align: center;
}
</style>
</html>