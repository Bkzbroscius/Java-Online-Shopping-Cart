<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
		<div class="clear"></div>
		<div class="frm">
			<h3>Login</h3>
			<span id="msg"></span>
			<form method="post" action="UserController" name="login"
				onsubmit="return validateForm()">
				<p>
					<label for="username">Username</label> <input type="text"
						name="username" placeholder="username" id="username"
						onblur="search(this.value)">
				</p>
				<p>
					<label for="password">Password</label> <input type="password"
						name="pass" placeholder="password" id="pass">
				</p>
				<p>
					<input type="hidden" name="action" id="action" value="login">
				</p>
				<p id="loginpara">
					<input type="submit" value="Login" id="login">
				</p>
			
			</form>
				<p><font color="red"><c:out value="${message}"/> </font></p>
		</div>
		<footer></footer>
		<script type="text/javascript">
			var txt = document.getElementById("username");

			txt.addEventListener("keypress", validateUserName);

			function validateForm() {
				var name = document.login.username.value;
				var pass = document.login.password.value;
				var reg = "/\S+@\S+\.\S+/"
				if (name === "" || pass === "") {
					document.getElementById("msg").innerHTML = "You must enter a username or password.";
					return false;
				} else if (name.length < 6 || pass.length < 6) {
					document.getElementById("msg").innerHTML = "Your username or password must be at least 6 characters long.";
					return false;
				} else if (pass.length < 6) {
					document.getElementById("msg").innerHTML = "Invalid password. Enter 6 or more characters.";
					return false;
				}

				else if (!validateEmail(email)) {
					document.getElementById("msg").innerHTML = "Enter a valid e-mail address";
					return false;
				}

			}

			function validateUserName(event) {
				var ch = event.which;
				if (!((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)
						|| (ch == 32) || (ch == 8))) {
					event.preventDefault();
				}
			} 
			
			
		</script>
</body>
</html>