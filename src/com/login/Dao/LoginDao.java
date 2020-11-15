package com.login.Dao;
import java.sql.*;

public class LoginDao {
	String sql="select * from slogin where sid=? and pass=?";
	String url="jdbc:mysql://localhost:3306/mydb";
	public ResultSet check(String sid,String password) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,"root","Givesome@08");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, sid);
        st.setString(2, password);
        ResultSet rs=st.executeQuery();
        return rs;
	
}
}