<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="Login.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://fonts.googleapis.com/css?family=Aladin" rel="stylesheet">
</head>
<body>

<a href="Home.jsp">HOME</a>

<form action="LoginServlet" method="post">
	<div class="login-box">
	<h1>Smart Shop Login</h1>
	<div class="textbox">
	<i class="material-icons">person</i>
			<input type="text" name="uname" required="required" placeholder="Username"  value="">
	</div>
	<div class="textbox">
		<i class="material-icons">lock</i>
		<input type="password" name="pass" required="required" placeholder="Password"  value="">
	</div>

<input class="btn" type="submit" name="Submit" value="Login">
</form>
</div>
</body>
</html>