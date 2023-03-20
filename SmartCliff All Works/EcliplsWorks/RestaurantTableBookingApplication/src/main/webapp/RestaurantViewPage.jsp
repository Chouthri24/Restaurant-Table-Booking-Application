<%@ page import="com.main.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.persondetails.*" %>
<!DOCTYPE html>
<html>
<head>
 <%String id=request.getParameter("id");
  Restaurant res=null;
  	for(Restaurant rs:Restaurant.restaurant_obj_list){
  		if(rs.getRestaurantID().equalsIgnoreCase(id)){
  			res=rs;
  		}
  	}%>
<title><%=res.getRestaurantName() %> Restaurant</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
</head>
<body id="myPage">





<!-- Navbar -->
<div class="w3-top">
 <div class="w3-bar w3-theme-d2 w3-left-align">
  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-hover-white w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
   <a href="RestaurantViewPage.jsp?id=<%=id %>" class="w3-bar-item w3-button w3-hide-small w3-hover-white " style="background-color:#F7CA3E;color:black; border-radius:50px;" ><%=res.getRestaurantName() %> Restaurant <lable style="color:red;">.</lable></a>
  
  <a href="CustomerHomePage.jsp" class="w3-bar-item w3-button " style="border-radius:50px;" >Home</a>
  <a href="CustomerHomePage.jsp" class="w3-bar-item w3-button w3-hide-small " style=" border-radius:50px;" >Back</a>
 
 
 
 
 
 
 
 </div>

  <!-- Navbar on small screens -->
 

</div>

<!-- Header -->
<header class="w3-display-container w3-content w3-wide" style="max-width:1600px;min-width:500px" id="home">
  <img class="w3-image" src="resview1.jpg" alt="Hamburger Catering" width="1600" height="800">
  <div class="w3-display-bottomleft w3-padding-large w3-opacity">
    <h1 class="w3-xxlarge" style="color:white"><%=res.getRestaurantName()%> Restaurant</h1>
  </div>
</header>

<!-- Page content -->
<div class="w3-content" style="max-width:1100px">

  <!-- About Section -->
  <div class="w3-row w3-padding-64" id="about">
    <div class="w3-col m6 w3-padding-large w3-hide-small">
     <img src="tablesetting2.jpg" class="w3-round w3-image w3-opacity-min" alt="Table Setting" width="600" height="750">
    </div>

    <div class="w3-col m6 w3-padding-large">
      <h1 class="w3-center">About Catering</h1><br>
      <h5 class="w3-center">Tradition since 1889</h5>
      <p class="w3-large">The Catering was founded in Blabla by Mr. Smith is a pain in the ass, he is pursuing a career in pursuit of a career in college, but at the same time they fall into a great deal of pain and suffering. For to come to the smallest detail, no one should practice any kind of work unless he derives some benefit from it. Duis aute iruredolor in reprehenerit in pleasure he wants to be a hair from the pain eu no pariatur. We only use <span class="w3-tag w3-light-grey">seasonal</span> ingredients.</p>
      <p class="w3-large w3-text-grey w3-hide-medium">Unless they are blinded by desire, they do not come out, they are in fault who abandon their duties, the mind softens, that is to say, it is the result of hardships, but they are just as time-consuming as some great work and pain. For to come to the smallest detail, no one should practice any kind of work unless he derives some benefit from it.</p>
    </div>
  </div>
  
  <hr>
  <%
  String fd=res.getFooditems().getFoodName();
  String item[]=fd.split(","); 
 %>
  <!-- Menu Section -->
  <div class="w3-row w3-padding-64" id="menu">
    <div class="w3-col l6 w3-padding-large">
      <h1 class="w3-center">Our Menu</h1><br>
      <h4><%=item[0] %> Bread Basket</h4>
      <p class="w3-text-grey">Assortment of fresh baked fruit breads and muffins 5.50</p><br>
    
      <h4><%=item[1] %> Honey Almond Granola with Fruits</h4>
      <p class="w3-text-grey">Natural cereal of honey toasted oats, raisins, almonds and dates 7.00</p><br>
    
      <h4><%=item[2] %>  Belgian Waffle</h4>
      <p class="w3-text-grey">Vanilla flavored batter with malted flour 7.50</p><br>
    
      <h4><%=item[3] %> Scrambled eggs</h4>
      <p class="w3-text-grey">Scrambled eggs, roasted red pepper and garlic, with green onions 7.50</p><br>
    
      <h4><%=item[4] %> Blueberry Pancakes</h4>
      <p class="w3-text-grey">With syrup, butter and lots of berries 8.50</p>    
    </div>
    
    
    <div class="w3-col l6 w3-padding-large">
      <img src="tablesetting.jpg" class="w3-round w3-image w3-opacity-min" alt="Menu" style="width:100%">
    </div>
  </div>

  <a class="block" href="TableShowPage.jsp?id=<%=id%>">Book Seats</a> 
  
 
  <!-- Contact Section -->
  <div class="w3-container w3-padding-64" id="contact">
    <h1>Contact</h1><br>
    <p>We offer full-service catering for any event, large or small. We understand your needs and we will cater the food to satisfy the biggerst criteria of them all, both look and taste. Do not hesitate to contact us.</p>
    <p class="w3-text-blue-grey w3-large"><b><%=res.getRestaurantAddress() %></b></p>
    <p>You can also contact us by phone <%=res.getContact_no() %> or email <%=res.getEmail_id() %>, or you can send us a message here:</p>
    
  </div>
  
<!-- End page content -->
</div>

<!-- Footer -->


</body>
</html>
