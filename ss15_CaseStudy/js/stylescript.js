

jQuery(document).ready(function ($) {

    var slideCount = $('#slider ul li').length;
    var slideWidth = $('#slider ul li').width();
    var slideHeight = $('#slider ul li').height();
    var sliderUlWidth = slideCount * slideWidth;
    var currentSlide = 0;
    var autoplayInterval;

    $('#slider').css({ width: slideWidth, height: slideHeight });

    $('#slider ul').css({ width: sliderUlWidth, marginLeft: - slideWidth });

    $('#slider ul li:last-child').prependTo('#slider ul');

    function moveSlider(direction) {
        if (direction === 'left') {
            if (currentSlide > 0) {
                currentSlide--;
                $('#slider ul').animate({
                    left: + slideWidth
                }, 200, function () {
                    $('#slider ul li:last-child').prependTo('#slider ul');
                    $('#slider ul').css('left', '');
                });
            }
        } else if (direction === 'right') {
            if (currentSlide < slideCount - 1) {
                currentSlide++;
                $('#slider ul').animate({
                    left: - slideWidth
                }, 200, function () {
                    $('#slider ul li:first-child').appendTo('#slider ul');
                    $('#slider ul').css('left', '');
                });
            }
        }
    }

    // Khởi động tự động khi trang tải
    autoplayInterval = setInterval(function () {
        moveSlider('right');
    }, 3000);

    $('a.control_prev').click(function () {
        moveSlider('left');
    });

    $('a.control_next').click(function () {
        moveSlider('right');
    });
});



