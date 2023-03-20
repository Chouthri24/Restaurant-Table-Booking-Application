package com.registerationcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.accountdao.RestaurantAccountDao;
import com.persondetails.Account;
import com.persondetails.Restaurant;

/**
 * Servlet implementation class DeleteRestaurantAccount
 */
@WebServlet("/delete")
public class DeleteRestaurantAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRestaurantAccount() {
        super();
        // TODO Auto-generated constructor stub
    }
    RestaurantAccountDao obj=new RestaurantAccountDao();
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
		String id=request.getParameter("userid1");
		String resid=request.getParameter("resid1");
		Restaurant res=new Restaurant();
		
		
		 try { 
			  if(obj.delete_Restaurant(id)) {
				  
				  for(Restaurant obj:res.restaurant_obj_list) {
					 
					  if(obj.getRestaurantID().equalsIgnoreCase(resid)) {
						  obj.setRestaurant_isActive(0);
					  }
				  }
				  
				  for(Account obj1:Account.account_obj_list) {
					  if(obj1.getUserID().equalsIgnoreCase(id)) {
						  obj1.setIsActive(0);
					  }
				  }
				  
				  
				  
				  System.out.println("Deleted...");
			  }
			  HttpSession ss=request.getSession();
				ss.setAttribute("deleterestaurant", "del");
			  response.sendRedirect("ViewRestaurantRecord.jsp");
		  
		  
		  } catch (ClassNotFoundException | SQLException e) { // TODO Auto-generated
		  }
		 
		
	}

}
