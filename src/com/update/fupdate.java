package com.update;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.Dao.Fac;

@WebServlet("/fupdate")
public class fupdate extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fid = request.getParameter("uid");
		String pass = request.getParameter("pass");
		String fname=request.getParameter("uname");
		String email=request.getParameter("email");
		String dept=request.getParameter("dept");
		HttpSession session=request.getSession();
		String sql=" update login set fname=?, pass=?, email=?, dept=? where fid=? ";
		String url="jdbc:mysql://localhost:3306/mydb";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","Givesome@08");
			PreparedStatement st = con.prepareStatement(sql);
	        st.setString(1, fname);
	        st.setString(2, pass);
	        st.setString(3, email);
	        st.setString(4, dept);
	        st.setString(5, fid);
	        int rs=st.executeUpdate();
			if(rs!=0)
			{
				Fac fac=new Fac();
				fac.setFid(fid);
		        fac.setDept(dept);
		        fac.setFname(fname);
		        fac.setEmail(email);
				session.setAttribute("fac", fac);
				response.sendRedirect("facultydetails.jsp");
			}
			else {
					session.setAttribute("wrongupdate", true);
					response.sendRedirect("facultydetails.jsp");
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
