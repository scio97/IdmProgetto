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

<style>
    .navbar {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 10px;
        background-color: #003d4c; /* Cambiato colore di sfondo della navbar */
        color: black; /* Colore del testo */
    }

    .navbar-left {
        /* Stili per gli elementi a sinistra della navbar se presenti */
    }

    .navbar-right {
        display: flex;
        gap: 10px;
    }

    .navbar a {
        color: black; /* Cambiato colore dei link nella navbar */
        transition: color 0.3s; /* Aggiunto effetto di transizione per il colore */
    }

    .navbar a:hover, .navbar a:focus {
        color: #00acc1; /* Cambiato colore al passaggio del mouse o al focus */
    }

    .navbar-brand {
        display: flex;
        align-items: center;
    }

    .navbar-brand img {
        max-width: 50px; /* Larghezza massima dell'immagine del trenino */
        height: auto; /* Mantieni l'aspetto proporzionato */
        display: block; /* Impedisce la visualizzazione di altri margini orizzontali */
        margin: 0 auto; /* Centra l'immagine orizzontalmente */
    }

</style>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" >
            <img src="https://banner2.cleanpng.com/20171220/lss/train-png-5a39f79632b9a0.48010542151374837420784507.jpg" alt="Trenino Logo">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/creaTreno">Crea un treno!</a>
                </li>
            </ul>
        </div>
        <div class="navbar-right">
            <a class="nav-link" href="${pageContext.request.contextPath}/<%= urlAccesso %>" id="accesso"><%= txtAccesso %></a>
            <a class="nav-link" href="${pageContext.request.contextPath}/<%= url %>" id="registra"><%= username %></a>
        </div>
    </div>
</nav>