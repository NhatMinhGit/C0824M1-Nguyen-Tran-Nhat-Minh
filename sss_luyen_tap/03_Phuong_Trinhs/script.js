function tinhTong(n) {
    let S = 0;
    for (let i = 1; i <= n; i++) {
        S += 1 / i;
    }
    return S;
}

// Ví dụ: Tính tổng khi n = 5
let n = 5;
let ketQua = tinhTong(n);
console.log("Tổng S =", ketQua);


function tinhTong2(n) {
    let S = 0;
    let dau = 1; // Biến dấu để thay đổi dấu của các số hạng
    let giaiThua = 1;
    for (let i = 1; i <= n; i++) {
        giaiThua *= i;
        S += dau * (1 / giaiThua);
        dau *= -1;
    }
    return S;
}



function tinhTong3(n) {
    let S = 0;
    let giaiThua = 1;
    for (let i = 1; i <= n; i++) {
        giaiThua *= (2 * i - 1) * (2 * i); // Tính giai thừa của số lẻ
        S += 1 / giaiThua;
    }
    return S;
}



function tinhGiaiThuaKep(n) {
    let giaiThuaKep = 1;
    for (let i = 1; i <= n; i += 2) {
        giaiThuaKep *= i;
    }
    return giaiThuaKep;
}


function tinhTongVaTichChuSo(m) {
    let tong = 0;
    let tich = 1;
    while (m > 0) {
        let chuSo = m % 10;
        tong += chuSo;
        tich *= chuSo;
        m = Math.floor(m / 10);
    }
    return { tong, tich };
}


function uocChungLonNhat(a, b) {
    while (b !== 0) {
        let temp = a % b;
        a = b;
        b = temp;
    }
    return a;
}

function boiChungNhoNhat(a, b) {
    return (a * b) / uocChungLonNhat(a, b);
}