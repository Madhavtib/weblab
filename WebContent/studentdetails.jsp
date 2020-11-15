<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html">
<html>
<head>
<link rel="stylesheet" href="index.css">
    <!-- <script src="https://kit.fontawesome.com/a076d05399.js"></script> -->
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css">
</head>
<body>
	<%
	 
	  response.addHeader("Pragma", "no-cache");
	  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	  response.addHeader("Cache-Control", "pre-check=0, post-check=0");
	  response.setDateHeader("Expires", 0);
		if(session.getAttribute("stud")==null)
		{
			response.sendRedirect("studentlogin.jsp");
			
		}
	%>
<nav>
      <label class="logo">CollegeManagementSystem</label>
      <ul>
        <li><a href="index.html">Home</a></li>
        <li><a class="active"  href="studentlogin.html">Student</a></li>
        <li><a href="flogin.html">Faculty</a></li>
        <li><a href="departmentlist.jsp">Department</a></li>
        <li><a href="ContactUs.html">Contact Us</a></li>
        <li><a href="AboutUs.html">About Us</a></li>
      </ul>
    </nav>

	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>StudentID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Department</th>
					<th>Year</th>
				</tr>
			</thead>
			<tbody>
				<tr>
				
				<td>${stud.sid}</td>
				<td>${stud.sname}</td>
				<td>${stud.email}</td>
				<td>${stud.dept}</td>
				<td>${stud.year}</td>
				</tr>
				<tr>
					<td><button class="btn btn-success" onclick="window.location.href='studentupdate.jsp';">Update</button></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="container" align="center">
		<form action="logout" method="post">
		<button class="btn btn-warning" type="submit">Logout</button>
		</form>
	</div>
</body>
</html>