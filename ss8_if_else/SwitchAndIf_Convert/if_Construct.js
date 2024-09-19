function if_Construct1() {
    let browser = prompt("Enter browser name!")
    if (browser == 'Edge') {
        alert("You've got the Edge!");
    } else if (browser == 'Chrome' || browser == 'Firefox' || browser == 'Safari' || browser == 'Opera') {
        alert('Okay we support these browsers too');
    } else {
        alert('We hope that this page looks ok!');
    }    
}
function if_Construct2() {
    let a = prompt('a?', '');

    if (a == 0) {
        alert(0);
    }

    if (a == 1) {
        alert(1);
    }

    if (a == 2 || a == 3) {
        alert('2,3');
    }
}
function if_Construct3() {
    let value = prompt('Type a number', 0);
    if (value > 0) {
        alert(1);
    } else if (value < 0) {
        alert(-1);
    } else {
        alert(0);
    }
}