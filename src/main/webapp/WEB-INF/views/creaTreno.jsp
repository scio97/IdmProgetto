<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="navBar.jsp" %>
    <title>Crea Treno</title>
    <style>
        body {
            background-color: #f0f5f9; /* Sfondo più chiaro tendente al blu */
            color: #34495e; /* Colore testo più scuro tendente al blu */
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }

        .page-container {
            flex: 1;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }

        .title {
            text-align: center;
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 10px;
            color: #2980b9; /* Blu più intenso */
        }

        .subtitle {
            text-align: center;
            font-size: 18px;
            color: #555;
            margin-bottom: 20px;
        }

        .instructions {
            margin-bottom: 30px;
            font-size: 14px;
            color: #555;
        }

        .box-container {
            display: flex;
            gap: 20px; /* Aggiunto il gap tra i box */
            justify-content: space-between;
            margin-bottom: 40px;
            padding: 20px;
            background-color: #ecf0f3; /* Sfondo più chiaro tendente al blu */
            border-radius: 8px;
            box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
        }

        .box {
            flex: 1; /* Occupa tutto lo spazio disponibile */
            max-width: 200px; /* Larghezza massima del box */
            text-align: center;
            padding: 10px;
            border: 1px solid #bdc3c7; /* Colore bordo tendente al blu */
            border-radius: 4px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: #dfe6e9; /* Colore sfondo più chiaro tendente al blu */
        }

        .box img {
            width: 100%;
            height: auto;
            object-fit: cover;
            margin-bottom: 10px;
            border-radius: 4px;
        }

        .box h3 {
            margin-bottom: 8px;
            font-size: 16px;
            color: #2980b9; /* Blu più intenso */
        }

        .box p {
            margin: 0;
            font-size: 14px;
            color: #555;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #2980b9; /* Blu più intenso */
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
            border: 1px solid #bdc3c7; /* Colore bordo tendente al blu */
            border-radius: 4px;
        }

        button {
            background-color: #3498db; /* Blu più vivido */
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #2980b9; /* Blu più intenso al passaggio del mouse */
        }

        .footer {
            background-color: #2980b9;
            color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: auto;
            text-align: center;
        }
    </style>
</head>
<body>

    <div class="page-container">
        <div class="title">Crea il tuo Treno!</div>
        <div class="subtitle">Scegli gli elementi del tuo treno e indicane la provenienza</div>

        <div class="box-container">
            <div class="box">
                <h3>Locomotiva</h3>
                <img src="/images/locomotiva_image.png" alt="Locomotiva">
                <p>Lettera: <b>H</b></p><br>
                <p>Una potente locomotiva per guidare il tuo treno.</p>
            </div>
            <div class="box">
                <h3>Vagone Passeggeri</h3>
                <img src="/images/passeggeri_image.png" alt="Vagone Passeggeri">
                <p>Lettera: <b>P</b></p><br>
                <p>Un comodo vagone per i tuoi passeggeri.</p>
            </div>
            <div class="box">
                <h3>Vagone Cargo</h3>
                <img src="/images/cargo_image.png" alt="Vagone Cargo">
                <p>Lettera: <b>C</b></p><br>
                <p>Un resistente vagone per il trasporto di merci.</p>
            </div>
            <div class="box">
                <h3>Vagone Ristorante</h3>
                <img src="/images/ristorante_image.png" alt="Vagone Ristorante">
                <p>Lettera: <b>R</b></p><br>
                <p>Un vagone ristorante per servire deliziosi pasti durante il viaggio.</p>
            </div>
        </div>

        <form method="post" action="/creaTreno">
            <div class="instructions">
                <p>Compila il seguente modulo per creare un nuovo treno. La stringa del treno deve essere formata dalle lettere 'H', 'P', 'C', o 'R' concatenate tra loro.</p>
            </div>
            
            <label for="input">Stringa del Treno:</label>
            <input type="text" id="input" name="input" required>
            
            <label for="nazionalita">Paese di provenienza:</label>
            <input type="text" id="nazionalita" name="nazionalita" required>

            <button type="submit">Crea Treno</button>
            <br><br>
        </form>
    </div>

    <div class="footer">
        <p>&copy; 2024 Trenino. Tutti i diritti riservati.</p>
    </div>
    
</body>
</html>
