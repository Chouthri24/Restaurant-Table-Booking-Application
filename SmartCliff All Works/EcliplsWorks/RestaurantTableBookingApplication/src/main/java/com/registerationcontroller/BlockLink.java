package com.registerationcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class BlockLink
 */
@WebServlet("/blocklk")
public class BlockLink extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Destroys the session for this user.
       
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("index1.jsp" );
    }
}
