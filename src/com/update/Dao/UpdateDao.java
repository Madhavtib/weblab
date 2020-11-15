package com.update.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDao {
	String sql=" update slogin set sname=?, pass=?, email=?, dept=?, year=? where sid=? ";
	String url="jdbc:mysql://localhost:3306/mydb";
	public int check(String sid,String sname,String password,String email,String dept,Integer year) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,"root","Givesome@08");
		PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, sname);
        st.setString(2, password);
        st.setString(3, email);
        st.setString(4, dept);
        st.setInt(5, year);
        st.setString(6, sid);
        int rs=st.executeUpdate();
      
        return rs;
	
}
}
