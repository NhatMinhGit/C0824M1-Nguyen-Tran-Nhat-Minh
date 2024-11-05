//Chuyen tien từ USD sang VND và ngược lại
function chuyenDoiTien() {
    let amount = parseFloat(document.getElementById('amount').value); 
    let tiGia = 23000;
    
    // Check if the amount is a valid number
    if (isNaN(amount) || amount <= 0) {
        document.getElementById('result').innerHTML = 'Please enter a valid amount.';
        return;
    }
    
    if (document.getElementById('from').value == 'usd' && document.getElementById('to').value == 'vnd') {
        let vnd = amount * tiGia;
        document.getElementById('result').innerHTML = 'Result: ' + vnd.toFixed(2) + ' VND';
    } else if (document.getElementById('from').value == 'vnd' && document.getElementById('to').value == 'usd') {
        let usd = amount / tiGia;
        document.getElementById('result').innerHTML = 'Result: ' + usd.toFixed(2) + ' USD';
    } else {
        document.getElementById('result').innerHTML = 'Invalid currency selection.';
    }
}
