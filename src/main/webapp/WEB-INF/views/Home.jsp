<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

  <title>Homepage</title>
  <%@ include file="navBar.jsp" %>

</head>
<body>

  <p>il nome utente e': <%= session.getAttribute("user") %></p>
          
</body>
</html>