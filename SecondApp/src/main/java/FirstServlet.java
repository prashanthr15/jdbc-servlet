

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * servlet is application which is resideding on server to handle the req from client
 * when you  make change in html and jsp just save no need to stop the server 
 * when you  make change in servlet stop server and re deploy it
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	
	static
	{
		System.out.println("servlet is loaded");
	}
       
   
    public FirstServlet() {
        super();
        
        System.out.println("servelet object is instantiated.....");
    }

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("intit is initiaized or invoked");
	}

	public void destroy() {
		System.out.println("at the end to close the app");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("method to handle the request and response");
		PrintWriter writer=response.getWriter();
		writer.println("<html> <head><title>first app</title></head>");
		writer.println("<body bgcolor='cyan'><h1>welcome to our dynamic app</h1></body>");	
		writer.println("</html>");	
		writer.close();
	}
	//PrintWriter to display on client machine
	//PrintWriter writer = new PrintWriter();

}
