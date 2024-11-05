function compareOrPlus(a, b) {
    const num1 = parseInt(a);
    const num2 = parseInt(b);
    if (num1 > num2) {
        alert(num1 + " lớn hơn " + num2);
    } else if (num1 <= num2) {
        alert(num1 + " nhỏ hơn hoặc bằng " + num2 + "=" + (num1 + num2));
        return num1+num2;
    } 
}