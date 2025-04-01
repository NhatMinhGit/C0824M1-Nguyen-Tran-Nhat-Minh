package org.example.ex05_personalcalculator.Service.Impl;

import org.example.ex05_personalcalculator.Model.CalculationRequest;
import org.example.ex05_personalcalculator.Service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public double calculate(CalculationRequest request) {
        double num1 = request.getNumber1();
        double num2 = request.getNumber2();
        String operator = request.getOperator();

        switch (operator) {
            case "plus": return num1 + num2;
            case "minus": return num1 - num2;
            case "multiply": return num1 * num2;
            case "divide": return (num2 != 0) ? num1 / num2 : Double.NaN;
            default: throw new IllegalArgumentException("Invalid operation");
        }
    }
}
