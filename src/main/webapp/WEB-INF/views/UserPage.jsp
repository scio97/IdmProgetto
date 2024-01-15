<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>


    <div class="container mt-5">
        <form method="POST" action="${pageContext.request.contextPath}/login">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <button type="submit">Login</button>
        </form>
    </div>


    <nav class="navbar navbar-expand-lg bg-body-tertiary">

    </nav>


    <nav class="navbar bg-body-tertiary">

    </nav>

</body>
</html>
