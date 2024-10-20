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
	<h1>Product List</h1>
	<a href="${pageContext.request.contextPath}/CartController">View cart</a>
	<table border="1">
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Image</th>
			<th>Product Price</th>
			<th></th>

		</tr>
		<c:forEach var="item" items="${listProduct}">
			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td><img
					src="${pageContext.request.contextPath}/resources/images/${item.image}"
					width="100" height="100" /></td>
				<td>${item.price}</td>
				<td><a href="${pageContext.request.contextPath}/CartController?action=add&id=${item.id}">Add To Cart</a>
			</tr>
		</c:forEach>
	</table>
	
</body>

<style>
table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
	text-align: left;
	border-bottom: 3px solid #ddd;
	font-weight: bold;
	font-size: 16px;
}

th {
	background-color: #d9e790;
}

a {
	text-decoration: none;
	color: rgb(0, 21, 255);
	font-size: 20px;
}

a:hover {
	color: red;
}

td a {
	color: green;
	font-size: 16px;
}
</style>
</html>