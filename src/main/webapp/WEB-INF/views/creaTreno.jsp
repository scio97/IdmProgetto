<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="navBar.jsp" %>
    <title>Crea Treno</title>
    <style>
        <%@ include file="css/creaTreno.css" %>
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

    <%@ include file="footer.jsp" %>
    
</body>
</html>
