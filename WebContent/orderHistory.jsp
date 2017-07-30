<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<ul>
				<li><a href="OrderController?action=viewOrderHistory"> View Order History</a></li>
			</ul>
		</div>
	</div>
	</div>
	<div class="tformat" style="font-size: 1.5em; color: purple">
		<h1 style="text-align: center">View Your Order History</h1>
		<table border="0" align=center width="80%">
			<thead>
				<tr>
					<th align="center">Order Number</th>
					<th align="center">Order Amount</th>
					<th align="center">Order Date</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${orderList}" var="item">
					<tr>
						<td align="center"><c:out value="${item.orderNumber}" /></td>
						<!--<td><c:out value="${item.orderAmount}" /></td>-->
						<td align="center"><fmt:formatNumber value="${item.orderAmount}" type="currency" /></td>
						<td align="center"><c:out value="${item.orderDate}" /></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>