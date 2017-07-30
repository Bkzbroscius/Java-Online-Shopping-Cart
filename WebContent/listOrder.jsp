<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Low Low Prices</title>
<link rel="stylesheet" href="styling.css" type="text/css">
</head>
<body>
<div id="header">
    <div class="Logo"><h1><a href="home.jsp">Low Low Prices</a></h1></div>
            <div class="menu">
                <ul><li><a href="home.jsp">Home</a></li></ul>
                <ul><li><a href="aboutUs.jsp">About Us</a></li></ul>
                <ul><li><a href="register.jsp">Sign Up</a></li></ul>
                <ul><li><a href="contactUs.jsp">Contact Us</a></li></ul>
                <ul><li><a href="home.jsp">Shop Online</a></li></ul>
                <ul><li><a href="login.jsp">Login</a></li></ul>
                <ul><li><a href="CartController?action=listCartItem"><img src="Images/cart.png">View Cart</image></a></ul>
                <ul><li class="order"><a href="shipping.jsp" >Order Now</image></a></li></ul>
           </div>
     </div>
</div>
<table border=1 align=center>
        <thead>
            <tr>
                <th>Cart Id</th>
                <th>Product Id</th>
                <th>Description</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Order Number</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${li}" var="item">
                <tr>
                    <td><c:out value="${item.orderId}" /></td>
                    <td><c:out value="${item.orderAmount}" /> </td>
                    <td><c:out value="${item.orderDate}" /></td>
                    <td><c:out value="${item.orderNumber}" /></td>
                   
                </tr>
            </c:forEach>
        </tbody>
 </table>
</body>
</html>