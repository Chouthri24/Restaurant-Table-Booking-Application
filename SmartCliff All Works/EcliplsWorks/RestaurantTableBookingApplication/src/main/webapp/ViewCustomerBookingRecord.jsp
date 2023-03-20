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
    <title>Restaurant</title>
    <link rel="stylesheet"
          href="AdminMain.css">
    <link rel="stylesheet"
          href="ResponseAdmin.css">
          
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
                
                    <h1 class="recent-Articles">Booking List</h1>
                     
                    <div class="searchbar">
            <input type="text"
                  placeholder="Search for Date.."id="myInput" onkeyup="myFunction()">
            <div class="searchbtn">
            
              <img src=
"https://media.geeksforgeeks.org/wp-content/uploads/20221210180758/Untitled-design-(28).png"
                    class="icn srchicn"
                    alt="search-icon">
              </div>
        </div>
                   
                </div>
                
 
 				<table class="report-body"  id="myTable">
 				
 				<thead >
 				<tr  class="report-topic-heading">
 				     <th><h3 class="t-op"style="width: 25px;text-align: left;" >Order_ID</h3></th> 
                       <th><h3 class="t-op"style="width: 50px;text-align: left;" >Date</h3></th> 
                       <th><h3 class="t-op"style="width: 40px;text-align: left;" >Name</h3></th> 
                       <th><h3 class="t-op"style="width: 80px;text-align: left;" >Email_ID</h3></th> 
                       <th><h3 class="t-op"style="width: 95px;text-align: left;" > Contact_No</h3></th> 
                       <th><h3 class="t-op"style="width: 65px;text-align: left;" >Seats</h3></th> 
                       <th> <h3 class="t-op"style="width: 50px;text-align: left;" >Bill Amount</h3></th>
                        <th> <h3 class="t-op" style="width: 100px;text-align: left;" >Status</h3></th>
                       </tr>
 			  	
 				
 				</thead>
 				   
 				<tbody class="items">
 					
                     <%	        
 					 List<Booking> list=ConnectionProvider.bookingGetObjOperationjsp();
                     int ids=0;
                     for(Booking res:list){
                    	
                    	 String isactive;
 							if(obj1.resmainobj.getRestaurantID().equalsIgnoreCase(res.getRes_id()) && res.getOrder_status()==1){
 								
 								 ids++;
 								isactive="ACTIVE";
 							
 							
 					%>
 					<tr class="item1" id=<%=ids%>>

                           <td> <h3 class="t-op-nextlvl row-data" style="width: 60px;text-align: left;" scope="row" name="testParam"><%= res.getOrder_id()%></h3></td>
                           <td style="width: 7px;">&nbsp;</td> 
                           <%DateTimeFormatter fb=DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
                                String da=res.getNextdate().format(fb); %>
                            <td> <h3 class="t-op-nextlvl row-data" style="width: 70px;text-align: left;" ><%=da%></h3></td> 
                            <td style="width: 7px;">&nbsp;</td>
                              <td> <h3 class="t-op-nextlvl" style="width: 70px;text-align: left;" ><%=res.getCustomername()%></h3></td> 
                            <td style="width: 7px;">&nbsp;</td>
                           <td>  <h3 class="t-op-nextlvl" style="width: 150px;text-align: left;" ><%=res.getCustomerEmailid() %></h3></td> 
                           <td style="width: 7px;">&nbsp;</td>
                         <td> <h3 class="t-op-nextlvl" style="width: 80px;text-align: left;" ><%=res.getCustomerphoneno() %></h3></td> 
                         <td style="width: 7px;">&nbsp;</td>
                         
                         <td> <h3 class="t-op-nextlvl" style="width: 150px;text-align: left;" ><%=res.user_choice_seats %></h3></td> 
                         <td style="width: 7px;">&nbsp;</td>
                         <td> <h3 class="t-op-nextlvl" style="width: 50px;text-align: left;" ><%=res.getBillamount()%></h3></td> 
                         <td style="width: 7px;">&nbsp;</td>
                       
                           <td>  <h3 class="t-op-nextlvl lavel-tag" style="width: 90px;padding: 5px;text-align: left;" ><%=isactive%></h3></td> 
                           <td style="width: 7px;">&nbsp;</td>
                           <%} %>
                          
                    
                    </tr>
                    <%} %>
 				
 				</tbody>
   				
   				
                    
                   
                    </table>
 					
                    
                </div>
		</div>
	
  
</body>
</html>