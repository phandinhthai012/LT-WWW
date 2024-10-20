<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Detail</title>
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
			<form action="" method="get">
				<H3>SEARCH SITE</H3>
				<input type="text" name="search" placeholder="Search for books...">
				<input type="submit" value="Search">
			</form>
			<br>
            <a href="${pageContext.request.contextPath}/CartController">View Cart</a>
		</div>
		<div class="right">
			<c:set var="book" value="${book}" />
			<div class="item">
				<h3>Product detail: ${book.name}-tác giả:${book.author}</h3>
				<img
					src="${pageContext.request.contextPath}/resources/images/${book.image}"
					alt="" class="imghi">
				<p>Price(VNĐ):${book.price}</p>
				<p>Quantity:${book.quantity}</p>
				<p>Des:${book.description}</p>
                <a href="${pageContext.request.contextPath}/CartController?action=add&id=${book.id}">Add to cart</a>
				<h4>
				<a href="${pageContext.request.contextPath}/BookController">Back
					To Product list</a>
				</h4>
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

.item {
	padding: 10px;
	display: inline-block;
	float: left;
	margin: 10px;
	color: #817d7d;
}

.imghi {
	width: 250px;
	height: 220px;
}
</style>
</html>