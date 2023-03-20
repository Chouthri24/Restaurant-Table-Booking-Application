<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Restaurant</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  
  <!-- Google Fonts -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Amatic+SC:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Inter:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/main.css" rel="stylesheet">
<style>
.header {
    background: black;
    transition: all 0.5s;
    z-index: 997;
    height: 50px;
    color: #FDD023;
    border-bottom: 1px solid #fff;
}
@media (min-width: 1280px)
.navbar a, .navbar a:focus {
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0px;
    font-family: var(--font-secondary);
    font-size: 16px;
    font-weight: 600;
    color: yellow;
    white-space: nowrap;
    transition: 0.3s;
    position: relative;
}

</style>
  
</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top d-flex align-items-center">
    <div  class="container d-flex align-items-center justify-content-between">

      <a  class="logo d-flex align-items-center me-auto me-lg-0">
        <!-- Uncomment the line below if you also wish to use an image logo -->
        <!-- <img src="assets/img/logo.png" alt=""> -->
        <h1 style="color:#FDD023;">Restaurant<span>.</span></h1>
      </a>

      <nav id="navbar" class="navbar" style="height:80px;" >
        <ul>
        
      
       <li><a href="index1.jsp">Home</a></li>
         	
          <li><a href="#about">About</a></li>
       
          <li><a href="#contact">Contact</a></li>
        </ul>
      </nav><!-- .navbar -->

<div>
     <a class="btn btn-warning btn-sm" style="align-items:right;"href="SignIn.jsp">Sign In</a>
      <a class="btn btn-warning btn-sm" href="SignUp.jsp">Sign Up</a>
      </div>
     <!-- .navbar -->
     
      <i class="mobile-nav-toggle mobile-nav-show bi bi-list"></i>
      <i class="mobile-nav-toggle mobile-nav-hide d-none bi bi-x"></i>

    </div>
  </header><!-- End Header -->

  <main id="main">

    
  <!-- ======= Hero Section ======= -->
  <section id="hero" class="hero d-flex align-items-center section-bg">
    <div class="container">
      <div class="row justify-content-between gy-5">
        <div class="col-lg-4 order-2 order-lg-1 d-flex flex-column justify-content-center align-items-center align-items-lg-start text-center text-lg-start">
          <h2 data-aos="fade-up">Restaurant Table<br>Booking Application</h2>
          <p data-aos="fade-up" data-aos-delay="100">Enjoy Your Healthy<br>Delicious Food</p>
          <div class="d-flex" data-aos="fade-up" data-aos-delay="200">
            <a href="#book-a-table" class="btn-book-a-table">Book a Table</a>
           </div>
        </div>
        <div class="col-lg-5 order-1 order-lg-2 text-center text-lg-start">
          <img src="assets/img/hero-img.png" class="img-fluid" alt="" data-aos="zoom-out" data-aos-delay="300">
        </div>
      </div>
    </div>
  </section><!-- End Hero Section -->

  </main><!-- End #main -->
    <section id="about" class="about">
      <div class="container" data-aos="fade-up">

        <div>
          <h2>About Us</h2>
          <p>Learn More <span>About Us</span></p>
        </div>

        <div class="row gy-4">
          <div class="col-lg-7 position-relative about-img" style="background-image: url(pex.jpeg) ;" data-aos="fade-up" data-aos-delay="150">
            
          </div>
          <div class="col-lg-5 d-flex align-items-end" data-aos="fade-up" data-aos-delay="300">
            <div class="content ps-0 ps-lg-5">
              <p >
               It is important to take care of the patient, the patient will be followed by the patient, but it will happen at the same time as labor and pain
                some great things
              </p>
              <ul>
                <li><i class="bi bi-check2-all"></i> I do not work at all except to get some advantage out of it.</li>
                <li><i class="bi bi-check2-all"></i> Doubts or irrure pain in reprimands in the pleasure he wants.</li>
                <li><i class="bi bi-check2-all"></i> I do not work at all except to get some advantage out of it. Duis aureur irure pain in reprehendit in pleasure tridetas storacalaperda mastir pain eu fu no be born.</li>
              </ul>
              <p>
               I do not work at all except to get some advantage out of it. Doubts or irure pain in reprimanding in pleasure
                He wants to be a hair, let him run away from the pain, and no one will give birth. Unless they are blinded by lust, they will not come out
              </p>

              <div class="position-relative mt-4">
                <img src="assets/img/about-2.jpg" class="img-fluid" >
               
              </div>
            </div>
          </div>
        </div>

      </div>
    </section><!-- End About Section -->

  <!-- ======= Footer ======= -->
  <footer id="contact" class="footer">

    <div class="container">
      <div class="row gy-3">
        <div class="col-lg-3 col-md-6 d-flex">
          <i class="bi bi-geo-alt icon"></i>
          <div>
            <h4>Address</h4>
            <p>
              A108 Adam Street, <br>
              Bangalore.<br>
            </p>
          </div>

        </div>

        <div class="col-lg-3 col-md-6 footer-links d-flex">
          <i class="bi bi-telephone icon"></i>
          <div>
            <h4>Reservations</h4>
            <p>
              <strong>Phone:</strong> +91 9876543210<br>
              <strong>Email:</strong> Restaurant@example.com<br>
            </p>
          </div>
        </div>

       
        <div class="col-lg-3 col-md-6 footer-links">
          <h4>Follow Us</h4>
          <div class="social-links d-flex">
            <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
            <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
            <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
            <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
          </div>
        </div>

      </div>
    </div>

   
  </footer><!-- End Footer -->
  <!-- End Footer -->

  <a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <div id="preloader"></div>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>