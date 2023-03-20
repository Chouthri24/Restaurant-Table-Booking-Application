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
          <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

response.setHeader("Pragma","no-cache");

response.setDateHeader("Expires",0);

if(session.getAttribute("block") == null){

response.sendRedirect("index1.jsp");

}

%>
<style>

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
  <%Restaurant res=null;
           CustomerAccountServletSignin obj1=new CustomerAccountServletSignin();
           			for(Restaurant rs:Restaurant.restaurant_obj_list){
           				if(rs.getRestaurantID().equalsIgnoreCase(obj1.resmainobj.getRestaurantID())){
           					res=rs;
           				}
           			}
           %>
   
    <!-- for header part -->
   
 
 
 
 <div class="w3-top logosec">
 <div class="w3-bar w3-theme-d2 w3-left-align">
  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-hover-white w3-theme-d2 logo2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
   <a href="#team" class="w3-bar-item w3-button w3-hide-small w3-hover-white w3-teal"><%=res.getRestaurantName() %> Restaurant</a>
  <a href="RestaurantHomePage.jsp" class="w3-bar-item w3-button "><i class="fa fa-home w3-margin-right "></i>Home</a>
 
  <a href="RestaurantHomePage.jsp" class="w3-bar-item w3-button w3-hide-small w3-right w3-hover-teal">Back</a>
 </div>
</div>
 
        
 
        
  <label style="font-size:40px;margin-top:50px;"><%=res.getRestaurantName() %> Restaurant Seat Arrangement </label><br>
  
 
       
<div class="movie-container">

      <label> Table Arrangement:</label>
      <select id="movie" name="movie">
        <option value=<%=res.tables.getBasictableseatamount() %>>Basic Seat(RS.<%=res.tables.getBasictableseatamount() %>)</option>
        <option value=<%=res.tables.getPremiumtableseatamount() %>>Premium Seat(RS.<%=res.tables.getPremiumtableseatamount() %>)</option>
      </select>
    </div>

    <ul class="showcase">
      <li>
        <div class="seat"></div>
        <small>Available</small>
      </li>
      <li>
        <div class="seat selected"></div>
        <small>Selected</small>
      </li>
      <li>
        <div class="seat sold"></div>
        <small>Sold</small>
      </li>
    </ul>
    
    
    
    
    
    
    <div  class="container">
  <br>  <label style="font-size:30px";> Basic Table Seats </label>
			<%int c=res.tables.tableSeats.getBasictableseatcount();
				int r=res.tables.tableSeats.getBasictablecount()*3;
					
					int flag=1,flag1=1,flag2=1;
					for(Map.Entry hashobj: res.tables.tableSeats.basicseatobj.entrySet()){
					
					c--;
					if(r>res.tables.tableSeats.getBasictablecount()*2 && res.tables.tableSeats.getBasictablecount()*3 >=r ){
						if(r==res.tables.tableSeats.getBasictablecount()*3){
							if(flag==1){
								%>
					 			 <br> <br>  <label> 10 AM to 12 PM :</label><br><br>
									<%
							System.out.println("div-open");
							%><div class="row"><% 
							flag=0;
							}
							if(c==0){
								%><div class="seat"></div><% 
								System.out.print(c);
								c=res.tables.tableSeats.getBasictableseatcount();
								r--;
								System.out.println("div-close");
								%></div><% 
								flag=1;
							}else{
								%><div class="seat"></div><% 
							System.out.print(c);
							}
						
					}else if(r!=(res.tables.tableSeats.getBasictablecount()*2)+1){
						if(flag==1){
							
							System.out.println("div-open");
							%><div class="row"><% 
							flag=0;
							}
							if(c==0){
								%><div class="seat"></div><% 
								System.out.print(c);
								c=res.tables.tableSeats.getBasictableseatcount();
								r--;
								System.out.println("div-close");
								%></div><% 
								flag=1;
								
							}else{
								%><div class="seat"></div><% 
							System.out.print(c);
							}
							
						}
						else{
							if(flag==1){
								System.out.println("div-open");
								%><div class="row"><% 
								flag=0;
								}
							if(c==0){
								%><div class="seat"></div><% 
								System.out.print(c);
								c=res.tables.tableSeats.getBasictableseatcount();
								r--;
								System.out.println();
								System.out.println("div-close");
								%></div><% 
								flag=1;
							}else{
								%><div class="seat"></div><% 
							System.out.print(c);
							}
						}
						
						
					}
					
					else if(r>res.tables.tableSeats.getBasictablecount() && res.tables.tableSeats.getBasictablecount()*2 >=r ){
						
						
						if(r==res.tables.tableSeats.getBasictablecount()*2){
							if(flag1==1){
								%>
					 			 <br> <br>  <label> 1 PM to 3 PM :</label><br><br>
									<%
							System.out.println("div-open");
							%><div class="row"><% 
							flag1=0;
							}
							if(c==0){
								%><div class="seat"></div><% 
								System.out.print(c);
								c=res.tables.tableSeats.getBasictableseatcount();
								r--;
								System.out.println("div-close");
								%></div><% 
								flag1=1;
							}else{
								%><div class="seat"></div><% 
							System.out.print(c);
							}
						
					}else if(r!=(res.tables.tableSeats.getBasictablecount()*1)+1){
						if(flag1==1){
							System.out.println("div-open");
							%><div class="row"><% 
							flag1=0;
							}
							if(c==0){
								%><div class="seat"></div><% 
								System.out.print(c);
								c=res.tables.tableSeats.getBasictableseatcount();
								r--;
								System.out.println("div-close");
								%></div><% 
								flag1=1;
								
							}else{
								%><div class="seat"></div><% 
							System.out.print(c);
							}
							
						}
						else{
							if(flag1==1){
								
								System.out.println("div-open");
								%><div class="row"><% 
								flag1=0;
								}
							if(c==0){
								%><div class="seat"></div><% 
								System.out.print(c);
								c=res.tables.tableSeats.getBasictableseatcount();
								r--;
								System.out.println();
								System.out.println("div-close");
								%></div><% 
								flag1=1;
							}else{
								%><div class="seat"></div><% 
							System.out.print(c);
							}
						}
						
					}
					else{
						
						if(r==res.tables.tableSeats.getBasictablecount()){
							if(flag2==1){
								%>
					 			 <br> <br>  <label> 8 PM to 11 PM :</label><br><br>
									<%
							System.out.println("div-open");
							%><div class="row"><% 
							flag2=0;
							}
							if(c==0){
								%><div class="seat"></div><% 
								System.out.print(c);
								c=res.tables.tableSeats.getBasictableseatcount();
								r--;
								System.out.println("div-close");
								%></div><% 
								flag2=1;
							}else{
								%><div class="seat"></div><% 
							System.out.print(c);
							}
						
					}else if(r!=1){
						if(flag2==1){
							System.out.println("div-open");
							%><div class="row"><% 
							flag2=0;
							}
							if(c==0){
								%><div class="seat"></div><% 
								System.out.print(c);
								c=res.tables.tableSeats.getBasictableseatcount();
								r--;
								System.out.println("div-close");
								%></div><% 
								flag2=1;
								
							}else{
								%><div class="seat"></div><% 
							System.out.print(c);
							}
							
						}
						else{
							if(flag2==1){
								System.out.println("div-open");
								
								%><div class="row"><% 
								flag2=0;
								}
							if(c==0){
								%><div class="seat"></div><% 
								System.out.print(c);
								c=res.tables.tableSeats.getBasictableseatcount();
								r--;
								System.out.println();
								System.out.println("div-close");
								%></div><% 
								flag2=1;
							}else{
								%><div class="seat"></div><% 
							System.out.print(c);
							}
						}
						
					}
					
					}
					
					
					
				 %>
  		
		
	
  <br>  <label style="font-size:30px";> Premium Table Seats </label>
			<%int c1=res.tables.tableSeats.getPremiumtableseatcount();
				int r1=res.tables.tableSeats.getPremiumtablecount()*3;
					
					int flag4=1,flag5=1,flag6=1;
					for(Map.Entry hashobj: res.tables.tableSeats.premiumseatobj.entrySet()){
					
					c1--;
					if(r1>res.tables.tableSeats.getPremiumtablecount()*2 && res.tables.tableSeats.getPremiumtablecount()*3 >=r1 ){
						if(r1==res.tables.tableSeats.getPremiumtablecount()*3){
							if(flag4==1){
								%>
					 			 <br> <br>  <label> 10 AM to 12 PM :</label><br><br>
									<%
							System.out.println("div-open");
							%><div class="row"><% 
							flag4=0;
							}
							if(c1==0){
								%><div class="seat"></div><% 
								System.out.print(c1);
								c1=res.tables.tableSeats.getPremiumtableseatcount();
								r1--;
								System.out.println("div-close");
								%></div><% 
								flag4=1;
							}else{
								%><div class="seat"></div><% 
							System.out.print(c1);
							}
						
					}else if(r1!=(res.tables.tableSeats.getPremiumtablecount()*2)+1){
						if(flag4==1){
							
							System.out.println("div-open");
							%><div class="row"><% 
							flag4=0;
							}
							if(c1==0){
								%><div class="seat"></div><% 
								System.out.print(c1);
								c1=res.tables.tableSeats.getPremiumtableseatcount();
								r1--;
								System.out.println("div-close");
								%></div><% 
								flag4=1;
								
							}else{
								%><div class="seat"></div><% 
							System.out.print(c1);
							}
							
						}
						else{
							if(flag4==1){
								System.out.println("div-open");
								%><div class="row"><% 
								flag4=0;
								}
							if(c1==0){
								%><div class="seat"></div><% 
								System.out.print(c1);
								c1=res.tables.tableSeats.getPremiumtableseatcount();
								r1--;
								System.out.println();
								System.out.println("div-close");
								%></div><% 
								flag1=1;
							}else{
								%><div class="seat"></div><% 
							System.out.print(c1);
							}
						}
						
						
					}
					
	else if(r1>res.tables.tableSeats.getPremiumtablecount() && res.tables.tableSeats.getPremiumtablecount()*2 >=r1 ){
						
						
						if(r1==res.tables.tableSeats.getPremiumtablecount()*2){
							if(flag5==1){
								%>
					 			 <br> <br>  <label> 1 PM to 3 PM :</label><br><br>
									<%
							System.out.println("div-open");
							%><div class="row"><% 
							flag5=0;
							}
							if(c1==0){
								%><div class="seat"></div><% 
								System.out.print(c1);
								c1=res.tables.tableSeats.getPremiumtableseatcount();
								r1--;
								System.out.println("div-close");
								%></div><% 
								flag5=1;
							}else{
								%><div class="seat"></div><% 
							System.out.print(c1);
							}
						
					}else if(r1!=(res.tables.tableSeats.getPremiumtablecount()*1)+1){
						if(flag5==1){
							System.out.println("div-open");
							%><div class="row"><% 
							flag5=0;
							}
							if(c1==0){
								%><div class="seat"></div><% 
								System.out.print(c1);
								c1=res.tables.tableSeats.getPremiumtableseatcount();
								r1--;
								System.out.println("div-close");
								%></div><% 
								flag5=1;
								
							}else{
								%><div class="seat"></div><% 
							System.out.print(c1);
							}
							
						}
						else{
							if(flag5==1){
								
								System.out.println("div-open");
								%><div class="row"><% 
								flag5=0;
								}
							if(c1==0){
								%><div class="seat"></div><% 
								System.out.print(c1);
								c1=res.tables.tableSeats.getPremiumtableseatcount();
								r1--;
								System.out.println();
								System.out.println("div-close");
								%></div><% 
								flag1=1;
							}else{
								%><div class="seat"></div><% 
							System.out.print(c1);
							}
						}
						
					}
					else{
						
						if(r1==res.tables.tableSeats.getPremiumtablecount()){
							if(flag6==1){
								%>
					 			 <br> <br>  <label> 8 PM to 11 PM :</label><br><br>
									<%
							System.out.println("div-open");
							%><div class="row"><% 
							flag6=0;
							}
							if(c1==0){
								%><div class="seat"></div><% 
								System.out.print(c1);
								c1=res.tables.tableSeats.getPremiumtableseatcount();
								r1--;
								System.out.println("div-close");
								%></div><% 
								flag6=1;
							}else{
								%><div class="seat"></div><% 
							System.out.print(c1);
							}
						
					}else if(r1!=1){
						if(flag6==1){
							System.out.println("div-open");
							%><div class="row"><% 
							flag6=0;
							}
							if(c1==0){
								%><div class="seat"></div><% 
								System.out.print(c1);
								c1=res.tables.tableSeats.getPremiumtableseatcount();
								r1--;
								System.out.println("div-close");
								%></div><% 
								flag6=1;
								
							}else{
								%><div class="seat"></div><% 
							System.out.print(c1);
							}
							
						}
						else{
							if(flag6==1){
								System.out.println("div-open");
								
								%><div class="row"><% 
								flag6=0;
								}
							if(c1==0){
								%><div class="seat"></div><% 
								System.out.print(c1);
								c1=res.tables.tableSeats.getPremiumtableseatcount();
								r1--;
								System.out.println();
								System.out.println("div-close");
								%></div><% 
								flag6=1;
							}else{
								%><div class="seat"></div><% 
							System.out.print(c1);
							}
						}
						
					}
					
					}
					
					
					
				 %>
  		
		
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    <p class="text">
      You have selected <span id="count">0</span> seat for a price of RS.<span
        id="total"
        >0</span
      >
    </p>
    
   
   <script>

const container = document.querySelector(".container");
const seats = document.querySelectorAll(".row .seat:not(.sold)");
const count = document.getElementById("count");
const total = document.getElementById("total");
const movieSelect = document.getElementById("movie");

populateUI();

let ticketPrice = +movieSelect.value;

// Save selected movie index and price
function setMovieData(movieIndex, moviePrice) {
  localStorage.setItem("selectedMovieIndex", movieIndex);
  localStorage.setItem("selectedMoviePrice", moviePrice);
}

// Update total and count
function updateSelectedCount() {
  const selectedSeats = document.querySelectorAll(".row .seat.selected");

  const seatsIndex = [...selectedSeats].map((seat) => [...seats].indexOf(seat));

  localStorage.setItem("selectedSeats", JSON.stringify(seatsIndex));

  const selectedSeatsCount = selectedSeats.length;

  count.innerText = selectedSeatsCount;
  total.innerText = selectedSeatsCount * ticketPrice;

  setMovieData(movieSelect.selectedIndex, movieSelect.value);
}


// Get data from localstorage and populate UI
function populateUI() {
  const selectedSeats = JSON.parse(localStorage.getItem("selectedSeats"));

  if (selectedSeats !== null && selectedSeats.length > 0) {
    seats.forEach((seat, index) => {
      if (selectedSeats.indexOf(index) > -1) {
        console.log(seat.classList.add("selected"));
      }
    });
  }

  const selectedMovieIndex = localStorage.getItem("selectedMovieIndex");

  if (selectedMovieIndex !== null) {
    movieSelect.selectedIndex = selectedMovieIndex;
    console.log(selectedMovieIndex)
  }
}
console.log(populateUI())
// Movie select event
movieSelect.addEventListener("change", (e) => {
  ticketPrice = +e.target.value;
  setMovieData(e.target.selectedIndex, e.target.value);
  updateSelectedCount();
});

// Seat click event
container.addEventListener("click", (e) => {
  if (
    e.target.classList.contains("seat") &&
    !e.target.classList.contains("sold")
  ) {
    e.target.classList.toggle("selected");

    updateSelectedCount();
  }
});

// Initial count and total set
updateSelectedCount();




$(document).ready(function(){
    $('#movie').on('change', function(){
    	var demovalue = $(this).val(); 
        $("div.myDiv").hide();
        $(demovalue).show();
    });
});
   </script>

	
             
	
  
</body>
</html>