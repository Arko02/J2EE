<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- CSS style block for background color and input fields -->
<style>
  body {
    background-color: red;
    text-align: center;
  }
  
  /* To zoom out the input fields of phone number and password */
  /* CSS to adjust the font size and padding of the input fields */
  input[type="tel"], input[type="password"] {
    font-size: 16px;
    padding: 10px;
    -webkit-text-size-adjust: 100%;
    -ms-text-size-adjust: 100%;
  }
  
</style>

</head>
<body>

   <form action="login" method="post">
     Phone Number: <input type="tel" name="ph"><br>
     Password: <input type="password" name ="ps"><br>
     <input type="submit" value="LOGIN">
   </form>
   <h3><a href="Register.jsp">Click here to Register</a></h3>

</body>
</html>
