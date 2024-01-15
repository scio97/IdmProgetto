<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
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
        }

        .form-container {
            max-width: 500px;
            background-color: #ecf0f3;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            margin: auto;
        }

        label {
            display: block;
            margin-bottom: 12px;
            font-weight: bold;
            color: #2980b9;
        }

        input {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            box-sizing: border-box;
            border: 1px solid #bdc3c7;
            border-radius: 6px;
        }

        button {
            background-color: #3498db;
            color: #fff;
            padding: 12px 20px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }

        button:hover {
            background-color: #2980b9;
        }

        .footer {
            background-color: #2980b9;
            color: #fff;
            padding: 10px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: auto;
            text-align: center;
        }
    </style>
</head>

<body>

    <div class="form-container">
        <h2>Login</h2>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <button type="submit">Login</button>
        </form>
        <p>Non sei ancora registrato? <a href="${pageContext.request.contextPath}/register">Registrati</a></p>
    </div>

    <div class="footer">
        <p>&copy; 2024 Trenino. Tutti i diritti riservati.</p>
    </div>

</body>

</html>
