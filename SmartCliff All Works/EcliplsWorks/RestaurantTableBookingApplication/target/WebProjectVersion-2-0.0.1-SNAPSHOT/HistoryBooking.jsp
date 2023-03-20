

<%@ page import="com.main.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.persondetails.*" %>
<%@ page import="com.restaurantdetails.*" %>
<%@ page import="com.booking.*" %>
<!DOCTYPE html>
<html>
<head>
 <%String id=request.getParameter("id");

	
  Customer cus=null;
  	for(Customer cs:Customer.customer_obj_list){
  		if(cs.getCustomerId().equalsIgnoreCase(id)){
  			cus=cs;
  		}
  		
  	}
  
  	%>
  	
<title>Customer Login</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
/* width */
::-webkit-scrollbar {
  width: 20px;
}

/* Track */
::-webkit-scrollbar-track {
  box-shadow: inset 0 0 5px grey; 
  border-radius: 10px;
}
 
/* Handle */
::-webkit-scrollbar-thumb {
  background: red; 
  border-radius: 10px;
}
a:link {

text-decoration: none;

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
/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
  background: #b30000; 
}
</style>
<style>
.block:hover {
  background-color: #ddd;
  color: black;
}
.block {
  display: block;
  width: 100%;
  border: none;
  background-color: #3DCAB5;
  padding: 14px 28px;
  font-size: 16px;
  cursor: pointer;
  text-align: center;
}
</style>
 <style>
      @import url("https://fonts.googleapis.com/css?family=Lato&display=swap");

* {
  box-sizing: border-box;
}

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

.movie-container {
  margin:auto;
  
}

.movie-container select {
  background-color: #fff;
  border: 0;
  border-radius: 5px;
  font-size: 16px;
  margin-left: 10px;
  padding: 5px 15px 5px 15px;
  -moz-appearance: none;
  -webkit-appearance: none;
  appearance: none;
}

.container {
  perspective: 1000px;
  margin-bottom: 30px;
}

.seat {
  background-color: #444451;
  height: 26px;
  width: 32px;
  margin: 3px;
  font-size: 50px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}

.seat.selected {
  background-color: green;
}

.seat.sold {
  background-color: #fff;
}

.seat:nth-of-type(2) {
  margin-right: 18px;
}

.seat:nth-last-of-type(2) {
  margin-left: 18px;
}

.seat:not(.sold):hover {
  cursor: pointer;
  transform: scale(1.2);
}

.showcase .seat:not(.sold):hover {
  cursor: default;
  transform: scale(1);
}

.showcase {
  background: rgba(0, 0, 0, 0.1);
  padding: 5px 10px;
  border-radius: 5px;
  color: #777;
  list-style-type: none;
  display: flex;
  justify-content: space-between;
}

.showcase li {
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 0 10px;
}
.showcase li small {
  margin-left: 2px;
}

.row {
  display: flex;
}

.screen {
  background-color: #fff;
  height: 120px;
  width: 100%;
  margin: 15px 0;
  transform: rotateX(-48deg);
  box-shadow: 0 3px 10px rgba(255, 255, 255, 0.7);
}

p.text{
    margin: 5px 0;
}

p.text span{
    color: rgb(158, 248, 158);
}

    </style>
    
</head>
<%

if(session.getAttribute("block") == null){

response.sendRedirect("IndexPage.jsp");

}

%>
<body id="myPage">



<nav class="w3-sidebar w3-bar-block w3-white w3-card w3-animate-left w3-xxlarge" style="display:none;z-index:2" id="mySidebar">
 
</nav>

<!-- Navbar -->
<div class="w3-top">
 <div class="w3-bar w3-theme-d2 w3-left-align">
  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-hover-white w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
   <a class="w3-bar-item w3-button w3-hide-small w3-hover-white " style="background-color:#F7CA3E;color:white; border-radius:50px;"  ><%=cus.getName()%></a>
  <a href="CustomerHomePage.jsp" class="w3-bar-item w3-button " style=" border-radius:50px;"></i>Home</a>
  
   <a href="CustomerHomePage.jsp" class="w3-bar-item w3-button w3-hide-small w3-right"  style=" border-radius:50px;">Back</a>	 
 </div>
</div>
<div class="w3-content" style="max-width:1100px">
<div class="w3-container w3-padding-64 w3-center" id="team">
<h2 style="font-family: 'Oswald', sans-serif;">History</h2>

</div>



<div >
				
				 <div class="w3-row-padding">
	<%
	int id1=0;
		Booking s=new Booking();
	      for(Booking bk:s.bookingobjlist){
	    	  
	    	  if(bk.getCustomerId().equalsIgnoreCase(cus.getCustomerId())){
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
		<% if(bk.getOrder_status()==1){%>
	<p><a href=""><button class="w3-button  w3-block" style="background-color: green;
  color: white;">Confirmed</button></a></p>
	<%} %><% else if(bk.getOrder_status()==0){%>
	<p><a href=""><button class="w3-button w3-block" style="background-color: red;
  color: white;">Cancelled</button></a></p>
	<%} %>
	
	</div>

<% }
	    	  } %>


</div>
  


		</div>



</div>



</body>
</html>