<%@ page import="com.main.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.persondetails.*" %>
<!DOCTYPE html>
<html lang="en">
 
<head>
	 <%

if(session.getAttribute("block") == null){

response.sendRedirect("IndexPage.jsp");

}

%>
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
 	<style>
 		.addu{
 			width:200px;
 		}
 		.lavel-tag2 {
  width: 100px;
  text-align: center;
  background-color:#d11a2a;
  color: white;
  border-radius: 4px;
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


window.setTimeout(function() {
    $(".alert").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove(); 
    });
}, 4000);
</script>
<body>


    <!-- for header part -->
    <header>
 
        <div class="logosec">
            <div class="logo">ADMIN</div>
        </div>
 		
 			<%String addres=(String)session.getAttribute("addrestaurant"); 
 				if(addres!=null){%>
 			<div class="alert alert-success" role="alert">
  			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  			<strong>Success!</strong> New Restaurant Account Added successfully!
			</div>
      		
        	<%}session.setAttribute("addrestaurant",null);
        	%>
        	
        	<%String adres=(String)session.getAttribute("addup"); 
 				if(adres!=null){%>
 			<div class="alert alert-success" role="alert">
  			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  			<strong>Success!</strong>Restaurant Account Updated successfully!
			</div>
      		
        	<%}session.setAttribute("addup",null);
        	%>
        	
        	<%String delres=(String)session.getAttribute("deleterestaurant"); 
 				if(delres!=null){%>
 			<div class="alert alert-danger" role="alert">
  			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  			<strong>Success!</strong>Restaurant Account Deleted successfully!
			</div>
      		 <div>
        	<%}session.setAttribute("deleterestaurant",null);
        	%>
        	<%String actres=(String)session.getAttribute("activaterestaurant"); 
 				if(actres!=null){%>
 			<div class="alert alert-success" role="alert">
  			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  			<strong>Success!</strong>Restaurant Account Activated successfully!
			</div>
      		 <div>
        	<%}session.setAttribute("activaterestaurant",null);
        	%>
              				<a href="AdminHomePage.jsp">
      <button  class="button button2" >Back</button>
    </a>
              </div>
        </header>
        <div class="main">
		<div class="report-container">
                <div class="report-header">
                    <h1 class="recent-Articles">Restaurant List</h1>
                     <a href="AddRestaurant.jsp">  <button class="button addu">Add Restaurant</button></a>
                   
                    <div class="searchbar">
            <input type="text"
                  placeholder="Search for Names.."id="myInput" onkeyup="myFunction()">
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
 				     <th><h3 class="t-op"style="width: 10px;text-align: left;" >User_ID</h3></th> 
                       <th><h3 class="t-op"style="width: 50px;text-align: left;" >Name</h3></th> 
                       <th><h3 class="t-op"style="width: 80px;text-align: left;" >Location</h3></th> 
                       <th><h3 class="t-op"style="width: 80px;text-align: left;" >Email_ID</h3></th> 
                       <th><h3 class="t-op"style="width: 95px;text-align: left;" > Contact_No</h3></th> 
                       <th><h3 class="t-op"style="width: 80px;text-align: left;" >Manager_Name</h3></th> 
                       <th> <h3 class="t-op"style="width: 30px;text-align: left;" >Status</h3></th>
                        <th> <h3 class="t-op" style="width: 100px;text-align: left;" >More Details</h3></th>
                       </tr>
 			  	
 				
 				</thead>
 				   
 				<tbody class="items">
 					
                     <%	        
 					 List<Restaurant> list=ConnectionProvider.restaurantAccountGetObjOperationjsp();
                     int ids=0;
                     for(Restaurant res:list){
                    	 ids++;
                    	 String isactive;
 							if(res.getRestaurant_isActive()==1){
 								isactive="ACTIVE";
 							}
 							else{
 								isactive="INACTIVE";
 							}
 							
 					%>
 					<tr class="item1" id=<%=ids%>>

                           <td> <h3 class="t-op-nextlvl row-data" style="width: 10px;text-align: left;" scope="row" name="testParam"><%= res.getRestaurantID()%></h3></td>
                           <td style="width: 7px;">&nbsp;</td> 
                            <td> <h3 class="t-op-nextlvl row-data" style="width: 50px;text-align: left;" ><%=res.getRestaurantName()%></h3></td> 
                            <td style="width: 7px;">&nbsp;</td>
                              <td> <h3 class="t-op-nextlvl" style="width: 50px;text-align: left;" ><%=res.getRestaurantLocation() %></h3></td> 
                            <td style="width: 7px;">&nbsp;</td>
                           <td>  <h3 class="t-op-nextlvl" style="width: 100px;text-align: left;" ><%=res.getEmail_id() %></h3></td> 
                           <td style="width: 7px;">&nbsp;</td>
                         <td> <h3 class="t-op-nextlvl" style="width: 100px;text-align: left;" ><%=res.getContact_no() %></h3></td> 
                         <td style="width: 7px;">&nbsp;</td>
                         <td> <h3 class="t-op-nextlvl" style="width: 80px;text-align: left;" ><%=res.getName()%></h3></td> 
                         <td style="width: 7px;">&nbsp;</td>
                         <%if(isactive.equalsIgnoreCase("ACTIVE")) {%>
                           <td>  <h3 class="t-op-nextlvl lavel-tag" style="width: 90px;padding: 5px;text-align: left;" ><%=isactive%></h3></td> 
                           <td style="width: 7px;">&nbsp;</td>
                           <%}else{ %>
                                 <td>  <h3 class="t-op-nextlvl lavel-tag2" style="width: 90px;padding: 5px;text-align: left;" ><%=isactive%></h3></td> 
                           <td style="width: 7px;">&nbsp;</td>
                           <%} %>
                           
                           
                           <td> <a class="t-op-nextlvl material-icons" style="width: 50px;text-align: left;"
 								  href="ResMoreDetails.jsp?id=<%=res.getRestaurantID()%>"><img src="mored.png"

                    class="icn srchicn"
                    alt="search-icon"></a></td>
                  
                    
                    </tr>
                    <%} %>
 				
 				</tbody>
   				
                    
                   
                    </table>
 					
                    
                </div>
            </div>
  
    
</body>
</html>