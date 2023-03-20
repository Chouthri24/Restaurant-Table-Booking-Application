<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- <!DOCTYPE html>
<html lang="en">
<head>
  <title>SignUp</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script rel="text/Javascript" src="JavaScriptjs.js"></script>
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 
  <style>
    
    #deptlabel{
    visibility:hidden;
    color:red;
    }
    #genderlabel{
    visibility:hidden;
    color:red;
    }
    #namelabel{
    visibility:hidden;
    color:red;
    }
    #addlabel{
    visibility:hidden;
    color:red;
    }
    #passlabel{
    visibility:hidden;
    color:red;
    }

    #loclabel{
    visibility:hidden;
    color:red;
    }

    #conpasslabel{
    visibility:hidden;
    color:red;
    }

    #phlabel{
    visibility:hidden;
    color:red;
    }
    #agelabel{
    visibility:hidden;
    color:red;
    }
    #emaillabel{
    visibility:hidden;
    color:red;
    }
    #doblabel{
    visibility:hidden;
    color:red;
    }
    body{
        background-image: url(p2.jpg);
        min-height: 500px;
        background-attachment: fixed;
        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
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
            box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
            }
        
        h1{
            font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
            color: #FDD023;
           
        }
        .container{
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
                margin-left: 5%;
                float: left;
                }
                .right {
                right: 0;
                float: left;
               margin-left: 15%;
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
                .col-sm-6{
                margin-top:35px;
                    background: rgba(0, 0, 0, 0.8);
                    border-radius: 25px;
                }
                label{
                    color: aquamarine;
                }
                .inputfield{
                    width: 190px;
                    height: 38px;
                }
                .navigation{
                border-radius: 25px;
                background: rgba(0, 0, 0, 0.8);
                color: white;
                }
                .btnback{
                    color: rgb(246, 234, 19);
                    background: rgba(0, 0, 0, 0.8);
                }
                .navbar-nav>li>a{
    color: rgb(246, 234, 19);
    padding-left: 20px;
    padding-right: 20px;
   }
   .clr{
   		 
   		  background: #FDD023;
   }
.nav-display{
      display: block;
  position: -webkit-sticky;
  overflow: hidden;
  color: #f2f2f2;
  text-decoration: none;
    }
    nav
    {
        position: fixed;
    }
  </style>

  </head>
  <body>
  

<div class="w3-top">
 <div class="w3-bar w3-theme-d2 w3-left-align">  
  <a class="w3-bar-item w3-button w3-hide-small w3-hover-white clr">Sign Up</a>
  
   <a href="SignIn.jsp" class="w3-bar-item w3-button"><i class="fa fa-fw fa-user"></i>Login</a>
   <a href="index1.jsp" class="w3-bar-item w3-button w3-right ">Back</a>
 
 </div>
   
</div>
		
  
 
    <div >
        <div class="col-sm-6">
            
        </div>
        <div class="col-sm-6">
            <form action="cus_signup" method="post" onsubmit="return validate()">
                <center><h1>Sign Up</h1><br></center>
                
                <div class="container">
                    <div class="split left">
                        <label for="fname">Name <label Style="color:red;">*</label></label><br>
                    <input class="inputfield" type="text" id="fname" name="fname" placeholder="First Name"  autocomplete="off" style="width:220px; height:45px;"/><br>
                    <label id="namelabel"></label>
                    <br>
                    </div>
                    <div class="split right">
                        <label for="email_id_signup">Email ID <label Style="color:red;">*</label></label><br>
                        <input class="inputfield" type="text" id="email_id_signup" name="email_id_signup" placeholder="Email id" autocomplete="off"  style="width:220px; height:45px;"/><br>
                        <label id="emaillabel"></label>
                        <br>
                    </div>
                    <br>
                </div>
                <div class="container">
                    <br>
                    <div class="split left">
                        <label for="password_signup">Password <label Style="color:red;">*</label></label><br>
                    <input class="inputfield" type="text" id="password_signup" name="password_signup" placeholder="password" autocomplete="off" style="width:220px; height:45px;"/><br>
                    <label id="passlabel"></label>
                    <br><br>
                    </div>
                    <div class="split right">
                        <label for="conpassword">Confirm Password <label Style="color:red;">*</label></label><br>
                    <input class="inputfield" type="text" id="conpassword" name="conpassword" placeholder="confirm password"autocomplete="off" style="width:220px; height:45px;"/><br>
                    <label id="conpasslabel"></label>
                    <br><br>
                    </div>
                    <br>
                </div>
                <div class="container">
                    <div class="split left">
                    <label>Gender:</label>
                <input  type="radio" id="male" name="gender" value="Male" checked/>
                <label for="male">Male</label>
                <input type="radio" id="female" name="gender" value="Female">
                <label for="female">Female</label>
                <input type="radio" id="other" name="gender" value="Other">
                <label for="other">Other</label><br>
                </div></div>
                <div class="container">
                    <div class="split left">
                        <label for="contactno">Contact No <label Style="color:red;">*</label></label><br>
                        <input class="inputfield"type="text" id="contactno" name="contactno" placeholder="contactno" autocomplete="off" style="width:220px; height:45px;"/><br>
                        <label id="phlabel"></label>
                        <br><br>
                    </div>
                    <div class="split right">
                        <label for="age">Age <label Style="color:red;">*</label></label><br>
                        <input class="inputfield" type="text" id="age" name="age" placeholder="Age"  autocomplete="off" style="width:220px; height:45px;"/><br>
                        <label id="agelabel"></label>
                    </div>
                </div>
                <div class="container">
                    <div class="split left">
                    <p><label for="location">Location <label Style="color:red;">*</label></label></p>
                    <input class="inputfield" type="text" id="location" name="location" placeholder="Location"  autocomplete="off" style="width:220px; height:45px;"/><br>
                    <label id="loclabel"></label>
           		</div>
           		
           		 <div class="split right">
                       <p> <label for="address">Address <label Style="color:red;">*</label></label></p>
                        <input class="inputfield" type="text" id="address" name="address" placeholder="Address" autocomplete="off" style="width:220px; height:45px;"/><br>
                        <label id="addlabel"></label>
                    </div>
                </div>
                <div class="container">
                    <center> <button type="Submit" class="button button2" value="submit" >Submit</button></center>
                </div>
                </div>
                <div class="container">
						<centers>
							<%= response.getStatus() %>
						</center>
					</div>
                  </form>
                </div>
                
                <script>
                  
                    var name1=false;
                    var pass1=false;
                    var pass2=false;
                    var ph1=false;
                    var age1=false;
                    var email1 = false;
                    var loc1=false;
                    var add1=false;
                   
                   
                $("#fname").keyup(function() {
                
                name();
                
                });
                $("#location").keyup(function() {
                
                locationcheck();
                
                });
                $("#address").keyup(function() {
                
                addresscheck();
                
                });

              
                $("#contactno").keyup(function() {
                
                phno();
                
                });

                $("#age").keyup(function() {
                
                age();
                
                });
                $("#email_id_signup").keyup(function() {
                
                email();
                
                });
                
                $("#password_signup").keyup(function() {
                
                password();
                
                });
                
                $("#conpassword").keyup(function() {
                
                conpassword();
                
                });
                
                
                function name() {
                
                var uname = $("#fname").val();
                
                let regex = /^[-_ A-Za-z]{3,20}$/;
                
                var boolean = regex.test(uname);
                
                if (uname.trim() == "") {
                
                $("#namelabel").html("Please Enter Name");
                
                $("#namelabel").css("visibility", "visible");
                
                $("#fname").css("border", "solid 1px red");
                
                name1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#namelabel").html("Please Enter Valid Name");
                
                $("#namelabel").css("visibility", "visible");
                
                $("#fname").css("border", "solid 1px red");
                
                name1  = false;
                
                }
                
                else {
                
                $("#namelabel").css("visibility", "hidden");
                
                $("#fname").css("border", "solid 1px green");
                
                name1  = true;
                
                }
                
                }



                function locationcheck() {
                
                var uname = $("#location").val();
                
                let regex = /^[-_ A-Za-z]{3,20}$/;
                
                var boolean = regex.test(uname);
                
                if (uname.trim() == "") {
                
                $("#loclabel").html("Please Enter Location");
                
                $("#loclabel").css("visibility", "visible");
                
                $("#location").css("border", "solid 1px red");
                
                loc1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#loclabel").html("Please Enter Valid Location");
                
                $("#loclabel").css("visibility", "visible");
                
                $("#location").css("border", "solid 1px red");
                
                loc1  = false;
                
                }
                
                else {
                
                $("#loclabel").css("visibility", "hidden");
                
                $("#location").css("border", "solid 1px green");
                
                loc1  = true;
                
                }
                
                }



                function addresscheck() {
                
                var uname = $("#address").val();
                
                let regex =  /^[-_ 0-9 A-Za-z ,.]{3,50}$/;
                
                var boolean = regex.test(uname);
                
                if (uname.trim() == "") {
                
                $("#addlabel").html("Please Enter Address");
                
                $("#addlabel").css("visibility", "visible");
                
                $("#address").css("border", "solid 1px red");
                
                add1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#addlabel").html("Please Enter Valid Address");
                
                $("#addlabel").css("visibility", "visible");
                
                $("#address").css("border", "solid 1px red");
                
                add1  = false;
                
                }
                
                else {
                
                $("#addlabel").css("visibility", "hidden");
                
                $("#address").css("border", "solid 1px green");
                
                add1  = true;
                
                }
                
                }

                function phno() {
                
                var uname = $("#contactno").val();
                
                let regex = /^[0-9]{10}$/;
                
                var boolean = regex.test(uname);
                
                if (uname.trim() == "") {
                
                $("#phlabel").html("Please Enter Contact No");
                
                $("#phlabel").css("visibility", "visible");
                
                $("#contactno").css("border", "solid 1px red");
                
                phno1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#phlabel").html("Please Enter Valid Contact No");
                
                $("#phlabel").css("visibility", "visible");
                
                $("#contactno").css("border", "solid 1px red");
                
                phno1  = false;
                
                }
                
                else {
                
                $("#phlabel").css("visibility", "hidden");
                
                $("#contactno").css("border", "solid 1px green");
                
                phno1  = true;
                
                }
                
                }


                function age() {
                
                var uage = $("#age").val();
                
                let regex = /^[0-9]{1,3}$/;
                
                var boolean = regex.test(uage);
                
                if (uage.trim() == "") {
                
                $("#agelabel").html("Please Enter Age");
                
                $("#agelabel").css("visibility", "visible");
                
                $("#age").css("border", "solid 1px red");
                
                age1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#agelabel").html("Please Enter Valid Age");
                
                $("#agelabel").css("visibility", "visible");
                
                $("#age").css("border", "solid 1px red");
                
                age1  = false;
                
                }
                
                else {
                
                $("#agelabel").css("visibility", "hidden");
                
                $("#age").css("border", "solid 1px green");
                
                age1  = true;
                
                }
                
                }



                function email() {
                
                var uname = $("#email_id_signup").val();
                
                let regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                
                var boolean = regex.test(uname);
                
                if (uname.trim() == "") {
                
                $("#emaillabel").html("Please Enter Email ID");
                
                $("#emaillabel").css("visibility", "visible");
                
                $("#email_id_signup").css("border", "solid 1px red");
                
                email1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#emaillabel").html("Please Enter Valid Email ID");
                
                $("#emaillabel").css("visibility", "visible");
                
                $("#email_id_signup").css("border", "solid 1px red");
                
                email1  = false;
                
                }
                
                else {
                
                $("#emaillabel").css("visibility", "hidden");
                
                $("#email_id_signup").css("border", "solid 1px green");
                
                email1  = true;
                
                }
                
                }





                function password() {
                
                var pass = $("#password_signup").val();
                
                let regex =/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,20}$/;
                
                var boolean = regex.test(pass);
                
                if (pass.trim() == "") {
                
                $("#passlabel").html("Please Enter Password");
                
                $("#passlabel").css("visibility", "visible");
                
                $("#password_signup").css("border", "solid 1px red");
                
                pass1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#passlabel").html("Please Enter Valid Password");
                
                $("#passlabel").css("visibility", "visible");
                
                $("#password_signup").css("border", "solid 1px red");
                
                pass1  = false;
                
                }
                
                else {
                
                $("#passlabel").css("visibility", "hidden");
                
                $("#password_signup").css("border", "solid 1px green");
                
                pass1  = true;
                
                }
                
                }






                function conpassword() {
                
                var conpass = $("#conpassword").val();
                
                let regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,20}$/
                
                var boolean = regex.test(conpass);
                
                if (conpass.trim() == "") {
                
                $("#conpasslabel").html("Please Enter Password");
                
                $("#conpasslabel").css("visibility", "visible");
                
                $("#conpassword").css("border", "solid 1px red");
                
                pass2  = false;
                
                }
                
                else if (!boolean) {
                
                $("#conpasslabel").html("Please Enter Valid Password");
                
                $("#conpasslabel").css("visibility", "visible");
                
                $("#conpassword").css("border", "solid 1px red");
                
                pass2  = false;
                
                }
                
                else {
                
                $("#conpasslabel").css("visibility", "hidden");
                
                $("#conpassword").css("border", "solid 1px green");
                
                pass2  = true;
                
                }
                
                }






                
                function validate(){
                
                try{
                
                name();
                password();
                conpassword();
                phno();
                email();
                locationcheck();
                age();
                addresscheck();
                
                }
                catch (err) { console.log(err); }
                
                if(name1&&email1&&phno1&& pass1&&pass2&&age1 && loc1 && add1){
                
                return true;
                
                }
                
                else{
                
                return false;
                
                }};
                      </script>  
       
  </body>  -->
  
  

  <!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Restaurant</title>
  <meta content="" name="description">
  <meta content="" name="keywords">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 
  
  <script rel="text/Javascript" src="JavaScriptjs.js"></script>
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 
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
.containerw{
display: flex;

justify-content: space-between!important;
max-width: 1140px;
--bs-gutter-x: 1.5rem;
    --bs-gutter-y: 0;
    width: 100%;
    padding-right: calc(var(--bs-gutter-x) * .5);
    padding-left: calc(var(--bs-gutter-x) * .5);
    margin-right: auto;
    margin-left: auto;
}
.container {
    width: 100%;
    padding: 10px 10px 10px 10px;
    margin-left: 7px;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}
    
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
<style>
    
    #deptlabel{
    visibility:hidden;
    color:red;
    }
    #genderlabel{
    visibility:hidden;
    color:red;
    }
    #namelabel{
    visibility:hidden;
    color:red;
    }
    #addlabel{
    visibility:hidden;
    color:red;
    }
    #passlabel{
    visibility:hidden;
    color:red;
    }

    #loclabel{
    visibility:hidden;
    color:red;
    }

    #conpasslabel{
    visibility:hidden;
    color:red;
    }

    #phlabel{
    visibility:hidden;
    color:red;
    }
    #agelabel{
    visibility:hidden;
    color:red;
    }
    #emaillabel{
    visibility:hidden;
    color:red;
    }
    #doblabel{
    visibility:hidden;
    color:red;
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
            box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
            }
        
        h1{
            font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
            color: #FDD023;
           
        }
        .container{
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
                margin-left: 5%;
                float: left;
                }
                .right {
                right: 0;
                float: left;
               margin-left: 15%;
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
                .col-sm-6{
                margin-top:35px;
                   
                  
                }
                label{
                    color:black;
                }
                .inputfield{
                    width: 190px;
                    height: 38px;
                }
                .navigation{
                border-radius: 25px;
                background: rgba(0, 0, 0, 0.8);
                color: white;
                }
                .btnback{
                    color: rgb(246, 234, 19);
                    background: rgba(0, 0, 0, 0.8);
                }
                .navbar-nav>li>a{
    color: rgb(246, 234, 19);
    padding-left: 20px;
    padding-right: 20px;
   }
   .clr{
   		 
   		  background: #FDD023;
   }
.nav-display{
      display: block;
  position: -webkit-sticky;
  overflow: hidden;
  color: #f2f2f2;
  text-decoration: none;
    }
    nav
    {
        position: fixed;
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


</head>

<body>

  <!-- ======= Header ======= -->
   <header id="header" class="header fixed-top d-flex align-items-center">
    <div  class="containerw d-flex align-items-center justify-content-between" >

      <a href="index.html" class="logo d-flex align-items-center me-auto me-lg-0">
        <!-- Uncomment the line below if you also wish to use an image logo -->
        <!-- <img src="assets/img/logo.png" alt=""> -->
        <h1 style="color:#FDD023;">Restaurant<span>.</span></h1>
      </a>

      <nav id="navbar" class="navbar" style="height:80px;" >
        <ul>
        <li><a href="index1.jsp">Home</a></li>
          
          <li><a href="index1.jsp#about">About</a></li>
       
          <li><a href="index1.jsp#contact">Contact</a></li>
        </ul>
      </nav><!-- .navbar -->

<div>
     <a class="btn btn-warning btn-sm" style="align-items:right;"href="SignIn.jsp">Sign In</a>
      <a class="btn btn-sm" href="SignUp.jsp" style="background-color:black; color:#FDD023;">Sign Up</a>
      </div>
     <!-- .navbar -->
     
      <i class="mobile-nav-toggle mobile-nav-show bi bi-list"></i>
      <i class="mobile-nav-toggle mobile-nav-hide d-none bi bi-x"></i>

    </div>
  </header><!-- End Header -->

  <main id="main">

    
  <!-- ======= Hero Section ======= -->
  
		<div class="row" style="margin-top:5%;">
			<div class="col-sm-6">
			<img src="sngimg.jpg " width=700 height=500 style="lef">
			
			</div>
			<div class="col-sm-6">
				
				
				 <form action="cus_signup" method="post" onsubmit="return validate()">
                <center><h1>Sign Up</h1><br></center>
                
                <div class="container">
                    <div class="split left">
                        <label for="fname">Name <label Style="color:red;">*</label></label><br>
                    <input class="inputfield" type="text" id="fname" name="fname" placeholder="First Name"  autocomplete="off"/><br>
                    <label id="namelabel"></label>
                   
                    </div>
                    <div class="split right">
                        <label for="email_id_signup">Email ID <label Style="color:red;">*</label></label><br>
                        <input class="inputfield" type="text" id="email_id_signup" name="email_id_signup" placeholder="Email ID" autocomplete="off"  /><br>
                        <label id="emaillabel"></label>
                       
                    </div>
                    
                </div>
                <div class="container">
                    <br>
                    <div class="split left">
                        <label for="password_signup">Password <label Style="color:red;">*</label></label><br>
                    <input class="inputfield" type="password" id="password_signup" name="password_signup" placeholder="Password" autocomplete="off" /><br>
                    <label id="passlabel"></label>
                    
                    </div>
                    <div class="split right">
                        <label for="conpassword">Confirm Password <label Style="color:red;">*</label></label><br>
                    <input class="inputfield" type="password" id="conpassword" name="conpassword" placeholder="Confirm Password"autocomplete="off" /><br>
                    <label id="conpasslabel"></label>
                    
                    </div>
                    <br>
                </div>
                <div class="container">
                    <div class="split left">
                    <label>Gender:</label>
                <input  type="radio" id="male" name="gender" value="Male" checked/>
                <label for="male">Male</label>
                <input type="radio" id="female" name="gender" value="Female">
                <label for="female">Female</label>
                <input type="radio" id="other" name="gender" value="Other">
                <label for="other">Other</label><br>
                </div>
                 <div class="split right">
                       
                   
                    </div>
                
                </div>
                <div class="container">
                    <div class="split left">
                        <label for="contactno">Contact No <label Style="color:red;">*</label></label><br>
                        <input class="inputfield"type="text" id="contactno" name="contactno" placeholder="Contact No" autocomplete="off" /><br>
                        <label id="phlabel"></label>
                        <br><br>
                    </div>
                    <div class="split right">
                        <label for="age">Age <label Style="color:red;">*</label></label><br>
                        <input class="inputfield" type="text" id="age" name="age" placeholder="Age"  autocomplete="off" /><br>
                        <label id="agelabel"></label>
                    </div>
                </div>
                
                
                
                
           
                
                
                
                
                
                
                <div class="container">
                    <div class="split left">
                    <p><label for="location">Location <label Style="color:red;">*</label></label></p>
                    <input class="inputfield" type="text" id="location" name="location" placeholder="Location"  autocomplete="off" /><br>
                    <label id="loclabel"></label>
           		</div>
           		
           		 <div class="split right">
                       <p> <label for="address">Address <label Style="color:red;">*</label></label></p>
                        <input class="inputfield" type="text" id="address" name="address" placeholder="Address" autocomplete="off" /><br>
                        <label id="addlabel"></label>
                    </div>
                </div>
                
                <div class="container">
                    <center> <button type="Submit" class="button button2" value="submit" >Submit</button></center>
                </div>
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
                  
                    var name1=false;
                    var pass1=false;
                    var pass2=false;
                    var ph1=false;
                    var age1=false;
                    var email1 = false;
                    var loc1=false;
                    var add1=false;
                   
                   
                $("#fname").keyup(function() {
                
                name();
                
                });
                $("#location").keyup(function() {
                
                locationcheck();
                
                });
                $("#address").keyup(function() {
                
                addresscheck();
                
                });

              
                $("#contactno").keyup(function() {
                
                phno();
                
                });

                $("#age").keyup(function() {
                
                age();
                
                });
                $("#email_id_signup").keyup(function() {
                
                email();
                
                });
                
                $("#password_signup").keyup(function() {
                
                password();
                
                });
                
                $("#conpassword").keyup(function() {
                
                conpassword();
                
                });
                
                
                function name() {
                
                var uname = $("#fname").val();
                
                let regex = /^[-_ A-Za-z]{3,20}$/;
                
                var boolean = regex.test(uname);
                
                if (uname.trim() == "") {
                
                $("#namelabel").html("Please Enter Name");
                
                $("#namelabel").css("visibility", "visible");
                
                $("#fname").css("border", "solid 1px red");
                
                name1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#namelabel").html("Please Enter Valid Name");
                
                $("#namelabel").css("visibility", "visible");
                
                $("#fname").css("border", "solid 1px red");
                
                name1  = false;
                
                }
                
                else {
                
                $("#namelabel").css("visibility", "hidden");
                
                $("#fname").css("border", "solid 1px green");
                
                name1  = true;
                
                }
                
                }



                function locationcheck() {
                
                var uname = $("#location").val();
                
                let regex = /^[-_ A-Za-z]{3,20}$/;
                
                var boolean = regex.test(uname);
                
                if (uname.trim() == "") {
                
                $("#loclabel").html("Please Enter Location");
                
                $("#loclabel").css("visibility", "visible");
                
                $("#location").css("border", "solid 1px red");
                
                loc1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#loclabel").html("Please Enter Valid Location");
                
                $("#loclabel").css("visibility", "visible");
                
                $("#location").css("border", "solid 1px red");
                
                loc1  = false;
                
                }
                
                else {
                
                $("#loclabel").css("visibility", "hidden");
                
                $("#location").css("border", "solid 1px green");
                
                loc1  = true;
                
                }
                
                }



                function addresscheck() {
                
                var uname = $("#address").val();
                
                let regex =  /^[-_ 0-9 A-Za-z ,.]{3,50}$/;
                
                var boolean = regex.test(uname);
                
                if (uname.trim() == "") {
                
                $("#addlabel").html("Please Enter Address");
                
                $("#addlabel").css("visibility", "visible");
                
                $("#address").css("border", "solid 1px red");
                
                add1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#addlabel").html("Please Enter Valid Address");
                
                $("#addlabel").css("visibility", "visible");
                
                $("#address").css("border", "solid 1px red");
                
                add1  = false;
                
                }
                
                else {
                
                $("#addlabel").css("visibility", "hidden");
                
                $("#address").css("border", "solid 1px green");
                
                add1  = true;
                
                }
                
                }

                function phno() {
                
                var uname = $("#contactno").val();
                
                let regex = /^[0-9]{10}$/;
                
                var boolean = regex.test(uname);
                
                if (uname.trim() == "") {
                
                $("#phlabel").html("Please Enter Contact No");
                
                $("#phlabel").css("visibility", "visible");
                
                $("#contactno").css("border", "solid 1px red");
                
                phno1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#phlabel").html("Please Enter Valid Contact No");
                
                $("#phlabel").css("visibility", "visible");
                
                $("#contactno").css("border", "solid 1px red");
                
                phno1  = false;
                
                }
                
                else {
                
                $("#phlabel").css("visibility", "hidden");
                
                $("#contactno").css("border", "solid 1px green");
                
                phno1  = true;
                
                }
                
                }


                function age() {
                
                var uage = $("#age").val();
                
                let regex = /^[0-9]{2,3}$/;
                
                var boolean = regex.test(uage);
                
                if (uage.trim() == "") {
                
                $("#agelabel").html("Please Enter Age");
                
                $("#agelabel").css("visibility", "visible");
                
                $("#age").css("border", "solid 1px red");
                
                age1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#agelabel").html("Please Enter Valid Age");
                
                $("#agelabel").css("visibility", "visible");
                
                $("#age").css("border", "solid 1px red");
                
                age1  = false;
                
                }
                
                else {
                
                $("#agelabel").css("visibility", "hidden");
                
                $("#age").css("border", "solid 1px green");
                
                age1  = true;
                
                }
                
                }



                function email() {
                
                var uname = $("#email_id_signup").val();
                
                let regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                
                var boolean = regex.test(uname);
                
                if (uname.trim() == "") {
                
                $("#emaillabel").html("Please Enter Email ID");
                
                $("#emaillabel").css("visibility", "visible");
                
                $("#email_id_signup").css("border", "solid 1px red");
                
                email1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#emaillabel").html("Please Enter Valid Email ID");
                
                $("#emaillabel").css("visibility", "visible");
                
                $("#email_id_signup").css("border", "solid 1px red");
                
                email1  = false;
                
                }
                
                else {
                
                $("#emaillabel").css("visibility", "hidden");
                
                $("#email_id_signup").css("border", "solid 1px green");
                
                email1  = true;
                
                }
                
                }





                function password() {
                
                var pass = $("#password_signup").val();
                
                let regex =/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,20}$/;
                
                var boolean = regex.test(pass);
                
                if (pass.trim() == "") {
                
                $("#passlabel").html("Please Enter Password");
                
                $("#passlabel").css("visibility", "visible");
                
                $("#password_signup").css("border", "solid 1px red");
                
                pass1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#passlabel").html("Please Enter Valid Password");
                
                $("#passlabel").css("visibility", "visible");
                
                $("#password_signup").css("border", "solid 1px red");
                
                pass1  = false;
                
                }
                
                else {
                
                $("#passlabel").css("visibility", "hidden");
                
                $("#password_signup").css("border", "solid 1px green");
                
                pass1  = true;
                
                }
                
                }






                function conpassword() {
                
                var conpass = $("#conpassword").val();
                
                let regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,20}$/
                
                var boolean = regex.test(conpass);
                
                if (conpass.trim() == "") {
                
                $("#conpasslabel").html("Please Enter Password");
                
                $("#conpasslabel").css("visibility", "visible");
                
                $("#conpassword").css("border", "solid 1px red");
                
                pass2  = false;
                
                }
                
                else if (!boolean) {
                
                $("#conpasslabel").html("Please Enter Valid Password");
                
                $("#conpasslabel").css("visibility", "visible");
                
                $("#conpassword").css("border", "solid 1px red");
                
                pass2  = false;
                
                }
                
                else {
                
                $("#conpasslabel").css("visibility", "hidden");
                
                $("#conpassword").css("border", "solid 1px green");
                
                pass2  = true;
                
                }
                
                }






                
                function validate(){
                
                try{
                
                name();
                password();
                conpassword();
                phno();
                email();
                locationcheck();
                age();
                addresscheck();
                
                }
                catch (err) { console.log(err); }
                
                if(name1&&email1&&phno1&& pass1&&pass2&&age1 && loc1 && add1){
                
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