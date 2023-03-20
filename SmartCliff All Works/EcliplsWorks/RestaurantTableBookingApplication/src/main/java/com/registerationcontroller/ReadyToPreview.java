package com.registerationcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

/**
 * Servlet implementation class ReadyToPreview
 */
@WebServlet("/ReadyToPview")
public class ReadyToPreview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static HashSet<String> seat_obj1=new HashSet<String>();
	 public static int count1;
	 public static String restaurantid;
	 public static String datetoprint;
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadyToPreview() {
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
		
		String resid=request.getParameter("resid");
		restaurantid=resid;
		SeatCollection sc=new SeatCollection();
		seat_obj1.addAll(sc.seat_obj);
		count1=sc.count;
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate nextday=LocalDate.now().plusDays(1);
		datetoprint=nextday.format(dtf);
		System.out.println("-----------");
		System.out.println("Ready To Preview");
		System.out.println("date");
		System.out.println(restaurantid);
		System.out.println(seat_obj1);
		System.out.println("c-"+count1);
		System.out.println("-----------");
		
		if(seat_obj1.isEmpty()) {
			
	    		HttpSession ss=request.getSession();
	    		ss.setAttribute("noseatselect","no");
	    		System.out.println("set--");
	    	
			response.sendRedirect("TableShowPage.jsp?id="+resid);
		}else {
		response.sendRedirect("PreviewBill.jsp?id="+resid);
		}
		
	}

}
