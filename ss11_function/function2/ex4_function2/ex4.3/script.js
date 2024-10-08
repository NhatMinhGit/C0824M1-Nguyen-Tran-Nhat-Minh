//tính giai thừa
function giaiThua(n){
    if(n == 0){
        return 1;
    }
    return n * giaiThua(n - 1);
}
function showInfor(){
    var n = document.getElementById("n").value;
    alert("Giai thừa của " + n + " là: " + giaiThua(n));
}
