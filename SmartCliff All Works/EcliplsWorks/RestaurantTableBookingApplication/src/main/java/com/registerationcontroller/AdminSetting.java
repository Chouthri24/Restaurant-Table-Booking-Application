package com.registerationcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.accountdao.AdminDao;
import com.persondetails.Account;
import com.persondetails.Admin;

/**
 * Servlet implementation class AdminSetting
 */
@WebServlet("/updateadsetting")
public class AdminSetting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSetting() {
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
		AdminDao obj=new AdminDao();
		CustomerAccountServletSignin cs=new CustomerAccountServletSignin();
		Admin ad=cs.admainobj;
		
		String newpass=request.getParameter("pass");
		String email=request.getParameter("ademail");
		
		try {
			if(obj.update_AdminSetting(email, newpass)) {
				
				for(Account ac:Account.account_obj_list) {
					if(ac.getUser_emailid().equalsIgnoreCase(email)) {
					ac.setUserPassword(newpass);
					//System.out.print("Ib");
					}
				}
				
			}
			
			response.sendRedirect("AdminHomePage.jsp");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
