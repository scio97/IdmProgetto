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
<title>Dettagli Treno</title>

<style>
body {
	background-color: #f0f5f9;
	font-family: Arial, sans-serif;
	margin: 0;
}

h2 {
	padding: 20px;
	color: #333;
}

h3 {
	padding: 20px;
	font-size: 24px;
	color: #333;
}

p {
	color: #666;
}

.error {
	color: #ff0000;
}

.suggestion {
	color: #ff9900;
}

table {
	padding: 20px;
	background-color: #2980b9;
	color: #fff;
	border-collapse: collapse;
	width: calc(100% - 40px);
	margin: 20px;
	border: 2px solid #ddd;
	border-radius: 8px;
	overflow: hidden;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: left;
	transition: background-color 0.3s;
}

th {
	background-color: #1f4566; /* Colore più scuro per la prima riga */
}

tr:hover {
	color: #fff;
	background-color: #2d6187; /* Colore più scuro durante l'hover */
}

.footer {
	background-color: #2980b9;
	color: #fff;
	padding: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	position: fixed;
	bottom: 0;
	width: 100%;
	text-align: center;
	margin: 0;
}
</style>
</head>
<body>
	<% if (request.getAttribute("errore") != null) { %>
	<p>
		Errore:
		<%= request.getAttribute("errore") %></p>
	<p>
		Suggerimento:
		<%= request.getAttribute("suggerimento") %></p>
	<% } %>

	<% if (request.getAttribute("treno") != null) { %>
	<h2>Dettagli Treno:</h2>
	<table>
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
	</table>
	<h3>Vagoni:</h3>

	<% if (request.getAttribute("caratteri") != null) { %>
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
	<% } %>
</body>
<div class="footer">
	<p>&copy; 2024 Trenino. Tutti i diritti riservati.</p>
</div>
</html>