package com.controller;

import com.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private Repository repository;
    @GetMapping("")
    public String showForm(){
        System.out.println("Vào get");
        return "index";
    }
    @PostMapping("")
    public String translate(@RequestParam String word, Model model){
        System.out.println("Vào post");
        String result = repository.translate(word);
        model.addAttribute("input", word);
        model.addAttribute("result", result);
        return "index";
    }
}
