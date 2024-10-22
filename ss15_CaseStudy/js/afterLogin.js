function updateUserInfo() {
    // Lấy thông tin khách hàng từ localStorage
    const loggedInCustomerData = localStorage.getItem('loggedInCustomer');

    if (loggedInCustomerData) {
        // Phân tích thông tin khách hàng từ chuỗi JSON
        const loggedInCustomer = JSON.parse(loggedInCustomerData);

        // Tìm phần tử có id là 'loginLink' và cập nhật văn bản thành tên khách hàng
        const accountLink = document.getElementById('loginLink');
        if (accountLink) {
            accountLink.textContent = 'Account: '+ loggedInCustomer._name;
            accountLink.href = "#"; // Cập nhật liên kết nếu cần
        }
    } else {
        // Nếu không có khách hàng nào đang đăng nhập, giữ văn bản mặc định là 'Account'
        const accountLink = document.getElementById('loginLink');
        if (accountLink) {
            accountLink.textContent = 'Account';
        }
    }
}

// Gọi hàm cập nhật khi trang được tải
document.addEventListener('DOMContentLoaded', updateUserInfo);
