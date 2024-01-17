<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="com.marcoarcarisi.demo.entity.DatiLogin"%>
<%@ page import="com.marcoarcarisi.demo.entity.TreniCreati"%>

<%
    List<TreniCreati> treniCreati = (List<TreniCreati>) request.getAttribute("treniCreati");
    String username = (String) session.getAttribute("user");
    DatiLogin utenteLoggato = (DatiLogin) session.getAttribute("utente");
    String admin = "admin";
%>

<html>
	<head>

		<title>Lista Treni</title>

		<%@ include file="navBar.jsp" %>

		<style>
			<%@ include file="css/listaTreni.css" %>
		</style>

	</head>
	
	<body>

		<div class="container">
			<%
			if (username != null) {
			%>
			<div class="welcome-message">Questi sono i treni creati dagli tutti gli utenti:</div>

			<% if (treniCreati != null && !treniCreati.isEmpty()) { %>
			<% for (TreniCreati treno : treniCreati) { %>

			<div class="treno-details">

				<div class="treno-details-title">
					<img src="https://flagsapi.com/<%=treno.getCodicepaese()%>/shiny/32.png" alt="Bandiera" class="img-flag">
					<div class="txt-titolo-dettagli">Dettagli Treno</div>
				</div>

				<div class="treno-info">
					<label>creato da:</label> <span><%= treno.getUser() %></span>
				</div>

				<div class="treno-info">
					<label>Creazione:</label> <span><%= treno.getInputCreazione() %></span>
				</div>

				<div class="treno-info">
					<label>Paese di provenienza:</label><span><%= treno.getNazionalita() %></span>
				</div>


				<div class="treno-images">
					<% for (char carattere : treno.getInputCreazione().toCharArray()) { %>
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

				<% if (utenteLoggato.getRuolo().equals(admin)) { %>
					<form method="post" action="/eliminaTrenoAdmin">
						<input type="hidden" name="idTreno" value="<%= treno.getId() %>">
						<button type="submit" class="btn btn-danger">Elimina Treno</button>
					</form>
				<% } %>
				
			</div>
			<% } %>
			<% } else { %>
			<p class="no-treni">Nessun treno creato.</p>
			<% } %>
			<%
				}
			%>
		</div>

		<%@ include file="footer.jsp" %>

	</body>
</html>
