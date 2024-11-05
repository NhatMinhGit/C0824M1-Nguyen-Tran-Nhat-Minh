let arr1 = [6,5,4,3,2,1];
let arr2 = [100, 100, 99, 98, 102, 103];
let arr3 = [1, 2, 3, 4, 5];


function removeDuplicates(arr) {
    return [...new Set(arr)];//... là sao chép tất cả các phần tử vào Spread operator
}
function searchElement(arr, n) {
    const sortedArr = arr.sort((a,b)=> b - a);
    const uniqueNumbers = removeDuplicates(sortedArr);
    console.log(uniqueNumbers);
    if(0<n<uniqueNumbers.length){
        return uniqueNumbers[n-1];
    }else{
        return -1;
    }
}
console.log(searchElement(arr1,1));
console.log(searchElement(arr2,4));
console.log(searchElement(arr3,10));