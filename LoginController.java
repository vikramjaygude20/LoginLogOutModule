package com.Authenticate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Authenticate.dao.LoginDao;


public class LoginController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String pass  = request.getParameter("pass");
		LoginDao dao = new LoginDao();
				
		if(dao.check(uname,pass)){
			
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("Welcome.jsp");
		}
		else {
			
			response.sendRedirect("login.jsp");
		}
	}

	
	

}
