function tinhDiemTrungBinh() {
    var sinh = parseFloat(prompt('Enter diem sinh:'))
    var ly = parseFloat(prompt('Enter diem ly:'))
    var hoa = parseFloat(prompt('Enter diem hoa:'))
    var tong = sinh + ly + hoa;
    var diemTrungBinh = tong / 3;
    alert('Diem trung binh la: ' + diemTrungBinh);
}
//chuyenDoiNhietDo Celcius to Fahrenheit function
function chuyenDoiNhietDo() {
    var doC = prompt('Enter do C:')
    doC = parseFloat(doC);
    var doF = doC * 9 / 5 + 32;
    alert('Do F la: ' + doF);
}
//function tinhDienTichHinhTron
function tinhDienTichHinhTron() {
    var r = prompt('Enter ban kinh:')
    r = parseFloat(r);
    var s = r * r * 3.14;
    alert('Dien tich hinh tron la: ' + s);
}
//function tinhChuViHinhTron
function tinhChuViHinhTron() {
    var r = prompt('Enter ban kinh:')
    var c = r * 2 * 3.14;
    c = parseFloat(c);
    alert('Chu vi hinh tron la: ' + c);
}