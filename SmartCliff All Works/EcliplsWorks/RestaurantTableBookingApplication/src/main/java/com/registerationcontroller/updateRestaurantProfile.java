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
 * Servlet implementation class updateRestaurantProfile
 */
@WebServlet("/updateresprofile")
public class updateRestaurantProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateRestaurantProfile() {
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
		
		String email=request.getParameter("manemail");
		String manname=request.getParameter("manname");
		 String mancontact=request.getParameter("mancontact");
		 String pass=request.getParameter("pass");
		 RestaurantAccountDao obj=new RestaurantAccountDao();
		try {
			if(obj.update_Restaurant_profile(email,manname,mancontact,pass)) {
				
				for(Restaurant rs:Restaurant.restaurant_obj_list) {
					if(rs.getEmail_id().equalsIgnoreCase(email)) {
					rs.setName(manname);
					rs.setContact_no(mancontact);}
					
				}
				for(Account ac:Account.account_obj_list) {
					if(ac.getUser_emailid().equalsIgnoreCase(email)) {
						ac.setUserPassword(pass);
					}
				}
				HttpSession session=request.getSession();
				session.setAttribute("updateprofileres", "Added");
				
				response.sendRedirect("RestaurantHomePage.jsp");
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		
		
	}

}
