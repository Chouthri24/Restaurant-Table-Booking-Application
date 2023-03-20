package com.registerationcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.booking.Booking;
import com.persondetails.Customer;

/**
 * Servlet implementation class CancelBookingServlet
 */
@WebServlet("/cancel")
public class CancelBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CancelBookingServlet() {
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
		
		String orderid=request.getParameter("Orderidd");
		String action = request.getParameter("action");
		
		Booking bkobj = null;
		for(Booking bk:Booking.bookingobjlist) {
			if(bk.getOrder_id().equalsIgnoreCase(orderid)) {
			
				bkobj=bk;
			}
		}
		if("Confirm To Cancel".equalsIgnoreCase(action)) {
			
			
			System.out.println("Ready to Cancel"+bkobj.getOrder_id());
			
			for(Customer cus:Customer.customer_obj_list) {
				if(cus.getCustomerId().equalsIgnoreCase(bkobj.getCustomerId())) {
					Booking.cancelBooking(cus, bkobj.getOrder_id());
					break;
					
				}
				
				
			}		
			HttpSession sse=request.getSession();
			sse.setAttribute("CancelBook","Cancel");
		response.sendRedirect("ViewBooking.jsp?id="+bkobj.getCustomerId());
		
		}else if("Back".equalsIgnoreCase(action)) {
			System.out.println("Back");
			response.sendRedirect("ViewBooking.jsp?id="+bkobj.getCustomerId());
		}
		
	}

}
