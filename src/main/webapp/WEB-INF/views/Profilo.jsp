<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.marcoarcarisi.demo.entity.TreniCreati" %>

<%
    List<TreniCreati> treniCreati = (List<TreniCreati>) request.getAttribute("treniCreati");
    String username = (String) session.getAttribute("user");
%>

<html>
<head>
    <title>Profilo Utente</title>
    <style>
        .treno-details {
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 10px;
        }

        .treno-images img {
            width: 15%; /* Regola la larghezza delle immagini a tuo piacimento */
            margin-right: 5px; /* Aggiunge spazio tra le immagini */
        }

        .welcome-message {
            background-color: #f0f5f9;
            color: #34495e;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
        }
    </style>
</head>
<body>

<%
    if (username != null) {
%>
        <div class="welcome-message">
            <h3>Benvenuto nel tuo profilo, <%= username %>!</h3>
            <p>Questi sono i treni che hai creato.</p>
        </div>

        <% if (treniCreati != null && !treniCreati.isEmpty()) { %>
            <% for (TreniCreati treno : treniCreati) { %>
                <div class="treno-details">
                    <h3>Dettagli Treno</h3>
                    <p>Id: <%= treno.getId() %></p>
                    <p>Input Creazione: <%= treno.getInputCreazione() %></p>
                    <p>Paese provenienza del treno: <%= treno.getNazionalita() %></p>

                    <div class="treno-images">
                        <!-- Logica per mostrare le immagini basate sui caratteri -->
                        <% for (char carattere : treno.getInputCreazione().toCharArray()) { %>
                            <%-- Aggiungi logica per mostrare le immagini qui usando il carattere --%>
                            <% if (carattere == 'H') { %>
                                <img src="/images/H.png" alt="Immagine H" style="width: 15%;">
                            <% } else if (carattere == 'C') { %>
                                <img src="/images/C.png" alt="Immagine C" style="width: 10%;">
                            <% } else if (carattere == 'P') { %>
                                <img src="/images/P.png" alt="Immagine P" style="width: 10%;">
                            <% } else if (carattere == 'R') { %>
                                <img src="/images/R.png" alt="Immagine R" style="width: 8%;">
                            <% } %>
                        <% } %>
                        <!-- Fine logica immagini -->
                    </div>
                </div>
            <% } %>
        <% } else { %>
            <p>Nessun treno creato.</p>
        <% } %>
<%
    } else {
%>
        <p>Utente non autenticato. Effettua il login.</p>
<%
    }
%>

</body>
</html>