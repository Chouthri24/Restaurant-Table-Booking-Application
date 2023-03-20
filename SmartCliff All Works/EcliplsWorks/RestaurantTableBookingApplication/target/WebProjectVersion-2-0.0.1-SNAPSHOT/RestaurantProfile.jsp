<%@ page import="com.persondetails.*" %>
<%@ page import="com.main.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.persondetails.*" %>
<%@ page import="com.registerationcontroller.*" %>
<%@ page import="com.booking.*" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html lang="en" style="background-color: #F7E371">
 
<head >
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible"
          content="IE=edge">
    <meta name="viewport"
          content="width=device-width,
                   initial-scale=1.0">
    <title>Restaurant</title>
    <link rel="stylesheet"
          href="AdminMain.css">
    <link rel="stylesheet"
          href="ResponseAdmin.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <%

if(session.getAttribute("block") == null){

response.sendRedirect("IndexPage.jsp");

}

%>
      <style>
      .option2 {
  border-left: 5px solid #010058af;
  background-color:#FDDA0D;
  
  cursor: pointer;
}
      header2 {
  height: 70px;
  width: 100vw;
  padding: 0 30px;
  background-color: #696969;
  position: fixed;
  z-index: 100;
  box-shadow: 1px 1px 15px rgba(161, 182, 253, 0.825);
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.logo2 {
  font-size: 27px;
  font-weight: 600;
  color: #FDDA0D;
}
#phlabel{
    visibility:hidden;
    color:red;
    }
    #passlabel{
    visibility:hidden;
    color:red;
    }
    #namelabel{
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
             .button1 {
            background-color: #d11a2a; /* Green */
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
 .button12 {
            background-color: #F7E371; /* Green */
            border: none;
            border-radius: 5px;
            color: black;
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
             .al{
            	margin-left:30px;
            }
             .al1{
            	margin-left:70px;
            }
             .button2:hover {
            box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
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
      
</head>
 
<body>
   
    <!-- for header part -->
    <header2>
 
        <div class="logosec" >
           <%CustomerAccountServletSignin obj1=new CustomerAccountServletSignin();%>
            <div class="logo2"><h3><%=obj1.resmainobj.getRestaurantName()%> Restaurant</h3></div>
            
        </div>
         <div>
        
              				<a href="RestaurantHomePage.jsp">
      <button  class="button12 button2" >Back</button>
    </a>
              </div>
 
        
 
        
    </header2>
 
        <div class="main" style="background-color:#F7E371">
 
		<div class="report-container">
		
		
		
		
                <div class="report-header">
                    <h1 class="recent-Articles">Update Profile</h1>
                    
                 </div>
                  <form action="updateresprofile" method="post" onsubmit="return validate()">
                 <%  CustomerAccountServletSignin obj=new  CustomerAccountServletSignin();
                 
                 		Restaurant rs=obj.resmainobj;
                 		Account acc=null;
                 		for(Account ac:Account.account_obj_list){
                 			if(ac.getUser_emailid().equalsIgnoreCase(rs.getEmail_id())){
                 				acc=ac;
                 			}
                 		}
                 
                 %> 
					
        			
             		<br>
                 <h3 class="t-op al"style="width: 250px;text-align: left;" >Restaurant Name</h3>
                 <br>
                 
                    <input   class="t-op al1" type="text" id="resname"  name="resname" value="<%=rs.getRestaurantName() %>" readonly/>
                    <br>
                 <br><h3 class="t-op al"style="width: 250px;text-align: left;" >Manager Name <label Style="color:red;">*</label>
                 </h3> 
                   <br><input   class="t-op al1" type="text"  id="manname" name="manname" value="<%=rs.getName() %>"/>
                   <label id="namelabel"></label> <br>
                <br> <h3 class="t-op al"style="width: 250px;text-align: left;" >Manager Email ID</h3> 
                  <br> <input  class="t-op al1" type="text" id="manemail" name="manemail" value="<%=rs.getEmail_id()%>" readonly/> <br>
                  
                 <br><h3 class="t-op al"style="width: 250px;text-align: left;" >Manager Contact No <label Style="color:red;">*</label>
                 </h3> 
                  <br> <input   class="t-op al1" type="text" id="mancontact" name="mancontact" value="<%=rs.getContact_no() %>"/> 
                  <label id="phlabel"></label><br>
                  
                  <br><h3 class="t-op al"style="width: 250px;text-align: left;" >Password</h3> 
                   <br><input   class="t-op al1" type="text" value="<%=acc.getUserPassword() %>" readonly/> <br>
                  	
                  
                  <br><h3 class="t-op al"style="width: 250px;text-align: left;" >Change Password <label Style="color:red;">*</label></h3> 
                   <br><input   class="t-op al1" type="text" id="pass" name="pass" value="<%=acc.getUserPassword() %>"/>
                   <label id="passlabel"></label> <br>
                  		
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
      
                var pass1 = false;
            

               
            $("#manname").keyup(function() {
            
            name();
            
            });

     
          
            $("#mancontact").keyup(function() {
            
            phno();
            
            });

           
            $("#pass").keyup(function() {
            
            password();
            
            });
            
            
            function name() {
            
            var uname = $("#manname").val();
            
            let regex = /^[-_ A-Za-z]{3,20}$/;
            
            var boolean = regex.test(uname);
            
            if (uname.trim() == "") {
            
            $("#namelabel").html("Please Enter Name");
            
            $("#namelabel").css("visibility", "visible");
            
            $("#manname").css("border", "solid 1px red");
            
            name1  = false;
            
            }
            
            else if (!boolean) {
            
            $("#namelabel").html("Please Enter Valid Name");
            
            $("#namelabel").css("visibility", "visible");
            
            $("#manname").css("border", "solid 1px red");
            
            name1  = false;
            
            }
            
            else {
            
            $("#namelabel").css("visibility", "hidden");
            
            $("#manname").css("border", "solid 1px green");
            
            name1  = true;
            
            }
            
            }


            
           
            function phno() {
            
            var uname = $("#mancontact").val();
            
            let regex = /^[0-9]{10}$/;
            
            var boolean = regex.test(uname);
            
            if (uname.trim() == "") {
            
            $("#phlabel").html("Please Enter Contact no");
            
            $("#phlabel").css("visibility", "visible");
            
            $("#mancontact").css("border", "solid 1px red");
            
            phno1  = false;
            
            }
            
            else if (!boolean) {
            
            $("#phlabel").html("Please Enter Valid Contact no");
            
            $("#phlabel").css("visibility", "visible");
            
            $("#mancontact").css("border", "solid 1px red");
            
            phno1  = false;
            
            }
            
            else {
            
            $("#phlabel").css("visibility", "hidden");
            
            $("#mancontact").css("border", "solid 1px green");
            
            phno1  = true;
            
            }
            
            }



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
            
            name();
            phno();
          	password();
            
            }
            
            catch (err) { console.log(err); }
            
            if(name1&&phno1 && pass1){
            
            return true;
            
            }
            
            else{
            
            return false;
            
            }};
                  </script>  
  
</body>
</html>