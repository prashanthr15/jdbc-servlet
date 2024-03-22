package com.StudenPortal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudenPortal.model.Model;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		Model model= new Model();
		model.setUserName(name);
		model.setPassword(password);
		
		model.login();
	String dbuser=	model.getUserName();
	String dbpassword=	model.getPassword();
		System.out.println("login class in controller checking name,password"+name+" "+password);
		if(name!=null) {
	if(name.equals(dbuser) && password.equals(dbpassword)) {
		
		response.sendRedirect("/MVCProject/loginsuccess.jsp");
	}
	else {
		response.sendRedirect("/MVCProject/loginfail.jsp");

	}
		}
		else {
			System.out.println("there a prblem with data");
		}
	}

}
