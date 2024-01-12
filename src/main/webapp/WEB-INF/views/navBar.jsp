<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">

<%@ page session="true" %>
<%
    String username, url, txtAccesso, urlAccesso;
    if(session != null && session.getAttribute("user") != null){
        username = (String) session.getAttribute("user");
        url = "";

        txtAccesso = "Logout";
        urlAccesso = "logout";
    }else{
        username = "Registrati";
        url = "register";

        txtAccesso = "Login";
        urlAccesso = "login";
    }
%>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
    <a class="navbar-brand">Trenino</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/listatreni">ListaTreni</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/<%= urlAccesso %>" id="accesso"><%= txtAccesso %></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/<%= url %>" id="registra"><%= username %></a>
        </li>
            
        </ul>
    </div>
    </div>
</nav>