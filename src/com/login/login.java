package com.login;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.Dao.LoginDao;
import com.login.Dao.Stud;

/**
 * Servlet implementation class login
 */
@WebServlet("/slogin")
public class login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String sid = request.getParameter("uname");
			String pass = request.getParameter("pass");
			LoginDao dao=new LoginDao();
			HttpSession session=request.getSession();
			ResultSet rs;
			try {
				rs = dao.check(sid,pass);
				if(rs.next()) {
					Stud stud=new Stud();
					stud.setSid(rs.getString("sid"));
			        stud.setDept(rs.getString("dept"));
			        stud.setSname(rs.getString("sname"));
			        stud.setYear(rs.getInt("year"));
			        stud.setEmail(rs.getString("email"));
					session.setAttribute("stud", stud);
					response.sendRedirect("studentdetails.jsp");
				}
				else {
					session.setAttribute("wrongcred", true);
					response.sendRedirect("studentlogin.html");
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
	}

	
}
