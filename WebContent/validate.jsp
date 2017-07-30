<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Login</title>
<style>
  #usern {
        margin-top: 20px;
        margin-bottom: 20px;
   }
  #sub {
      margin-top: 20px; 
      background-color: #DF01D7;
      color: white;
      width: 60px;
      height: 40px;
  }
  p {
     padding-top: 30px;
     text-align: center;
     font-size: 2em;
  }
  body {
      background-color: #2EFEF7;
  }
  div {
     text-align: center;
  }
  
  #msg {
     text-align: center;
     color: red;
     
  }
  
  input {
       margin: 5px;
  }
</style>
</head>
<body>
<p>Welcome to my shop! Enter your details to sign in.</p>
<div>
<span id="msg"></span>
<form action="GetLoginInfo.jsp" method="post" name="login" onsubmit="return validateForm()">
<strong>Enter your username:</strong> <input id="username" type="text" name="username"><br>
<strong>Enter your password:</strong> <input id="password" type="password" name="password"><br>
<strong>Enter your e-mail:	</strong> <input id="email" type="text" name="email">
<br>
<input type="submit" id="sub" value="Login">
</form>
</div>
<script type="text/javascript">
var txt=document.getElementById("username");

txt.addEventListener("keypress", validateUserName);

function validateForm() {
	var name=document.login.username.value;  
	var pass=document.login.password.value; 
	var email=document.login.email.value;
	var reg = "/\S+@\S+\.\S+/"
	if (name === "" || pass === "") {
		 document.getElementById("msg").innerHTML = "You must enter a username or password.";
		 return false;
	}
	else if (name.length < 6 || pass.length < 6) {
		  document.getElementById("msg").innerHTML = "Your username or password must be at least 6 characters long.";
	      return false;
	}
	else if (email === "") {
		document.getElementById("msg").innerHTML = "You must enter an email address.";
		return false;
	}
	else if (pass.length < 6) {
		  document.getElementById("msg").innerHTML = "Invalid password. Enter 6 or more characters.";
		  return false;
	}

	else if (!validateEmail(email)) {
			document.getElementById("msg").innerHTML = "Enter a valid e-mail address";
			return false;
	} 
	
}

function validateEmail(em) 
{ 
    var re = /\S+@\S+\.\S+/;
    return re.test(em);
}

function validateUserName(event)
{
	var ch=event.which; 
    if(!((ch >=65 && ch <=90) || (ch >=97 && ch<=122) || (ch == 32) || (ch == 8)))
	{  
   		event.preventDefault();
	}
}
</script>
</body>
</html>