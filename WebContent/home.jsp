<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Shop Online</title>
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
		
		<!--  <div class="clear"></div>-->
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
				<li><a href="contactUs.jsp">Contact Us</a></li>
			</ul>
			<ul>
				<li><a href="home.jsp">Shop Online</a></li>
			</ul>
			<ul>
				<li><a href="login.jsp">Login</a></li>
			</ul>
			<ul>
				<li><a href="CartController?action=listCartItem"><img
						src="Images/cart.png" class="cart">View Cart</image></a>
			</ul>
			<ul>
				<li><a href="logout.jsp">Logout</a></li>
			</ul>
			<ul>
				<li><a href="OrderController?action=viewOrderHistory"> View Order History</a></li>
			</ul>
		</div>
	</div>

	<div id="clear"></div><br>

	<div style="font-size: 1.25em; text-align: center; color:blue">
		<%
			if (session.getAttribute("loggedIn") == null) {
				out.println("<strong><p>You must login to purchase products</p></strong>");
		%>
		<br><strong>Click <a href="login.jsp"> here </a>to login. or <a href="register.jsp">Sign Up</a><strong><br>
		<%
			} else {
		%><p style="text-align: center"><%=session.getAttribute("loggedIn")%>
		,you have successfully logged in.</p>
	
	<%
		}
	%>
	<c:out value="${msg}" />
	</div>
	<div class="products" style="padding-top:100px">
		<h3 >Featured Products</h3>
		<div class="prods">
			<div class="image" id="image1">
				<a href="fruits.jsp"><img src="apples.jpg" alt="apples"
					class="produce"></a>
				<p>Buy Fruits</p>
			</div>
			<div class="image" id="image2">
				<a href="veggies.jsp"><img src="Images/potatoes.jpg"
					alt="potatoes" class="produce"></a>
				<p>Buy Vegetables</p>
			</div>
		</div>
	</div>
	<footer></footer>
</body>
</html>