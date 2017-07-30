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
       <div><%  
               if (session.getAttribute("loggedIn").equals(null)) {
            	   out.println("You must log in to place an order");
            	   response.sendRedirect("login.jsp");
               }
    	   			%> </div>
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
        <h3>Enter Shipping Details</h3>
            <form id="shippingForm" method="post">
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
                <input type="text" id="zip"><br>
                <input type="submit" value="submit" id="submitbut">
            </form>
        </div>
        <footer></footer>
    </body>
</html>