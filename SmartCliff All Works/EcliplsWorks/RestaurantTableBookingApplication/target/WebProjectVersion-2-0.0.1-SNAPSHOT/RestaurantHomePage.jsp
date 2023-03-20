<%@ page import="com.persondetails.*" %>
<%@ page import="com.booking.*" %>
<%@ page import="com.registerationcontroller.*" %>
<!DOCTYPE html>
<html lang="en">
 
<head>
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
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
       
       </head>
       <%

if(session.getAttribute("block") == null){

response.sendRedirect("IndexPage.jsp");

}

%>
<style>
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

.alert {
  padding: 15px;
  margin-bottom: 20px;
  border: 1px solid transparent;
  border-radius: 4px;
}
.alert-success {
  background-color: #dff0d8;
  border-color: #d6e9c6;
  color: #3c763d;
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
 
<body>
   
    <!-- for header part -->
    <header2>
 
        <div class="logosec" >
            <%CustomerAccountServletSignin obj1=new CustomerAccountServletSignin();%>
            <div class="logo2"><h3><%=obj1.resmainobj.getRestaurantName()%> Restaurant</h3></div>
            
        </div>
 
        <%String uppro=(String)session.getAttribute("updateprofileres"); 
 				if(uppro!=null){%>
 			<div class="alert alert-success" role="alert">
 			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  			
  			<strong>Success!</strong> Profile Updated successfully!
			</div>
      		 
        	<%}session.setAttribute("updateprofileres",null);
        	%>
        	
        	 <%String upset=(String)session.getAttribute("updatesettingres"); 
 				if(upset!=null){%>
 			<div class="alert alert-success" role="alert">
  			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  			<strong>Success!</strong> Setting Updated successfully!
			</div>
      		 
        	<%}session.setAttribute("updatesettingres",null);
        	%>
 
        <div class="message" >
            <div class="circle"></div>
            <img src=
"https://media.geeksforgeeks.org/wp-content/uploads/20221210183322/8.png"
                 class="icn"
                 alt="">
            
        </div>
 
    </header2>
 
    <div class="main-container" style="background-color:#A9A9A9">
        <div class="navcontainer" style="background-color:#A9A9A9">
            <nav class="nav" style="background-color:#A9A9A9">
                <div class="nav-upper-options">
                    <div class="nav-option option2">
                        <img src=
"https://media.geeksforgeeks.org/wp-content/uploads/20221210182148/Untitled-design-(29).png"
                            class="nav-img"
                            alt="dashboard">
                        <h3> Dashboard</h3>
                    </div>
                    <a href="RestaurantProfile.jsp"><button style="background-color: transparent;box-shadow: 0 6px 6px rgba(0, 0, 0, 0.6);">
                   
                    <div class="nav-option option5">
                        <img src=
"https://media.geeksforgeeks.org/wp-content/uploads/20221210183323/10.png"
                            class="nav-img"
                            alt="blog">
                        <h3> Profile</h3>
                    </div>
 						</button></a>
 						
 						
 						
 						 <a href="RestaurantTableViewSetting.jsp"><button style="background-color: transparent;box-shadow: 0 6px 6px rgba(0, 0, 0, 0.6);">
                   
                    <div class="nav-option option6">
                        <img src=
"https://media.geeksforgeeks.org/wp-content/uploads/20221210183320/4.png"
                            class="nav-img"
                            alt="settings">
                        <h3>Seat Structure</h3>
                    </div>
                    </button></a>
 						
 						
 						
 						
 						
 						
 						 <a href="RestaurantSettings.jsp"><button style="background-color: transparent;box-shadow: 0 6px 6px rgba(0, 0, 0, 0.6);">
                   
                    <div class="nav-option option6">
                        <img src=
"https://media.geeksforgeeks.org/wp-content/uploads/20221210183320/4.png"
                            class="nav-img"
                            alt="settings">
                        <h3> Settings</h3>
                    </div>
                    </button></a>
                    <form action="blocklk">
 				<button type="submit" style="background-color: transparent;box-shadow: 0 6px 6px rgba(0, 0, 0, 0.6);">
                    <div class="nav-option logout">
                        <img src=
"https://media.geeksforgeeks.org/wp-content/uploads/20221210183321/7.png"
                            class="nav-img"
                            alt="logout">
                        <h3>Logout</h3>
                    </div>
 					</button>
 					</form>
                </div>
            </nav>
        </div>
        <div class="main" style="background-color:#F7E371">
 
            <div class="box-container" >
              <%int count=0; %>
                    <%for(Booking ob:Booking.bookingobjlist) {
                    		if(ob.getRes_id().equalsIgnoreCase(obj1.resmainobj.getRestaurantID()) && ob.getOrder_status()==1){
                   	 
                        		count+=1;
                        		%>
                        
                        <%}} if(count!=0){%>
                        
 				
 				<a href="ViewCustomerBookingRecord.jsp" >
 				<%}else{ %>
 				<a>
 				<%} %>
 				
                <div class="box box1" style="background-color:#FFFFFF" >
                
                 <div class="text">
                    
                  
                       
                        <h2 class="topic-heading" style="color: black"><%= count %></h2>
                        <h3 class="topic" style="color: black">Customer Booking</h3>
                    </div>
 
                    <img src=
"https://media.geeksforgeeks.org/wp-content/uploads/20221210183322/9.png"
                        alt="Views">
                </div>
                </a>
 				
          </div>
      
 </div>
	</div>
	
   
</body>
</html>