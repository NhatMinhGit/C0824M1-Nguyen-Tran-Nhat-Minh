function upArrowPressed() {
    let element = document.getElementById("nobita");
    element.style.top = parseInt(element.style.top) - 5 + 'px';
}

function downArrowPressed() {
    let element = document.getElementById("nobita");
    element.style.top = parseInt(element.style.top) + 5 + 'px';
}

function leftArrowPressed() {
    let element = document.getElementById("nobita");
    element.style.left = parseInt(element.style.left) - 5 + 'px';
}

function rightArrowPressed() {
    let element = document.getElementById("nobita");
    element.style.left = parseInt(element.style.left) + 5 + 'px';
}

function moveSelection(evt) {
    // Prevent default behavior (like scrolling)
    evt.preventDefault();
    console.log(`Key pressed: ${evt.key}`); // Log the key pressed
    switch (evt.key) {
        case 'ArrowLeft':
            leftArrowPressed();
            break;
        case 'ArrowRight':
            rightArrowPressed();
            break;
        case 'ArrowUp':
            upArrowPressed();
            break;
        case 'ArrowDown':
            downArrowPressed();
            break;
    }
}

function docReady() {
    window.addEventListener('keydown', moveSelection);
}
