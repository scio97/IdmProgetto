<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <title>Login</title>

    <%@ include file="navBar.jsp" %>

    <style>
        <%@ include file="css/login.css" %>
    </style>

    <%
        String txtRedirect = "";

        if(request.getParameter("redirect") != null){
            switch (request.getParameter("redirect")){
                case "ct":
                    txtRedirect = "E' necessario effettuare l'accesso prima di creare un treno.";
                    break;
                case "lt":
                    txtRedirect = "E' necessario effettuare l'accesso prima di visualizzare la lista dei treni.";
                    break;
            }
        }
    %>
</head>

<body>

    <div class="form-container">
        <h2>Login</h2>
        <form action="${pageContext.request.contextPath}/login" method="post">

            <div id="redirect" class="redirect">
                <p><i><%= txtRedirect %></i></p>
            </div>

            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <div id="errorUsername" class="errorUsername">
                <p>${errorUsername}</p>
            </div>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <div id="errorPassword" class="errorPassword">
                <p>${errorPassword}</p>
            </div>

            <button type="submit">Login</button>
        </form>
        <p class="reg-text">Non sei ancora registrato? <a href="${pageContext.request.contextPath}/register">Registrati</a></p>
    </div>

    <%@ include file="footer.jsp" %>

</body>

</html>
