function addNumbers() {
    firstNum = parseInt(document.getElementById("firstNum").value);
    secondNum = parseInt(document.getElementById("secondNum").value);
    result = firstNum + secondNum;
    alert(firstNum + " + " + secondNum + " = " + result);
    return result;
}
result = 0;
result = addNumbers(); 