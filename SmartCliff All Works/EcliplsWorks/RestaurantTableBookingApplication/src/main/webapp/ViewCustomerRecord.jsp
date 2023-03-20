<%@ page import="com.main.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.persondetails.*" %>
<%@ page import="java.util.*" %>
<%Customer obj=new Customer(); %>
<!DOCTYPE html>
<html lang="en">
 
<head>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

response.setHeader("Pragma","no-cache");

response.setDateHeader("Expires",0);

if(session.getAttribute("block") == null){

response.sendRedirect("index1.jsp");

}

%>
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
         .btnback {
	color: rgb(246, 234, 19);
	background: rgba(0, 0, 0, 0.8);
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
        
         
         
         </style>
</head>
 
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
                    <h1 class="recent-Articles">Customer List</h1>
                    
                             <div class="searchbar">
            <input type="text"
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
 					<thead>
 						<tr class="report-topic-heading">
 							<th><h3 class="t-op">ID</h3></th>
 							<th> <h3 class="t-op">Name</h3></th>
 							<th><h3 class="t-op">Email ID</h3></th>
 							<th><h3 class="t-op">Contact No</h3></th>
 							<th> <h3 class="t-op">Address</h3></th>
 							<th><h3 class="t-op">Status</h3></th>
 							
 						</tr>
 					
 					</thead>
 					<tbody class="items">
 						 <%	        
 						 
 						 List<Customer> list=ConnectionProvider.customerAccountGetObjOperationjsp();
                     for(Customer res:list){
                    	
                    	 String isactive;
 							if(res.getIsActive()==1){
 								isactive="ACTIVE";
 							}
 							else{
 								isactive="INACTIVE";
 							}
 					%>
 						
 						<tr class="item1">
 							<td>  <h3 class="t-op-nextlvl"style="width: 50px; text-align: left;"><%= res.getCustomerId()%></h3></td>
 							<td style="width: 7px;">&nbsp;</td>
 							<td> <h3 class="t-op-nextlvl" style="width: 70px;text-align: left;" ><%=res.getName()%></h3></td>
 							<td style="width: 7px;">&nbsp;</td>
 							<td> <h3 class="t-op-nextlvl" style="width: 100px;text-align: left;" ><%=res.getEmail_id() %></h3></td>
 							<td style="width: 7px;">&nbsp;</td>
 							<td> <h3 class="t-op-nextlvl" style="width: 100px;text-align: left;" ><%=res.getContact_no() %></h3></td>
 							<td style="width: 7px;">&nbsp;</td>
 					
 							<td> <h3 class="t-op-nextlvl" style="width: 100px;text-align: left;" ><%=res.getAddress()%></h3></td>
 							<td style="width: 7px;">&nbsp;</td>
 							<td> <h3 class="t-op-nextlvl lavel-tag" style="width: 100px; padding: 5px; text-align: left;" ><%=isactive%></h3></td>
 							
 						</tr>
 						
 						 <%
 					}%>
 					</tbody>
 				
 				</table>
                
                        
   			</div>
   		</div>
   				
 	
               
</body>
</html>