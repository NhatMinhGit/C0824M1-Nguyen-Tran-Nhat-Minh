let stars = ["Polaris", "Aldebaran", "Deneb", "Vega", "Altair", "Dubhe", "Regulus"];
let horoscopes = ["Ursa Minor", "Tarurus", "Cygnus", "Lyra", "Aquila", "Ursa Major", "Leo"];

function findHoroscope(star){
    for (let i = 0; i < stars.length; i++){
        if (star === stars[i]){
            return horoscopes[i];
        }
    }
    return "Not found";
}
function showHoroscope() {
    let starName = document.getElementById("starName").value;
    let horoscope = findHoroscope(starName);
    alert("Horoscope: " + horoscope);
}