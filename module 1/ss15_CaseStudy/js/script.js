class Item {
    constructor(id, name, price, imageUrl, description, quantity) {
        // Make sure this matches
        this._id = id;
        this._name = name;
        this._price = price;
        this._imageUrl = imageUrl;
        this._description = description;
        this._quantity = quantity;
    }

    get id() {
        return this._id;
    }

    set id(value) {
        this._id = value;
    }

    get name() {
        return this._name;
    }

    set name(value) {
        this._name = value;
    }

    get price() {
        return this._price;
    }

    set price(value) {
        this._price = value;
    }

    get imageUrl() {
        return this._imageUrl;
    }

    set imageUrl(value) {
        this._imageUrl = value;
    }

    get description() {
        return this._description;
    }

    set description(value) {
        this._description = value;
    }

    get quantity() {
        return this._quantity;
    }

    set quantity(value) {
        this._quantity = value;
    }
}

class Customer {
    constructor(id, name, email, password, creditPoints = 0) {
        this._id = id;
        this._name = name;
        this._email = email;
        this._password = password;
        this._creditPoints = creditPoints; // Added: Initial credit points (default to 0)
    }


    get id() {
        return this._id;
    }

    set id(value) {
        this._id = value;
    }

    get name() {
        return this._name;
    }

    set name(value) {
        this._name = value;
    }

    get email() {
        return this._email;
    }

    set email(value) {
        this._email = value;
    }

    get password() {
        return this._password;
    }

    set password(value) {
        this._password = value;
    }

    get creditPoints() {
        return this._creditPoints;
    }

    set creditPoints(value) {
        this._creditPoints = value;
    }
}

class Cart {
    constructor(customerId) {
        this._items = [];
        this._customerId = customerId;
    }

    get customerId() {
        return this._customerId;
    }

    set customerId(value) {
        this._customerId = value;
    }

    get items() {
        return this._items;
    }

    set items(value) {
        this._items = value;
    }

    addItem(item) {
        const existingItem = this._items.find(cartItem => cartItem.id === item.id);
        if (existingItem) {
            existingItem.quantity++; // Increase quantity if item already exists
        } else {
            this._items.push(item);
        }

        // Update Local Storage with the updated cart
        localStorage.setItem('cartItems', JSON.stringify(this._items));
    }

    removeItem(itemId) {
        this._items = this._items.filter(item => item.id !== itemId);
    }

    updateItemQuantity(itemId, newQuantity) {
        const existingItem = this._items.find(item => item.id === itemId);
        if (existingItem) {
            existingItem.quantity = newQuantity;
        } else {
            console.error("Item not found in cart:", itemId);
        }
    }

    getTotalPrice() {
        return this._items.reduce((sum, item) => sum + (item.price * item.quantity), 0);
    }

    getCartItems() {
        return [...this._items]; // Return a copy of the items array
    }

    clearCart() {
        this._items = [];
    }
}

const items = [
    new Item(1, "New Razer Blade 16", 2799.99, "../img/items/New Razer Blade 16.png", "High-Performance 16” Gaming Laptop with 240 Hz OLED display", 15),
    new Item(2, "New Razer Blade 18", 4499.99, "../img/items/Razer Blade 18.png", "Ultra-Performance 18” Gaming Laptop with 4K 200 Hz Display", 15),
    new Item(3, "Razer Viper Mini Signature Edition", 299.99, "../img/items/Razer Viper Mini Signature Edition.png", "Ultra-High-End Wireless Gaming Mouse", 15),
    new Item(4, "Razer Basilisk V3 Pro 35K", 159.99, "../img/items/Razer Basilisk V3 Pro 35K.png", "Fully Customizable Wireless Ergonomic RGB Gaming Mouse", 15),
    new Item(5, "Razer Kraken V4 Pro", 399.99, "../img/items/Razer Kraken V4 Pro.png", "Wireless Gaming Headset with Control Hub", 15),
    new Item(6, "Razer Freyja", 299.99, "../img/items/Razer Freyja.png", "Gaming Cushion Powered by Razer Sensa HD Haptics", 15),
    new Item(7, "Razer BlackWidow V4 Pro 75%", 299.99, "../img/items/Razer BlackWidow V4 Pro.png", "Wireless Hot-swappable Gaming Keyboard", 15),
    new Item(8, "Razer Kiyo X", 49.99, "../img/items/Razer Kiyo X.png", "USB Webcam for Full HD Streaming", 15),

];

const customers = [
    new Customer(1, 'Alice', 'alice@example.com', '123'),
    new Customer(2, 'Bob', 'bob@example.com', 'mypassword'),
    new Customer(3, 'Charlie', 'charlie@example.com', 'securepassword')
];

