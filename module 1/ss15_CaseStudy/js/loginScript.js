document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.getElementById('loginForm');
    if (!loginForm) {
        console.error("Login form not found!");
        return;
    }

    function login(email, password) {
        const customer = customers.find(c => c.email === email && c.password === password);

        if (customer) {
            console.log(`Welcome back, ${customer.name}!`);

            // Lưu thông tin khách hàng vào localStorage
            localStorage.setItem('loggedInCustomer', JSON.stringify(customer));

            // Lưu ID khách hàng vào localStorage
            localStorage.setItem('customerId', customer.id);

            // Khởi tạo giỏ hàng cho khách hàng này nếu chưa có
            const existingCart = JSON.parse(localStorage.getItem(`cartItems_${customer.id}`)) || [];
            localStorage.setItem(`cartItems_${customer.id}`, JSON.stringify(existingCart));

            // Chuyển hướng đến trang chính sau khi đăng nhập thành công
            window.location.href = 'index.html';
            return true;
        } else {
            console.log('Invalid email or password. Please try again.');
            return false;
        }
    }

    loginForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const email = document.getElementById('gmail').value;
        const password = document.getElementById('password').value;

        login(email, password);
    });
});
