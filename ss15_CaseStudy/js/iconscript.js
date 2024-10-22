const cartIcon = document.querySelector('.cart-icon img'); // Chọn đúng hình ảnh trong thẻ a

const dropdownMenu = document.querySelector('.dropdown-menu');

cartIcon.addEventListener('click', () => {
    dropdownMenu.classList.toggle('show');
});

