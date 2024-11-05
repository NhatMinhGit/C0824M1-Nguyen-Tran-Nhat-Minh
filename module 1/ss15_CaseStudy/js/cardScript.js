document.addEventListener('DOMContentLoaded', function() {
    function populateCards() {
        const cardContainer = document.querySelector('.card-container');
        if (!cardContainer) {
            console.error("Card container not found");
            return;
        }

        items.forEach(item => {
            const card = document.createElement('div');
            card.classList.add('card');
            card.dataset.itemId = item.id;

            const cardImage = document.createElement('img');
            cardImage.src = item.imageUrl;
            cardImage.alt = "Item Image";
            card.appendChild(cardImage);

            const cardContent = document.createElement('div');
            cardContent.classList.add('card-content');

            const itemName = document.createElement('h3');
            itemName.classList.add('item-name');
            itemName.textContent = item.name;
            cardContent.appendChild(itemName);

            const itemDescription = document.createElement('p');
            itemDescription.classList.add('item-description');
            itemDescription.textContent = item.description;
            cardContent.appendChild(itemDescription);
            //document.createElement('<br>');

            const itemPrice = document.createElement('p');
            itemPrice.classList.add('item-description');
            itemPrice.textContent = "$ " +item.price;
            cardContent.appendChild(itemPrice);


            const addToCartButton = document.createElement('button');
            addToCartButton.classList.add('add-to-cart');
            addToCartButton.textContent = "Add to Cart";

            // Xử lý sự kiện khi nhấn nút "Add to Cart"
            addToCartButton.addEventListener('click', function() {
                const customerId = localStorage.getItem('customerId');
                if (!customerId) {
                    console.log("Please log in to add items to your cart.");
                    return; // Ngăn không cho thêm hàng nếu chưa đăng nhập
                }

                // Lấy giỏ hàng từ localStorage dựa trên customerId
                const cartItems = JSON.parse(localStorage.getItem(`cartItems_${customerId}`)) || [];

                const existingItemIndex = cartItems.findIndex(cartItem => cartItem.id === item.id);

                if (existingItemIndex > -1) {
                    cartItems[existingItemIndex].quantity++;
                } else {
                    const itemToAdd = {
                        id: item.id,
                        name: item.name,
                        description: item.description,
                        price: item.price,
                        quantity: 1,
                        imageUrl: item.imageUrl
                    };
                    cartItems.push(itemToAdd);
                }

                // Lưu giỏ hàng vào localStorage cho customerId
                localStorage.setItem(`cartItems_${customerId}`, JSON.stringify(cartItems));

                // Cập nhật số lượng giỏ hàng
                const cartCountElement = document.getElementById('cart-count');
                if (cartCountElement) {
                    const totalItems = cartItems.reduce((acc, curr) => acc + curr.quantity, 0);
                    cartCountElement.textContent = `Số lượng: ${totalItems}`;
                } else {
                    console.error("Cart count element not found");
                }

                console.log(`Added ${item.name} to cart`);
                console.log(cartItems);
            });

            cardContent.appendChild(addToCartButton);
            card.appendChild(cardContent);
            cardContainer.appendChild(card);
        });
    }

    populateCards();
});
