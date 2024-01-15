<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Cerca Treno</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #87CEEB; /* Light Sky Blue */
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        .search-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center; /* Centratura orizzontale del contenuto */
        }

        h1 {
            color: #3498db; /* Dodger Blue */
        }

        label {
            margin-bottom: 0;
            font-family: 'Arial', sans-serif; /* Cambio del font per la scritta "Paese" */
        }

        button {
            background-color: #3498db;
            color: white;
            border: 1px solid #3498db; /* Aggiunta del bordo per il bottone "Cerca" */
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #2980b9; /* Darker Dodger Blue */
        }
    </style>
</head>
<body>
    <div class="search-container">
        <h1>Ricerca treni</h1>
        <form action="${pageContext.request.contextPath}/risultatoRicerca" method="post">
            <div class="mb-3">
                <label for="paese" class="form-label">Paese:</label>
                <input type="text" id="paese" name="paese" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Cerca</button>
        </form>
    </div>
</body>
</html>