package com.prog.main;
/*
 * service means actual business logic
 * controller means takes request from the client end and response back to the client back
 * ex; servlet
 * this is servlet class
 * am just writing only taking  request and sending respose 
 * remainning code is transferred to registers class
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prog.util.JDBCutillity;
import com.prog.util.JdbcApp;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// to catch the data from user enter in web page
		
		String id = request.getParameter("uid");
		String name = request.getParameter("uname");
		String age = request.getParameter("uage");

		String gender = request.getParameter("ugender");
		// to degub we geting the data or not
		System.out.println(name + " " + age + " " + gender);

		PreparedStatement pstmt = null;
		Connection connect = null;

		//before line 47 to 59 are present here later shift to jdbcapp
		// create the obj JdbcApp
		JdbcApp app = new JdbcApp();
		//from web page it comes as string so converting to int
		app.setAge(Integer.parseInt(age));
		app.setGender(gender);
		//from web page it comes as string so converting to int
		app.setId(Integer.parseInt(id));
		app.setName(name);

		app.jdbcRegister();
		//for debuging purpose
		System.out.println("register inivoked");

		
		//deleted bcz ita a servlet
	//	PrintWriter writer = response.getWriter();
		
//		writer.println("<html> <head><title>Student registration</title></head>");
//
//		int row = app.getRow();
//		//for debuging purpose
//		System.out.println(row + "servlet row");
//		if (row != 0) {
//
//			writer.println("<body bgcolor='cyan'><h1>Registered</h1></body>");
//
//		} else {
//			writer.println("<body bgcolor='cyan'><h1>fail to Register</h1></body>");
//
//		}
//		writer.println("</html>");
		
		
		
		int row= app.getRow();
		if(row!=0) {
			response.sendRedirect("/RegistrationJDBC/success.jsp");
		}
		else {
			response.sendRedirect("/RegistrationJDBC/fail.jsp");
		}

	}

}
