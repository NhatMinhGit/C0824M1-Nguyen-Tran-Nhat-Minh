let b = document.getElementById("tttgame");

let board = [];
let data = "";
for (let i = 0; i < 5; i++) {
    board[i] = new Array(0, 0, 0, 0, 0);
}

for (let i = 0; i < 5; i++) {
    data += "<br/>";
    for (let j = 0; j < 5; j++) {
        data += board[i][j] + "&nbsp;&nbsp;";
    }
}

data += "<br/><br/><input type='button' value='Change Value' onclick='changeValue()'>"
b.innerHTML = data;
let count = 0;
function changeValue() {
    let positionX = prompt("X: ");
    let positionY = prompt("Y: ");
    
    if (board[positionX][positionY] === "x" || board[positionX][positionY] === "o") {
        alert("This position has been filled");
        return;
    }else if (positionX < 0 || positionX >= 5 || positionY < 0 || positionY >= 5) {
        alert("Invalid position");
        return;
    }
    data = "";
    if (count % 2 == 0) {
        board[positionX][positionY] = "o";
        count++;
    }
    else if (count % 2 != 0){
        board[positionX][positionY] = "x";
        count++;
    }
    for (let i = 0; i < 5; i++) {
        data += "<br/>";
        for (let j = 0; j < 5; j++) {
            data += board[i][j] + "&nbsp;&nbsp;&nbsp;&nbsp;";
        }
    }
    data += "<br/><br/><input type='button' value='Change Value' onclick='changeValue()'>"
    b.innerHTML = "<hr/>" + data;
}