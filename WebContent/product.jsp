<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styling.css"/>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css"/>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
<title>Low Low Prices :: Product Management :: Add Product</title>
</head>
<body>
<div id="header">
            <div class="Logo"><h1><a href="home.jsp">Low Low Prices</a></h1></div>
            <div id="searchfield">
            <div class="menu">
                <ul><li><a href="home.jsp">Home</a></li></ul>
                <ul><li><a href="aboutUs.jsp">About Us</a></li></ul>
                <ul><li><a href="register.jsp">Sign Up</a></li></ul>
                <ul><li><a href="contactUs.jsp">Contact Us</a></li></ul>
                <ul><li><a href="home.jsp">Shop Online</a></li></ul>
                <ul><li><a href="login.jsp">Login</a></li></ul>
                <ul><li><a href="CartController?action=listCartItem"><img src="Images/cart.png" class="cart">View Cart</image></a></ul>
                
            </div>
        </div>
<div id="wrapper">
<h1>Product Management : Add Product</h1>
<br><br>
<form method="POST" action='ProductController' name="frmAddproduct">
<table style="width:500px">
<tr>
 <td>Product ID : </td>
 <td><input type="text" readonly="readonly" name="id" value="<c:out value="${product.id}" />" /> </td>
</tr>

<tr> 
 <td>Description: </td>
 <td><input type="text" name="description" value="<c:out value="${product.description}" />" /> </td>
</tr>

<tr>  
 <td>Price : </td>
 <td><input type="text" name="price" value="<c:out value="${product.price}" />" /> </td>
</tr>

<tr>
 <td>Quantity : </td>
 <td><input type="text" name="quantity" value="<c:out value="${product.quantity}" />" /> </td>
</tr>
 <td colspan="2" align="center"><input type="submit" value="Submit" ></td>
</tr>
</table> 
</form>
</div>
</body>
</html>


