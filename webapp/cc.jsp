<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="false"
    
 %>
  <%
 HttpSession session = request.getSession(false);
 String ses_2 = (String)request.getParameter("skey");
 System.out.println(ses_2);
 
 if (session==null){
	 
	 
    response.sendRedirect("http://localhost:8080/ncc2/login.html");
    return;
    }
 else { 
	 String ses =(String)request.getSession().getAttribute("session");
		
	 System.out.println(ses);
	 
 }
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>

<h1>ses test</h1>

<%= session %>


</body>
</html>