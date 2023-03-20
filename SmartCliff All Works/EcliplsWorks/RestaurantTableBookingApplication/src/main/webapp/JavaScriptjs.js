function fieldValidation1(){  
    var email_id=document.getElementById("email_id_signin").value;
    var email_id_pattern=("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
    if (email_id.trim().match(email_id_pattern)){  
        document.getElementById("email_id_error2").innerHTML="Correct";

      }else {  
        document.getElementById("email_id_error1").innerHTML="Invalid Email Id...";
        return false;
        }  
        
    var pass=document.getElementById("password_signin").value;
    var password_pattern=("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{5,})");
    if(pass.trim().match(password_pattern)){
        document.getElementById("password_error2").innerHTML="Correct";
    }
    else{
        document.getElementById("password_error1").innerHTML="Invalid Password....";
       return false;
    }
    
    
  }
  function fieldValidation2(){


    var fname=document.getElementById("fname").value;
    if(fname!=null && fname !=""){
        document.getElementById("error1_2").innerHTML="Correct";
    }
    else{
        document.getElementById("error1_1").innerHTML="Invalid Name... ";
        return false;   
    }

    var email_id=document.getElementById("email_id_signup").value;
    var email_id_pattern=("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
    if (email_id.trim().match(email_id_pattern)){  
        document.getElementById("error2_2").innerHTML="Correct";
        
      }else {  
        document.getElementById("error2_1").innerHTML="Invalid Email Id... ";
        return false;   
        }  



    var pass=document.getElementById("password_signup").value;
    var password_pattern=("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{5,})");
   
    if(pass.trim().match(password_pattern)){
        document.getElementById("error3_2").innerHTML="Correct";
    }
    else{
        document.getElementById("error3_1").innerHTML="Invalid Password... ";
        return false;   
    }
    var conpass=document.getElementById("conpassword").value;
    if(conpass.trim().match(password_pattern)){
        document.getElementById("error4_2").innerHTML="Correct";
    }
    else{
        document.getElementById("error4_1").innerHTML="Invalid Confirm Password... ";
        return false;   
    }

    if(pass != conpass){
        alert("Password Mismatch...");  
        return false;
    }

    var contactno=document.getElementById("contactno").value;
    var contactno_pattern=/^[0-9]{10}$/;
    if(contactno.trim().match(contactno_pattern)){
        document.getElementById("error5_2").innerHTML="Correct";
    }
    else{
        document.getElementById("error5_1").innerHTML="Invalid Contact No... ";
        return false;   
    }

    var age=document.getElementById("age").value;
    var age_pattern=("^(?=.*[0-9])");
    if(age.trim().match(age_pattern)){
        document.getElementById("error6_2").innerHTML="Correct";
    }
    else{
        document.getElementById("error6_1").innerHTML="Invalid Age... ";
        return false;   
    }

    var location=document.getElementById("location").value;
    var location_pattern=("^(?=.*[a-z])");
    if(location.trim().match(location_pattern)){
        document.getElementById("error7_2").innerHTML="Correct";
    }
    else{
        document.getElementById("error7_1").innerHTML="Invalid Location... ";
        return false;   
    }
    
  }
  