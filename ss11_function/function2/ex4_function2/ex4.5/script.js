//tìm số nhỏ nhất
function isSmallest(a, b, c) {
    if (a < b && a < c) {
        return a;
    } else if (b < a && b < c) {
        return b;
    } else {
        return c;
    }
}

function showInfor() {
    let a = document.getElementById("a").value;
    let b = document.getElementById("b").value;
    let c = document.getElementById("c").value;
    alert("Số nhỏ nhất trong 3 số " + a + ", " + b + ", " + c + " là: " + isSmallest(a, b, c));
}