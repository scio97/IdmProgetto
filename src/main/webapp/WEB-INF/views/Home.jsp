<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>

        <title>Homepage</title>

        <%@ include file="navBar.jsp" %>

        <style>
            <%@ include file="css/home.css" %>
        </style>

    </head>

    <body>

        <div class="page-container">
                <div class="title">Benvenuto su TrenoCreator!</div>
                <div class="subtitle">Un sito creato appositamente per tutti gli appassionati di treni!</div>

            <div class="row text-center">
                <div class="col-md-4">
                    <i class="bi bi-geo-alt feature-icon"></i>
                    <div class="titolo-box">Infinite configurazioni!</div>
                    <br>
                    <div class="sottotitolo-box">Crea il TUO treno personale, sono possibili infinite configurazioni!</div>
                </div>

                <div class="col-md-4">
                    <i class="bi bi-lightbulb feature-icon"></i>
                    <div class="titolo-box">Condividi il tuo treno!</div>
                    <br>
                    <div class="sottotitolo-box">I treni di ogni utente potranno essere visualizzati da tutti!</div>
                </div>

                <div class="col-md-4">
                    <i class="bi bi-star feature-icon"></i>
                    <div class="titolo-box">Crearlo é semplice!</div>
                    <br>
                    <div class="sottotitolo-box">Ti basterá inserire una semplice stringa di testo per creare il treno che hai sempre sognato!</div>
                </div>
            </div>

            <div class="carousel-container">

                <div class="carousel-slide">
                    <img src="/images/treno1.jpg" alt="Treno 1">
                    <div class="carousel-caption">
                        <div class="descrizione-img">Locomotiva del gruppo 625 (1910)</div>
                    </div>
                </div>

                <div class="carousel-slide">
                    <img src="/images/treno2.jpg" alt="Treno 2">
                    <div class="carousel-caption">
                        <div class="descrizione-img">Settebello Etr 300 (1953)</div>
                    </div>
                </div>

                <div class="carousel-slide">
                    <img src="/images/treno3.jpg" alt="Treno 3">
                    <div class="carousel-caption">
                        <div class="descrizione-img">Arlecchino ETR 250 Treno rapido di lusso (1960)</div>
                    </div>
                </div>

                <div class="carousel-slide">
                    <img src="/images/treno4.jpg" alt="Treno 4">
                    <div class="carousel-caption">
                        <div class="descrizione-img">Elettrotreno rapido ETR200 (1939)</div>
                    </div>
                </div>

                <div class="carousel-slide">
                    <img src="/images/treno5.jpg" alt="Treno 5">
                    <div class="carousel-caption">
                        <div class="descrizione-img">Frecciarossa 1000 (2015)</div>
                    </div>
                </div>

                <a class="carousel-prev" onclick="changeSlide(-1)">&#10094;</a>
                <a class="carousel-next" onclick="changeSlide(1)">&#10095;</a>
            </div>
        </div>

        <script>
            <%@ include file="script.js" %>
        </script>

    <%@ include file="footer.jsp" %>

    </body>

</html>
