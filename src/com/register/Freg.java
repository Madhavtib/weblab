package com.register;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/freg")
public class Freg extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String sql="insert into flogin values(?,?,?,?,?)";
	String url="jdbc:mysql://localhost:3306/mydb";
	String fid = request.getParameter("uid");
	String pass = request.getParameter("pass");
	String fname= request.getParameter("uname");
	String email= request.getParameter("email");
	String dept= request.getParameter("dept");
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,"root","Givesome@08");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, fid);
	    st.setString(2, fname);
	    st.setString(3, email);
	    st.setString(4, dept);
	    st.setString(5, pass);
	    st.executeUpdate();
		response.sendRedirect("facultylogin.html");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
