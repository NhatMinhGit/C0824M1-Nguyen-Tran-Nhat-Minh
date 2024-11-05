function isPrime(number){
    if (number < 2) return false;
    for (let i = 2; i <= Math.sqrt(number); i++){
        if (number % i === 0) return false;
    }
    return true;
}
let a = prompt("Enter a number: ");
if(isPrime(a)){
    alert(a + " is a prime number");
}
else{
    alert(a + " is not a prime number");
}