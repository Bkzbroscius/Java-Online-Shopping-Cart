<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		</div>
	</div>

	<div id="clear"></div>

	<%
		if (session.getAttribute("loggedIn") != null) {
			session.removeAttribute("loggedIn");
		
	%>
	<div style="padding-top: 5%; text-align: center">
		<h3 style="font-size: 2em;">You have logged Out.</h3>
		<br> Click <a href="login.jsp" style="font-size: 1.5em"> here
		</a> to login and continue shopping.
	</div>
	<% } else { %>
	<br><br>
	<div style="text-align: center; font-size: 1.5em;"><p>You are currently not signed in.</p></p></div>
	<%} %>
</body>
</html>