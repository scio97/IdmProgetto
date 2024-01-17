<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List" %>
<%@ page import="com.marcoarcarisi.demo.entity.TreniCreati" %>

<%
    List<TreniCreati> treniRicerca = (List<TreniCreati>) request.getAttribute("treniTrovati");
%>

<html>
    <head>

        <title>Risultato Ricerca</title>

        <%@ include file="navBar.jsp" %>

        <style>
			<%@ include file="css/risultatoRicerca.css" %>
		</style>

    </head>
    <body>

        <div class="container">

            <div class="welcome-message">Risultato ricerca treni</div>

            <% if (treniRicerca != null && !treniRicerca.isEmpty()) { %>
                <% for (TreniCreati treno : treniRicerca) { %>
                    <div class="treno-details">
                        <div class="treno-details-title">
					        <img src="https://flagsapi.com/<%=treno.getCodicepaese()%>/shiny/32.png" alt="Bandiera" class="img-flag">
					        <div class="txt-titolo-dettagli">Dettagli Treno</div>
				        </div>

                        <div class="treno-info">
                            <label>Creazione:</label> <span><%= treno.getInputCreazione() %></span>
                        </div>

                <div class="treno-info">
                    <label>Paese di provenienza:</label> <span><%= treno.getNazionalita() %></span>
                </div>

                        <div class="treno-images">
                            <!-- Logica per mostrare le immagini basate sui caratteri -->
                            <% for (char carattere : treno.getInputCreazione().toCharArray()) { %>
                                <!-- Aggiungi logica per mostrare le immagini qui usando il carattere -->
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
                        </div>
                    </div>
                <% } %>
            <% } else { %>
                <p>Nessun treno trovato per la ricerca.</p>
            <% } %>
        </div>

        <%@ include file="footer.jsp" %>

    </body>
</html>