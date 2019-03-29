<!DOCTYPE HTML>
<html>
<head>
	<title>Registration Form</title>
	<link rel="stylesheet" type="text/css" href="Register.css">
	<link href="https://fonts.googleapis.com/css?family=Aladin" rel="stylesheet">
	
	 <script> 
function validate(form)
{ 
 password=form.password.value;
 CnfPs=form.CnfPs.value;
 First_Name=form.First_Name.value;
 Last_Name=form.Last_Name.value;
 Age=form.Age.value;
 MobileNumber=form.MobileNumber.value;
 Email=form.Email.value;
 
 if(First_Name=='')
 {
 alert("Please enter First_Name");
 }
 else if(Last_Name=='')
 {
 alert("Please enter Last_Name");
 }
 else if(Age=='')
 {
 alert("Please enter Age");
 }
 else if(Email=='')
 {
 alert("Please enter Email");
 }
 else if(MobileNumber=='')
	 {
	 alert("Please enter MobileNumber");
	 }
 else if(password=='')
 {
alert("please enter valid password");
 }
 else if(CnfPs=='')
		 {
	 alert("please confirm password");
		 }
 else if(password!=CnfPs)
	 {
	 alert("password did not match");
 return false;
	 }
 
 } 
</script> 

</head>
	<body> 
	<a href="Home.jsp">HOME</a>
	
	   <div class="d-flex justify-content-center">

<h5 class="text-centre" style="text-align:centre; background-color: black;color: white">${info}</h5>
</div>
		<h1>Registration Form</h1>
		<div class="register">
		<form onSubmit="return validate(this)" method="post" id="register" action="RegisterServlet">
		<h2>Register Here</h2>
		<label> First Name :</label><br><br>
		<input type="hidden" value=<%=request.getParameter("userType")%> name="userType"/>
		<input type="text" required="required" name="First_Name" id="name" placeholder="Enter Your First Name"><br><br>
		<label> Last Name :</label><br><br>
		<input type="text" required="required" name="Last_Name" id="name" placeholder="Enter Your Last Name"><br><br>
		<label>Age :</label><br><br>
		<input type="number" required="required" name="Age" id="age"placeholder="Enter your age"><br><br>
		<label> Mobile Number :</label><br><br>
		<select id="ph">
			<option>+91</option>
			<option>+92</option>
			<option>+93</option>
			<option>+94</option>
			<option>+95</option>
		</select>
		<input type="number" name="MobileNumber" id="num"placeholder="Enter your Mobile Number"><br><br>
		<label>Gender :</label>
		<input type="radio" name="male" id="male"><span id="male">Male</span>
		<input type="radio" name="male" id="male"><span id="male">Female</span>
		<input type="radio" name="male" id="male"><span id="male">Other</span><br><br>
		<label> Email: </label><br><br>
		<input type="email" required="required" name="Email" id="name"placeholder="Enter Your Email"><br><br>
		<label> Password: </label><br><br>
		<input type="password" required name="password" id="name"placeholder="Enter Your Password"><br><br>
		<label> Re-enter Your Password: </label><br><br>
		<input type="password" required name="CnfPs" id="name"placeholder="Confirm Your Password"><br><br>

		<input type="submit" value="Submit" id="sub">
	
		</div>	
	</body>
</html>