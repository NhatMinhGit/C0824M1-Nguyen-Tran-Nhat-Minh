function footToMeter(foot) {
    return 0.305 * foot;
}
let a = prompt("Enter foot to convert: ");
alert(a + " foot is equal to " + footToMeter(a) + " meters");

function meterToFoot(meter) {
    return 3.279 * meter;
}
let b = prompt("Enter meter to convert: ");
alert(b + " meter is equal to " + meterToFoot(b) + " foots");
