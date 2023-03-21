<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		background-color: yellow;
		text-align: center;
	}
</style>
</head>
<body>
<%
String name=(String)session.getAttribute("name");
int id=(int)session.getAttribute("id");
long phone=(long)session.getAttribute("phone");
int age=(int)session.getAttribute("age");
String password=(String)session.getAttribute("password");

if(name!=null){
%>
<h2>Id:<%=id %></h2>
<h2>name:<%=name %></h2>
<h2>phone:<%=phone %></h2>
<h2>age:<%=age %></h2>
<%
} else {
response.sendRedirect("Login.jsp");
}
%>
</body>
</html>
