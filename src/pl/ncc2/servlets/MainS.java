package pl.ncc2.servlets;

//imports
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MainS extends HttpServlet{
	private static final long serialVersionUID= 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		String p1 = request.getParameter("p");
		PrintWriter out = response.getWriter();
		if (p1 !=null){
			out.print("true");
		}
		 
			
			
			
		
		
		
	}
	
	

}
