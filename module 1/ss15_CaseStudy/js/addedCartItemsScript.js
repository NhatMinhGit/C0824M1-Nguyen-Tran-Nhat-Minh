function renderCartItems() {
    const customerId = localStorage.getItem('customerId');
    if (!customerId) {
        console.error("Customer ID not found! Please log in.");
        return; // Ngăn không cho hiển thị giỏ hàng nếu chưa đăng nhập
    }

    const cartItemsList = document.getElementById('cart-items-list');
    cartItemsList.innerHTML = '';

    // Lấy dữ liệu giỏ hàng từ localStorage dựa trên customerId
    const cartItems = JSON.parse(localStorage.getItem(`cartItems_${customerId}`)) || [];

    cartItems.forEach(item => {
        const cartItemCard = document.createElement('div');
        cartItemCard.classList.add('cart-item-card');

        const itemImage = document.createElement('img');
        itemImage.src = item.imageUrl;
        itemImage.alt = `${item.name} image`;
        itemImage.classList.add('cart-item-image');
        cartItemCard.appendChild(itemImage);

        const itemName = document.createElement('h3');
        itemName.textContent = item.name;
        cartItemCard.appendChild(itemName);

        const itemDescription = document.createElement('p');
        itemDescription.textContent = item.description;
        cartItemCard.appendChild(itemDescription);

        const itemQuantity = document.createElement('span');
        itemQuantity.textContent = `Số lượng: ${item.quantity} `;
        cartItemCard.appendChild(itemQuantity);

        const increaseButton = document.createElement('button');
        increaseButton.textContent = '+';
        increaseButton.addEventListener('click', function() {
            item.quantity++;
            localStorage.setItem(`cartItems_${customerId}`, JSON.stringify(cartItems));
            renderCartItems();
        });
        cartItemCard.appendChild(increaseButton);

        const decreaseButton = document.createElement('button');
        decreaseButton.textContent = '-';
        decreaseButton.addEventListener('click', function() {
            if (item.quantity > 1) {
                item.quantity--;
                localStorage.setItem(`cartItems_${customerId}`, JSON.stringify(cartItems));
                renderCartItems();
            }
        });
        cartItemCard.appendChild(decreaseButton);

        cartItemCard.appendChild(document.createElement('br'));

        const itemPrice = document.createElement('span');
        itemPrice.textContent = `$${item.price}`;
        cartItemCard.appendChild(itemPrice);

        cartItemsList.appendChild(cartItemCard);
    });

    const cartCountElement = document.getElementById('cart-count');
    const totalItems = cartItems.reduce((acc, curr) => acc + curr.quantity, 0);
    cartCountElement.textContent = `Số lượng: ${totalItems}`;
}

// Gọi hàm renderCartItems khi trang được tải
document.addEventListener('DOMContentLoaded', renderCartItems);
