package com.prog.requestDispatch;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 * forward()==> complete responsibility should be taken taken by second servlet 
 * it should take the req and send the res to client
 * include()==> giving  the control to second servlet for some task to comlete and response is givinen by first servlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("cnotrol in first serlet");
		//redirect to secondservlet
	//	RequestDispatcher reqDispatch= request.getRequestDispatcher("/SecondServlet");
		//reqDispatch.forward(request, response);
	//	reqDispatch.forward(request, response);
		
	//	response.sendRedirect("/ReqDispatchBascics/response1.html");
		
		
		//second style
		
		ServletContext context= request.getServletContext();
		RequestDispatcher req=context.getRequestDispatcher("/SecondServlet");
		req.forward(request, response);
		
		//request.getServletContext().getRequestDispatcher("/SecondServlet").forward(request, response);
		//getRequestDispatcher means servlet chaining
		request.getServletContext().getRequestDispatcher("/SecondServlet").include(request, response);

		response.sendRedirect("/ReqDispatchBascics/response1.html");
	}

	

}
