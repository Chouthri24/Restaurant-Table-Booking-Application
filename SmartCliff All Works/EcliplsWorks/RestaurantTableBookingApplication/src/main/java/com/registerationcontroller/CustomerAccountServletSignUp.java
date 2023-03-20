package com.registerationcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.main.ConnectionProvider;
import com.main.Main;
import com.persondetails.Customer;


/**
 * Servlet implementation class CustomerAccountServletSignUp
 */
@WebServlet("/cus_signup")
public class CustomerAccountServletSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAccountServletSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("fname");
		String emailid=request.getParameter("email_id_signup");
		String pass=request.getParameter("password_signup");
		String contactno=request.getParameter("contactno");
		String gender=request.getParameter("gender");
		String age=request.getParameter("age");
		String address=request.getParameter("address");
		
		ConnectionProvider cnpv=new ConnectionProvider();
		try {
			cnpv.connectionPart();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Customer customer_obj=new Customer();
		customer_obj.setUser_id();
		customer_obj.setCustomerId();
		
		
		
		int flag=0;
		for(Customer obj1:customer_obj.customer_obj_list) {
			
			  if(obj1.getName().equalsIgnoreCase(name)&&obj1.getEmail_id().equalsIgnoreCase(emailid)) {
				  flag=1;
			  }
		
		}
		
		if(flag==1) {
			response.sendRedirect("AccountAlreadyExistPage.jsp");
		}
		else {
		customer_obj.accountSignUp(cnpv,1,name, pass, emailid.toLowerCase(), contactno, gender, Integer.parseInt(age),address, "CUSTOMER");
		response.sendRedirect("SignIn.jsp");
		}
	}

}
