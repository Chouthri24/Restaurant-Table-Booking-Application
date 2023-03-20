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
 	#passlabel{
    visibility:hidden;
    color:red;
    }
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
            #passlabel{
    visibility:hidden;
    color:red;
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
                    <h1 class="recent-Articles">Setting</h1>
                    
                 </div>
                  <form action="updateadsetting" method="post" onsubmit="return validate()">
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
                 <h3 class="t-op al"style="width: 250px;text-align: left;" >Password</h3>
                 <br>
                 
                    <input   class="t-op al1" type="text"  value="<%=acc.getUserPassword()%>" readonly/>
                    
                    <br>
                     <input   class="t-op al1" type="hidden" id="ademail"  name="ademail" value="<%=acc.getUser_emailid()%>" readonly/>
                   
                 <br><h3 class="t-op al"style="width: 250px;text-align: left;" >Change Password</h3> 
                   <br><input   class="t-op al1" type="text"  id="pass" name="pass" value="<%=acc.getUserPassword() %>"/>
                   <label id="passlabel"></label>
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
                  
                
                var pass1=false;
               
               
           
            $("#pass").keyup(function() {
            
            password();
            
            });
            
           
            
            
            



            function password() {
            
            var pass = $("#pass").val();
            
            let regex =/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,20}$/;
            
            var boolean = regex.test(pass);
            
            if (pass.trim() == "") {
            
            $("#passlabel").html("Please Enter Password");
            
            $("#passlabel").css("visibility", "visible");
            
            $("#pass").css("border", "solid 1px red");
            
            pass1  = false;
            
            }
            
            else if (!boolean) {
            
            $("#passlabel").html("Please Enter Valid Password");
            
            $("#passlabel").css("visibility", "visible");
            
            $("#pass").css("border", "solid 1px red");
            
            pass1  = false;
            
            }
            
            else {
            
            $("#passlabel").css("visibility", "hidden");
            
            $("#pass").css("border", "solid 1px green");
            
            pass1  = true;
            
            }
            
            }






         




            
            function validate(){
            
            try{
            
           
            password();
            
            
            }
            
            catch (err) { console.log(err); }
            
            if(pass1){
            
            return true;
            
            }
            
            else{
            
            return false;
            
            }};
                  </script>  
    
</body>
</html>