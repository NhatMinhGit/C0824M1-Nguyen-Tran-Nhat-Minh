package org.example.ex01_chuyendoitiente.controller;

import org.example.ex01_chuyendoitiente.model.CurrencyConversion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CurrencyController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("conversion", new CurrencyConversion());
        return "index";
    }

    @PostMapping("/convert")
    public String convert(@ModelAttribute CurrencyConversion conversion, Model model) {
        conversion.setResult(conversion.getRate() * conversion.getAmount());
        model.addAttribute("conversion", conversion);
        return "index";
    }
}
