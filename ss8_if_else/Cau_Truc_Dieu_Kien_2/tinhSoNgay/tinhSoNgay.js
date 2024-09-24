function tinhSoNgay_switchCase(){
    let thang = parseInt(document.getElementById("thang").value);
    
    switch (thang) {
        case 1:
            document.write("Tháng 1 có 31 ngày");
            break;
        case 2:
            document.write("Tháng 2 có 28 hoặc 29 ngày");
            break;
        case 3:
            document.write("Tháng 3 có 31 ngày");
            break;
        case 4:
            document.write("Tháng 4 có 30 ngày");
            break;
        case 5:
            document.write("Tháng 5 có 31 ngày");
            break;
        case 6:
            document.write("Tháng 6 có 30 ngày");
            break;
        case 7:
            document.write("Tháng 7 có 31 ngày");
            break;
        case 8:
            document.write("Tháng 8 có 31 ngày");
            break;
        case 9:
            document.write("Tháng 9 có 30 ngày");
            break;
        case 10:
            document.write("Tháng 10 có 31 ngày");
            break;
        case 11:
            document.write("Tháng 11 có 30 ngày");
            break;
        case 12:
            document.write("Tháng 12 có 31 ngày");
            break;
        default:
            alert('Nhap sai roi!!!');
    }
}
function tinhSoNgay_if_else() {
    let thang = parseInt(document.getElementById("thang").value);
    
    if (thang === 1) {
        document.write("Tháng 1 có 31 ngày");
    } else if (thang === 2) {
        document.write("Tháng 2 có 28 hoặc 29 ngày");
    } else if (thang === 3) {
        document.write("Tháng 3 có 31 ngày");
    } else if (thang === 4) {
        document.write("Tháng 4 có 30 ngày");
    } else if (thang === 5) {
        document.write("Tháng 5 có 31 ngày");
    } else if (thang === 6) {
        document.write("Tháng 6 có 30 ngày");
    } else if (thang === 7) {
        document.write("Tháng 7 có 31 ngày");
    } else if (thang === 8) {
        document.write("Tháng 8 có 31 ngày");
    } else if (thang === 9) {
        document.write("Tháng 9 có 30 ngày");
    } else if (thang === 10) {
        document.write("Tháng 10 có 31 ngày");
    } else if (thang === 11) {
        document.write("Tháng 11 có 30 ngày");
    } else if (thang === 12) {
        document.write("Tháng 12 có 31 ngày");
    } else {
        alert('Nhập sai rồi!!!');
    }
}