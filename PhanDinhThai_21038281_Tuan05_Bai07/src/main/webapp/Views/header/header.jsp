<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<div class ="imgHeader">
			<img alt="" src="${pageContext.request.contextPath}/Resource/images/news1.jpg">
		</div>
		<div>
			<nav class ="menu">
				<ul>
					<li><a href="${pageContext.request.contextPath}/DanhSachTinTucServlet">Danh Sách Tin Tức</a></li>
					<li><a href="${pageContext.request.contextPath}/Views/body/TinTucForm.jsp">Thêm Tín Tức Mới</a></li>
					<li><a href="${pageContext.request.contextPath}/QuanLyFormServlet"">Chức Năng Quản Lý</a></li>
				</ul>
			</nav>
		</div>
		
	</div>
</body>

<style>
body {
	margin: 0px;
	padding: 0px;
}

.header {
	width: 100%;
	height: 300px;
	background-color: #f1f1f1;
	margin: 0px;
}

.imgHeader {
	width: 100%;
	height: 240px;
}

img {
	width: 100%;
	height: 240px;
}

.menu {
	width: 100%;
	height: 40px;
	background-color: #333;
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
}

li {
	display: inline;
	padding: 10px;
}

a {
	color: white;
	font-size: 20px;
	margin: 24px
}
</style>
</html>