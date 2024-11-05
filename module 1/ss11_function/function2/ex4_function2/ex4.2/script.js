function dienTichHinhTron(r){
    return Math.PI * r * r;
}
function chuViHinhTron(r){
    return 2 * Math.PI * r;
}

function showInfor(){
    var r = document.getElementById("r").value;
    //var result = document.getElementById("result");
    alert("Diện tích hình tròn là: " + dienTichHinhTron(r) + "\n" + "Chu vi hình tròn là: " + chuViHinhTron(r));
}