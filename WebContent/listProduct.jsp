<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/mindteck.css"/>
<link rel="stylesheet" href="styling.css" type="text/css">
<title>Low Low Prices</title>
</head>
<body>
<div id="header">
            <div class="Logo"><h1><a href="home.jsp">Low Low Prices</a></h1></div>
            <div class="menu">
                <ul><li><a href="home.jsp">Home</a></li></ul>
                <ul><li><a href="aboutUs.jsp">About Us</a></li></ul>
                <ul><li><a href="register.jsp">Sign Up</a></li></ul>
                <ul><li><a href="contactUs.jsp">Contact Us</a></li></ul>
                <ul><li><a href="home.jsp">Shop Online</a></li></ul>
                <ul><li><a href="login.jsp">Login</a></li></ul>
                <ul><li><a href="CartController?action=listCartItem"><img src="Images/cart.png">View Cart</image></a></ul>
                <ul><li class="order"><a href="shipping.jsp" >Order Now</image></a></li></ul>
            </div>
        </div>
<div id="wrapper">
 <h1>Product Management</h1>
    <table border=1 align=center>
        <thead>
            <tr>
                <th>Product Id</th>
                <th>Description</th>
                <th>Price</th>
                <th>Quantity</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><c:out value="${product.id}" /></td>
                    <td><c:out value="${product.description}" /></td>
                    <td><c:out value="${product.price}" /></td>
                    <td><c:out value="${product.quantity}" /></td>
                    <td><a href="ProductController?action=edit&id=<c:out value="${product.id}"/>">Update</a></td>
                    <td><a href="ProductController?action=delete&id=<c:out value="${product.id}"/>" onclick="return confirm('Do you want to delete the user?')">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
 </table>
 <hr>
 <a href="ProductController?action=insert">Add Product</a>
 </div>
</body>
</html>

