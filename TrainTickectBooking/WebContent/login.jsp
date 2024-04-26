<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="style.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container p-5">
        <center><h2>Login</h2></center>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <form action="LoginAction" method="post">
                <% if(request.getAttribute("msg")!=null){ %>
                	<label style="color:red" >Enter Valid details</label>
                <%} %>	
                <input id="inp" class="input form-control" type="text" name="user" placeholder="Username">
                <br/>
                <input id="inp2" class="input form-control" type="password" name="pass" placeholder="Password">
                <br/>
                <% if(request.getAttribute("msg")!=null){ %>
                	<script>
                		document.getElementById("inp").style.border='1px solid red'
                    	document.getElementById("inp2").style.border='1px solid red'
                	</script>
                <%} %>	
                <input type="submit" class="input bg-primary form-control text-white" />
                </form>
            </div>
            <div class="col-md-4"></div>
        </div>
    </div>
</body>
</html>