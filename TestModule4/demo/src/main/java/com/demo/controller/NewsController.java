package com.demo.controller;

import com.demo.dto.NewsDto;
import com.demo.model.NewsEntity;
import com.demo.model.NewsTypeEntity;
import com.demo.service.NewsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@Controller
public class NewsController {
    @Autowired
    private NewsService newsService;
    @ModelAttribute("newsTypeList")
    public List<NewsTypeEntity> getAllType(){
        return newsService.getAllType();
    }
    @GetMapping("/")
    public String showMainPage(@RequestParam(required = false, defaultValue = "") String key,
                               Model model){
        model.addAttribute("newsList", newsService.getNews(key));
        return "index";
    }
    @GetMapping("/delete/{id}")
    public String deleteNews(@PathVariable int id){
        newsService.deleteNews(id);
        return "redirect:/";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("newsDto", new NewsDto());
        return "create";
    }
    @PostMapping("/create")
    public String createNews(@Valid @ModelAttribute NewsDto newsDto,
                             BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "create";
        }
        NewsEntity newsEntity = new NewsEntity();
        BeanUtils.copyProperties(newsDto, newsEntity);
        newsService.create(newsEntity);
        return "redirect:/";
    }

}
