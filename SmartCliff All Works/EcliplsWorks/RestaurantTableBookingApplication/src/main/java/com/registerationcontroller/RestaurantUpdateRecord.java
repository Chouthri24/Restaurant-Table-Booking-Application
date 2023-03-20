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
 * Servlet implementation class RestaurantUpdateRecord
 */
@WebServlet("/updateres")
public class RestaurantUpdateRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantUpdateRecord() {
        super();
        // TODO Auto-generated constructor stub
    }
  
    RestaurantAccountDao obj=new RestaurantAccountDao();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid=request.getParameter("userid");
		String resid=request.getParameter("resid");
		String resname=request.getParameter("resname");
		String resaddress=request.getParameter("resaddress");
		String resloc=request.getParameter("reslocation");
		String resdis=request.getParameter("resdistance");
		String name=request.getParameter("manname");
		String contact=request.getParameter("mancon");
		//System.out.print(resid+" "+resname+" "+resaddress+" "+resloc+" "+resdis+" "+name+" "+contact);
		
		
		
		  try { 
			  obj.update_Restaurant(userid,resid,resname, resaddress, resdis, resloc, name,
		  contact);
		  
			  for(Restaurant rs:Restaurant.restaurant_obj_list) {
					
					if(rs.getRestaurantID().equalsIgnoreCase(resid)) {
						rs.setRestaurantName(resname);
						rs.setRestaurantAddress(resaddress);
						rs.setRestaurantLocation(resloc);
						rs.setRestaurant_distance(Float.parseFloat(resdis));
						rs.setName(name);
						rs.setContact_no(contact);
					}
				}
				
				for(Account ac:Account.account_obj_list) {
					if(ac.getUserID().equalsIgnoreCase(userid)) {
						ac.setUserName(resname);
						
					}
				}
				
				HttpSession ssr=request.getSession();
				ssr.setAttribute("addup", "add");
			  
		  response.sendRedirect("ViewRestaurantRecord.jsp");
		  
		  
		  } catch (ClassNotFoundException | SQLException e) { // TODO Auto-generated
		  }
		 
		
		
	}

}
