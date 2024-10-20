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
	<h1>List item in cart</h1>
	<table>
		<c:set var="total" value="0"></c:set>
		<tr>
			<th>Action</th>
			<th>Product id</th>
			<th>Product name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Total</th>
		</tr>
		<c:forEach var="item" items="${sessionScope.cart}">
			<tr>
				<td><a
					href="${pageContext.request.contextPath}/CartController?action=remove&id=${item.product.id}">Remove</a></td>
				<td>${item.product.id}</td>
				<td>${item.product.name}</td>
				<td>${item.product.price}</td>
				<td>${item.quantity}</td>
				<td>${item.product.price * item.quantity}</td>
				<c:set var="total" value="${total + item.product.price * item.quantity}"></c:set>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">Total all bills</td>
			<td>${total}</td>
	</table>
	<a href="${pageContext.request.contextPath}/ProductController">Continue to shopping</a>
</body>

<style>
table {
	width: 100%;
	border-collapse: collapse;
	border: 2px solid black;
}

th {
	border: 2px solid black;
	background-color: #d9e790;
}

th, td {
	border: 2px solid black;
	padding: 10px;
	text-align: left;
}

a {
	text-decoration: none;
	color: rgb(0, 21, 255);
	font-size: 20px;
}
</style>
</html>