
//Xử lý ma trận
//
//
//
// Nhập ma trận
function nhapMaTran(m, n) {
    const a = [];
    for (let i = 0; i < m; i++) {
        a[i] = [];
        for (let j = 0; j < n; j++) {
            a[i][j] = parseInt(prompt(`Nhập phần tử hàng ${i + 1}, cột ${j + 1}:`));
        }
    }
    return a;
}

// Tính tích các số là bội số của 3 trên dòng đầu tiên
function tinhTichBoiSo3(a) {
    let tich = 1;
    for (let j = 0; j < a[0].length; j++) {
        if (a[0][j] % 3 === 0) {
            tich *= a[0][j];
        }
    }
    return tich;
}

// Tìm giá trị lớn nhất trên mỗi dòng và tạo mảng X
function timGiaTriLonNhat(a) {
    const X = [];
    for (let i = 0; i < a.length; i++) {
        let max = a[i][0];
        for (let j = 1; j < a[i].length; j++) {
            if (a[i][j] > max) {
                max = a[i][j];
            }
        }
        X.push(max);
    }
    return X;
}

// Xoá phần tử đầu tiên của mảng X
function xoaPhanTuDau(X) {
    X.shift();
}

// Ví dụ sử dụng:
const m = parseInt(prompt("Nhập số hàng:"));
const n = parseInt(prompt("Nhập số cột:"));
const a = nhapMaTran(m, n);
const tich = tinhTichBoiSo3(a);
const X = timGiaTriLonNhat(a);
console.log("Tích các số là bội số của 3 trên dòng đầu:", tich);
console.log("Mảng X:", X);
xoaPhanTuDau(X);
console.log("Mảng X sau khi xóa:", X);

