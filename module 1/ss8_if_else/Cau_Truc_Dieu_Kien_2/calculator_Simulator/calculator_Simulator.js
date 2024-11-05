let currentInput = '';
let operator = '';
let previousInput = '';

function appendNumber(number) {
    const resultField = document.getElementById("result");

    // If current input is zero, replace it with the new number
    if (currentInput === '0') {
        currentInput = number;
    } else {
        currentInput += number; // Append the new number
    }
    
    resultField.value = currentInput;
}

function appendOperator(op) {
    const resultField = document.getElementById("result");

    if (currentInput === '') return; // Don't allow operator without a number

    if (previousInput === '') {
        previousInput = currentInput;
    } else {
        previousInput = calculate();
    }
    
    operator = op;
    currentInput = '';  // Clear the input for the next number
    resultField.value = previousInput + ' ' + operator;
}

function clearResult() {
    currentInput = '0';
    operator = '';
    previousInput = '';
    document.getElementById("result").value = currentInput;
}

function calculate() {
    if (currentInput === '' || previousInput === '' || operator === '') return;

    let result = 0;
    const prev = parseFloat(previousInput);
    const current = parseFloat(currentInput);

    // Perform the calculation based on the operator
    switch (operator) {
        case '+':
            result = prev + current;
            break;
        case '-':
            result = prev - current;
            break;
        case '*':
            result = prev * current;
            break;
        case '/':
            result = prev / current;
            break;
        default:
            return;
    }

    document.getElementById("result").value = result;
    previousInput = result.toString();  // Store the result for further operations
    currentInput = '';  // Reset current input
    operator = '';  // Reset operator
    return result;  // Return result for chaining calculations
}
