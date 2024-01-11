<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Importazioni di stile e script -->
</head>
<body>

    <!-- Contenuto della pagina di login -->
    <div class="container mt-5">
        <form method="POST" action="${pageContext.request.contextPath}/login">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <button type="submit">Login</button>
        </form>
    </div>

    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <!-- Contenuto della barra di navigazione -->
    </nav>

    <!-- Seconda barra di navigazione -->
    <nav class="navbar bg-body-tertiary">
        <!-- Contenuto della seconda barra di navigazione -->
    </nav>

</body>
</html>
