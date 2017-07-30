<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/mindteck.css"/>
<title>Mindteck: User Management</title>
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
                <ul><li><a href="CartController?action=listCartItem"><img src="Images/cart.png">View Cart</image></a></ul>
                <ul><li class="order"><a href="shipping.jsp" >Order Now</image></a></li></ul>
            </div>
        </div>
<div id="wrapper">
 <h1>MINDTECK :: USER MANAGEMENT</h1>
    <table border=1 align=center>
        <thead>
            <tr>
                <th>User Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>DOB</th>
                <th>Email</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.userid}" /></td>
                    <td><c:out value="${user.firstName}" /></td>
                    <td><c:out value="${user.lastName}" /></td>
                    <td><fmt:formatDate pattern="dd-MMM-yyyy" value="${user.dob}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><a href="UserController?action=edit&userId=<c:out value="${user.userid}"/>">Update</a></td>
                    <td><a href="UserController?action=delete&userId=<c:out value="${user.userid}"/>" onclick="return confirm('Do you want to delete the user?')">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
 </table>
 <hr>
 <a href="UserController?action=insert">Add User</a>
 </div>
</body>
</html>

