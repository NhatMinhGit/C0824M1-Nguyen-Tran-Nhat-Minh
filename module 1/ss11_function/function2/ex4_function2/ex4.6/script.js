function isPositive(num) {
  if(num > 0) {
    return true;
  } else {
    return false;
  }
}
function showInfor() {
    let num = document.getElementById("num").value; 
    if(isPositive(num)) {
        alert("Số " + num + " là số dương");
    } else {
        alert("Số " + num + " không phải số dương");
    }
}