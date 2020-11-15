<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="index.css">
    <!-- <script src="https://kit.fontawesome.com/a076d05399.js"></script> -->
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="style.css">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <script >
    function validateForm() {
    	  var y=document.getElementById("pass1");
    	  var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
    	  var x = document.forms["myform"]["uid"].value;
    	  if (x.startsWith("FA")==false||x.length!=8) {
    		document.getElementById("userdemo").innerHTML = "wrong username";
      	    return false;
      	  }
    	  else if(y.value.match(passw)) 
    		  {
    		  return true;
    		  }
    	  else{
    		  document.getElementById("userdemo").innerHTML = "wrong password format";
        	  return false;
    	  } 
    	}
    </script>
</head>
<body>
			<div class="center">
      <div class="container">
      	<label id="userdemo"></label>
        <div class="text">Student Update</div>
        <form name="myform" onsubmit="return validateForm()" action="fupdate" method="post">
          <div class="data">
            <label>UserId</label>
            <input type="text" name="uid" value="${fac.fid}" required>
          </div>
          <div class="data">
            <label>Email</label>
            <input type="email" name="email"required>
          </div>
          <div class="data">
            <label>Name</label>
            <input type="text" name="uname"required>
          </div>
          <div class="data">
            <label>Department</label>
            <input type="text" name="dept"required>
          </div>
          <div class="data">
            <label>Password</label>
            <input type="password" name="pass" id="pass1" required>
          </div>
          <div class="btn">
            <div class="inner"></div>
            <button type="submit">update</button>
          </div>
        </form>
      </div>
    </div>
</body>
</html>