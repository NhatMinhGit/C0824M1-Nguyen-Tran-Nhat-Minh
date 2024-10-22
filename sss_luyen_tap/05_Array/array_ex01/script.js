// Nhập mảng
function nhapMang(n) {
    const a = [];
    for (let i = 0; i < n; i++) {
        a[i] = parseInt(prompt(`Nhập phần tử thứ ${i + 1}:`));
    }
    return a;
}

// Tính tổng số dương lẻ
function tinhTongSoDuongLe(a) {
    let tong = 0;
    for (let i = 0; i < a.length; i++) {
        if (a[i] > 0 && a[i] % 2 !== 0) {
            tong += a[i];
        }
    }
    return tong;
}

// Tìm vị trí đầu tiên của phần tử k
function timViTri(a, k) {
    for (let i = 0; i < a.length; i++) {
        if (a[i] === k) {
            return i;
        }
    }
    return -1; // Không tìm thấy
}

// Sắp xếp mảng tăng dần (Sử dụng thuật toán sắp xếp nổi bọt)
function sapXepTangDan(a) {
    for (let i = 0; i < a.length - 1; i++) {
        for (let j = 0; j < a.length - i - 1; j++) {
            if (a[j] > a[j + 1]) {
                // Hoán đổi
                const temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
        }
    }
}

// Chèn phần tử p vào mảng tăng dần
function chenPhanTu(a, p) {
    let i = a.length - 1;
    while (i >= 0 && a[i] > p) {
        a[i + 1] = a[i];
        i--;
    }
    a[i + 1] = p;
}

// Ví dụ sử dụng:
const n = parseInt(prompt("Nhập số lượng phần tử:"));
const a = nhapMang(n);
const k = parseInt(prompt("Nhập phần tử cần tìm:"));
const p = parseInt(prompt("Nhập phần tử cần chèn:"));

console.log("Mảng ban đầu:", a);
console.log("Tổng số dương lẻ:", tinhTongSoDuongLe(a));
console.log("Vị trí của", k, "là:", timViTri(a, k));
sapXepTangDan(a);
console.log("Mảng sau khi sắp xếp:", a);
chenPhanTu(a, p);
console.log("Mảng sau khi chèn:", a);




