<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

  <head>

      <title>Registrazione</title>
      <%@ include file="navBar.jsp" %>
      
      <style>
      
        body {
            background-color: #f0f5f9;
            color: #34495e;
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            overflow-x: hidden;
        }

        .form-container {
            max-width: 500px;
            background-color: #ecf0f3;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            margin: auto; /* Aggiunto solo il margine auto per centrare orizzontalmente e verticalmente */
        }

        label {
            display: block;
            margin-bottom: 12px; /* Aumentato il margine inferiore */
            font-weight: bold;
            color: #2980b9;
        }

        input {
            width: 100%;
            padding: 12px; /* Aumentato il padding */
            margin-bottom: 20px; /* Aumentato il margine inferiore */
            box-sizing: border-box;
            border: 1px solid #bdc3c7;
            border-radius: 6px; /* Aumentato il bordo di arrotondamento */
        }

        button {
            background-color: #3498db;
            color: #fff;
            padding: 12px 20px; /* Aumentato il padding */
            border: none;
            border-radius: 6px; /* Aumentato il bordo di arrotondamento */
            cursor: pointer;
        }

        button:hover {
            background-color: #2980b9;
        }

        #error-message {
          color: #c0392b; /* Colore del testo rosso per evidenziare l'errore */
          font-size: 14px; /* Dimensione del testo */
          margin-top: 10px; /* Spazio superiore aggiunto per separare dal resto del form */
        }

      </style>
  </head>

  <body>

      <div class="form-container">
          <h2>Registrati</h2>
          <form action="${pageContext.request.contextPath}/register" method="post">

            <div id="error-message" class="error-message">
                <p>${error}</p>
            </div>

            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <button type="submit">Registrati</button>

          </form>
          <p>Sei già registrato? <a href="${pageContext.request.contextPath}/login">Login</a></p>
      </div>

      <%@ include file="footer.jsp" %>

  </body>

</html>
