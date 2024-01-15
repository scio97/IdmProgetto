<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="com.marcoarcarisi.demo.entity.TreniCreati"%>

<%
    List<TreniCreati> treniCreati = (List<TreniCreati>) request.getAttribute("treniCreati");
    String username = (String) session.getAttribute("user");
%>

<html>
<head>
<title>Profilo Utente</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
   
<style>
body {
            font-family: 'Arial', sans-serif;
            background-color: #ecf0f1;
            margin: 0;
            padding: 0;
            overflow-x: hidden;
        }

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
        }

        .navbar a:hover,
        .navbar a:focus {
            background-color: #fff;
            color: #2980b9;
        }

.container {
	max-width: 800px;
	margin: 20px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.welcome-message {
	background-color: #3498db;
	color: #fff;
	padding: 15px;
	margin-bottom: 20px;
	border-radius: 8px;
}

.treno-details {
	border: 1px solid #ccc;
	padding: 15px;
	margin-bottom: 20px;
	border-radius: 8px;
}

.treno-details h3 {
	color: #3498db;
	margin-bottom: 10px;
}

.treno-info {
	margin-bottom: 10px;
}

.treno-info label {
	font-weight: bold;
	margin-right: 10px;
}


.treno-images img {
	width: 15%;
	margin-right: 5px;
	border-radius: 8px;
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
}

.no-treni {
	color: #e74c3c;
}

.login-message {
	color: #e74c3c;
}

</style>
</head>
<body>
    <div class="navbar">
        <div class="navbar-left">
            <a href="${pageContext.request.contextPath}/">Home</a>
            <a href="${pageContext.request.contextPath}/creaTreno">Crea un treno!</a>
            <a href="${pageContext.request.contextPath}/listaTreni">Treni da tutto il mondo!</a>
        </div>
        <div class="navbar-right">
            <% if (username != null) { %>
                <a href="${pageContext.request.contextPath}/logout">Logout</a>
                <a href="${pageContext.request.contextPath}/profilo"><%= username %></a>
            <% } else { %>
                <a href="${pageContext.request.contextPath}/login">Login</a>
                <a href="${pageContext.request.contextPath}/register">Registrati</a>
                <a href="${pageContext.request.contextPath}/listaTreni">Treni da tutto il mondo!</a>
            <% } %>
        </div>
    </div>

	<div class="container">
		<%
        if (username != null) {
    %>
		<div class="welcome-message">
			<h3>
				Benvenuto nel tuo profilo,
				<%= username %>!
			</h3>
			<p>Questi sono i treni che hai creato:</p>
		</div>

		<% if (treniCreati != null && !treniCreati.isEmpty()) { %>
		<% for (TreniCreati treno : treniCreati) { %>
		<div class="treno-details">
			<h3>Dettagli Treno</h3>

			<div class="treno-info">
				<label>Creazione:</label> <span><%= treno.getInputCreazione() %></span>
			</div>

			<div class="treno-info">
				<label>Paese di provenienza:</label> <span><%= treno.getNazionalita() %></span>
			</div>

			<div class="treno-images">
				<!-- Logica per mostrare le immagini basate sui caratteri -->
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
                <form method="post" action="/eliminaTreno">
                    <input type="hidden" name="trenoId" value="<%= treno.getId() %>">
                    <button type="submit" class="delete-button">Elimina</button>
                </form>
		</div>
		<% } %>
		<% } else { %>
		<p class="no-treni">Nessun treno creato.</p>
		<% } %>
		<%
        } else {
    %>
		<p class="login-message">Utente non autenticato. Effettua il
			login.</p>
		<%
        }
    %>
	</div>
    <%@ include file="footer.jsp" %>

</body>
</html>