
function binhPhuong(a) {
    return a * a;
}

function showBinhPhuong() {
    let a = +document.getElementById('num').value;
    let result = binhPhuong(a);
    alert(result);
}