package com.registerationcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.accountdao.CustomerAccountDao;
import com.main.ConnectionProvider;
import com.persondetails.Admin;
import com.persondetails.Customer;
import com.persondetails.Restaurant;

/**
 * Servlet implementation class CustomerAccountServlet
 */
@WebServlet("/cuslogin")
public class CustomerAccountServletSignin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public   static Admin admainobj;
	public static Restaurant resmainobj;
	public  static Customer cusmainobj;
	public static boolean flag=true;
 CustomerAccountDao cus_obj=new CustomerAccountDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAccountServletSignin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		// TODO Auto-generated method stub
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(flag) {
		ConnectionProvider cnpv=new ConnectionProvider();
		try {
			
			cnpv.connectionPart();
			flag=false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		String page = "";
		String type=request.getParameter("User_type");
		 String email=request.getParameter("email_id_signin");
		 String pass=request.getParameter("password_signin"); 
		 //response.getWriter().append(type);
		 boolean out;
		try {
			out = cus_obj.signInAccountCheck(type,email.toLowerCase(),pass);
		
			HttpSession sess=request.getSession();
			
		 if(out==true && "ADMIN".equalsIgnoreCase(type)) {
			 
			 for(Admin obj:Admin.admin_obj_list) {
				 if(obj.getEmail_id().equalsIgnoreCase(email)) {
					 
					 admainobj=obj;
					 sess.setAttribute("block",obj.getName());
					 page = "AdminHomePage.jsp";
				 }
			 }
		 }
		 else if(out && "CUSTOMER".equalsIgnoreCase(type)) {
			 for(Customer obj1:Customer.customer_obj_list) {
				 if(obj1.getEmail_id().equalsIgnoreCase(email)) {
					 
					 cusmainobj=obj1;
					 sess.setAttribute("block",obj1.getName());
					 page = "CustomerHomePage.jsp";
				 }
			 }
			 
			 
			 
		 }else if(out && "RESTAURANT".equalsIgnoreCase(type)) {
			 
			 for(Restaurant obj:Restaurant.restaurant_obj_list) {
				 if(obj.getEmail_id().equalsIgnoreCase(email)) {
					 
					 resmainobj=obj;
					 sess.setAttribute("block",obj.getName());
					 System.out.println("servlet-"+resmainobj.getRestaurantName());
					 page = "RestaurantHomePage.jsp";
				 }
			 }
			 
			
		 }
		 else {
			 HttpSession session=request.getSession();
			 session.setAttribute("err", "Invalid Email ID / Password"); 
             page = "SignIn.jsp";
		 }
		 
		 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(page);
	
		
	}
	
}

