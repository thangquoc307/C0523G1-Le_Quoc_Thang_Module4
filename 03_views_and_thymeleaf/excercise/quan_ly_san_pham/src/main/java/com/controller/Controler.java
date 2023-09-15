package com.controller;
import com.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Controler {
    @Autowired
    private static Service service;
    @GetMapping("")
    public String showAll(Model model){
        model.addAttribute("list", service.showAll());
        return "index";
    }
    @GetMapping("create")
    public String showFormCreate(){

        return "create";
    }
    @PostMapping("create")
    public String saveCreate(){

        return "index";
    }
    @GetMapping("edit/*")
    public String showFormEdit(){

        return "edit";
    }
    @PostMapping("edit")
    public String saveEdit(){

        return "index";
    }
    @PostMapping("delete")
    public String delete(){


        return "index";
    }
    @GetMapping("detail")
    public String detail(){

        return "detail";
    }
    @GetMapping("search")
    public String search(){


        return "search";
    }
}
