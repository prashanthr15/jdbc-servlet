
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register class should imlement servelet
 * interface or extends HttpServlet class
 */
@WebServlet("/reg")
public class Register extends HttpServlet {

	public Register() {
		super();
		System.out.println("register obj is created");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// client sent request to server [request]
		// server sent response to client [response]
		// <td><input type="text" name="uname"></td>
		// should give the samr name

		String name = request.getParameter("uname");
		String city = request.getParameter("ucity");
		String number = request.getParameter("number");
		
		
		PrintWriter writer=response.getWriter();
		writer.println("<html> <head><title>first app</title></head>");
		writer.println("<body bgcolor='cyan'><h1>welcome to our dynamic app</h1>");	
		writer.println("<table>");
		writer.println("<tr> <th>name</th> <th>city</th> <th>number</th></tr>");
		writer.println("<tr><td> " +name+"</td>  <td> " +city+"</td>  <td> " +number+"</td></tr>");
		writer.println("</table>");
		writer.println("</body>");
		writer.println("</html>");	
		writer.close();
	}

}
