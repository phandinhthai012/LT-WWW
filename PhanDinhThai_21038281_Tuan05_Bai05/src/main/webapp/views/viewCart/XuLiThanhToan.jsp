<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Out</title>
</head>
<body>
	<div class="header">
        <h1>BookStrore</h1>
        <div>
            <a href="#" class="menu">Home</a>
            <a href="#" class="menu">Example</a>
            <a href="#" class="menu">Servicer</a>
            <a href="#" class="menu">Prodict</a>
            <a href="#" class="menu">Contact</a>
        </div>
    </div>
    <div class="body">
        <div class="left">
            <h2>ABOUT US</h2>
            <P>About us information will be here ... <a href="">Read More</a></P>
            <form action="" method="get">
                <H3>SEARCH SITE</H3>
                <input type="text" name="search" placeholder="Search for books...">
                <input type="submit" value="Search">
            </form>
            <a href="${pageContext.request.contextPath}/CartController" class="viewcart">View cart(${requestScope.size})</a>
        </div>
        <div class="right">
            <form action="ReceiptController" method="post">
                <h4>CheckOut Already registered</h4>
                <table>
                    <tr>
                        <th>Full name</th>
                        <td><Input type="text" name="fullname"></Input></td>
                    </tr>
                    <tr>
                        <th>Shipping address</th>
                        <td><Input type="text" name="address"></Input></td>
                    </tr>
                    <tr>
                        <th>Total prices</th>
                        <td><Input type="text" name="total" value="${requestScope.total}" readonly></Input>
                        </td>
                    </tr>
                    <tr>
                       <th>Payment method</th>
                        <td>
                            <input type="radio" name="payment" value="Paypal"> Paypal
                            <input type="radio" name="payment" value="ATM Debit"> ATM Debit
                            <input type="radio" name="payment" value="Visa/Master card"> Visa/Master card
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="btns">
                        	<c:set var="listID" value="id: "></c:set>
                            <c:forEach var="item" items="${sessionScope.cart}">
                            	<c:set var="listID" value="${listID}${item.book.id}:"></c:set>
                            </c:forEach>
                            <input type="hidden" name="listID" value="${listID}">
                            <input type="submit" value="Save">
                            <input type="button" value="Cancel">
       
                        </td>
                    </tr>

                </table>
            </form>
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
   table{
    width: 100%;
    border-collapse: collapse;
    border: 1px solid #221f1f;
   }
   tr{
    background-color: #f2f2f2;
   }
    td,th {
    border: 1px solid #ddd;
    padding: 8px;
   }
   th{
    text-align: left;
   }
   .btns {
        padding: 50px 0 0 0;
        text-align: center;
   }
   input{
    padding: 10px 10px;
    margin-bottom: 10px;
   }
   .btns input {
    padding: 10px 20px;
    background-color: #4CAF50;
    color: white;
    border: none;
    cursor: pointer;
   }
   .viewcart{
    border: none;
    cursor: pointer;
   }
</style>
</html>