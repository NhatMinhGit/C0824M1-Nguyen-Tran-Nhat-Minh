let sequence1 = [1, 4, 5, 7, 9];
let sequence2 = [0];
let sequence3 = [3, 3];



function isMonotonous(arr) {
    if (arr.length <= 1) {
        return true;
    }

    let isIncreasing = true;
    let isDecreasing = true;

    if(arr[0]<arr[1]) {
        for (let i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                if (isIncreasing) {
                    isIncreasing = false;
                } else {
                    return false;
                }
            }
        }
    }else if (arr[0] > arr[1]) {
        for (let i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                if (isDecreasing) {
                    isDecreasing = false;
                } else {
                    return false;
                }
            }
        }
    }
    for (let i = 1; i < arr.length; i++) {
        if (arr[i] == arr[i - 1]) {
            return false;
        }
    }
    return true;
}


console.log(isMonotonous(sequence1));
console.log(isMonotonous(sequence2));
console.log(isMonotonous(sequence3));