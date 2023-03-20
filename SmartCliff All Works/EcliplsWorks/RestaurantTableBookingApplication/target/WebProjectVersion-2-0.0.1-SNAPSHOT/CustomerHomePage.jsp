<%@ page import="com.main.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.persondetails.*" %>
<%@ page import="com.registerationcontroller.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.stream.Collectors" %>


<!DOCTYPE html>
<html lang="en">
<head>
<%

if(session.getAttribute("block") == null){

response.sendRedirect("IndexPage.jsp");

}

%>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant Table Booking Application</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@200;400;500&family=Roboto:wght@100;300;400;500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
   <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
   <style>
   .container .input{
	border: 0;
	outline: none;
	color: #8b7d77;
}

.search_wrap{
	width: 500px;
	margin: 38px auto;
}

.search_wrap .search_box{
	position: relative;
	width: 500px;
	height: 60px;
}

.search_wrap .search_box .input{
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	padding: 10px 20px;
	border-radius: 3px;
	font-size: 18px;
}

.search_wrap .search_box .btn{
	position: absolute;
	top: 0;
	right: 0;
	width: 60px;
	height: 100%;
	background: #7690da;
	z-index: 1;
	cursor: pointer;
}
.search_wrap.search_wrap_6 .search_box .input{
	border-radius: 50px;
	background-color:#F7CA3E;
}
.search_wrap.search_wrap_6 .search_box .btn,
.search_wrap.search_wrap_5 .search_box .btn{
	width: 125px;
	height: 45px;
	right: 5px;
	border-radius: 3px;
	color: #fff;
	display: flex;
	align-items: center;
	justify-content: center;
}

.search_wrap.search_wrap_6 .search_box .btn{
	border-radius: 25px;
	background-color:black;
}


.search_wrap.search_wrap_5 .search_box .input,
.search_wrap.search_wrap_6 .search_box .input{
	padding-right: 145px;
}

.search_wrap .search_box .btn:hover{
	background: gray;	
}

.search_wrap .search_box .btn.btn_common .fas{
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%,-50%);
	color: #fff;
	font-size: 20px;
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
 .text-center{
       margin-top: 20%;
       margin-left: 15%;
       width: 100%; 
       margin-right: 20%;
       position: relative;
        display: inline-block; 
        border-radius: 50px;
        padding:10px;
       color: yellow;
      
        z-index: 999;    
        text-align: center;
        top: 10%; /* Adjust this value to move the positioned div up and down */
        background: rgba(0, 0, 0, 0.8);
        
        color: #fff;
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
	

</style>
<script>
window.setTimeout(function() {
    $(".alert").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove(); 
    });
}, 4000);
</script>
       <style>
        :root{
    --yellow:#F7CA3E;
}

*{
    font-family: 'Roboto', sans-serif;
    margin:0; padding:0;
    box-sizing: border-box;
    text-decoration: none;
    outline: none; border:none;
    text-transform: capitalize;
    transition:all .2s linear;
}



*::selection{
    background:var(--yellow);
    color:#fff;
}

html{
    font-size: 62.5%;
    overflow-x: hidden;
}

body{
    overflow-x: hidden;
    /* height:200rem; */
}

html::-webkit-scrollbar{
    width:1.4rem;
}

html::-webkit-scrollbar-track{
    background:#333;
}

html::-webkit-scrollbar-thumb{
    background:var(--yellow);
}

section{
    min-height: 100vh;
    padding:1rem 10%;
    padding-top: 8.5rem;
}

.btn{
    font-size: 1.7rem;
    padding:.7rem 4rem;
    border-radius: 5rem;
    margin-top: 1rem;
    background:none;
    color:#333;
    cursor: pointer;
    border:.2rem solid var(--yellow);
}

.btn:hover{
    background:var(--yellow);
}

.heading{
    text-align: center;
    font-size: 4rem;
    padding:0 .5rem;
    color:#333;
}

.heading span{
    color:var(--yellow);
}

header{
    position: fixed;
    top:0; left:0;
    z-index: 1000;
    width:100%;
    background:#fff;
    padding:1.5rem 10%;
    box-shadow: 0 .3rem 2rem rgba(0,0,0,.1);
    display: flex;
    align-items: center;
    justify-content: space-between;
}

header .logo img{
    height:5rem;
}

header .navbar ul{
    display: flex;
    align-items: center;
    justify-content: center;
    list-style: none;
}

header .navbar ul li{
    margin-left: 3rem;
}

header .navbar ul li a{
    font-size: 1.7rem;
    color:#666;
}

header .navbar ul li a.active,
header .navbar ul li a:hover{
    color:var(--yellow);
}

header #menu-bar{
    font-size: 3rem;
    color:#666;
    cursor: pointer;
    display: none;
}

.home{
    display: flex;
    align-items: center;
    justify-content: center;
    flex-wrap: wrap;
    position: relative;
    z-index: 0;
    overflow: hidden;
}

.home::before,
.home::after{
    content:'';
    position: absolute;
    top:5rem; right:-6rem;
    background:var(--yellow);
    border-radius: 3rem;
    transform:rotate(-45deg);
    height:40rem;
    width:70rem;
    z-index: -2;
    animation: animte 1s linear 1;
}

@keyframes animte{
    0%{
        transform:rotate(45deg) translateY(-40rem);
    }
}

.home::before{
    top:-7rem;
    background:#fff;
    box-shadow: 0 1rem 4rem rgba(0,0,0,.1);
    z-index: -1;
}

.home .image{
    flex:1 1 39rem;
}

.home .image img{
    width:100%;
}

.home .content{
    flex:1 1 39rem;
}

.home .content h3{
    color:#333;
    font-size: 6rem;
}

.home .content p{
    color:#666;
    font-size: 2rem;
    padding:1rem 0;
}

.about{
    display: flex;
    align-items: center;
    justify-content: center;
    flex-wrap: wrap;
}

.about .image{
    flex:1 1 40rem;
    height:50rem;
    background:url(../images/about-frame-img.png), url(../images/about-img.jpg) no-repeat;
    background-size: cover;
    background-position: center;
    background-blend-mode: screen;
}

.about .content{
    flex:1 1 40rem;
    padding:2rem;
}

.about .content h3{
    font-size: 4rem;
    color:#333;
}

.about .content p{
    font-size: 1.6rem;
    color:#666;
    padding:1rem 0;
}

.popular{
    background:linear-gradient(rgba(255,255,255,.7),rgba(255,255,255,.7)), url(../images/popular-bg.jpg) no-repeat;
    background-size: cover;
    background-position: center;
    background-attachment: fixed;
}

.popular .box-container{
    display: flex;
    align-items: center;
    justify-content: center;
    flex-wrap: wrap;
}

.popular .box-container .box{
    background:#fff;
    width:35rem;
    padding:2rem;
    margin:2rem;
    border-radius: 1rem;
    box-shadow: 0 .3rem .5rem rgba(0,0,0,.2);
    text-align: center;
}

.popular .box-container .box img{
    height:20rem;
    width:100%;
    object-fit: cover;
}

.popular .box-container .box h3{
    color:#333;
    font-size: 3rem;
    font-weight: normal;
}

.popular .box-container .box .stars i{
    color:var(--yellow);
    font-size: 2rem;
    padding:1rem .1rem;
}

.popular .box-container .box .price{
    color:#666;
    font-size: 2.5rem;
}

.popular .box-container .box:hover{
    transform: scale(1.02);
    box-shadow: 0 1rem 1rem rgba(0,0,0,.2);
}

.gallery .box-container{
    display: flex;
    align-items: center;
    justify-content: center;
    flex-wrap: wrap;
}

.gallery .box-container .box{
    height:20rem;
    width:30rem;
    margin:2rem;
    cursor: pointer;
    overflow: hidden;
    position: relative;
}

.gallery .box-container .box img{
    height:100%;
    width:100%;
    object-fit: cover;
}

.gallery .box-container .box h3{
    position: absolute;
    top:100%; left:50%;
    transform: translate(-50%, -50%);
    color:#fff;
    text-align: center;
    font-size: 3rem;
    opacity: 0;
}

.gallery .box-container .box:hover h3{
    top:50%;
    opacity: 1;
    transition-delay: .2s;
}

.gallery .box-container .box::before{
    content: '';
    position: absolute;
    top:-100%; left:0;
    height:100%;
    width: 100%;
    background:rgba(0,0,0,.7);
    transition:.2s linear;
}

.gallery .box-container .box:hover::before{
    top:0;
}

.order{
    background:url(../images/contact-bg.jpg) no-repeat;
    background-size: cover;
    background-position: center;

}

.order .row{
    display: flex;
    background:#fff;
    margin:2rem 0;
    overflow: hidden;
    box-shadow: 0 .5rem 1rem rgba(0,0,0,.3);
    border-radius: 1rem;
}

.order .row .image{
    flex:1 1 40%;
}

.order .row .image img{
    height:100%;
    width:100%;
    object-fit: cover;
}

.order .row form{
    flex:1 1 60%;
    background:#fff;
    padding:2rem;
}

.order .row form .box{
    padding:1rem;
    margin:1rem 0;
    font-size: 1.5rem;
    color:#333;
    text-transform: none;
    background:#f0f0f0;
    width:100%;
}

.order .row form .box::placeholder{
    text-transform: capitalize;
}

.order .row form .address{
    resize: none;
    height:15rem;
}

.footer{
    background:#282727;
    padding:1rem 7%;
}

.footer .box-container{
    display: flex;
    flex-wrap: wrap;
}

.footer .box-container .box{
    flex:1 1 25rem;
    margin:2rem;
}

.footer .box-container .box h3{
    font-size: 2.5rem;
    color:#fff;
    padding:1rem 0;
    font-weight: normal;
}

.footer .box-container .box p{
    font-size: 1.7rem;
    color:#eee;
    padding:1rem 0;
}

.footer .box-container .box a{
    font-size: 1.7rem;
    color:#eee;
    padding:1rem 0;
    display: block;
}

.footer .box-container .box a:hover{
    color:var(--yellow);
}

.footer .box-container .box p i{
    padding-right: .5rem;
    color:var(--yellow);
}

.footer .credit{
    font-size: 2rem;
    text-align: center;
    border-top: .2rem solid rgba(255,255,255,.7);
    padding:2rem 1rem;
    font-weight: normal;
    letter-spacing: .1rem;
    color:#fff;
}

.footer .credit a{
    color:var(--yellow);
}


/* media queries  */

@media (max-width:991px){

    html{
        font-size: 55%;
    }

    .home::before,
    .home::after{
        display: none;
    }

}

@media (max-width:768px){


    header #menu-bar{
        display: block;
    }

    header .navbar{
        position: fixed;
        top:8rem; left:0;
        width:100%;
        background:var(--yellow);
        border-top: .2rem solid rgba(0,0,0,.1);
        transform:scaleY(0);
        transform-origin: top;
        opacity: 0;
    }

    header .navbar ul{
        flex-flow: column;
        padding:2rem;
    }

    header .navbar ul li{
        margin:1.5rem;
        width: 100%;
    }

    header .navbar ul li a{
        display: block;
        color:#fff;
        padding-left: 2rem;
        border-left: .2rem solid #fff;
        font-size: 2rem;
    }

    header .navbar ul li a:hover,
    header .navbar ul li a.active{
        color:#333;
        border-color: #333;
    }

    .fa-times{
        transform:rotate(180deg);
    }

    header .navbar.nav-toggle{
        transform:scaleY(1);
        opacity: 1;
    }

    .home .content{
        text-align: center;
    }

    .home .content h3{
        font-size: 4.5rem;
    }

    .order .row .image{
        display: none;
    }

}

@media (max-width:500px){

    html{
        font-size: 50%;
    }

    section{
        padding:1rem 5%;
        padding-top: 8.5rem;
    }
}
    </style>
    <script>
    $(document).ready(function(){

$('#menu-bar').click(function(){
    $(this).toggleClass('fa-times');
    $('.navbar').toggleClass('nav-toggle');
});

$(window).on('load scroll',function(){

    $('#menu-bar').removeClass('fa-times');
    $('.navbar').removeClass('nav-toggle');

    $('section').each(function(){

        let top = $(window).scrollTop();
        let height = $(this).height();
        let id = $(this).attr('id');
        let offset = $(this).offset().top - 200;

        if(top > offset && top < offset + height){
            $('.navbar ul li a').removeClass('active');
            $('.navbar').find(`[href="#${id}"]`).addClass('active');
        }

    });

});

$('.list .btn').click(function(){
    $(this).addClass('active').siblings().removeClass('active');
    let src = $(this).attr('data-src');
    $('.menu .row .image img').attr('src',src);
});

});
</script>
</head>
<body>


    <%CustomerAccountServletSignin cs=new  CustomerAccountServletSignin();
    	Customer cus=cs.cusmainobj;%>
<!-- Navbar -->
<div class="w3-top">
 <div class="w3-bar w3-theme-d2 w3-left-align">
  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-hover-white w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
   <a class="w3-bar-item w3-button w3-hide-small w3-hover-white " style="background-color:#F7CA3E;color:white; border-radius:50px;" >Home</a>

  
  <a href="ViewBooking.jsp?id=<%=cus.getCustomerId()%>" class="w3-bar-item w3-button w3-hide-small w3-hover-white" style="border-radius:50px;">View Booking</a>
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
 <%String upset=(String)session.getAttribute("success"); 
 				if(upset!=null){%>
 			<div class="alert alert-success" role="alert">
  			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  			<strong>Success!</strong> Seat Booked successfully!
			</div>
      		 
        	<%}session.setAttribute("success",null);
        	%>
        	
        	<%String upsett=(String)session.getAttribute("updateprofilecus"); 
 				if(upsett!=null){%>
 			<div class="alert alert-success" role="alert">
  			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  			<strong>Success!</strong> Profile Updated successfully!
			</div>
      		 
        	<%}session.setAttribute("updateprofilecus",null);
        	%>
</div>
<section class="home" id="home">

    <div class="content" data-aos="fade-right">
        <h3 style="font-family: 'Oswald', sans-serif;">Restaurant Table Booking Application</h3>
        <p>We belive good food offer great smile</p>
        <a href="#team"><button class="btn">Search Your Restaurant</button></a>
    </div>

    <div class="image" data-aos="fade-up">
        <img src="home-img.png" alt="">
    </div>

</section>


<div class="w3-content" style="max-width:1100px">

<!-- Team Container -->
<div class="w3-container w3-padding-64 w3-center" id="team">
<h2 style="font-family: 'Oswald', sans-serif;">Eating is so intimate...</h2>
<div class="w3-row"><br>

<div class="w3-quarter">
  <img src="download (3).jpeg" alt="Boss" style="width:45%" class="w3-circle w3-hover-opacity">
  <h3>Pizza</h3>
  
</div>

<div class="w3-quarter">
  <img src="images (4).jpeg" alt="Boss" style="width:45%" class="w3-circle w3-hover-opacity">
  <h3>Full Grilled Chicken</h3>
  
</div>

<div class="w3-quarter">
  <img src="download (5).jpeg" alt="Boss" style="width:45%" class="w3-circle w3-hover-opacity">
  <h3>Burger</h3>
  
</div>

<div class="w3-quarter">
  <img src="images (3).jpeg" alt="Boss" style="width:45%" class="w3-circle w3-hover-opacity">
  <h3>Fried Chicken</h3>
 
</div>

</div>
</div>
</div>

<div >
  		
    
      	<form action="searchby" method="post">
   			<div class="search_wrap search_wrap_6">
			<div class="search_box">
				<input type="text" class="input" placeholder="location..." name="search">
				<button type="submit" class="btn">
					<p>Search</p>
				</button>
			</div>
		</div>
		
      </form>
    
  </div>
  <br>
 
  <div class="w3-row-padding">
	<%
	int id=0;
	Search s=new Search();
    for(Restaurant rs:s.searchlist){
	    	 	id+=1;
	      %>

	<div class="w3-col l3 m6 w3-margin-bottom">
	<img src="p1.jpg" alt="John" style="width:100%">
	<h3><%=rs.getRestaurantName()%> Restaurant</h3>
	<p class="w3-opacity"><%=rs.getRestaurantAddress() %></p>
	<p><%=rs.getRestaurant_distance() %> Km</p>
	<p><a href="RestaurantViewPage.jsp?id=<%=rs.getRestaurantID()%>"><button class="w3-button w3-light-grey w3-block" >View</button></a></p>
	</div>

<%} %>


</div>
<div class="w3-container w3-padding-64 w3-center" id="team">
<h2 style="font-family: 'Oswald', sans-serif;">All Restaurants</h2>
</div>
<div class="w3-row-padding">
	<%
	
	      for(Restaurant rs:Restaurant.restaurant_obj_list){
	    	 	
	      %>

	<div class="w3-col l3 m6 w3-margin-bottom">
	<img src="p1.jpg" alt="John" style="width:100%">
	<h3><%=rs.getRestaurantName()%> Restaurant</h3>
	<p class="w3-opacity"><%=rs.getRestaurantAddress() %></p>
	<p><%=rs.getRestaurant_distance() %> Km</p>
	<p><a href="RestaurantViewPage.jsp?id=<%=rs.getRestaurantID()%>"><button class="w3-button w3-light-grey w3-block" >View</button></a></p>
	</div>

<%} %>


</div>
<section class="gallery" id="gallery">

<h1 class="heading"> our food <span>gallery</span> </h1>

<div class="box-container">

    <div class="box" data-aos="fade-up">
        <img src="img1.jpg" alt="">
        <h3>delicious food</h3>
    </div>

    <div class="box" data-aos="fade-up">
        <img src="img2.jpg" alt="">
        <h3>delicious food</h3>
    </div>

    <div class="box" data-aos="fade-up">
        <img src="img3.jpg" alt="">
        <h3>delicious food</h3>
    </div>

    <div class="box" data-aos="fade-up">
        <img src="img4.jpg" alt="">
        <h3>delicious food</h3>
    </div>

    <div class="box" data-aos="fade-up">
        <img src="img5.jpg" alt="">
        <h3>delicious food</h3>
    </div>

    <div class="box" data-aos="fade-up">
        <img src="img6.jpg" alt="">
        <h3>delicious food</h3>
    </div>

</div>

</section>





<div class="footer">

    <div class="box-container">

        <div class="box">
            <h3>contact info</h3>
            <p> <i class="fas fa-map-marker-alt"></i> Chennai, Adyar 600020 </p>
            <p> <i class="fas fa-envelope"></i> RestaurantTableBooking@gmail.com </p>
            <p> <i class="fas fa-phone"></i> +123-456-7890 </p>
            <p> <i class="fas fa-phone"></i> +111-222-333 </p>
        </div>

        <div class="box">
            <h3>branch location</h3>
            <a href="#">Jam Bazaar</a>
            <a href="#">Egmore</a>
            <a href="#">Loyola College</a>
            <a href="#">Perambur North</a>
        </div>

       
        <div class="box">
            <h3>follow us</h3>
            <a href="#">instagram</a>
            <a href="#">facebook</a>
            <a href="#">twitter</a>
            <a href="#">linkedin</a>
        </div>

    </div>

  
</div>



<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>

    AOS.init({
        delay:400,
        duration:1000
    })

</script>

</body>
</html>