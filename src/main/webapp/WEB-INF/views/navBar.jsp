<%@ page session="true" %>

<%
    String username, url, txtAccesso, urlAccesso;
    if(session != null && session.getAttribute("user") != null){
        username = (String) session.getAttribute("user");
        url = "profilo";

        txtAccesso = "Logout";
        urlAccesso = "logout";
    }else{
        username = "Registrati";
        url = "register";

        txtAccesso = "Login";
        urlAccesso = "login";
    }
%>

<style>

    .navbar {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 10px;
        background-color: #2980b9;
        color: white;
        width: 100%;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .navbar a {
        color: white;
        text-decoration: none;
        padding: 10px 15px;
        border-radius: 4px;
        transition: background-color 0.3s, color 0.3s;
        margin-right: 15px;
    }

    .navbar-right a:first-child {
        margin-right: auto; /* Aggiunto per centrare il pulsante "Registrati" rispetto a destra */
    }

    .navbar a:hover,
    .navbar a:focus {
        background-color: #fff;
        color: #2980b9;
    }

</style>

<nav class="navbar">
    <div class="navbar-left">
        <a href="${pageContext.request.contextPath}/">Home</a>
        <a href="${pageContext.request.contextPath}/creaTreno">Crea un treno!</a>
        <a href="${pageContext.request.contextPath}/listaTreni">Treni da tutto il mondo!</a>
    </div>
    <div class="navbar-right">
        <a href="${pageContext.request.contextPath}/<%= urlAccesso %>"><%= txtAccesso %></a>
        <a href="${pageContext.request.contextPath}/<%= url %>"><%= username %></a>
    </div>
</nav>