package com.registerationcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.accountdao.CustomerAccountDao;
import com.accountdao.RestaurantAccountDao;
import com.persondetails.Account;
import com.persondetails.Customer;
import com.persondetails.Restaurant;

/**
 * Servlet implementation class CustomerProfileUpdate
 */
@WebServlet("/updatecuspro")
public class CustomerProfileUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerProfileUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String userid=request.getParameter("userid");
		String cusid=request.getParameter("cusid");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		 String contact=request.getParameter("contact");
		 String gender=request.getParameter("gender");
		 String age=request.getParameter("age");
		 String address=request.getParameter("address");
		 String pass=request.getParameter("pass");
		 
		 CustomerAccountDao obj=new CustomerAccountDao();
		try {
			if(obj.update_Customer_profile(userid,cusid,name,email,contact,gender,age,address,pass)) {
				
				/*
				 * for(Restaurant rs:Restaurant.restaurant_obj_list) {
				 * if(rs.getEmail_id().equalsIgnoreCase(email)) { rs.setName(manname);
				 * rs.setContact_no(mancontact);}
				 * 
				 * } for(Account ac:Account.account_obj_list) {
				 * if(ac.getUser_emailid().equalsIgnoreCase(email)) { ac.setUserPassword(pass);
				 * } }
				 */
				
				for(Customer cus:Customer.customer_obj_list) {
					if(cus.getEmail_id().equalsIgnoreCase(email)) {
						cus.setName(name);
						cus.setContact_no(contact);
						cus.setGender(gender);
						cus.setAge(Integer.parseInt(age));
						cus.setAddress(address);
						
					}
				}
				for(Account ac:Account.account_obj_list) {
					 if(ac.getUser_emailid().equalsIgnoreCase(email)) {
						 ac.setUserName(name);
						 ac.setUserPassword(pass);
					  } }
				HttpSession session=request.getSession();
				session.setAttribute("updateprofilecus", "Added");
				
				response.sendRedirect("CustomerHomePage.jsp");
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		
		
		
		
	}

}
