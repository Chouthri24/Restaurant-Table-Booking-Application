package com.registerationcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.persondetails.Restaurant;

/**
 * Servlet implementation class Search
 */
@WebServlet("/searchby")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public static ArrayList<Restaurant> searchlist=new ArrayList<Restaurant>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
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
		
		searchlist.clear();
		String location=request.getParameter("search");
		for(Restaurant rs:Restaurant.restaurant_obj_list) {
			if(rs.getRestaurantLocation().equalsIgnoreCase(location)) {
				searchlist.add(rs);
			}
		}
		response.sendRedirect("CustomerHomePage.jsp");
		
	}
	

}
