<%@ page import="com.main.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.persondetails.*" %>
<%@ page import="com.accountdao.*" %>
<%@ page import="java.sql.*" %>
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


/* Set a style for all buttons */


/* Float cancel and delete buttons and add an equal width */
.cancelbtn, .deletebtn {
  float: left;
  width: 50%;
}
#reslabel{
    visibility:hidden;
    color:red;
    }
    #locationlabel{
    visibility:hidden;
    color:red;
    }
    #addresslabel{
    visibility:hidden;
    color:red;
    }
    #distancelabel{
    visibility:hidden;
    color:red;
    }
    
    #manconlabel{
    visibility:hidden;
    color:red;
    }
    #mannamelabel{
    visibility:hidden;
    color:red;
    }
/* Add a color to the cancel button */
.cancelbtn {
  background-color: #ccc;
  color: black;
}

/* Add a color to the delete button */
.deletebtn {
  background-color: #f44336;
}

/* Add padding and center-align text to the container */
.container {
  padding: 16px;
  text-align: center;
}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: #474e5d;
  padding-top: 50px;
}

/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 80%; /* Could be more or less, depending on screen size */
}

/* Style the horizontal ruler */
.hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}
 
/* The Modal Close Button (x) */
.close {
  position: absolute;
  right: 35px;
  top: 15px;
  font-size: 40px;
  font-weight: bold;
  color: #f1f1f1;
}

.close:hover,
.close:focus {
  color: #f44336;
  cursor: pointer;
}

/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

/* Change styles for cancel button and delete button on extra small screens */
@media screen and (max-width: 300px) {
  .cancelbtn, .deletebtn {
     width: 100%;
  }
}
</style>
 	<style>
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
             .buttonGR {
            background-color: rgb(0, 177, 0); /* Green */
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
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
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
        
              				<a href="ViewRestaurantRecord.jsp">
      <button  class="button button2" >Back</button>
    </a>
              </div>
        </header>
        
        
        
        
      <div class="main">
     
		<div class="report-container">
		
		
		
		
                <div class="report-header">
                    <h1 class="recent-Articles">Restaurant List</h1>
                    
                    
                    
                    
                 </div>
                  <form action="updateres" method="post" onsubmit="return validate()">
                 <%String id=request.getParameter("id");
	RestaurantAccountDao rdao=new RestaurantAccountDao();
		ResultSet rs=rdao.moreDetailRestaurant(id);
		
		while(rs.next()){%> 
					
        			<%String idstore=rs.getString(2);%>
             
                 <h3 class="t-op al"style="width: 100px;text-align: left;" >User_ID</h3>
                    <input   class="t-op al1" type="text" id="userid"  name="userid" value="<%=rs.getString(1) %>" readonly/>
                 <h3 class="t-op al"style="width: 100px;text-align: left;" >Restaurant_ID</h3>
                  <input   class="t-op al1" type="text"  id="resid" name="resid" value="<%=rs.getString(2) %>" readonly/>
                 <h3 class="t-op al"style="width: 100px;text-align: left;" >Restaurant_Name</h3>
                  <input  class="t-op al1" type="text" id="resname" name="resname" value="<%=rs.getString(3) %>"/>
                  <label id="reslabel"></label>
                 <h3 class="t-op al"style="width: 100px;text-align: left;" >Restaurant_Address</h3>
                  <input   class="t-op al1" type="text" id="resaddress" name="resaddress" value="<%=rs.getString(4) %>"/>
                  <label id="addresslabel"></label>
                 <h3 class="t-op al"style="width: 100px;text-align: left;" >Restaurant_Location</h3>
                  <input  class="t-op al1" type="text" id="reslocation" name="reslocation" value="<%=rs.getString(5) %>"/>
                  <label id="locationlabel"></label>
                 <h3 class="t-op al"style="width: 100px;text-align: left;" >Restaurant_Distance</h3>
                  <input    class="t-op al1" type="text" id="resdistance" name="resdistance" value="<%=rs.getString(6) %>"/>
                  <label id="distancelabel"></label>
                 <h3 class="t-op al"style="width: 100px;text-align: left;" >Manager_Name</h3>
                  <input    class="t-op al1" type="text" id="manname" name="manname" value="<%=rs.getString(7) %>"/>
                  <label id="mannamelabel"></label>
                 <h3 class="t-op al"style="width: 100px;text-align: left;" >Manager_EmailID</h3>
                  <input    class="t-op al1" type="text" value="<%=rs.getString(8) %>" readonly/>
                 <h3 class="t-op al"style="width: 100px;text-align: left;" >Manager_Contact No</h3>
                  <input    class="t-op al1" type="text" id="mancon"  name="mancon" value="<%=rs.getString(9) %>"/>
                  <label id="manconlabel"></label>
                 <h3 class="t-op al"style="width: 100px;text-align: left;" >Basic_Table_Count</h3>
                  <input    class="t-op al1" type="text"  value="<%=rs.getString(10) %>" readonly/>
                  <h3 class="t-op al"style="width: 100px;text-align: left;" >Basic_Table_Seat_Count</h3>
                   <input    class="t-op al1" type="text"  value="<%=rs.getString(11) %>" readonly/>
                   <h3 class="t-op al"style="width: 100px;text-align: left;" >Premium_Table_Count</h3>
                    <input    class="t-op al1" type="text" value="<%=rs.getString(12) %>" readonly/>
                    <h3 class="t-op al"style="width: 100px;text-align: left;" >Premium_Table_Seat_Count</h3>
                     <input    class="t-op al1" type="text"  value="<%=rs.getString(13) %>"/ readonly>
                       <h3 class="t-op al"style="width: 100px;text-align: left;" >Basic_Table_Amount</h3>
                     <input    class="t-op al1" type="text" value="<%=rs.getString(14) %>" readonly/>
                      <h3 class="t-op al"style="width: 100px;text-align: left;" >Premium_Table_Amount</h3>
                     <input    class="t-op al1" type="text"  value="<%=rs.getString(15) %>" readonly/>
                       <h3 class="t-op al"style="width: 100px;text-align: left;" >Food Items</h3>
                      <input    class="t-op al1" type="text" value="<%=rs.getString(16) %>"  size="50" readonly/>
        				
        				 <div>
         <br>
              				<a href="ViewRestaurantRecord.jsp">
      <button  class="button button2" >Update</button>
    </a>
    
              </div>
               </form>
              <%if(rs.getInt(17)!=1) {%>
              <form action="activateRes" method="post">
              		 <div>
        
              				<a >
              				
      <button  class="buttonGR button2" type="submit" value="submit"  >Activate </button>
      <input   class="t-op al1" type="hidden" style="margin-right: 110px;" type="text"  id="userid2" name="userid2" value="<%=rs.getString(1) %>" readonly/>
    </a>
      <input   class="t-op al1" type="hidden" style="margin-right: 110px;" type="text"  id="resid2" name="resid2" value="<%=rs.getString(2) %>" readonly/>
  
              </div>
              
              </form>
              <%} else{%>
                <button class="button1 button2" onclick="document.getElementById('id01').style.display='block'">Delete</button>
                    
              
              
              <%} %>
              
              <div id="id01" class="modal">
  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">×</span>
  <form class="modal-content" action="delete" method="post">
    <div class="container">
    
    <input   class="t-op al1" type="hidden" style="margin-right: 110px;" type="text"  id="userid1" name="userid1" value="<%=rs.getString(1) %>" readonly/>
   
    <input   class="t-op al1" type="hidden" style="margin-right: 110px;" type="text"  id="resid1" name="resid1" value="<%=rs.getString(2) %>" readonly/>
      <h1 style="margin-right: 85px;">Delete <%=rs.getString(3) %> Account</h1>
      
      <p style="margin-right: 85px;">Are you sure you want to delete your account?</p>
    
      <div class="clearfix">
        <button type="button" onclick="document.getElementById('id01').style.display='none'" class="button cancelbtn" style=" margin-left:250px">Cancel</button>
        <button type="submit" value="submit" onclick="document.getElementById('id01').style.display='none'" class="button1 deletebtn" style=" margin-left:250px">Delete</button>
      </div>
    </div>
  </form>
</div>
              
        	 <% }%>
        	
          </div>
         </div> 
         
         
          <script>
          			var resname1=false;
                    var resadd1=false;
                    var resdis1=false;
                    var resloc1=false;
                    var manname1=false;
                    var mancon1=false;             
                   
                $("#resname").keyup(function() {
                
                restaurantname();
                
                });
                $("#resaddress").keyup(function() {
                
                restaurantaddress();
                
                });
                $("#reslocation").keyup(function() {
                
                restaurantlocation();
                
                });

              
                $("#resdistance").keyup(function() {
                
                restaurantdistance();
                
                });

                $("#manname").keyup(function() {
                
                managername();
                
                });
                $("#mancon").keyup(function() {
                
                managercontact();
                
                });
                
               
                
                function restaurantname() {
                
                var uname = $("#resname").val();
                
                let regex =  /^[-_ 0-9 A-Za-z]{3,20}$/;
                
                var boolean = regex.test(uname);
                
                if (uname.trim() == "") {
                
                $("#reslabel").html("Please Enter Valid Restaurant Name");
                
                $("#reslabel").css("visibility", "visible");
                
                $("#resname").css("border", "solid 1px red");
                
                resname1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#reslabel").html("Please Enter valid Restaurant Name");
                
                $("#reslabel").css("visibility", "visible");
                
                $("#resname").css("border", "solid 1px red");
                
                resname1  = false;
                
                }
                
                else {
                
                $("#reslabel").css("visibility", "hidden");
                
                $("#resname").css("border", "solid 1px green");
                
                resname1  = true;
                
                }
                
                }


                function managername() {
                
                var uname = $("#manname").val();
                
                let regex =  /^[-_ A-Za-z]{3,20}$/;
                
                var boolean = regex.test(uname);
                
                if (uname.trim() == "") {
                
                $("#mannamelabel").html("Please Enter Valid Manager Name");
                
                $("#mannamelabel").css("visibility", "visible");
                
                $("#manname").css("border", "solid 1px red");
                
                manname1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#mannamelabel").html("Please Enter valid Manager Name");
                
                $("#mannamelabel").css("visibility", "visible");
                
                $("#manname").css("border", "solid 1px red");
                
                manname1  = false;
                
                }
                
                else {
                
                $("#mannamelabel").css("visibility", "hidden");
                
                $("#manname").css("border", "solid 1px green");
                
                manname1  = true;
                
                }
                
                }




                function restaurantaddress() {
                
                var uname = $("#resaddress").val();
                
                let regex = /^[-_ 0-9 A-Za-z ,.]{3,50}$/;
                
                var boolean = regex.test(uname);
                
                if (uname.trim() == "") {
                
                $("#addresslabel").html("Please Enter Valid Restaurant Address");
                
                $("#addresslabel").css("visibility", "visible");
                
                $("#resaddress").css("border", "solid 1px red");
                
                resadd1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#addresslabel").html("Please Enter valid Restaurant Address");
                
                $("#addresslabel").css("visibility", "visible");
                
                $("#resaddress").css("border", "solid 1px red");
                
                resadd1  = false;
                
                }
                
                else {
                
                $("#addresslabel").css("visibility", "hidden");
                
                $("#resaddress").css("border", "solid 1px green");
                
                resadd1  = true;
                
                }
                
                }



                function restaurantlocation() {
                
                var uname = $("#reslocation").val();
                
                let regex = /^[A-Za-z]{3,20}$/;
                
                var boolean = regex.test(uname);
                
                if (uname.trim() == "") {
                
                $("#locationlabel").html("Please Enter Valid Location");
                
                $("#locationlabel").css("visibility", "visible");
                
                $("#reslocation").css("border", "solid 1px red");
                
                resloc1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#locationlabel").html("Please Enter Valid Location");
                
                $("#locationlabel").css("visibility", "visible");
                
                $("#reslocation").css("border", "solid 1px red");
                
                resloc1  = false;
                
                }
                
                else {
                
                $("#locationlabel").css("visibility", "hidden");
                
                $("#reslocation").css("border", "solid 1px green");
                
                resloc1  = true;
                
                }
                
                }

                


                function restaurantdistance() {
                
                var uage = $("#resdistance").val();
                
                let regex = /^[0-9 . ]{1,4}$/;
                
                var boolean = regex.test(uage);
                
                if (uage.trim() == "") {
                
                $("#distancelabel").html("Please Enter Valid Distance");
                
                $("#distancelabel").css("visibility", "visible");
                
                $("#resdistance").css("border", "solid 1px red");
                
                resdis1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#distancelabel").html("Please Enter valid Distance");
                
                $("#distancelabel").css("visibility", "visible");
                
                $("#resdistance").css("border", "solid 1px red");
                
                resdis1  = false;
                
                }
                
                else {
                
                $("#distancelabel").css("visibility", "hidden");
                
                $("#resdistance").css("border", "solid 1px green");
                
                resdis1  = true;
                
                }
                
                }
                
               
                function managercontact() {
                
                var uname = $("#mancon").val();
                
                let regex = /^[0-9]{10}$/;
                
                var boolean = regex.test(uname);
                
                if (uname.trim() == "") {
                
                $("#manconlabel").html("Please Enter Valid Contact No");
                
                $("#manconlabel").css("visibility", "visible");
                
                $("#mancon").css("border", "solid 1px red");
                
                mancon1  = false;
                
                }
                
                else if (!boolean) {
                
                $("#manconlabel").html("Please Enter Valid Contact No");
                
                $("#manconlabel").css("visibility", "visible");
                
                $("#mancon").css("border", "solid 1px red");
                
                mancon1  = false;
                
                }
                
                else {
                
                $("#manconlabel").css("visibility", "hidden");
                
                $("#mancon").css("border", "solid 1px green");
                
                mancon1  = true;
                
                }
                
                }

                
                function validate(){
                
                try{
                
                restaurantname();
                restaurantaddress();
                restaurantdistance();
                restaurantlocation();
                managername();
                managercontact();
                
                
                }
                
                catch (err) { console.log(err); }
                
                if(resname1 && resadd1 && resdis1 && resloc1 && manname1 && mancon1){
                
                return true;
                
                }
                
                else{
                
                return false;
                
                }};
                      </script>  
                 
</body>
</html>