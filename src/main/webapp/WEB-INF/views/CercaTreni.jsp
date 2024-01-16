<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Cerca Treno</title>
    <%@ include file="navBar.jsp" %>

    <style>
        body {
            background-color: #f0f5f9;
            color: #34495e;
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            overflow-x: hidden;
        }

        .form-container {
            width: 400px; /* Imposta la larghezza desiderata */
            margin: auto; /* Centra orizzontalmente */
            background-color: #ecf0f3;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        label {
            display: block;
            margin-bottom: 12px; /* Aumentato il margine inferiore */
            font-weight: bold;
            color: #2980b9;
        }

        input {
            width: 100%;
            padding: 12px; /* Aumentato il padding */
            box-sizing: border-box;
            border: 1px solid #bdc3c7;
            border-radius: 6px; /* Aumentato il bordo di arrotondamento */
        }

        button {
            background-color: #3498db;
            color: #fff;
            padding: 12px 20px; /* Aumentato il padding */
            border: none;
            border-radius: 6px; /* Aumentato il bordo di arrotondamento */
            cursor: pointer;
        }

        button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Ricerca treni</h2>
        <form action="${pageContext.request.contextPath}/risultatoRicerca" method="post">

            <label for="paese" class="form-label">Paese:</label>
            <input type="text" id="paese" name="paese" class="form-control" required>

            <button type="submit" class="btn btn-primary">Cerca</button>
        </form>
    </div>

    <%@ include file="footer.jsp" %>

</body>
</html>