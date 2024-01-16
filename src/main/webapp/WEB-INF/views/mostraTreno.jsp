<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

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
		<%@ include file="navBar.jsp" %>
		<title>Dettagli Treno</title>

		<style>
			<%@ include file="css/mostraTreno.css" %>
		</style>

	</head>

	<body>
		<% if (request.getAttribute("errore") != null) { %>
			<div class="error-container">
				<div class="error-title">Errore: <%= request.getAttribute("errore") %></div>
				<br>
				<div class="error-subtitle">Suggerimento: <%= request.getAttribute("suggerimento") %></div>
			</div>
		<% } %>

		<% if (request.getAttribute("treno") != null) { %>

		<div class="title">Dettagli Treno:</div>

		<table class="tabellaTreno">
			<tr>
				<th>Descrizione</th>
				<th>Valore</th>
			</tr>
			<tr>
				<td>Peso totale treno</td>
				<td>${treno.pesoTotale()} Kg</td>
			</tr>
			<tr>
				<td>Lunghezza totale treno</td>
				<td>${treno.lunghezzaTotale()} m</td>
			</tr>
			<tr>
				<td>Velocità massima</td>
				<td>${treno.velocita()} Km/h</td>
			</tr>
			<tr>
				<td>Stringa di input</td>
				<td>${treno.getInput()}</td>
			</tr>
			<tr>
				<td>Input paese</td>
				<td><%= request.getAttribute("paeseInput") %></td>
			</tr>
			<tr>
				<td>Paese Normalizzato</td>
				<td><%= request.getAttribute("inputNormalizzato") %></td>
			</tr>
		</table>

		<div class="title">Vagoni:</div>

		<% if (request.getAttribute("caratteri") != null) { %>
		<div class="image-container">
		<% for (Character carattere : (List<Character>) request.getAttribute("caratteri")) { %>
		<!-- Esegui un'operazione diversa per ogni carattere -->

		<%-- Stampa un'immagine in base al valore del carattere con dimensioni in percentuale --%>
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
		<% } %>
		</div>
		<% } %>

		<%@ include file="footer.jsp" %>
		
	</body>

</html>