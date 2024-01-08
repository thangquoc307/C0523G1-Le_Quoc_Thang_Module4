package com.test.controller;

import com.test.service.PigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PigController {
    @Autowired
    private PigService pigService;
    @GetMapping("/")
    public String showAllPig(Model model){
        System.out.println("----------------------------------------------");
        System.out.println(pigService.showAll());
        System.out.println("----------------------------------------------");
        model.addAttribute("pigList", pigService.showAll());
        return "index";
    }
//    @GetMapping("/detail/{id}")
//    public String showDetail(@PathVariable int id){
//
//    }
}
