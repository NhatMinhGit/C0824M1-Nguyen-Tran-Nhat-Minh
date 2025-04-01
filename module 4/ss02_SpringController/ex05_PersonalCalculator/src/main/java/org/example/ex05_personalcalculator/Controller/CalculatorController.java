package org.example.ex05_personalcalculator.Controller;

import org.example.ex05_personalcalculator.Model.CalculationRequest;
import org.example.ex05_personalcalculator.Service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;
    @GetMapping("/calculator")
    public String showCalculator() {
        return "calculator";
    }
    @PostMapping("/calculate")
    public String calculate(@ModelAttribute CalculationRequest request, Model model) {
        double result = calculatorService.calculate(request);
        model.addAttribute("result", result);
        return "result"; // Trả về trang hiển thị kết quả
    }
}
