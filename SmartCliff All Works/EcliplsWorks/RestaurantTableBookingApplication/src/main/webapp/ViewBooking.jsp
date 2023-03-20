<%@ page import="com.main.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.persondetails.*" %>
<%@ page import="com.persondetails.*" %>
<%@ page import="com.restaurantdetails.*" %>
<%@ page import="com.registerationcontroller.*" %>
<%@ page import="com.registerationcontroller.*" %>
<%@ page import="com.booking.*" %>
<!DOCTYPE html>
<html>
<head>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

response.setHeader("Pragma","no-cache");

response.setDateHeader("Expires",0);

if(session.getAttribute("block") == null){

response.sendRedirect("index1.jsp");

}

%>
 <%String id=request.getParameter("id");

	
  Customer cus=null;
  	for(Customer cs:Customer.customer_obj_list){
  		if(cs.getCustomerId().equalsIgnoreCase(id)){
  			cus=cs;
  		}
  		
  	}
  
  	%>
<title>Restaurant Table Booking Application</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
<style>
body {
  background-color: #242333;
  color: #fff;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  
  font-family: "Lato", sans-serif;
  margin: 0;
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
	.cent{
	margin-left:500px;
	
  width: 60%;
  padding: 10px;
	}

</style>
<script>
window.setTimeout(function() {
    $(".alert").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove(); 
    });
}, 4000);
</script>
</head>
<body id="myPage">

<nav class="w3-sidebar w3-bar-block w3-white w3-card w3-animate-left w3-xxlarge" style="display:none;z-index:2" id="mySidebar">
 
</nav>

<!-- Navbar -->
<div class="w3-top">

 <div class="w3-bar w3-theme-d2 w3-left-align">
 
  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-hover-white w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
  
  
  
 
   
 <a class="w3-bar-item w3-button w3-hide-small w3-hover-white " style="background-color:#F7CA3E;color:black; border-radius:50px;" >Restaurant<lable style="color:red;">.</lable></a>
 
   
    
   
  <a href="CustomerHomePage.jsp" class="w3-bar-item w3-button "  style=" border-radius:50px;"></i>Home</a>
  <a href="ViewBooking.jsp?id=<%=cus.getCustomerId()%>" class="w3-bar-item w3-button w3-hide-small w3-hover-white" style="background-color:#F7CA3E;color:black; border-radius:50px;" >View Booking</a>
  <a href="HistoryBooking.jsp?id=<%=cus.getCustomerId()%>" class="w3-bar-item w3-button w3-hide-small w3-hover-white" style="border-radius:50px;">History</a>

     <div class="w3-dropdown-hover w3-hide-small w3-right" style="background-color:#F7CA3E;color:black; border-radius:50px;" >
   <img src="https://mdbcdn.b-cdn.net/img/new/avatars/2.webp" class="rounded-circle" style="width: 39px;"
  alt="Avatar" />
    <a class="w3-button" title="Notifications"><%=cus.getName() %></a>     
  
  
    <div class="w3-dropdown-content ">
    <a href="CustomerProfileUpdate.jsp" class="w3-bar-item w3-button">Profile</a>
    	
    	<form action="blocklk">
      <button type="submit" class="w3-bar-item w3-button">Log Out</button>
  </form>
    </div>
  </div>
  
    </div>
   <%String upset=(String)session.getAttribute("CancelBook"); 
 				if(upset!=null){%>
 			<div class="alert alert-success" role="alert">
  			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  			<strong>Success!</strong> Ticket Cancelled successfully!
			</div>
      		 
        	<%}session.setAttribute("CancelBook",null);
        	%>
</div>
   
 
  <div class="w3-content" style="max-width:1100px">
  
<!-- Image Header -->
<!-- Team Container -->
<div class="w3-container w3-padding-64 w3-center" id="team">
<h2 style="font-family: 'Oswald', sans-serif;">View Booking</h2>

</div>

 
  <div >
				
				 <div class="w3-row-padding ">
				
	<%
	int id1=0;
		Booking s=new Booking();
	      for(Booking bk:s.bookingobjlist){
	    	  
	    	  if(bk.getCustomerId().equalsIgnoreCase(cus.getCustomerId()) && bk.getOrder_status()==1){
	    	 	id1+=1;
	      %>
 
	<div class="w3-col l3 m6 w3-margin-bottom">
	<img src="p1.jpg" alt="John" style="width:100%">
	<h3><%=bk.getRes_name()%> Restaurant</h3>
	<p class="w3-opacity">Order ID : <%=bk.getOrder_id() %></p>
	<p>Date : <%=bk.getNextdate()%></p>
	<p>Address : <%=bk.getRes_address()%></p>
	<p>Table Seats : <%=bk.getUser_choice_seats()%></p>
	<p>Amount : <%=bk.getBillamount()%></p>
	<p>Payment Status : <%=bk.getPaymentstatus()%></p>
	<br>
	<p><a href="CancelAlertBooking.jsp?id=<%=bk.getOrder_id() %>"><button class="w3-button w3-block" style="background-color: red;
  color: white;">Cancel Booking</button></a></p>
	</div>
	
	

<% }
	    	  } %>


</div>
  


		</div> 

  
  </div>


</body>
</html>
