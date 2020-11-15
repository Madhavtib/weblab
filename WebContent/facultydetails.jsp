<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html">
<html>
<head>
<link rel="stylesheet" href="index.css">
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css">
</head>
<body>
	<%
	 
	  response.addHeader("Pragma", "no-cache");
	  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	  response.addHeader("Cache-Control", "pre-check=0, post-check=0");
	  response.setDateHeader("Expires", 0);
	  if(session.getAttribute("fac")==null)
		{
			response.sendRedirect("flogin.html");
			
		}
	%>
<nav>
      <label class="logo">CollegeManagementSystem</label>
      <ul>
        <li><a href="index.html">Home</a></li>
        <li><a   href="studentlogin.html">Student</a></li>
        <li><a class="active" href="flogin.html">Faculty</a></li>
        <li><a href="departmenlist.jsp">Department</a></li>
        <li><a href="ContactUs.html">Contact Us</a></li>
      </ul>
    </nav>

	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>FacultyID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Department</th>
				</tr>
			</thead>
			<tbody>
				<tr>
				
				<td>${fac.fid}</td>
				<td>${fac.fname}</td>
				<td>${fac.email}</td>
				<td>${fac.dept}</td>
				</tr>
				<tr>
					<td><button class="btn btn-success" onclick="window.location.href='facultyupdate.jsp';">Update</button></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="container" align="center">

		<form action="flogout" method="post">
		<button class="btn btn-warning" type="submit">Logout</button>
		</form>
	</div>
</body>
</html>