package com.controller;

import com.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private Service service;
    @GetMapping("")
    public String showForm(){
        System.out.println("Vào get");
        return "index";
    }
    @PostMapping("")
    public String translate(@RequestParam String word, Model model){
        System.out.println("Vào post");
        String result = service.translate(word);
        model.addAttribute("input", word);
        model.addAttribute("result", result);
        return "index";
    }
}
