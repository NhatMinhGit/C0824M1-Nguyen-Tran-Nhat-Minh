function swapPlace(a,b){
    let temp = a;
    a = b;
    b = temp;
    return [a,b];
}
function showInfor() {
    let a = document.getElementById("a").value;
    let b = document.getElementById("b").value;
    let result = swapPlace(a,b);
    alert("Số a sau khi đổi chỗ với b là: " + result[0] + "\nSố b sau khi đổi chỗ với a là: " + result[1]);
}
