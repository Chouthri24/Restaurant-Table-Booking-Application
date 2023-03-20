<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script rel="text/Javascript" src="JavaScriptjs.js"></script>
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>

body {
   position: relative;
   padding: 15px;
   width: 100%;
   height: 700px;
}

body::before {
  content: "";
  position: absolute;
  top: 0; 
  left: 0;
  width: 100%;
  height: 100%;
  z-index: -1;
  opacity: .3; 
  background-image: url(p2.jpg);
}
.button {
	background-color: #FDD023; /* Green */
	border: none;
	border-radius: 5px;
	color: white;
	padding: 7px 28px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	-webkit-transition-duration: 0.4s; /* Safari */
	transition-duration: 0.4s;
}

.button2:hover {
	box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0
		rgba(0, 0, 0, 0.19);
}

h1 {
	font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
		'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
	color: #FDD023;
}

.container {
	width: 100%;
	padding: 10px 10px 10px 10px;
	margin-left: 7px;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.Main.split {
	width: 50%;
	position: fixed;
	top: 0;
	overflow-x: hidden;
	padding-top: 20px;
}

.left {
	left: 0;
	margin-left: 10%;
	float: left;
}

.right {
	right: 0;
	float: left;
	margin-left: 15%;
}

.col-sm-6 {
	margin-top:35px;
	background: rgba(0, 0, 0, 0.8);
	border-radius: 25px;
}

label {
	color: aquamarine;
}

.inputfield {
	width: 170px;
	height: 38px;
}

.navigation {
	border-radius: 25px;
	background: rgba(0, 0, 0, 0.8);
	color: white;
}

.btnback {
	color: rgb(246, 234, 19);
	background: rgba(0, 0, 0, 0.8);
}

.navbar-nav>li>a {
	color: rgb(246, 234, 19);
	padding-left: 20px;
	padding-right: 20px;
}

.nav-display {
	display: block;
	position: -webkit-sticky;
	overflow: hidden;
}
#emaillabel{
    visibility:hidden;
    color:red;
    }
#passlabel{
    visibility:hidden;
    color:red;
    }
    
 .clr{
   		 
   		  background: #FDD023;
   }
nav {
	position: fixed;
}
a:link {

text-decoration: none;

}
.avatar {
  vertical-align: middle;
  width: 50px;
  height: 50px;
  border-radius: 50%;
  }
a:visited {

text-decoration: none;

}

a:hover {

text-decoration: none;

}

a:active {

text-decoration: none;

}
</style>

</head>
<body>
	

<!-- Navbar -->
<div class="w3-top">
 <div class="w3-bar w3-theme-d2 w3-left-align">  
  <a class="w3-bar-item w3-button w3-hide-small w3-hover-white clr">Login</a>
  
   <a href="SignUp.jsp" class="w3-bar-item w3-button"><i class="fa fa-fw fa-user"></i>Sign Up</a>
   <a href="IndexPage.jsp" class="w3-bar-item w3-button w3-right ">Back</a>
 
 </div>
   
</div>
		
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<form action="cuslogin" onsubmit="return validate()" method="post">
					<center>
						<h1 >Login</h1>
						<br>
					</center>
					<div class="container">
						<div class="split left">
						<label for="email_id_signin">Account Type</label><br>
						<select name="User_type" class="inputfield" id="User_type"  style="width:350px; height:45px;">
							
   					 			<option class="inputfield" value="customer" >Customer</option>
    							
   								 <option class="inputfield" value="restaurant">Restaurant</option>
    								<option class="inputfield" value="admin">Admin</option>
  									</select>	
								 <br>
						</div>
						
						<div class="split right"></div>
						<br>
					</div>
					<br>
					<div class="container">
						<div class="split left">
							<label for="email_id_signin">Email ID <label Style="color:red;">*</label></label><br> <input
								class="inputfield" type="text" id="email_id_signin"
								name="email_id_signin" placeholder="Email ID" autocomplete="off" style="width:350px; height:45px;"/> <br>
                                <label id="emaillabel"></label>
						</div>
						<div class="split right"></div>
						<br>
					</div>
					<div class="container">
						
						<div class="split left">
							<label for="password_signin">Password <label Style="color:red;">*</label></label><br> 
							<input
								class="inputfield" type="text" id="password_signin"
								name="password_signin" placeholder="password" autocomplete="off" style="width:350px; height:45px;" /> <br>
                                <label id="passlabel"></label>
							<br>

						</div>
						<br>
						<br>
					</div>
						
      						<% 
      						  String err=(String)session.getAttribute("err");
      						if(err!=null){ %>
      						<div class="container">
           						 <div style="color:red;margin-left: 10%; font-weight: 700;"><%=err %></div>
           						 </div>
          							<% }
      								session.setAttribute("err",null);%>
						
						
					<div class="container">
						<center>
							<button type="Submit" class="button button2" >Submit</button>
						</center>
					</div>
					
				</form>
			</div>
		</div>

	<script>
        $("#email_id_signin").keyup(function() {
                
                email();
                
                });
                
                $("#password_signin").keyup(function() {
                
                password();
                
                });
         var email1 = false;
         var pass1=false;
         function email() {
                
                var uname = $("#email_id_signin").val();
                
                let regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                
                var boolean = regex.test(uname);
                
                if (uname.trim() == "") {
                
                $("#emaillabel").html("Please Enter Valid Email Id");
                
                $("#emaillabel").css("visibility", "visible");
                
                $("#email_id_signin").css("border", "solid 1px red");
                
                email1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#emaillabel").html("Please Enter Valid Email Id");
                
                $("#emaillabel").css("visibility", "visible");
                
                $("#email_id_signin").css("border", "solid 1px red");
                
                email1  = false;
                
                }
                
                else {
                
                $("#emaillabel").css("visibility", "hidden");
                
                $("#email_id_signin").css("border", "solid 1px green");
                
                email1  = true;
                
                }
                
                }
function password() {
                
                var pass = $("#password_signin").val();
                
                let regex =/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,20}$/;
                
                var boolean = regex.test(pass);
                
                if (pass.trim() == "") {
                
                $("#passlabel").html("Please Enter Valid Password");
                
                $("#passlabel").css("visibility", "visible");
                
                $("#password_signin").css("border", "solid 1px red");
                
                pass1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#passlabel").html("Please Enter Valid Password");
                
                $("#passlabel").css("visibility", "visible");
                
                $("#password_signin").css("border", "solid 1px red");
                
                pass1  = false;
                
                }
                
                else {
                
                $("#passlabel").css("visibility", "hidden");
                
                $("#password_signin").css("border", "solid 1px green");
                
                pass1  = true;
                
                }
                
                }

function validate(){
                
                try{
                password();
                email(); 
                }
                
                catch (err) { console.log(err); }
                
                if(email1&&pass1){
                
                return true;
                
                }
                
                else{
                
                return false;
                
                }};

    </script>
</body>


















 --%>


<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Fin Fin</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->

<style>

/* body {
   position: relative;
   padding: 15px;
   width: 100%;
   height: 700px;
}

body::before {
  content: "";
  position: absolute;
  top: 0; 
  left: 0;
  width: 100%;
  height: 100%;
  z-index: -1;
  opacity: .3; 
  background-image: url(p2.jpg);
} */
body{
background-color:grey;

}
.button {
	background-color: #FDD023; /* Green */
	border: none;
	border-radius: 5px;
	color: white;
	padding: 7px 28px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	-webkit-transition-duration: 0.4s; /* Safari */
	transition-duration: 0.4s;
}

.button2:hover {
	box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0
		rgba(0, 0, 0, 0.19);
}

h1 {
	font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
		'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
	color: #FDD023;
}

.container {
	width: 100%;
	padding: 10px 10px 10px 10px;
	margin-left: 7px;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.Main.split {
	width: 50%;
	position: fixed;
	top: 0;
	overflow-x: hidden;
	padding-top: 20px;
}

.left {
	left: 0;
	margin-left: 10%;
	float: left;
}

.right {
	right: 0;
	float: left;
	margin-left: 15%;
}

.col-sm-6 {
	margin-top:35px;
	background: rgba(0, 0, 0, 0.8);
	border-radius: 25px;
}

label {
	color: black;
}

.inputfield {
	width: 170px;
	height: 38px;
	border-radius:7px 7px 7px 7px;
}

.navigation {
	border-radius: 25px;
	background: rgba(0, 0, 0, 0.8);
	color: white;
}

.btnback {
	color: rgb(246, 234, 19);
	background: rgba(0, 0, 0, 0.8);
}

.navbar-nav>li>a {
	color: rgb(246, 234, 19);
	padding-left: 20px;
	padding-right: 20px;
}

.nav-display {
	display: block;
	position: -webkit-sticky;
	overflow: hidden;
}
#emaillabel{
    visibility:hidden;
    color:red;
    }
#passlabel{
    visibility:hidden;
    color:red;
    }
    
 .clr{
   		 
   		  background: #FDD023;
   }
nav {
	position: fixed;
}
a:link {

text-decoration: none;

}
.avatar {
  vertical-align: middle;
  width: 50px;
  height: 50px;
  border-radius: 50%;
  }
a:visited {

text-decoration: none;

}

a:hover {

text-decoration: none;

}

a:active {

text-decoration: none;

}
</style>
  <!-- Google Fonts -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Amatic+SC:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Inter:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/main.css" rel="stylesheet">
<style>
.header {
    background: black;
    transition: all 0.5s;
    z-index: 997;
    height: 50px;
    color: #FDD023;
    border-bottom: 1px solid #fff;
}
@media (min-width: 1280px)
.navbar a, .navbar a:focus {
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0px;
    font-family: var(--font-secondary);
    font-size: 16px;
    font-weight: 600;
    color: yellow;
    white-space: nowrap;
    transition: 0.3s;
    position: relative;
}

</style>


  <!-- =======================================================
  * Template Name: Yummy - v1.3.0
  * Template URL: https://bootstrapmade.com/yummy-bootstrap-restaurant-website-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top d-flex align-items-center">
    <div  class="container d-flex align-items-center justify-content-between">

      <a href="index.html" class="logo d-flex align-items-center me-auto me-lg-0">
        <!-- Uncomment the line below if you also wish to use an image logo -->
        <!-- <img src="assets/img/logo.png" alt=""> -->
        <h1 style="color:#FDD023;">Restaurant<span>.</span></h1>
      </a>

      <nav id="navbar" class="navbar" style="height:80px;" >
        <ul>
          <li><a href="#hero">Home</a></li>
          <li><a href="#about">About</a></li>
       	<li><a href="#">View Restaurants</a></li>
          <li><a href="#contact">Contact</a></li>
        </ul>
      </nav><!-- .navbar -->

<div>
     <a class="btn btn-warning btn-sm" style="align-items:right;"href="SignIn.jsp">Sign In</a>
      <a class="btn btn-warning btn-sm" href="SignUp.jsp">Sign Up</a>
      </div>
     <!-- .navbar -->
     
      <i class="mobile-nav-toggle mobile-nav-show bi bi-list"></i>
      <i class="mobile-nav-toggle mobile-nav-hide d-none bi bi-x"></i>

    </div>
  </header><!-- End Header -->

  <main id="main">

    
  <!-- ======= Hero Section ======= -->
  </div>
		<div class="row" style="margin-top:5%;">
			<div class="col-sm-7">
			<img src="OIP.jpeg " width=700 height=500 style="lef">
			
			</div>
			<div class="col-sm-4">
				<form action="cuslogin" onsubmit="return validate()" method="post">
					<center>
						<h1 >Login</h1>
						<br>
					</center>
					<div class="container">
						<div class="split left">
						<label for="email_id_signin">User Type</label><br>
						<select name="User_type" class="inputfield" id="User_type"  style="width:350px; height:35px;">
							
   					 			<option class="inputfield" value="customer" >Customer</option>
    							
   								 <option class="inputfield" value="restaurant">Restaurant</option>
    								<option class="inputfield" value="admin">Admin</option>
  									</select>	
								 <br>
						</div>
						
						<div class="split right"></div>
						<br>
					</div>
					<br>
					<br>
					<div class="container">
						<div class="split left">
							<label for="email_id_signin">Email ID <label Style="color:red;">*</label></label><br> <input
								class="inputfield" type="text" id="email_id_signin"
								name="email_id_signin" placeholder="Email ID" autocomplete="off" style="width:350px; height:35px;"/> <br>
                                <label id="emaillabel"></label>
						</div>
						<div class="split right"></div>
						<br>
					</div>
					<div class="container">
						
						<div class="split left">
							<label for="password_signin">Password <label Style="color:red;">*</label></label><br> 
							<input
								class="inputfield" type="text" id="password_signin"
								name="password_signin" placeholder="password" autocomplete="off" style="width:350px; height:35px;" /> <br>
                                <label id="passlabel"></label>
							<br>

						</div>
						<br>
						<br>
					</div>
						
      						<% 
      						  String err=(String)session.getAttribute("err");
      						if(err!=null){ %>
      						<div class="container">
           						 <div style="color:red;margin-left: 10%; font-weight: 700;"><%=err %></div>
           						 </div>
          							<% }
      								session.setAttribute("err",null);%>
						
						
					<div class="container">
						<center>
							<button type="Submit" class="button button2" >Submit</button>
						</center>
					</div>
					
				</form>
			</div>
		</div>

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
 

  <a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <div id="preloader"></div>
  <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script rel="text/Javascript" src="JavaScriptjs.js"></script>
<script>
        $("#email_id_signin").keyup(function() {
                
                email();
                
                });
                
                $("#password_signin").keyup(function() {
                
                password();
                
                });
         var email1 = false;
         var pass1=false;
         function email() {
                
                var uname = $("#email_id_signin").val();
                
                let regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                
                var boolean = regex.test(uname);
                
                if (uname.trim() == "") {
                
                $("#emaillabel").html("Please Enter Valid Email Id");
                
                $("#emaillabel").css("visibility", "visible");
                
                $("#email_id_signin").css("border", "solid 1px red");
                
                email1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#emaillabel").html("Please Enter Valid Email Id");
                
                $("#emaillabel").css("visibility", "visible");
                
                $("#email_id_signin").css("border", "solid 1px red");
                
                email1  = false;
                
                }
                
                else {
                
                $("#emaillabel").css("visibility", "hidden");
                
                $("#email_id_signin").css("border", "solid 1px green");
                
                email1  = true;
                
                }
                
                }
function password() {
                
                var pass = $("#password_signin").val();
                
                let regex =/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,20}$/;
                
                var boolean = regex.test(pass);
                
                if (pass.trim() == "") {
                
                $("#passlabel").html("Please Enter Valid Password");
                
                $("#passlabel").css("visibility", "visible");
                
                $("#password_signin").css("border", "solid 1px red");
                
                pass1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#passlabel").html("Please Enter Valid Password");
                
                $("#passlabel").css("visibility", "visible");
                
                $("#password_signin").css("border", "solid 1px red");
                
                pass1  = false;
                
                }
                
                else {
                
                $("#passlabel").css("visibility", "hidden");
                
                $("#password_signin").css("border", "solid 1px green");
                
                pass1  = true;
                
                }
                
                }

function validate(){
                
                try{
                password();
                email(); 
                }
                
                catch (err) { console.log(err); }
                
                if(email1&&pass1){
                
                return true;
                
                }
                
                else{
                
                return false;
                
                }};

    </script>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

	</body>

</html>