package com.prog.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Servlet implementation class Request2
 */
@WebServlet("/Request2")
public class Request2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("control in 2 servlet");
		PrintWriter writer=response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		if(session!=null) {
			Enumeration<String> en = session.getAttributeNames();
			
			while(en.hasMoreElements()) {
			String info=	en.nextElement();
				Object name = session.getAttribute(info);
				writer.println(name +" "+ info);
				long creationTime=session.getCreationTime();
				long lastActive = session.getLastAccessedTime();
				
				writer.println("creation time" + new Date(creationTime));
				writer.println("last accessed time" + new Date(lastActive));
			}
		}
		else {
			writer.print("no session informationl avaliable for this user");
		}
		writer.close();
	}

}
