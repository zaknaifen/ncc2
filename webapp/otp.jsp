<%@page import="pl.ncc2.lx.GeneratePass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String name=request.getParameter("name");
	String password=request.getParameter("password");
	String key=request.getParameter("key");
    
	
	if(!pl.ncc2.authlog.Validate.CheckKey(key)){
		return; }	
	
	
		
	if(!pl.ncc2.authlog.Validate.checkUser(name, password))
        {	return;}
	
	
	
	
	pl.ncc2.lx.GeneratePass.PreparePass(name);
    
    
    %>
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="LoginServlet" method="post">
		<table border="1"><tr>
<td>Name:</td>

<td><input type="text" name="name"><br></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="password"><br></td>
</tr>
<tr>
<td>key:</td>
<td><input type="password" name="key"><br></td>
</tr>

<tr>
<td></td>
<td><input type="password" name="otp"><br></td>
</tr>


<tr>
<td></td>
<td><input type="submit" value="submit"></td>
</tr>
		</table>
</body>
</html>