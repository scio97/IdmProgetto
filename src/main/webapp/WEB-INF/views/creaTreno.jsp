<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="navBar.jsp" %>
    <title>Crea Treno</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .page-container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }

        .title {
            text-align: center;
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .subtitle {
            text-align: center;
            font-size: 18px;
            color: #555;
            margin-bottom: 20px;
        }

        .instructions {
            margin-bottom: 30px; /* Aumenta il margine inferiore */
            font-size: 14px;
            color: #555;
        }

        .box-container {
            display: flex;
            justify-content: space-between;
            margin-bottom: 40px;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 8px rgba(0, 0, 0, 0.1); /* Riduci l'ombreggiatura */
        }

        .box {
            flex: 1;
            text-align: center;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-right: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }

        .box img {
            width: 100%; /* La larghezza sarà il 100% del contenitore */
            height: auto; /* Altezza fissa, puoi regolare questo valore in base alle tue preferenze */
            object-fit: cover;
            margin-bottom: 10px;
            border-radius: 4px;
        }

        .box h3 {
            margin-bottom: 8px;
            font-size: 16px;
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
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            background-color: #4caf50;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }

        .footer {
            text-align: center;
            margin-top: 20px;
            padding: 10px;
            background-color: #fff; /* Cambiato il colore di sfondo */
            color: #555; /* Cambia il colore del testo nel footer per migliorare il contrasto */
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
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
                <p>Una potente locomotiva per guidare il tuo treno.</p>
            </div>
            <div class="box">
                <h3>Vagone Passeggeri</h3>
                <img src="/images/passeggeri_image.png" alt="Vagone Passeggeri">
                <p>Un comodo vagone per i tuoi passeggeri.</p>
            </div>
            <div class="box">
                <h3>Vagone Cargo</h3>
                <img src="/images/cargo_image.png" alt="Vagone Cargo">
                <p>Un resistente vagone per il trasporto di merci.</p>
            </div>
            <div class="box">
                <h3>Vagone Ristorante</h3>
                <img src="/images/ristorante_image.png" alt="Vagone Ristorante">
                <p>Un vagone ristorante per servire deliziosi pasti durante il viaggio.</p>
            </div>
        </div>

        <form method="post" action="/creaTreno">
            <div class="instructions">
                <p>Compila il seguente modulo per creare un nuovo treno. Inserisci la stringa del treno e il paese di provenienza.</p>
            </div>
            
            <label for="input">Stringa del Treno:</label>
            <input type="text" id="input" name="input" required>
            
            <label for="nazionalita">Paese di provenienza:</label>
            <input type="text" id="nazionalita" name="nazionalita" required>

            <button type="submit">Crea Treno</button>
        </form>

        <div class="footer">
            <p>&copy; 2024 CreaTreno.com. Tutti i diritti riservati.</p>
        </div>
    </div>
</body>
</html>
