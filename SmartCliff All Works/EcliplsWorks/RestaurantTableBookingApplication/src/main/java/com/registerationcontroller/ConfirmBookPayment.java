package com.registerationcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashSet;

import com.booking.Booking;
import com.persondetails.Customer;
import com.persondetails.Restaurant;

/**
 * Servlet implementation class ConfirmBookPayment
 */
@WebServlet("/confirmBP")
public class ConfirmBookPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmBookPayment() {
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
		
		
		String cardno=request.getParameter("cardno");
		String cardname=request.getParameter("name1");
		
		ReadyToPreview tb=new ReadyToPreview();
		PreviewBook pb=new PreviewBook();
		Restaurant resObj=null;
		for(Restaurant rs:Restaurant.restaurant_obj_list) {
			if(rs.getRestaurantID().equalsIgnoreCase(tb.restaurantid)) {
				resObj=rs;
			}
		}
		CustomerAccountServletSignin Obj=new CustomerAccountServletSignin();
		Customer cusObj=Obj.cusmainobj;
		HttpSession session=request.getSession();
		session.setAttribute("CusObject",cusObj);
		System.out.println(tb.restaurantid+"---");
		System.out.println("------------Ready to Book----------");
	
		
		System.out.println("hs-"+pb.seat_obj2);
		System.out.print("C-"+pb.count2);
		System.out.println("Res Obj"+resObj.getRestaurantName());
		System.out.println("Cus Obj"+cusObj.getName());
		
		Booking.bookingOperationJSP(resObj,cusObj,pb.count2,pb.seat_obj2,cardno,cardname);
			
		System.out.println("----------------------");
		HttpSession session1=request.getSession();
		session1.setAttribute("success", "add");
		
		response.sendRedirect("success.jsp?id="+tb.restaurantid);
		
	}

}
