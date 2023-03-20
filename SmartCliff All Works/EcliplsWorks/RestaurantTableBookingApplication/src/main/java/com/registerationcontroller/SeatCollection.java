package com.registerationcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

import com.persondetails.Restaurant;

/**
 * Servlet implementation class SeatCollection
 */
@WebServlet("/seat")
public class SeatCollection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public static HashSet<String> seat_obj=new HashSet<String>();
       public static int count;
       public static boolean permission;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeatCollection() {
        super();
        // TODO Auto-generated constructor stub
    }
    Restaurant res_obj=new Restaurant();
    
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
		
		 String resid=request.getParameter("resid");
		
		String seat_pos=request.getParameter("S");
		
		boolean flag=false;
		if(seat_pos.charAt(0)=='B') {
	    				flag=true;
    	 }else if (seat_pos.charAt(0)=='P') {
	    				flag=true;
    	 }
    	
    	if(flag==true) {
    	
    			if(seat_obj.contains(seat_pos)) {  //if you click second time u can remove
    				count--;
    				seat_obj.remove(seat_pos);
    				System.out.println("Removed---"+seat_pos);
    				
    			}
    		else { //First time click only add
    		count++;
    		System.out.println("Added---"+seat_pos);
    		seat_obj.add(seat_pos);
    		}
		
		}else {
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Already");
		}
		
    	
		System.out.println("Hs-------"+seat_obj);
		String pg="TableShowPage.jsp?id="+resid;
		response.sendRedirect(pg);
		
	}

}
