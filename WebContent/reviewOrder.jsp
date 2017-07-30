<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Shop OncartItemne</title>
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
				<li class="order"><a href="OrderController?action=orderNow">Order
						Now</a></li>
			</ul>
			<ul>
				<li><a href="logout.jsp">Logout</a></li>
			</ul>
			<ul>
				<li><a href="OrderController?action=viewOrderHistory"> View
						Order History</a></li>
			</ul>
		</div>
	</div>

	<div id="clear"></div>
	<div style="padding-top: 50px; color: purple; font-size: 1.5em;">
		<table border="1" align=center>
			<thead>
				<tr>

					<th align="center">Description</th>
					<th align="center">Price</th>
					<th align="center">Quantity</th>


				</tr>
			</thead>
			<tbody>
				<c:set var="total" value="0.0" />
				<c:forEach items="${li}" var="cartItem">

					<tr>

						<td align="center"><c:out value="${cartItem.description}" /></td>
						<td align="center"><fmt:formatNumber
								value="${cartItem.price}" type="currency" /></td>
						<td align="center"><c:out value="${cartItem.quantity}" /></td>

						<c:set var="total" value="${total + (cartItem.price * cartItem.quantity)}" />
						<td><a
							href="CartController?action=delete&id=<c:out value="${cartItem.cartId}"/>"
							onclick="return confirm('Do you want to delete the user?')">Delete</a></td>

					</tr>
				</c:forEach>
				<tr>
					<th align="center">Shipping Amount</th>
					<th align="center">Total Price</th>
				</tr>
				<tr>
					<td align="center"><fmt:formatNumber value="${shippingAmount}"
							type="currency" />
					<td align="center"><fmt:formatNumber
							value="${total + shippingAmount}" type="currency" /></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div style="text-align: center; font-size: 1.5em; padding-top: 100px;">
		<a href="OrderController?action=confirmOrder">Confirm Order</a>
	</div>
</body>
</html>