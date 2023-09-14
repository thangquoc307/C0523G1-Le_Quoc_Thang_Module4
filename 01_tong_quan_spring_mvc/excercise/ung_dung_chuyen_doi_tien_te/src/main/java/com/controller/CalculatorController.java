package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/mainpage")
    public String createForm(){
        return "index";
    }
    @PostMapping("/mainpage")
    public String changeCurrency(@RequestParam String changeTo,
                                 @RequestParam double currency,
                                 Model model){

        double result;
        int convertFactor = 24000;
        if (changeTo.equals("1")){
            result = currency / convertFactor;
        } else {
            result = currency * convertFactor;
        }

        model.addAttribute("input", currency);
        model.addAttribute("change", changeTo);
        model.addAttribute("result", result);
        return "index";
    }
}
