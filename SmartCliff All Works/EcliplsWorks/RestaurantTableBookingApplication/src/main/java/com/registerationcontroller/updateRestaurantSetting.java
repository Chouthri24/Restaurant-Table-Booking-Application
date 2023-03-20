package com.registerationcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.main.Main;
import com.persondetails.Restaurant;

/**
 * Servlet implementation class updateRestaurantSetting
 */

@WebServlet("/updateresSetting")
public class updateRestaurantSetting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateRestaurantSetting() {
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
		
		String email=request.getParameter("resemail");
		String resname=request.getParameter("resname");
		Restaurant rsobj=null;
		for(Restaurant rs:Restaurant.restaurant_obj_list) {
			if(rs.getEmail_id().equalsIgnoreCase(email)) {
				rsobj=rs;
			}
		}
		
		String basictablecount=request.getParameter("btc");
		String basictableseatcount=request.getParameter("btsc");
		String basicseatamount=request.getParameter("bsa");
		String premiumtablecount=request.getParameter("ptc");
		String premiumtableseatcount=request.getParameter("ptsc");
		String premiumseatamount=request.getParameter("psa");
		String food=request.getParameter("food");
		
		Main obj=new Main();
		
		obj.updateTableArrangementJSP(rsobj, basictablecount, basictableseatcount, basicseatamount, premiumtablecount, premiumtableseatcount,premiumseatamount,food);
		
		
		HttpSession session=request.getSession();
		session.setAttribute("updatesettingres", "Added");
		
		response.sendRedirect("RestaurantHomePage.jsp");	
	}

}
