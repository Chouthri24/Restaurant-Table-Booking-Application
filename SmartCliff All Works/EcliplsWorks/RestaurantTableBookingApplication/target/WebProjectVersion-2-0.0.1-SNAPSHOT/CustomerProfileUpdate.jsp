<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.persondetails.*" %>

<%@ page import="com.registerationcontroller.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Update</title>
</head><%

if(session.getAttribute("block") == null){

response.sendRedirect("IndexPage.jsp");

}

%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
 <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 
<style>
body {
  background: #D3D3D3;
}

.form-control:focus {
  box-shadow: none;
  border-color: #BA68C8;
}

.profile-button {
  background: #BA68C8;
  box-shadow: none;
  border: none;
}

.profile-button:hover {
  background: #682773;
}

.profile-button:focus {
  background: #682773;
  box-shadow: none;
}

.profile-button:active {
  background: #682773;
  box-shadow: none;
}

.back:hover {
  color: #682773;
  cursor: pointer;
}
</style>
<body>
 <%CustomerAccountServletSignin cs=new  CustomerAccountServletSignin();
    	Customer cus=cs.cusmainobj;
    	
         
  		
  		Account acc=null;
  		for(Account ac:Account.account_obj_list){
  			if(ac.getUser_emailid().equalsIgnoreCase(cus.getEmail_id())){
  				acc=ac;
  				
  			}
  		}
  
  
    	
    	%>
	<div class="container rounded bg-white mt-5">
        <div class="row">
            <div class="col-md-4 border-right">
                <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" src="https://mdbcdn.b-cdn.net/img/new/avatars/2.webp" width="90"><span class="font-weight-bold"><%=cus.getName() %></span><span class="text-black-50"><%=cus.getEmail_id() %></span><span><%=cus.getAddress() %></span></div>
            </div>
            <div class="col-md-8">
                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <div class="d-flex flex-row align-items-center back">
                            <a href="CustomerHomePage.jsp"><h6>Back to home</h6></a>
                        </div>
                        <h6 class="text-right">Edit Profile</h6>
                    </div>
                    <form action="updatecuspro" method="post">
                    <div class="row mt-2">
                    	<input type="hidden" name="cusid" value=<%=cus.getCustomerId() %> readonly/>
                    	<input type="hidden" name="userid" value=<%=acc.getUserID() %> readonly/>
                        <div class="col-md-6"><input type="text" class="form-control" name="name" placeholder="first name" value=<%=cus.getName() %>></div>
                         <div class="col-md-6"><input type="text" class="form-control" name="email"  placeholder="Email" value=<%=cus.getEmail_id()%> readonly></div>
                       </div>
                    <div class="row mt-3">
                        <div class="col-md-6"><input type="text" class="form-control" name="contact" value=<%=cus.getContact_no() %> placeholder="Contact No" ></div>
                    	     <div class="col-md-6"><input type="text" class="form-control" name="gender" value=<%=cus.getGender() %> placeholder="Gender"></div>
                   
                    </div>
                    <div class="row mt-3">
                    <div class="col-md-6"><input type="text" class="form-control" name="age" placeholder="Age" value=<%=cus.getAge() %>></div>
                       
                        <div class="col-md-6"><input type="text" class="form-control" name="address" placeholder="address" value=<%=cus.getAddress() %>></div>
                    </div>
                    
                    <div class="row mt-3">
                        <div class="col-md-6"><input type="text" class="form-control"  value=<%=acc.getUserPassword()%> placeholder="Contact No" readonly> </div>
                    	     <div class="col-md-6"><input type="text" class="form-control" name="pass" value=<%=acc.getUserPassword()%> placeholder="Password"></div>
                   
                    </div>
                    
                    
                    <div class="mt-5 text-right"><button class="btn btn-primary profile-button" type="submit">Save Profile</button></div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>