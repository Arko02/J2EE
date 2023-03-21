<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		background-color: #F6A5D6; /* baby pink color */
		text-align: center;
	}
</style>
</head>
<body>

<%
	String name=(String)session.getAttribute("name");
	if(name!=null){
%>	
	<h1>Welcome Mr.<%=name %></h1>
	<h2> <a href="edit.jsp">Edit Your Account</a></h2>
	<h2><a href="Delete?id=<%=session.getAttribute("id")%>">Delete Your Account</a></h2>
	<h2><a href="View.jsp">View Your Profile</a></h2>
	<h2><a href="logout">Logout</a></h2>
   <% 
	}
	else
	{
	response.sendRedirect("Login.jsp");
	}
   %>

</body>
</html>
