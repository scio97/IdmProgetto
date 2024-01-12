<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="navBar.jsp" %>
    <title>Crea Treno</title>
</head>
<body>

    <form method="post" action="/creaTreno">
    <label for="input">Stringa del Treno:</label>
    <input type="text" id="input" name="input" required>
 <label for="nazionalita">Paese di provenienza:</label>
    <input type="text" id="nazionalita" name="nazionalita" required>

    <button type="submit">Crea Treno</button>
</form>
</body>
</html>
