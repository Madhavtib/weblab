package com.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.Dao.Stud;
import com.update.Dao.UpdateDao;

@WebServlet("/supdate")
public class update extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sid = request.getParameter("uid");
		String pass = request.getParameter("pass");
		String sname=request.getParameter("uname");
		String email=request.getParameter("email");
		String dept=request.getParameter("dept");
		Integer year=Integer.parseInt(request.getParameter("year"));
		UpdateDao dao=new UpdateDao();
		HttpSession session=request.getSession();
		int rs;
		try
		{
			rs=dao.check(sid, sname, pass, email, dept, year);
			if(rs!=0)
			{
				Stud stud=new Stud();
				stud.setSid(sid);
		        stud.setDept(dept);
		        stud.setSname(sname);
		        stud.setYear(year);
		        stud.setEmail(email);
				session.setAttribute("stud", stud);
				response.sendRedirect("studentdetails.jsp");
			}
			else {
					session.setAttribute("wrongupdate", true);
					response.sendRedirect("studentdetails.jsp");
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
