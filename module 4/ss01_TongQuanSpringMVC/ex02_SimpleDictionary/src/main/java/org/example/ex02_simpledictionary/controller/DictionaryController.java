package org.example.ex02_simpledictionary.controller;

import org.example.ex02_simpledictionary.service.DictionaryService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/")
    public String showSearchForm() {
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam("word") String word, Model model) {
        String meaning = dictionaryService.lookup(word);
        model.addAttribute("word", word);
        model.addAttribute("meaning", meaning);
        return "index";
    }
}
