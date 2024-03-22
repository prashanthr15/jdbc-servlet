package com.prog.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Request1
 */
@WebServlet("/Request1")
public class Request1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	String	id=request.getParameter("uid");
	String	name=request.getParameter("uname");

	String age=request.getParameter("uage");
	String gender=request.getParameter("ugender");
	System.out.println(id +" "+ name +" "+ age +" "+ gender);
	
	PrintWriter writer=response.getWriter();

	
	 HttpSession session = request.getSession();
	 if(session.isNew()) {
		 writer.println("new session created with id "+session.getId());
	 }
	 else {
		 writer.println("existing session been used with id "+session.getId());
	 }
	 
	 session.setAttribute(name,gender);
	 session.setMaxInactiveInterval(60);
	 
	 request.getRequestDispatcher("/Request2").include(request, response);
	 
	 writer.close();
	 
	}

}
