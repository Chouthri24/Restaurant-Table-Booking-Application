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
 * Servlet implementation class AdminUpdateProfile
 */

@WebServlet("/updateadprofile")
public class AdminUpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateProfile() {
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
		
		String name=request.getParameter("adname");
		String email=request.getParameter("ademail");
		String contact=request.getParameter("adcontact");
		String gender=request.getParameter("adgen");
		String address=request.getParameter("address");
		
		AdminDao obj=new AdminDao();
		CustomerAccountServletSignin cs=new CustomerAccountServletSignin();
		Admin ad=cs.admainobj;
		
		try {
			if(obj.update_Admin(name, email.toLowerCase(), contact, gender, address)) {
				//System.out.println(name+" "+email+" "+contact+" "+gender+" "+address);
				for(Admin obj1:Admin.admin_obj_list) {
					if(obj1.getEmail_id().equalsIgnoreCase(ad.getEmail_id())) {
					obj1.setName(name);
					obj1.setContact_no(contact);
					obj1.setGender(gender);
					obj1.setAddress(address);
					}
					
				}
				for(Account ac:Account.account_obj_list) {
					if(ac.getUser_emailid().equalsIgnoreCase(ad.getEmail_id())) {
						ac.setUserName(name);
					}
				}
			}
			
			response.sendRedirect("AdminHomePage.jsp");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
