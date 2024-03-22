package com.StudenPortal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudenPortal.model.Model;

/**
 * Servlet implementation class Register
 */
@WebServlet("/reg")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	String name=request.getParameter("uname");
	String city=request.getParameter("ucity");
	String country=request.getParameter("ucountry");
	String password=request.getParameter("upassword");
	String confirmpassword=request.getParameter("cpassword");
	
	if(password.equals(confirmpassword)) {
		Model model= new Model();
		model.setUserName(name);
		model.setCity(city);
		model.setCountry(country);
		model.setPassword(password);
		int row = model.register();
		if(row!=0) {
			System.out.println(row +"checking row in servlet");
			response.sendRedirect("/MVCProject/registersuccess.html");
			
		}
		else {
			response.sendRedirect("/MVCProject/failregister.html");
		}
	}
	else {
		System.out.println("password and confirm password not matching");
		response.sendRedirect("/MVCProject/reregister.html");
	}

	}

}
