package org.example.ex04_sandwichcondiments.controller;
import java.util.List;
import java.util.Arrays;
import org.springframework.ui.Model;
import org.example.ex04_sandwichcondiments.service.SandwichCondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SandwichCondimentsController {
    @Autowired
    private SandwichCondimentsService sandwichCondimentsService;

    @PostMapping("/save")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiment, Model model) {
        List<String> selectedCondiments = (condiment != null) ? Arrays.asList(condiment) : List.of();

        model.addAttribute("selectedCondiments", selectedCondiments);

        return "MySandwichOrder";
    }
    //Show form
    @GetMapping("/sandwich")
    public String showForm() {
        return "SandwichCondiments";
    }
}
