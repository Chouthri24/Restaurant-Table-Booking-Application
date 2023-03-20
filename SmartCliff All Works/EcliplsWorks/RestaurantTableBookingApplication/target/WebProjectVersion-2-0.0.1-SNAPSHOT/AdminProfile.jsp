<%@ page import="com.main.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.persondetails.*" %>
<%@ page import="com.main.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.persondetails.*" %>
<%@ page import="com.registerationcontroller.*" %>
<%@ page import="com.booking.*" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html lang="en">
 
<head>
	 
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible"
          content="IE=edge">
    <meta name="viewport"
          content="width=device-width,
                   initial-scale=1.0">
    <title>ADMIN</title>
    <link rel="stylesheet"
          href="AdminMain.css">
    <link rel="stylesheet"
          href="ResponseAdmin.css">
</head>
<%

if(session.getAttribute("block") == null){

response.sendRedirect("IndexPage.jsp");

}

%>
 	<style>
 		.addu{
 			width:200px;
 		}
 		.lavel-tag2 {
  width: 100px;
  text-align: center;
  background-color:#d11a2a;
  color: white;
  border-radius: 4px;
}
#addlabel{
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
#namelabel{
    visibility:hidden;
    color:red;
    }
    #genlabel{
    visibility:hidden;
    color:red;
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
            margin-left:500px
            }
            .button2:hover {
            box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
            }
             .al{
            	margin-left:30px;
            }
             .al1{
            	margin-left:70px;
            }
        </style>
        <script>
function myFunction() {
  // Declare variables
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[2];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}
</script>
<body>


    <!-- for header part -->
    <header>
 
        <div class="logosec">
            <div class="logo">ADMIN</div>
        </div>
 
       <div>
        
              				<a href="AdminHomePage.jsp">
      <button  class="button button2" >Back</button>
    </a>
              </div>
        </header>
       <div class="main">
 
		<div class="report-container">
		
		
		
		
                <div class="report-header">
                    <h1 class="recent-Articles">Update Profile</h1>
                    
                 </div>
                  <form action="updateadprofile" method="post" onsubmit="return validate()">
                 <%  CustomerAccountServletSignin obj=new  CustomerAccountServletSignin();
                 
                 		Admin rs=obj.admainobj;
                 		Account acc=null;
                 		for(Account ac:Account.account_obj_list){
                 			if(ac.getUser_emailid().equalsIgnoreCase(rs.getEmail_id())){
                 				acc=ac;
                 			}
                 		}
                 	
                 %> 
					
        			
             		<br>
                 <h3 class="t-op al"style="width: 250px;text-align: left;" >Name</h3>

                 <br>
                 
                    <input   class="t-op al1" type="text" id="adname"  name="adname" value="<%=rs.getName() %>" />
                    <label id="namelabel"></label>
                    <br>
                 <br><h3 class="t-op al"style="width: 250px;text-align: left;" >Email ID</h3> 
                   <br><input   class="t-op al1" type="text"  id="ademail" name="ademail" value="<%=rs.getEmail_id() %>" readonly/> 
                   <label id="emaillabel"></label><br>
                   <br> <h3 class="t-op al"style="width: 250px;text-align: left;" >Contact No</h3> 
                 <input  class="t-op al1" type="text" id="adcontact" name="adcontact" value="<%=rs.getContact_no()%>" />
                 <label id="phlabel"></label> <br>
                 <br> 
                 <br><h3 class="t-op al"style="width: 250px;text-align: left;" >Gender</h3> 
                  <br> <input   class="t-op al1" type="text" id="adgen" name="adgen" value="<%=rs.getGender() %>"/>
                  <label id="genlabel"></label>
                   <br>
                  
                  <br><h3 class="t-op al"style="width: 250px;text-align: left;" >Address</h3> 
                   <input   class="t-op al1" type="text" id="address" name="address" value="<%=rs.getAddress()%>"/> <label id="addlabel"></label>
                   <br>
                   <br> 
        				 <div>
                                <br>
              				<a >
                                     <button  class="button button2" >Update</button>
   	                                          </a>
    			
              </div>
               </form>
             </div>
             </div>
             
  
             <script>
                  
                var name1=false;
               
                var ph1=false;
      
                var email1 = false;
            
                var add1=false;
                var gen1=false;
               
            $("#adname").keyup(function() {
            
            name();
            
            });

            $("#adgen").keyup(function() {
            
            gender();
            
            });

            
            $("#address").keyup(function() {
            
            addresscheck();
            
            });

          
            $("#adcontact").keyup(function() {
            
            phno();
            
            });

           
            $("#ademail").keyup(function() {
            
            email();
            
            });
            
            
            function name() {
            
            var uname = $("#adname").val();
            
            let regex = /^[-_ A-Za-z]{3,20}$/;
            
            var boolean = regex.test(uname);
            
            if (uname.trim() == "") {
            
            $("#namelabel").html("Please Enter Name");
            
            $("#namelabel").css("visibility", "visible");
            
            $("#adname").css("border", "solid 1px red");
            
            name1  = false;
            
            }
            
            else if (!boolean) {
            
            $("#namelabel").html("Please Enter Valid Name");
            
            $("#namelabel").css("visibility", "visible");
            
            $("#adname").css("border", "solid 1px red");
            
            name1  = false;
            
            }
            
            else {
            
            $("#namelabel").css("visibility", "hidden");
            
            $("#adname").css("border", "solid 1px green");
            
            name1  = true;
            
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


            function gender() {
            
            var uname = $("#adgen").val();
            
            let regex = /^[A-Za-z]{3,20}$/;
            
            var boolean = regex.test(uname);
            
            if (uname.trim() == "") {
            
            $("#genlabel").html("Please Enter Gender");
            
            $("#genlabel").css("visibility", "visible");
            
            $("#adgen").css("border", "solid 1px red");
            
            gen1  = false;
            
            }
            
            else if (!boolean) {
            
            $("#genlabel").html("Please Enter Valid Gender");
            
            $("#genlabel").css("visibility", "visible");
            
            $("#adgen").css("border", "solid 1px red");
            
            gen1  = false;
            
            }
            
            else {
            
            $("#genlabel").css("visibility", "hidden");
            
            $("#adgen").css("border", "solid 1px green");
            
            gen1  = true;
            
            }
            
            }
            
           
            function phno() {
            
            var uname = $("#adcontact").val();
            
            let regex = /^[0-9]{10}$/;
            
            var boolean = regex.test(uname);
            
            if (uname.trim() == "") {
            
            $("#phlabel").html("Please Enter Contact no");
            
            $("#phlabel").css("visibility", "visible");
            
            $("#adcontact").css("border", "solid 1px red");
            
            phno1  = false;
            
            }
            
            else if (!boolean) {
            
            $("#phlabel").html("Please Enter Valid Contact no");
            
            $("#phlabel").css("visibility", "visible");
            
            $("#adcontact").css("border", "solid 1px red");
            
            phno1  = false;
            
            }
            
            else {
            
            $("#phlabel").css("visibility", "hidden");
            
            $("#adcontact").css("border", "solid 1px green");
            
            phno1  = true;
            
            }
            
            }



            function email() {
            
            var uname = $("#ademail").val();
            
            let regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
            
            var boolean = regex.test(uname);
            
            if (uname.trim() == "") {
            
            $("#emaillabel").html("Please Enter Email ID");
            
            $("#emaillabel").css("visibility", "visible");
            
            $("#ademail").css("border", "solid 1px red");
            
            email1  = false;
            
            }
            
            else if (!boolean) {
            
            $("#emaillabel").html("Please Enter Valid Email ID");
            
            $("#emaillabel").css("visibility", "visible");
            
            $("#ademail").css("border", "solid 1px red");
            
            email1  = false;
            
            }
            
            else {
            
            $("#emaillabel").css("visibility", "hidden");
            
            $("#ademail").css("border", "solid 1px green");
            
            email1  = true;
            
            }
            
            }
            
            function validate(){
            
            try{
            
            name();
            phno();
            email();
            gender();
            addresscheck();
            
            }
            
            catch (err) { console.log(err); }
            
            if(name1&&email1&&phno1 && add1 && gen1){
            
            return true;
            
            }
            
            else{
            
            return false;
            
            }};
                  </script>  
    
</body>

</html>