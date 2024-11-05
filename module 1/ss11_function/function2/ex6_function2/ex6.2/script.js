function cutHeadTail(str) {
  return str.slice(1, -1);
}


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
    if(isPalindrome(cutHeadTail(str))) {
        alert("Chuỗi " + str + " là chuỗi Palindrome" + " sau khi cắt 2 ký tự đầu và 2 ký tự cuối" + " chuỗi còn lại là: " + cutHeadTail(str));
    } else {
        alert("Chuỗi " + str + " không phải là chuỗi Palindrome");
    }
}
