<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Cerca Treno</title>
    <%@ include file="navBar.jsp" %>

    <style>
        <%@ include file="css/cercaTreni.css" %>
    </style>
</head>

<body>
    <div class="form-container">
        <h2>Ricerca treni</h2>
        <form action="${pageContext.request.contextPath}/risultatoRicerca" method="post">

            <label for="paese">Paese:</label>
            <input type="text" id="paese" name="paese" required>

            <div id="errorPaese" class="errorPaese">
                    <p></p>
            </div>
            
            <button type="submit">Cerca</button>
        </form>
    </div>

    <%@ include file="footer.jsp" %>

</body>
</html>