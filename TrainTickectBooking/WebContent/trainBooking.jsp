<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
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
	<div class="container pt-5">
        <h2>Train Ticket Booking</h2>
        <form>
            <div class="row">
                <div class="col-md-6">
                    <select class="input form-select">
                    	<option>From</option>
                        <%
                        	try{
                        		Class.forName("org.postgresql.Driver");
                    			Connection cn = DriverManager.getConnection("jdbc:postgresql://192.168.110.48/plf_training",
                    					"plf_training_admin", "pff123");
                    			Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    			ResultSet rs = st.executeQuery("select * from h_stations");
                    			while(rs.next()){%>
                    			<option><%=rs.getString(2) %></option>
                        	<%}}catch(Exception e){System.out.println(e);} %>
                      </select>
                </div>
                <div class="col-md-6">
                    <select class="input form-select">
                    	<option>To</option>
                        <%
                        	try{
                        		Class.forName("org.postgresql.Driver");
                    			Connection cn = DriverManager.getConnection("jdbc:postgresql://192.168.110.48/plf_training",
                    					"plf_training_admin", "pff123");
                    			Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    			ResultSet rs = st.executeQuery("select * from h_stations");
                    			while(rs.next()){%>
                    			<option><%=rs.getString(2) %></option>
                        	<%}}catch(Exception e){System.out.println(e);} %>
                      </select>
                </div>
            </div>   
            <br/>
            <div class="row">
                <div class="col-md-6">
                    <input class="input form-control" type="date" placeholder="Date"> 
                </div>
                <div class="col-md-6">
                    <select class="input form-select">
                        <option selected>Open this select menu</option>
                        <option value="Sleeper">Sleeper</option>
                        <option value="1st AC">1st AC</option>
                        <option value="2nd AC">2nd AC</option>
                        <option value="3rd AC">3rd AC</option>
                      </select>
                </div>
            </div>  
            <br/>
            <div class="row">
                <div class="col-md-5"></div>
                <div class="col-md-2">
                    <input type="submit" class="input bg-primary form-control text-white" />    
                </div>
                <div class="col-md-5"></div>
            </div>       
        </form>
        <br/>
        <h2>Passengers List</h2>
        <table class="table table-bordered">
            <tr>
                <td>1</td>
                <td><input type="text" id="pn1" name="pn1" class="form-control" placeholder="Name" /></td>
                <td><input type="text" id="pg1" name="pg1" class="form-control" placeholder="Gender"  /></td>
                <td><input type="number" id="pa1" name="pa1" class="form-control" placeholder="Age"  /></td>
                <td><input type="text" id="pp1" name="pp1" class="form-control" placeholder="Preferences"  /></td>
            </tr>
            <tr>
                <td>2</td>
                <td><input type="text" id="pn1" name="pn1" class="form-control" placeholder="Name" /></td>
                <td><input type="text" id="pg1" name="pg1" class="form-control" placeholder="Gender"  /></td>
                <td><input type="number" id="pa1" name="pa1" class="form-control" placeholder="Age"  /></td>
                <td><input type="text" id="pp1" name="pp1" class="form-control" placeholder="Preferences"  /></td>
            </tr>
            <tr>
                <td>3</td>
                <td><input type="text" id="pn1" name="pn1" class="form-control" placeholder="Name" /></td>
                <td><input type="text" id="pg1" name="pg1" class="form-control" placeholder="Gender"  /></td>
                <td><input type="number" id="pa1" name="pa1" class="form-control" placeholder="Age"  /></td>
                <td><input type="text" id="pp1" name="pp1" class="form-control" placeholder="Preferences"  /></td>
            </tr>
            <tr>
                <td>4</td>
                <td><input type="text" id="pn1" name="pn1" class="form-control" placeholder="Name" /></td>
                <td><input type="text" id="pg1" name="pg1" class="form-control" placeholder="Gender"  /></td>
                <td><input type="number" id="pa1" name="pa1" class="form-control" placeholder="Age"  /></td>
                <td><input type="text" id="pp1" name="pp1" class="form-control" placeholder="Preferences"  /></td>
            </tr>
            <tr>
                <td>5</td>
                <td><input type="text" id="pn1" name="pn1" class="form-control" placeholder="Name" /></td>
                <td><input type="text" id="pg1" name="pg1" class="form-control" placeholder="Gender"  /></td>
                <td><input type="number" id="pa1" name="pa1" class="form-control" placeholder="Age"  /></td>
                <td><input type="text" id="pp1" name="pp1" class="form-control" placeholder="Preferences"  /></td>
            </tr>
            <tr>
                <td>6</td>
                <td><input type="text" id="pn1" name="pn1" class="form-control" placeholder="Name" /></td>
                <td><input type="text" id="pg1" name="pg1" class="form-control" placeholder="Gender"  /></td>
                <td><input type="number" id="pa1" name="pa1" class="form-control" placeholder="Age"  /></td>
                <td><input type="text" id="pp1" name="pp1" class="form-control" placeholder="Preferences"  /></td>
            </tr>
        </table>
    </div>
</body>
</html>