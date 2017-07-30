<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Low Low Prices</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=yes">
<link rel="stylesheet" href="styling.css" type="text/css">

</head>
<body>

	<div id="header">
		<div class="Logo">
			<h1>
				<a href="home.jsp">Low Low Prices</a>
			</h1>
		</div>
		<div class="menu">
			<ul>
				<li><a href="home.jsp">Home</a></li>
			</ul>
			<ul>
				<li><a href="aboutUs.jsp">About Us</a></li>
			</ul>
			<ul>
				<li><a href="register.jsp">Sign Up</a></li>
			</ul>
			<ul>
				<li><a href="contactUs">Contact Us</a></li>
			</ul>
			<ul>
				<li><a href="home.jsp">Shop Online</a></li>
			</ul>
			<ul>
				<li><a href="login.jsp">Login</a></li>
			</ul>
		</div>
	</div>
	<div class="clear"></div>

	<c:set var="n" scope="session"><%=java.lang.Math.round(java.lang.Math.random() * 1000)%></c:set>
	<div class="big prods image left">
		<img src="Images/apples.jpg" class="plant">Delicious apples.
		Hand picked from our garden.<br>
		<div class="price">$2.00</div>
		<div class="addItem">
			
		
				<image src="Images/cart.png" alt="Add to cart" class="cart"></image></a>
		</div>
		<div>
			<form action="ProductController" method="get">
				Quantity<input type="number" name="quantity" min=1>
				        <input type="hidden" name="action" value="find">
				        <input type="hidden" name="productId" value="1">
				        <input type="submit" value="Add To Cart">
			</form>
		</div>

	</div>
	<footer></footer>
</body>