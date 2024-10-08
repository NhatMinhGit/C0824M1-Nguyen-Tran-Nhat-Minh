let arr = [
    { id: 1, name: "Sony Xperia" },
    { id: 2, name: "Samsung Galaxy" },
    { id: 3, name: "Nokia 6" },
    { id: 4, name: "Xiaomi Redmi Note 4" },
    { id: 5, name: "Apple iPhone 6S" },
    { id: 6, name: "Sony Xperia XZ" },
    { id: 7, name: "Samsung Galaxy S7" },
    { id: 8, name: "Apple iPhone 8 Plus" },
    { id: 9, name: "Oppo A71" },
    { id: 10, name: "Samsung Galaxy A7" }
];

function addProduct() {
    let name = document.getElementById("name").value;
    let id = arr.length + 1;  // Tự động tăng ID
    arr.push({ id: id, name: name });
    displayProducts();
    clearInput();
}

function editProduct() {
    let id = parseInt(document.getElementById("id").value) - 1;
    let name = document.getElementById("name").value;
    if (arr[id]) {
        arr[id].name = name;
        displayProducts();
        clearInput();
    } else {
        alert("Sản phẩm không tồn tại.");
    }
}

function deleteProduct() {
    let id = parseInt(document.getElementById("id").value) - 1;
    if (arr[id]) {
        arr.splice(id, 1);
        displayProducts();
        clearInput();
    } else {
        alert("Sản phẩm không tồn tại.");
    }
}

function displayProducts() {
    let productList = document.getElementById("product-list");
    productList.innerHTML = "";
    arr.forEach((product, index) => {
        productList.innerHTML += `<tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
        </tr>`;
    });
}

function clearInput() {
    document.getElementById("id").value = "";
    document.getElementById("name").value = "";
}

window.onload = function() {
    displayProducts();
};