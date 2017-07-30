<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Low Low Prices</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes">
        <link rel="stylesheet" href="styling.css" type="text/css">
    </head>
    <body>
       <div>
        <div id="header">
            <div class="Logo"><h1><a href="home.jsp">Low Low Prices</a></h1></div>
            <div class="menu">
                <ul><li><a href="home.jsp">Home</a></li></ul>
                <ul><li><a href="aboutUs.jsp">About Us</a></li></ul>
                <ul><li><a href="register.jsp">Sign Up</a></li></ul>
                <ul><li><a href="contactUs.jsp">Contact Us</a></li></ul>
                <ul><li><a href="home.jsp">Shop Online</a></li></ul>
                <ul><li><a href="Login.jsp">Login</a></li></ul>
            </div>
        </div>
        <div id="clear"></div>
        <div id="shipping">
        <% if (session.getAttribute("loggedIn") == null) {
        	  out.println("You must login to purchase products"); 
         %> Click <a href="login.jsp">here </a>to login.
        <% } %>
        <h3>Enter Billing Information</h3>
            <form action="OrderController" id="billingForm" method="post">
                <label for="firstname">First Name</label><br>
                <input type="text" id="firstname"><br>
                <label for="lastname">Last Name</label><br>
                <input type="text" id="name"><br>
                <label for="address1">Address Line1</label><br>
                <input type="text" id="address1"><br>
                <label for="address2">Address Line2</label><br>
                <input type="text" id="address2"><br>
                <label for="city">City</label><br>
                <input type="text" id="city"><br>
                <label for="state">State</label><br>
                <input type="text" id="state"><br>
                <label for="zip">Zip Code</label><br>
                <input type="text" id="zip"><br><br>
                Shipping Method<br>
                <label>
                <input type="radio" name="method" value="regular" checked>regular</label>$4.00
                <labeL><input type="radio" name="method" value="express">express</labeL>$20.00<br><br>
                Payment Method<br><br>
                Credit Card<br>
                <select name="type"> 		Type
                <option value="visa">visa</option>
                <option value="mastercard">mastercard</option>
                </select><br><br>
                <input type="text" value="number">Number<br>
                <input type="text" value="exp">Expiration Date<br>
                <input type="submit" value="submit" id="submitbut"><br><br>
                <input type="hidden" value="checkout" name="action">
            </form>
        </div>
        <footer></footer>
    </body>
</html>