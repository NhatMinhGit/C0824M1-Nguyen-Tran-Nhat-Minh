function xuLyChuoi(str) {
    // Đảo ngược chuỗi
    const daoNguoc = str.split('').reverse().join('');
    console.log('Chuỗi đảo ngược:', daoNguoc);

    // Chuyển thành chữ hoa
    const chuHoa = str.toUpperCase();
    console.log('Chuỗi chữ hoa:', chuHoa);

    // Chuyển thành chữ thường
    const chuThuong = str.toLowerCase();
    console.log('Chuỗi chữ thường:', chuThuong);

    // Đổi chữ hoa thành chữ thường và ngược lại
    const doiChu = str.replace(/[a-z]/gi, (char) => {
        return char === char.toUpperCase() ? char.toLowerCase() : char.toUpperCase();
    });
    console.log('Chuỗi đổi chữ:', doiChu);
}

// Ví dụ:
const chuoi = "ViET Nam";
xuLyChuoi(chuoi);



function xuLyTungTu(str) {
    // In mỗi từ trên một dòng
    const cacTu = str.split(' ');
    cacTu.forEach(tu => console.log(tu));

    // Đếm số từ
    console.log('Số từ:', cacTu.length);

    // Tính tần số xuất hiện của các từ
    const tanSo = {};
    cacTu.forEach(tu => {
        tanSo[tu] = (tanSo[tu] || 0) + 1;
    });
    console.log('Tần số xuất hiện:', tanSo);
}

// Ví dụ:
const chuoi = "Hello world hello";
xuLyTungTu(chuoi);
