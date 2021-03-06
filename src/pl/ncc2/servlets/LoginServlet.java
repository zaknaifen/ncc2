package pl.ncc2.servlets;

import java.sql.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		String otp=request.getParameter("otp");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String key=request.getParameter("key");
		HttpSession session=request.getSession();
		
		if(pl.ncc2.authlog.Validate.CheckKey(key)){
			
			if(pl.ncc2.lx.GeneratePass.ValidateOTP(name, otp))	
				{
					if(pl.ncc2.authlog.Validate.checkUser(name, password))
						{	
							out.println("<a href=\"OTP.jsp\">Profile2</a>");
							out.print("<br><a href=\"ProfileServlet\">Profile</a>");
							//HttpSession session=request.getSession();
							session.setMaxInactiveInterval(10);
							session.setAttribute("name",name);
							//rs.forward(request, response);
						}
					else
					{
						out.println("Username or Password incorrect");
						//RequestDispatcher rs = request.getRequestDispatcher("index.html");
						//rs.include(request, response);
					}
		
				} else {
					session.invalidate();
					out.println("otp validation failed");
					}
			}
		
		else{
			out.println("Key validation failed");
        }
		/*
		if(password.equals("admin123")){
		out.print("Welcome, "+name);
		HttpSession session=request.getSession();
		session.setAttribute("name",name);
		}
		else{
			out.print("Sorry, username or password error!");
			request.getRequestDispatcher("login.html").include(request, response);
		}*/
		out.close();
	}

}
