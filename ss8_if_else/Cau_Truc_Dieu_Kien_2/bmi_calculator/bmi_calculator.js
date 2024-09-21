function bmi_cal(){
    let weight = parseFloat(document.getElementById("weight").value);
    let height = parseFloat(document.getElementById("height").value);
    // Convert height from cm to m
    height = height / 100;
    let bmi = weight / (height * height);
    document.write("Your BMI is: " + bmi.toFixed(2) + "<br>");
    if (bmi < 18)
        document.write("Underweight");
    else if (bmi < 25.0)
        document.write("Normal");
    else if (bmi < 30.0)
        document.write("Overweight");
    else
        document.write("Obese");
}