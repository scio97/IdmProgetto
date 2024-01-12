<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%
    // Recupera la stringaTreno dalla richiesta
    String stringaTreno = (String) request.getAttribute("stringaTreno");

    if (stringaTreno != null && !stringaTreno.isEmpty()) {
        List<Character> caratteri = new ArrayList<>();
        for (char c : stringaTreno.toCharArray()) {
            caratteri.add(c);
        }
        request.setAttribute("caratteri", caratteri);
    }
%>

<html>
<head>
    <title>Dettagli Treno</title>
</head>
<body>
    <% if (request.getAttribute("errore") != null) { %>
        <p>Errore: <%= request.getAttribute("errore") %></p>
        <p>Suggerimento: <%= request.getAttribute("suggerimento") %></p>
    <% } %>

    <% if (request.getAttribute("treno") != null) { %>
        <h2>Dettagli Treno</h2>
        <p>Peso totale treno: <%= request.getAttribute("treno.pesoTotale()") %> Kg</p>
        <p>Lunghezza totale treno: <%= request.getAttribute("treno.lunghezzaTotale()") %> m</p>
        <p>Velocità massima: <%= request.getAttribute("treno.velocita()") %> Km/h</p>
        <p>Stringa di input: <%= request.getAttribute("stringaTreno") %></p>

        <h3>Vagoni:</h3>

        <% if (request.getAttribute("caratteri") != null) { %>
            <% for (Character carattere : (List<Character>) request.getAttribute("caratteri")) { %>
                <!-- Esegui un'operazione diversa per ogni carattere -->

                <%-- Stampa un'immagine in base al valore del carattere con dimensioni in percentuale --%>
                <% if (carattere == 'H') { %>
                    <img src="/images/H.png" alt="Immagine H" style="width: 100%;">
                <% } else if (carattere == 'C') { %>
                    <img src="/images/C.png" alt="Immagine C" style="width: 100%;">
                <% } else if (carattere == 'P') { %>
                    <img src="/images/P.png" alt="Immagine P" style="width: 100%;">
                <% } else if (carattere == 'R') { %>
                    <img src="/images/R.png" alt="Immagine R" style="width: 100%;">
                <% } %>
            <% } %>
        <% } %>
    <% } %>
</body>
</html>