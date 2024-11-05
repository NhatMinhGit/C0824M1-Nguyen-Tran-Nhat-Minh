prompt("Nhập số lần muốn nhập vào mảng: ");
let arr = [];
for(let i = 0; i < 5; i++){
    arr.push(prompt("Nhập vào phần tử thứ " + (i + 1)));
}

function reverseArr(arr){
    return arr.reverse();
}
alert("Mảng sau khi đảo ngược là: " + reverseArr(arr));