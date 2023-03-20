<%@ page import="com.persondetails.*" %>
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
    <title>ADMIN</title>
    <link rel="stylesheet"
          href="AdminMain.css">
    <link rel="stylesheet"
          href="ResponseAdmin.css">
          
      
</head>
  <%CustomerAccountServletSignin obj1=new CustomerAccountServletSignin();
  					%> 
  <%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

response.setHeader("Pragma","no-cache");

response.setDateHeader("Expires",0);

if(session.getAttribute("block") == null){

response.sendRedirect("index1.jsp");

}

%>
<style>
	.msg{
	gap: 15px;
	}
</style>
 
<body>
   
    <!-- for header part -->
    <header>
 
        <div class="logosec">
            <div class="logo">ADMIN</div>
            
        </div>

        <div class="message msg">
            <div class="circle"></div>
            
            <div class="dp">
              <img src="adpro.jpg" class="rounded-circle" style="width: 39px;"
  alt="Avatar" />
  		
              </div>
            <label><%= obj1.admainobj.getName()%></label>
  		
        </div>
        
    </header>
 
    <div class="main-container">
        <div class="navcontainer">
            <nav class="nav">
                <div class="nav-upper-options">
                    <div class="nav-option option1">
                        <img src=
"https://media.geeksforgeeks.org/wp-content/uploads/20221210182148/Untitled-design-(29).png"
                            class="nav-img"
                            alt="dashboard">
                        <h3> Dashboard</h3>
                    </div>
                    <a href="AdminProfile.jsp"><button style="background-color: transparent;box-shadow: 0 6px 6px rgba(0, 0, 0, 0.6);">
                  
                    <div class="nav-option option5">
                        <img src=
"https://media.geeksforgeeks.org/wp-content/uploads/20221210183323/10.png"
                            class="nav-img"
                            alt="blog">
                        <h3> Profile</h3>
                    </div>
                    </button></a>
 					<a href="AdminSettings.jsp"><button style="background-color: transparent;box-shadow: 0 6px 6px rgba(0, 0, 0, 0.6);">
                  
                   
                    <div class="nav-option option6">
                        <img src=
"https://media.geeksforgeeks.org/wp-content/uploads/20221210183320/4.png"
                            class="nav-img"
                            alt="settings">
                        <h3> Settings</h3>
                    </div>
                      </button></a>
 					
 					<form action="blocklk">
 					
 					<button type="Submit" style="background-color: transparent;box-shadow: 0 6px 6px rgba(0, 0, 0, 0.6);">

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
        </div>
        <div class="main">
 
            <div class="box-container">
 				
 				<a href="ViewRestaurantRecord.jsp" >
 				
                <div class="box box1" >
                
                
                    <div class="text">
                   	 
                        <h2 class="topic-heading"><%= Restaurant.m-1 %></h2>
                        <h2 class="topic">Restaurant Account</h2>
                    </div>
 
                    <img src=
"https://media.geeksforgeeks.org/wp-content/uploads/20221210184645/Untitled-design-(31).png"
                        alt="Views">
                </div>
                </a>
 				
 				 <a href="ViewCustomerRecord.jsp">
                <div class="box box1" >
               
                    <div class="text"> 
                   
                        <h2 class="topic-heading"><%= Customer.n-1 %></h2>
                        <h2 class="topic">Customer Account</h2>
                    </div>
 
                    <img src=
                    "https://media.geeksforgeeks.org/wp-content/uploads/20221210184645/Untitled-design-(31).png"
                                            alt="Views">
                </div>
                </a>
          </div>
      
 </div>
	</div>
	
    <script src="./index.js"></script>
</body>
</html>