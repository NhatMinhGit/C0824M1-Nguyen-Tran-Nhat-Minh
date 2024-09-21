function switch_Construct1() {
    let browser = prompt("Enter browser name!")
    switch (browser) {
        case 'Edge':
            alert("You've got the Edge!");
            break;
        case 'Chrome':
        case 'Firefox':
        case 'Safari':
        case 'Opera':
            alert('Okay we support these browsers too');
            break;
        default:
            alert('We hope that this page looks ok!');
    }
}
function switch_Construct2() {
    let a = +prompt('a?', '');
    switch (a) {
        case 0:
            alert(0);
            break;
        case 1:
            alert(1);
            break;
        case 2:
        case 3:
            alert('2,3');
            break;
    }
}
function switch_Construct3() {
    let value = prompt('Type a number', 0);
    switch (true) {
        case value > 0:
            alert(1);
            break;
        case value < 0:
            alert(-1);
            break;
        default:
            alert(0);
    }
}