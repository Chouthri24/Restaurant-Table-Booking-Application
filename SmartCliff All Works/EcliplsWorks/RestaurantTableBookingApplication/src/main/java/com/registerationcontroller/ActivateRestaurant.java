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
 * Servlet implementation class ActivateRestaurant
 */
@WebServlet("/activateRes")
public class ActivateRestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivateRestaurant() {
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
	RestaurantAccountDao obj=new RestaurantAccountDao();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		String id=request.getParameter("userid2");
		String resid=request.getParameter("resid2");
		 try { 
			  if(obj.activate_Restaurant(id)) {
				  
				  for(Restaurant obj2:Restaurant.restaurant_obj_list) {
					  if(obj2.getRestaurantID().equalsIgnoreCase(resid)) {
						  obj2.setRestaurant_isActive(1);
					  }
				  }
				  
				  for(Account obj1:Account.account_obj_list) {
					  if(obj1.getUserID().equalsIgnoreCase(id)) {
						  obj1.setIsActive(1);
					  }
				  }
				  
				  
				  System.out.println("Activated...");
			  }
			  HttpSession ss=request.getSession();
				ss.setAttribute("activaterestaurant", "Act");
			  response.sendRedirect("ViewRestaurantRecord.jsp");
		  
		  
		  } catch (ClassNotFoundException | SQLException e) { // TODO Auto-generated
		  }
	}

}
