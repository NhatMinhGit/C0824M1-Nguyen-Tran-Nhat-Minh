let n = prompt("Nhập số lần muốn nhập vào mảng: ");
let arr = [];
for(let i = 0; i < n; i++){
    arr.push(prompt("Nhập vào phần tử thứ " + (i + 1)));
}

let a = prompt("Nhập vào phần tử cần kiểm tra trong mảng: ");

function checkTextInArray(arr,a){
    let count = 0;
    for(let i = 0; i < arr.length; i++){
        if(arr[i] == a){
            count++;
        }
    }
    if(count > 0){
        return count;
    }
    return -1;
}

alert("Phần tử " + a + " có trong mảng " + arr + " xuất hiện " + checkTextInArray(arr,a) + " lần");