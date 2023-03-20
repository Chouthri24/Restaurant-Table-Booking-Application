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
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

response.setHeader("Pragma","no-cache");

response.setDateHeader("Expires",0);

if(session.getAttribute("block") == null){

response.sendRedirect("index1.jsp");

}

%>
      <style>
      #nvftclabel{
    visibility:hidden;
    color:red;
    }
     #nvfsclabel{
    visibility:hidden;
    color:red;
    }
    #nvfalabel{
    visibility:hidden;
    color:red;
    }
    
     #vftclabel{
    visibility:hidden;
    color:red;
    }
     #vfsclabel{
    visibility:hidden;
    color:red;
    }
    #vfalabel{
    visibility:hidden;
    color:red;
    }
    
    #foodlabel{
    visibility:hidden;
    color:red;
    }
    
    
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
                    <h1 class="recent-Articles">Setting</h1>
                    
                 </div>
                  <form action="updateresSetting" method="post" onsubmit="return validate()">
                 <%  CustomerAccountServletSignin obj=new  CustomerAccountServletSignin();
                 		Restaurant rs=obj.resmainobj;
                 %> 
             		<br>
                 <h3 class="t-op al"style="width: 250px;text-align: left;" >Restaurant Name</h3>
                 <br>
                  <input   class="t-op al1" type="hidden" id="resemail"  name="resemail" value="<%=rs.getEmail_id() %>" readonly/>
                    <input   class="t-op al1" type="text" id="resname"  name="resname" value="<%=rs.getRestaurantName() %>" readonly/>
                    <br>  <br>
                 <h3 class="t-op al"style="width: 300px;text-align: left;" >Non Veg Food Table Count <label Style="color:red;">*</label></h3>
                 <br>  
                  <input  class="t-op al1" type="text" id="btc" name="btc" value="<%=rs.tables.tableSeats.getBasictablecount()%>"/>
                  <label id="nvftclabel"></label>
                  <br>   <br>
                  <h3 class="t-op al"style="width: 310px;text-align: left;" >Non Veg Food Table Seat Count <label Style="color:red;">*</label></h3>
                  <br>  
                  <input  class="t-op al1" type="text" id="btsc" name="btsc" value="<%=rs.tables.tableSeats.getBasictableseatcount()%>"/>
                   <label id="nvfsclabel"></label><br>  
                   <br>
                   <h3 class="t-op al"style="width: 300px;text-align: left;" >Non Veg Food Seat Amount <label Style="color:red;">*</label></h3><br>  
                  <input  class="t-op al1" type="text" id="bsa" name="bsa" value="<%=rs.tables.getBasictableseatamount()%>"/>
                   <label id="nvfalabel"></label><br>  
                   <br>
                  <h3 class="t-op al"style="width: 300px;text-align: left;" >Veg Food Table Count <label Style="color:red;">*</label></h3><br>  
                  <input  class="t-op al1" type="text" id="ptc" name="ptc" value="<%=rs.tables.tableSeats.getPremiumtablecount()%>"/>
                   <label id="vftclabel"></label><br>  
                  <br> <h3 class="t-op al"style="width: 300px;text-align: left;" >Veg Food Table Seat Count <label Style="color:red;">*</label></h3><br>  
                  <input  class="t-op al1" type="text" id="ptsc" name="ptsc" value="<%=rs.tables.tableSeats.getPremiumtableseatcount()%>"/>
                   <label id="vfsclabel"></label><br>  
                   <br>
                   <h3 class="t-op al"style="width: 300px;text-align: left;" >Veg Food Seat Amount <label Style="color:red;">*</label></h3><br>  
                  <input  class="t-op al1" type="text" id="psa" name="psa" value="<%=rs.tables.getPremiumtableseatamount()%>"/>
                   <label id="vfalabel"></label>
                  
                  <br>  
                   <br>
                	<h3 class="t-op al"style="width: 300px;text-align: left;" >Food Items <label Style="color:red;">*</label>
                	
                	</h3><br>  
                  <input  class="t-op al1" type="text" id="food" name="food" value="<%=rs.fooditems.getFoodName()%>"/>
                   <label id="foodlabel"></label><br>  
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
                  
                var nvftc1=false;
               
                var nvfsc1=false;
      
                var nvfa1 = false;
             	var vftc1=false;
             	var vfsc1=false;
				var vfa1=false;
				var food1=false;
            
           
				$("#btc").keyup(function() {
		            
		            nvftc();
		            
		            });
				
				$("#btsc").keyup(function() {
		            
		            nvfsc();
		            
		            });
			$("#bsa").keyup(function() {
		            
		            nvfa();
		            
		            });
			
			
			
			$("#ptc").keyup(function() {
	            
	            vftc();
	            
	            });
			
			$("#ptsc").keyup(function() {
	            
	            vfsc();
	            
	            });
		$("#psa").keyup(function() {
	            
	            vfa();
	            
	            });
		$("#food").keyup(function() {
            
            food();
            
            });
			
		 function food() {
	            
	            var uname = $("#food").val();
	            
	            let regex =  /^[-_ A-Za-z ,.]{3,50}$/;
	            
	            var boolean = regex.test(uname);
	            
	            if (uname.trim() == "") {
	            
	            $("#foodlabel").html("Please Enter Food");
	            
	            $("#foodlabel").css("visibility", "visible");
	            
	            $("#food").css("border", "solid 1px red");
	            
	            food1  = false;
	            
	            }
	            
	            else if (!boolean) {
	            
	            $("#foodlabel").html("Please Enter Valid Food");
	            
	            $("#foodlabel").css("visibility", "visible");
	            
	            $("#food").css("border", "solid 1px red");
	            
	            food1  = false;
	            
	            }
	            
	            else {
	            
	            $("#foodlabel").css("visibility", "hidden");
	            
	            $("#food").css("border", "solid 1px green");
	            
	            food1  = true;
	            
	            }
	            
	            }

			
			
	           function vftc() {
	               
	               var uname = $("#ptc").val();
	               
	               let regex = /^[0-9]{0,2}$/;
	               
	               var boolean = regex.test(uname);
	               
	               if (uname.trim() == "") {
	               
	               $("#vftclabel").html("Please Enter Veg Food Table Count");
	               
	               $("#vftclabel").css("visibility", "visible");
	               
	               $("#ptc").css("border", "solid 1px red");
	               
	               vftc1  = false;
	               
	               }
	               
	               else if (!boolean) {
	               
	               $("#vftclabel").html("Please Enter Valid Veg Food Table Count");
	               
	               $("#vftclabel").css("visibility", "visible");
	               
	               $("#ptc").css("border", "solid 1px red");
	               
	               vftc1  = false;
	               
	               }
	               
	               else {
	               
	               $("#vftclabel").css("visibility", "hidden");
	               
	               $("#ptc").css("border", "solid 1px green");
	               
	               vftc1  = true;
	               
	               }
	               
	               }
	               
	               function vfsc() {
	                   
	                   var uname = $("#ptsc").val();
	                   
	                   let regex = /^[0-9]{0,2}$/;
	                   
	                   var boolean = regex.test(uname);
	                   
	                   if (uname.trim() == "") {
	                   
	                   $("#vfsclabel").html("Please Enter Veg Food Table Seat Count");
	                   
	                   $("#vfsclabel").css("visibility", "visible");
	                   
	                   $("#ptsc").css("border", "solid 1px red");
	                   
	                   vfsc1  = false;
	                   
	                   }
	                   
	                   else if (!boolean) {
	                   
	                   $("#vfsclabel").html("Please Enter Valid Veg Food Table Seat Count");
	                   
	                   $("#vfsclabel").css("visibility", "visible");
	                   
	                   $("#ptsc").css("border", "solid 1px red");
	                   
	                   vfsc1  = false;
	                   
	                   }
	                   
	                   else {
	                   
	                   $("#vfsclabel").css("visibility", "hidden");
	                   
	                   $("#ptsc").css("border", "solid 1px green");
	                   
	                   vfsc1  = true;
	                   
	                   }
	                   
	                   }
	               
	               
	    function vfa() {
	                   
	                   var uname = $("#psa").val();
	                   
	                   let regex = /^[0-9]{2,5}$/;
	                   
	                   var boolean = regex.test(uname);
	                   
	                   if (uname.trim() == "") {
	                   
	                   $("#vfalabel").html("Please Enter Veg Food Table Seat Amount");
	                   
	                   $("#vfalabel").css("visibility", "visible");
	                   
	                   $("#psa").css("border", "solid 1px red");
	                   
	                   vfa1  = false;
	                   
	                   }
	                   
	                   else if (!boolean) {
	                   
	                   $("#vfalabel").html("Please Enter Valid Veg Food Table Seat Amount");
	                   
	                   $("#vfalabel").css("visibility", "visible");
	                   
	                   $("#psa").css("border", "solid 1px red");
	                   
	                   vfa1  = false;
	                   
	                   }
	                   
	                   else {
	                   
	                   $("#vfalabel").css("visibility", "hidden");
	                   
	                   $("#psa").css("border", "solid 1px green");
	                   
	                   vfa1  = true;
	                   
	                   }
	                   
	                   }
			
			
			
			
			
			
			
			
			
			
				
            function nvftc() {
            
            var uname = $("#btc").val();
            
            let regex = /^[0-9]{0,2}$/;
            
            var boolean = regex.test(uname);
            
            if (uname.trim() == "") {
            
            $("#nvftclabel").html("Please Enter Non Veg Food Table Count");
            
            $("#nvftclabel").css("visibility", "visible");
            
            $("#btc").css("border", "solid 1px red");
            
            nvftc1  = false;
            
            }
            
            else if (!boolean) {
            
            $("#nvftclabel").html("Please Enter Valid Non Veg Food Table Count");
            
            $("#nvftclabel").css("visibility", "visible");
            
            $("#btc").css("border", "solid 1px red");
            
            nvftc1  = false;
            
            }
            
            else {
            
            $("#nvftclabel").css("visibility", "hidden");
            
            $("#btc").css("border", "solid 1px green");
            
            nvftc1  = true;
            
            }
            
            }
            
            function nvfsc() {
                
                var uname = $("#btsc").val();
                
                let regex = /^[0-9]{0,2}$/;
                
                var boolean = regex.test(uname);
                
                if (uname.trim() == "") {
                
                $("#nvfsclabel").html("Please Enter Non Veg Food Table Seat Count");
                
                $("#nvfsclabel").css("visibility", "visible");
                
                $("#btsc").css("border", "solid 1px red");
                
                nvfsc1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#nvfsclabel").html("Please Enter Valid Non Veg Food Table Seat Count");
                
                $("#nvfsclabel").css("visibility", "visible");
                
                $("#btsc").css("border", "solid 1px red");
                
                nvfsc1  = false;
                
                }
                
                else {
                
                $("#nvfsclabel").css("visibility", "hidden");
                
                $("#btsc").css("border", "solid 1px green");
                
                nvfsc1  = true;
                
                }
                
                }
            
            
 function nvfa() {
                
                var uname = $("#bsa").val();
                
                let regex = /^[0-9]{2,5}$/;
                
                var boolean = regex.test(uname);
                
                if (uname.trim() == "") {
                
                $("#nvfalabel").html("Please Enter Non Veg Food Table Seat Amount");
                
                $("#nvfalabel").css("visibility", "visible");
                
                $("#bsa").css("border", "solid 1px red");
                
                nvfa1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#nvfalabel").html("Please Enter Valid Non Veg Food Table Seat Amount");
                
                $("#nvfalabel").css("visibility", "visible");
                
                $("#bsa").css("border", "solid 1px red");
                
                nvfa1  = false;
                
                }
                
                else {
                
                $("#nvfalabel").css("visibility", "hidden");
                
                $("#bsa").css("border", "solid 1px green");
                
                nvfa1  = true;
                
                }
                
                }
            
            
            function validate(){
            
            try{
            
            nvftc();
           	nvfsc();
            nvfa();
            vftc();
           	vfsc();
            vfa();
            food();
            }
            
            catch (err) { console.log(err); }
            
            if(nvftc1 &&
            
           nvfsc1&&
  
      nvfa1 &&
         vftc1 &&
          vfsc1 &&
			vfa1&&
			food1){
            
            return true;
            
            }
            
            else{
            
            return false;
            
            }};
                  </script>  
  
  
</body>
</html>