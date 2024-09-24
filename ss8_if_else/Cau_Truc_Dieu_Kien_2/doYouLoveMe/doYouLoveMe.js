function randomJump(){
    let x = Math.floor(Math.random() * window.innerWidth);
    let y = Math.floor(Math.random() * window.innerHeight);
    document.getElementById('no').style.left = x + 'px';
    document.getElementById('no').style.top = y + 'px'; 
}
function love(){
    document.write("I love you too <3");
}