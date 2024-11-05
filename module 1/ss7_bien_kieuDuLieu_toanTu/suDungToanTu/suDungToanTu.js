//bước 1: khai báo biến
let inputWidth;
let inputHeight;
//bước 2: nhập giá trị
inputWidth = prompt("Enter the width");
inputHeight = prompt("Enter the height");
//bước 3: chuyển đổi kiểu dữ liệu
let width = parseInt(inputWidth);
let height = parseInt(inputHeight);
//bước 4: tính toán
let area = width * height;
document.write("The area is: " + area);