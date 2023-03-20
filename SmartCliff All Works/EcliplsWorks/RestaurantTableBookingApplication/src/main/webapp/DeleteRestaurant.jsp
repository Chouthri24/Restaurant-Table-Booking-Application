<%@ page import="com.persondetails.*" %>
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
            <style>
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
        
              				<a href="AdminHomePage.jsp">
      <button  class="button button2" >Back</button>
    </a> </div>
        </div>
 
    </header>
 	<form >
    <div class="main-container">
        
        <div class="main">
 			
 				 <div class="col-sm-6">
           
                <center><h1>Delete Restaurant</h1><br></center>
                <div class="container">
                    <div class="split left">
                        <label for="fname">User_ID </label><br>
                    <input class="inputfield" type="text" id="Resid" name="Resid" placeholder="User ID"/><br>
                    <span id="error1_1" style="color: #ff0505;"></span>
                    <span id="error1_2" style="color: #05ff97;"></span><br>
                    </div>
                    <div class="split right">
                        <label for="email_id_signup">Restaurant_Name</label><br>
                        <input class="inputfield" type="text" id="ResName" name="ResName" placeholder="Restaurant Name"/><br>
                        <span id="error2_1" style="color: #ff0505;"></span>
                        <span id="error2_2" style="color: #05ff97;"></span><br>
                    </div>
                    <div class="split right">
                        <label for="email_id_signup">User_Email_ID</label><br>
                        <input class="inputfield" type="text" id="ResEmail" name="ResEmail" placeholder="Email id"/><br>
                        <span id="error2_1" style="color: #ff0505;"></span>
                        <span id="error2_2" style="color: #05ff97;"></span><br>
                    </div>
                    <br>
                </div><br>
                <br>
                
                <div class="container">
                    <center> <button type="Submit" class="button button2" value="submit" onclick="fieldValidation2()" >Delete</button></center>
                	
                </div>
                </div>
          </div>
   </div>
   </form>
        <div class="main">
		<div class="report-container">
                <div class="report-header">
                    <h1 class="recent-Articles">Restaurant List</h1>
                    <div class="searchbar">
                  
            <input type="text" name="searchlist"
                   placeholder="Search">
            <div class="searchbtn">
              <img src=
"https://media.geeksforgeeks.org/wp-content/uploads/20221210180758/Untitled-design-(28).png"
                    class="icn srchicn"
                    alt="search-icon">
              </div>
              
        </div>
                   
                </div>
                
 
 				<table class="report-body">
 				
 				<thead >
 				<tr  class="report-topic-heading">
 				     <th><h3 class="t-op">User_ID</h3></th> 
                       <th><h3 class="t-op">Name</h3></th> 
                       <th><h3 class="t-op">Email_ID</h3></th> 
                       <th><h3 class="t-op"> Contact_No</h3></th> 
                       <th><h3 class="t-op">Manager_Name</h3></th> 
                       <th> <h3 class="t-op">Status</h3></th>
                       </tr>
 			  	
 				
 				</thead>
 				<tbody class="items">
 					
                     <%	        
 						
                     for(Restaurant res:Restaurant.restaurant_obj_list){
                    	 String isactive;
 							if(res.getRestaurant_isActive()==1){
 								isactive="ACTIVE";
 							}
 							else{
 								isactive="INACTIVE";
 							}
 					%>
 					<tr class="item1">

                           <td> <h3 class="t-op-nextlvl"><%= res.getRestaurantID()%></h3></td> 
                            <td> <h3 class="t-op-nextlvl"><%=res.getName() %></h3></td> 
                           <td>  <h3 class="t-op-nextlvl"><%=res.getEmail_id() %></h3></td> 
                         <td> <h3 class="t-op-nextlvl"><%=res.getContact_no() %></h3></td> 
                         <td> <h3 class="t-op-nextlvl"><%=res.getName()%></h3></td> 
                           <td>  <h3 class="t-op-nextlvl lavel-tag"><%=isactive%></h3></td> 
                         </tr>
                    <%
 					}%>
                    
                    
 				
 				
 				</tbody>
   				
                    
                   
                    </table>
 					
                    
                </div>
            </div>
       
</body>
</html>