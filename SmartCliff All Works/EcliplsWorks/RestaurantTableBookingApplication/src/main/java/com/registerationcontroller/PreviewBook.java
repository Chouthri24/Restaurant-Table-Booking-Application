package com.registerationcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

import com.persondetails.Customer;
import com.persondetails.Restaurant;

/**
 * Servlet implementation class PreviewBook
 */
@WebServlet("/Book")
public class PreviewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static HashSet<String> seat_obj2=new HashSet<String>();
	 public static int count2;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreviewBook() {
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
	
		ReadyToPreview tb=new ReadyToPreview();
		seat_obj2.addAll(tb.seat_obj1);
		count2=tb.count1;

		response.sendRedirect("Payment.jsp?id="+tb.restaurantid);
		
	}

}
