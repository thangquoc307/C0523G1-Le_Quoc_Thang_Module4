package com.blog_ajax.controller;

import com.blog_ajax.model.BlogEntity;
import com.blog_ajax.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;
    @GetMapping("/")
    public String showBlog(Model model){
//        Pageable pageable = PageRequest.of(0,2, Sort.by(Sort.Direction.DESC, "releaseDate"));
//        Page<BlogEntity> blogEntityPage = blogService.showBlogPage(pageable);
//        System.out.println(blogEntityPage);
//        model.addAttribute("page_0", blogEntityPage);
        return "index";
    }
}
