<%@ page session="true" %>

<%
    String usernameNav, urlNav, txtAccessoNav, urlAccessoNav;
    if(session != null && session.getAttribute("user") != null){
        usernameNav = (String) session.getAttribute("user");
        urlNav = "profilo";

        txtAccessoNav = "Logout";
        urlAccessoNav = "logout";
    }else{
        usernameNav = "Registrati";
        urlNav = "register";

        txtAccessoNav = "Login";
        urlAccessoNav = "login";
    }
%>

<style>
    <%@ include file="css/navBar.css" %>
</style>

<nav class="navbar">
    <div class="navbar-left">
        <a href="${pageContext.request.contextPath}/">Home</a>
        <a href="${pageContext.request.contextPath}/creaTreno">Crea un treno!</a>
        <a href="${pageContext.request.contextPath}/listaTreni">Treni da tutto il mondo!</a>
        <a href="${pageContext.request.contextPath}/cercaTreni">Ricerca treno</a>
    </div>
    <div class="navbar-right">
        <a href="${pageContext.request.contextPath}/<%= urlAccessoNav %>"><%= txtAccessoNav %></a>
        <a href="${pageContext.request.contextPath}/<%= urlNav %>"><%= usernameNav %></a>
    </div>
</nav>