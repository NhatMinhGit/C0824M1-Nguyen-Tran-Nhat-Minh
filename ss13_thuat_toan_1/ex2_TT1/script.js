let a1 = [1, 2, 3];
let a2 = [1, 2, 3, 3];


//function beautifulArray(a){
//     let left = 0;
//     let right = 0;
//     console.log(a);
//     for(let i=0;i<(a.length/2)-0.5;i++){
//         left += a[i];
//     }
//     console.log(left);
//     for(let i=a.length-1;i>=(a.length/2)+0.5;i--){
//         right += a[i];
//     }
//     console.log(right);
//     if(left === right){
//         return true;
//     }else {
//         return false;
//     }
// } chia ở giữa nhưng đề yêu cầu có thể cách đoạn từ bất cứ điểm nào ở trên mảng
//let a3 = [2,4,3,5,8,14];
//left = 2 + 4 + 3 + 5
//right = 14
//và cắt nhau tại 8
    function beautifulArray(arr) {

    let totalSum = 0;
    for (let i = 0; i < arr.length; i++) {
        totalSum += arr[i];
    }

    let leftSum = 0;

    for (let i = 0; i < arr.length; i++) {

        const rightSum = totalSum - leftSum - arr[i];


        if (leftSum === rightSum) {
            return true;
        }


        leftSum += arr[i];
    }

    return false;
}

console.log(beautifulArray(a1));
console.log(beautifulArray(a2));
console.log(beautifulArray(a3));