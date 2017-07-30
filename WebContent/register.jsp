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
	<div class="clear"></div>
	<div class="frm">
		<h3>Sign Up</h3>
		<span id="msg"></span>
		<form onsubmit="return validateForm()" name="reg" action="UserController" method="post">
			<p>
				<label for="firstname">Firstname</label><br> <input type="text"
					name="firstName" placeholder="firstname" id="firstName">
			</p>
			<p>
				<label for="lastname">Lastname</label><br> <input type="text"
					name="lastName" placeholder="Lastname" id="lastName">
			</p>
			<p>
				<label for="username">Username</label><br> 
				<input type="text" name="username" placeholder="username" id="username">
			</p>
			<p>
				<label for="password">Password</label><br> <input
					type="password" name="pass" placeholder="password"
					id="pass">
			</p>
			<p>
				<label for="email">Email Address</label><br> <input type="text"
					name="email" placeholder="email" id="email">
			</p>
			<p>
				<input type="hidden" name="action" id="action" value="register">
			</p>
			<p>
				<input type="submit" value="sign up" id="Sign Up">
			</p>
		</form>
		<p style="color: red"><c:out value="${message}" />
	</div>

	<script type="text/javascript">
		var fname = document.getElementById("firstName");
		fname.addEventListener("keypress", validateName);
		var lname = document.getElementById("lastName");
		lname.addEventListener("keypress", validateName);
		var username = document.getElementById("username");
		username.addEventListener("keypress", validateName);

		function validateForm() {
			var name = document.reg.username.value;
			var pass = document.reg.pass.value;
			var email = document.reg.email.value;
			var reg = "/\S+@\S+\.\S+/"
			if (name === "" || pass === "") {
				document.getElementById("msg").innerHTML = "You must enter a username or password.";
				return false;
			} else if (name.length < 5 || pass.length < 5) {
				document.getElementById("msg").innerHTML = "Your username or password must be at least 5 characters long.";
				return false;
			} else if (email === "") {
				document.getElementById("msg").innerHTML = "You must enter an email address.";
				return false;
			} else if (pass.length < 5) {
				document.getElementById("msg").innerHTML = "Invalid password. Enter 5 or more characters.";
				return false;
			}

			else if (!validateEmail(email)) {
				document.getElementById("msg").innerHTML = "Enter a valid e-mail address";
				return false;
			}

		}

		function validateEmail(em) {
			var re = /\S+@\S+\.\S+/;
			return re.test(em);
		}

		function validateName(event) {
			var ch = event.which;
			if (!((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)
					|| (ch == 32) || (ch == 8))) {
				event.preventDefault();
			}
		}
	</script>
		
</body>
</html>