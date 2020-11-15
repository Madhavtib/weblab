package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.Dao.FLoginDao;
import com.login.Dao.Fac;

@WebServlet("/login")
public class flogin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fid = request.getParameter("userid");
		String pass = request.getParameter("password");
		String sql="select * from login where fid=? and pass=?";
		String url="jdbc:mysql://localhost:3306/mydb";
		HttpSession session=request.getSession();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","Givesome@08");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, fid);
	        st.setString(2, pass);
	        ResultSet rs=st.executeQuery();
			System.out.println(rs.getFetchSize());
			if(rs.next()) {
				Fac fac=new Fac();
				fac.setFid(rs.getString("fid"));
		        fac.setDept(rs.getString("dept"));
		        fac.setFname(rs.getString("fname"));
		        fac.setEmail(rs.getString("email"));
				session.setAttribute("fac", fac);
				response.sendRedirect("facultydetails.jsp");
			}
			else {
				session.setAttribute("wrongcred", true);
				response.sendRedirect("flogin.html");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
}
}
