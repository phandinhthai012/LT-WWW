<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>
	<div class="header">
		<h1>BookStrore</h1>
		<div>
			<a href="#" class="menu">Home</a> <a href="#" class="menu">Example</a>
			<a href="#" class="menu">Servicer</a> <a href="#" class="menu">Prodict</a>
			<a href="#" class="menu">Contact</a>
		</div>
	</div>
	<div class="body">
		<div class="left">
			<h2>ABOUT US</h2>
			<P>
				About us information will be here ... <a href="">Read More</a>
			</P>
			<form action="" method="post">
				<H3>SEARCH SITE</H3>
				<input type="text" name="search" placeholder="Search for books...">
				<input type="submit" value="Search">
			</form>
		</div>
		<div class="right">
			<table>
				<tr>
					<th>Product ID</th>
					<th colspan="5">Product Name</th>
					<th>Price</th>
					<th>Qty</th>
					<th>Total</th>
					<th>Remove</th>
				</tr>
			<c:forEach var="item" items="${sessionScope.cart}">
				<tr>
					<td>${item.book.id}</td>
					<td colspan="5">${item.book.name}</td>
					<td>${item.book.price}</td>
					<td>${item.quantityCart }</td>
					<td>${item.quantityCart*item.book.price}</td>
					<td><a
						href="${pageContext.request.contextPath}/CartController?action=remove&id=${item.book.id}">Remove</a></td>
				</tr>
			</c:forEach>
			</table>
			<div>
				<a href="${pageContext.request.contextPath}/CartController?action=checkout" class="btn">Check Out</a> 
				<a href="${pageContext.request.contextPath}/BookController" class="btn">Continue Shopping</a>
			</div>
		</div>

	</div>
</body>
<style>
body {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
}

.header {
	background-color: #333;
	color: #fff;
	text-align: center;
	padding: 10px 0;
	display: flex;
	justify-content: space-around;
	align-items: center;
}

.menu {
	color: #fff;
	text-decoration: none;
	padding: 12px 24px;
	background-color: #817d7d;
	color: #fff;
	font-size: 16px;
	font-weight: 800;
}

a {
	color: #0d49ee;
	text-decoration: none;
}

a:hover {
	background-color: #fff;
	color: #333;
}

.left {
	width: 30%;
	padding: 20px;
	display: inline-block;
	float: inline-start;
}

.right {
	width: 60%;
	padding: 20px;
	display: inline-block;
}

table {
	width: 100%;
	border-collapse: collapse;
	border: 1px solid #221f1f;
}

tr {
	background-color: #f2f2f2;
}

td, th {
	border: 1px solid #ddd;
	padding: 8px;
}

th {
	background-color: #817d7d;
}

td {
	text-align: left;
	border-bottom: 1px solid #ddd;
}

.btn {
	padding: 10px 20px;
	background-color: #4CAF50;
	color: white;
	border: none;
	margin-top: 12px;
	cursor: pointer;
}

.right div {
	margin-top: 32px;
}
</style>
</html>