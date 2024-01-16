let currentSlide = 0;
const intervalTime = 4000;
let interval;

function showSlide(index) {
    const slides = document.getElementsByClassName('carousel-slide');

    if (index >= slides.length) {
        currentSlide = 0;
    } else if (index < 0) {
        currentSlide = slides.length - 1;
    } else {
        currentSlide = index;
    }

    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = 'none';
    }

    slides[currentSlide].style.display = 'block';
}

function changeSlide(direction) {
    showSlide(currentSlide + direction);
}

function startAutoSlide() {
    interval = setInterval(() => {
        changeSlide(1);
    }, intervalTime);
}

function stopAutoSlide() {
    clearInterval(interval);
}

showSlide(currentSlide);

startAutoSlide();