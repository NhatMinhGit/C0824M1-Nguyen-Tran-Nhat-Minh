function isPalindrome(str) {
  const reversedStr = str.split('').reverse().join(''); // tách ra và đảo ngược chuỗi để so sánh
  if(str === reversedStr) {
    return true;
  } else {
    return false;
  }
}

function showInfor() {
    let str = document.getElementById("txt").value;
    if(isPalindrome(str)) {
        alert("Chuỗi " + str + " là chuỗi Palindrome");
    } else {
        alert("Chuỗi " + str + " không phải là chuỗi Palindrome");
    }
}
