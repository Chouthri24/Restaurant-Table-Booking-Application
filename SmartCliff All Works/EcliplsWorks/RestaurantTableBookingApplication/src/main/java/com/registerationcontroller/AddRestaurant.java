package com.registerationcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.main.Main;

/**
 * Servlet implementation class AddRestaurant
 */
@WebServlet("/addRes")
public class AddRestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRestaurant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String resname=request.getParameter("Resname");
		String resaddress=request.getParameter("ResAddress");
		String reslocation=request.getParameter("location");
		String resdistance1=request.getParameter("distance");
		float resdistance=Float.parseFloat(resdistance1);
		String name=request.getParameter("Magname");
		String emailid=request.getParameter("MagEmail");
		String pass=request.getParameter("MagPass");
		String contactno=request.getParameter("Contact");
		HttpSession ss=request.getSession();
		ss.setAttribute("addrestaurant", "Added");
		Main obj=new Main();
		obj.addRestaurantFromJsp("RESTAURANT",resname,resaddress,reslocation,resdistance,name,emailid,pass,contactno);
		response.sendRedirect("ViewRestaurantRecord.jsp");
		//System.out.println(resname+" "+resaddress+" "+reslocation+" "+name+" "+emailid+" "+contactno);
		
		
		
		
	}

}
