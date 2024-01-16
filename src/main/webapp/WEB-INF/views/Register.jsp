<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

  <head>

      <title>Registrazione</title>
      <%@ include file="navBar.jsp" %>
      
      <style>
        <%@ include file="css/register.css" %>        
      </style>
  </head>

  <body>

      <div class="form-container">
          <h2>Registrati</h2>
          <form action="${pageContext.request.contextPath}/register" method="post">

            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <div id="errorUsername" class="errorUsername">
                <p>${errorUsername}</p>
            </div>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <div id="errorUsername" class="errorUsername">
                <p>${errorPassword}</p>
            </div>

            <button type="submit">Registrati</button>

          </form>
          <p class="reg-text">Sei già registrato? <a href="${pageContext.request.contextPath}/login">Login</a></p>
      </div>

      <%@ include file="footer.jsp" %>

  </body>
</html>
