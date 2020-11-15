<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="index.css">
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<%
	Class.forName("com.mysql.jdbc.Driver");
	String sql="select * from dept";
	String url="jdbc:mysql://localhost:3306/mydb";
	Connection con=DriverManager.getConnection(url,"root","Givesome@08");
	Statement st=con.createStatement();
    ResultSet rs=st.executeQuery(sql);
    String id="";
    String name="";
	%>
	<nav>
      <label class="logo">CollegeManagementSystem</label>
      <ul>
        <li><a href="index.html">Home</a></li>
        <li><a   href="studentlogin.html">Student</a></li>
        <li><a  href="flogin.html">Faculty</a></li>
        <li><a class="active" href="departmentlist.jsp">Department</a></li>
        <li><a href="ContactUs.html">Contact Us</a></li>
         <li><a href="AboutUs.html">About Us</a></li>
      </ul>
    </nav>

	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>DeptID</th>
					<th>Department Name</th>
				</tr>
			</thead>
			<tbody>
			<% 
			   while(rs.next())
			    {
			    	id=rs.getString("deptid");
			    	name=rs.getString("dname");
			    
			%>
				<tr>
				
				<td><%out.println(id); %></td>
				<td><%out.println(name); %></td>
				</tr>
			<%} %>
				<tr>
					<td><button class="btn btn-success" onclick="window.location.href='facultyupdate.jsp';">Update</button></td>
				</tr>
			</tbody>
		</table>
	</div>
	

</body>
</html>