<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dettagli Treno</title>
</head>
<body>
    <c:if test="${not empty errore}">
        <p>Errore: ${errore}</p>
        <p>Suggerimento: ${suggerimento}</p>
    </c:if>

    <c:if test="${not empty treno}">
        <h2>Dettagli Treno</h2>
        <p>${treno.toString()}</p>
        <p>Peso totale treno: ${treno.pesoTotale()} Kg</p>
        <p>Lunghezza totale treno: ${treno.lunghezzaTotale()} m</p>
        <p>Velocità massima: ${treno.velocita()} Km/h</p>
    </c:if>
</body>
</html>
