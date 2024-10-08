//Kiểm tra ký tự số trong chuỗi
function isDigit(str) {
    if (!isNaN(str)) {
        return true;
    }else{
        return false;
    }
}

function showInfor() {
    let str = document.getElementById("txt").value;
    for (let i = 0; i < str.length; i++) {
        if (isDigit(str[i])) {
            alert("Chuỗi có chứa số tại vị trí " + (i+1));
        }
    }
}