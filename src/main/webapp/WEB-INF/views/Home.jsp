<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Homepage</title>
    <%@ include file="navBar.jsp" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Aggiungi altri stili CSS se necessario -->
    <style>
        body {
            background-color: #f0f5f9;
            color: #34495e;
        }

        .jumbotron {
            background-color: #2980b9;
            color: #ffffff;
            margin-bottom: 20px;
            padding-bottom: 50px;
        }

        .btn-primary {
            background-color: #005064;
            border-color: #005064;
        }

        .carousel {
            margin-bottom: 20px;
        }

        .custom-card {
            border: 1px solid rgba(0, 0, 0, 0.125);
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-bottom: 20px;
        }

        .custom-card:not(:last-child) {
            margin-right: 10px;
        }

        .btn-primary:hover {
            background-color: #003d4c;
            border-color: #003d4c;
        }

        .carousel {
            margin-top: 30px;
        }

        .feature-icon {
            font-size: 4em;
            margin-bottom: 10px;
            color: #00acc1;
        }

        .carousel-caption {
            background: rgba(0, 0, 0, 0.5);
            color: #ffffff;
            padding: 10px;
        }

        .carousel-img {
            max-width: 100%;
            height: auto;
            margin: auto;
            display: block;
        }

        .footer {
            background-color: #2980b9;
            color: #fff;
            padding: 10px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: auto;
            text-align: center;
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <div class="jumbotron text-center">
        <h1 class="display-4">Benvenuto su TrenoCreator!</h1>
        <p class="lead">Un sito creato appositamente per tutti gli appassionati di treni!</p>
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/creaTreno" role="button">Crea il tuo treno</a>
    </div>

    <div class="row text-center">
        <div class="col-md-4">
            <i class="bi bi-geo-alt feature-icon"></i>
            <h3>Infinite configurazioni!</h3>
            <p>Crea il TUO treno personale,sono possibili infinite configurazioni!</p>
        </div>

        <div class="col-md-4">
            <i class="bi bi-lightbulb feature-icon"></i>
            <h3>Condividi il tuo treno!</h3>
            <p>I treni di ogni utente potranno essere visualizzati da tutti!</p>
        </div>

        <div class="col-md-4">
            <i class="bi bi-star feature-icon"></i>
            <h3>Crearlo é semplicissimo!</h3>
            <p>Ti basterá inserire una semplice stringa di testo per creare il treno che hai sempre sognato!</p>
        </div>
    </div>

    <div id="trainCarousel" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="//live.staticflickr.com/7370/8786459840_c598183771_c.jpg" class="d-block mx-auto carousel-img" alt="Treno 1">
                <div class="carousel-caption">
                    <h5>Locomotiva del gruppo 625 (1910)</h5>
                </div>
            </div>

            <div class="carousel-item">
                <img src="//live.staticflickr.com/4045/4621702322_87e57c2650_z.jpg" class="d-block mx-auto carousel-img" alt="Treno 2">
                <div class="carousel-caption">
                    <h5>Elettrotreno rapido ETR200 (1939)</h5>
                </div>
            </div>

            <div class="carousel-item">
                <img src="//live.staticflickr.com/5291/5531758271_4b10c5b63b_c.jpg" class="d-block mx-auto carousel-img" alt="Treno 2">
                <div class="carousel-caption">
                    <h5>Settebello Etr 300 (1953)</h5>
                </div>
            </div>

            <div class="carousel-item">
                <img src="//live.staticflickr.com/4091/4837680524_704679b7aa_b.jpg" class="d-block mx-auto carousel-img" alt="Treno 2">
                <div class="carousel-caption">
                    <h5>Arlecchino ETR 250
                        Treno rapido di lusso (1960)</h5>
                </div>
            </div>

            <div class="carousel-item">
                <img src="//live.staticflickr.com/5333/8780050601_38c20d00ff_c.jpg" class="d-block mx-auto carousel-img" alt="Treno 2">
                <div class="carousel-caption">
                    <h5>Locomotiva elettrica E656 (1975)</h5>
                </div>
            </div>



            <div class="carousel-item">
                <img src="https://www.infotrasporti.com/images/articoli/17/16fa2b0294-1024.jpg" class="d-block mx-auto carousel-img" alt="Treno 2">
                <div class="carousel-caption">
                    <h5>Frecciarossa 1000 (2015)</h5>
                </div>
            </div>

        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#trainCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#trainCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>

<div class="footer">
    <p>&copy; 2024 Trenino. Tutti i diritti riservati.</p>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
