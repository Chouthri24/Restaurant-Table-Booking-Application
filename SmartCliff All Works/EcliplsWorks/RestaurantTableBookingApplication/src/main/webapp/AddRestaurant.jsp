<%@ page import="com.persondetails.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
 
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible"
          content="IE=edge">
    <meta name="viewport"
          content="width=device-width,
                   initial-scale=1.0">
    <title>ADMIN</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
    <link rel="stylesheet"
          href="AdminMain.css">
    <link rel="stylesheet"
          href="ResponseAdmin.css">
            <style>
               
    #distancelabel{
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

    #mannamelabel{
    visibility:hidden;
    color:red;
    }

    #phlabel{
    visibility:hidden;
    color:red;
    }
    
    #emaillabel{
    visibility:hidden;
    color:red;
    }
   
    body{
       
        min-height: 500px;
        background-attachment: fixed;
        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
    }
        .button {
            background-color: #595fae; /* Green */
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
            color:	#7FFFD4;
           
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
                .col-sm-6{
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
 <%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

response.setHeader("Pragma","no-cache");

response.setDateHeader("Expires",0);

if(session.getAttribute("block") == null){

response.sendRedirect("index1.jsp");

}

%>
<body>
   
    <!-- for header part -->
    <header>
 
        <div class="logosec">
            <div class="logo">ADMIN</div>
            <img src=
"https://media.geeksforgeeks.org/wp-content/uploads/20221210182541/Untitled-design-(30).png"
                class="icn menuicn"
                id="menuicn"
                alt="menu-icon">
                
        </div>
 				
 			<div>
 				<div>
        
              				<a href="ViewRestaurantRecord.jsp">
      <button  class="button button2" >Back</button>
    </a> </div>
        </div>
 
    </header>
  <form action="addRes" method="post" onsubmit="return validate()">
    <div class="main-container">
        
        <div class="main">
 			
 				 <div class="col-sm-6">
          
                <center><h1>Add Restaurant</h1><br></center>
                <div class="container">
                 <div class="split left">
                        <label for="fname">UserType</label><br>
                    <input class="inputfield" type="text" id="usertype" name="usertype" placeholder="First Name" value="RESTAURANT" readonly/><br>
                    
                    <br>
                    </div>
                    <div class="split right">
                        <label for="fname">Restaurant Name</label><br>
                    <input class="inputfield" type="text" id="Resname" name="Resname" placeholder="Name" autocomplete="off"/><br>
                    <label id="namelabel"></label>
                    
                    <br>
                    </div>
                    <div class="split right">
                        <label for="email_id_signup">Restaurant Address</label><br>
                        <input class="inputfield" type="text" id="ResAddress" name="ResAddress" placeholder="Address"autocomplete="off"/><br>
                        <label id="addlabel"></label>
                        <br>
                    </div>
                  
                    <br>
                </div><br>
                <br>
                <div class="container">
                      <div class="split left">
                        <label for="fname">Location</label><br>
                    <input class="inputfield" type="text" id="location" name="location" placeholder="Location"autocomplete="off"/><br>
                    <label id="loclabel"></label>
                    <br>
                    </div>
                    
                    <div class="split right">
                        <label for="email_id_signup">Distance</label><br>
                        <input class="inputfield" type="text" id="distance" name="distance" placeholder="Distance"autocomplete="off"/><br>
                        <label id="distancelabel"></label>
                        <br>
                    </div>
                     <div class="split right">
                        <label for="fname">Manager Name</label><br>
                    <input class="inputfield" type="text" id="Magname" name="Magname" placeholder="Manager Name"autocomplete="off"/><br>
                    <label id="mannamelabel"></label>
                    <br>
                    </div>
                       
                    <br>
                </div><br>
                <br>
               
                <div class="container">
                <div class="split left">
                        <label for="email_id_signup">Manager Email ID</label><br>
                        <input class="inputfield" type="text" id="MagEmail" name="MagEmail" placeholder="Email ID"autocomplete="off"/><br>
                        <label id="emaillabel"></label>
                        <br>
                    </div>
                    <div class="split right">
                        <label for="fname">Manager Contact No</label><br>
                    <input class="inputfield" type="text" id="Contact" name="Contact" placeholder="Contact No" autocomplete="off"/><br>
                    <label id="phlabel"></label>
                    <br>
                    </div>
                    <div class="split right">
                        <label for="email_id_signup">Password</label><br>
                        <input class="inputfield" type="text" id="MagPass" name="MagPass" placeholder="Password" autocomplete="off"/><br>
                        <label id="passlabel"></label>
                        <br>
                    </div>
                    
                    <br>
                </div><br>
                <br>
                <div class="container">
                    <center> <button type="Submit" class="button button2" value="Submit">Submit</button></center>
                </div>
                </div>
                 
          </div>
         
   </div>
   </form>
      
   <script>
                  
    var name1=false;
    var pass1=false;
    var ph1=false;
    var email1 = false;
    var loc1=false;
    var add1=false;
   var manname1  = false;
   
$("#Resname").keyup(function() {

name();

});
$("#Magname").keyup(function() {

    managername();

});
$("#location").keyup(function() {

locationcheck();

});
$("#ResAddress").keyup(function() {

addresscheck();

});


$("#Contact").keyup(function() {

phno();

});

$("#age").keyup(function() {

age();

});
$("#MagEmail").keyup(function() {

email();

});

$("#MagPass").keyup(function() {

password();

});

$("#distance").keyup(function() {

    restaurantdistance();

});


function email() {
                
                var uname = $("#MagEmail").val();
                
                let regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                
                var boolean = regex.test(uname);
                
                if (uname.trim() == "") {
                
                $("#emaillabel").html("Please Enter Email ID");
                
                $("#emaillabel").css("visibility", "visible");
                
                $("#MagEmail").css("border", "solid 1px red");
                
                email1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#emaillabel").html("Please Enter Valid Email ID");
                
                $("#emaillabel").css("visibility", "visible");
                
                $("#MagEmail").css("border", "solid 1px red");
                
                email1  = false;
                
                }
                
                else {
                
                $("#emaillabel").css("visibility", "hidden");
                
                $("#MagEmail").css("border", "solid 1px green");
                
                email1  = true;
                
                }
                
                }


function restaurantdistance() {
                
                var uage = $("#distance").val();
                
                let regex = /^[0-9 . ]{1,4}$/;
                
                var boolean = regex.test(uage);
                
                if (uage.trim() == "") {
                
                $("#distancelabel").html("Please Enter Distance");
                
                $("#distancelabel").css("visibility", "visible");
                
                $("#distance").css("border", "solid 1px red");
                
                resdis1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#distancelabel").html("Please Enter Valid Distance");
                
                $("#distancelabel").css("visibility", "visible");
                
                $("#distance").css("border", "solid 1px red");
                
                resdis1  = false;
                
                }
                
                else {
                
                $("#distancelabel").css("visibility", "hidden");
                
                $("#distance").css("border", "solid 1px green");
                
                resdis1  = true;
                
                }
                
                }
                function managername() {
                
                var uname = $("#Magname").val();
                
                let regex =  /^[-_ A-Za-z]{3,20}$/;
                
                var boolean = regex.test(uname);
                
                if (uname.trim() == "") {
                
                $("#mannamelabel").html("Please Enter Manager Name");
                
                $("#mannamelabel").css("visibility", "visible");
                
                $("#Magname").css("border", "solid 1px red");
                
                manname1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#mannamelabel").html("Please Enter valid Manager Name");
                
                $("#mannamelabel").css("visibility", "visible");
                
                $("#Magname").css("border", "solid 1px red");
                
                manname1  = false;
                
                }
                
                else {
                
                $("#mannamelabel").css("visibility", "hidden");
                
                $("#Magname").css("border", "solid 1px green");
                
                manname1  = true;
                
                }
                
                }



                
               
               


function name() {

var uname = $("#Resname").val();

let regex = /^[-_ A-Za-z]{3,20}$/;

var boolean = regex.test(uname);

if (uname.trim() == "") {

$("#namelabel").html("Please Enter Name");

$("#namelabel").css("visibility", "visible");

$("#Resname").css("border", "solid 1px red");

name1  = false;

}

else if (!boolean) {

$("#namelabel").html("Please Enter valid Name");

$("#namelabel").css("visibility", "visible");

$("#Resname").css("border", "solid 1px red");

name1  = false;

}

else {

$("#namelabel").css("visibility", "hidden");

$("#Resname").css("border", "solid 1px green");

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

var uname = $("#ResAddress").val();

let regex = /^[-_ 0-9 A-Za-z ,.]{3,50}$/;

var boolean = regex.test(uname);

if (uname.trim() == "") {

$("#addlabel").html("Please Enter Address");

$("#addlabel").css("visibility", "visible");

$("#ResAddress").css("border", "solid 1px red");

add1  = false;

}

else if (!boolean) {

$("#addlabel").html("Please Enter Valid Address");

$("#addlabel").css("visibility", "visible");

$("#ResAddress").css("border", "solid 1px red");

add1  = false;

}

else {

$("#addlabel").css("visibility", "hidden");

$("#ResAddress").css("border", "solid 1px green");

add1  = true;

}

}








function phno() {

var uname = $("#Contact").val();

let regex = /^[0-9]{10}$/;

var boolean = regex.test(uname);

if (uname.trim() == "") {

$("#phlabel").html("Please Enter Contact No");

$("#phlabel").css("visibility", "visible");

$("#Contact").css("border", "solid 1px red");

phno1  = false;

}

else if (!boolean) {

$("#phlabel").html("Please Enter Valid Contact No");

$("#phlabel").css("visibility", "visible");

$("#Contact").css("border", "solid 1px red");

phno1  = false;

}

else {

$("#phlabel").css("visibility", "hidden");

$("#Contact").css("border", "solid 1px green");

phno1  = true;

}

}
function password() {

var pass = $("#MagPass").val();

let regex =/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,20}$/;

var boolean = regex.test(pass);

if (pass.trim() == "") {

$("#passlabel").html("Please Enter Password");

$("#passlabel").css("visibility", "visible");

$("#MagPass").css("border", "solid 1px red");

pass1  = false;

}

else if (!boolean) {

$("#passlabel").html("Please Enter Valid Password");

$("#passlabel").css("visibility", "visible");

$("#MagPass").css("border", "solid 1px red");

pass1  = false;

}

else {

$("#passlabel").css("visibility", "hidden");

$("#MagPass").css("border", "solid 1px green");

pass1  = true;

}

}



function validate(){

try{

name();
password();
restaurantdistance();
managername();
phno();
email();
locationcheck();
addresscheck();

}

catch (err) { console.log(err); }

if(name1&&email1&&phno1&& pass1 && loc1 && add1 && resdis1 && manname1 ){

return true;

}

else{

return false;

}};
      </script>  


</body>
</html>