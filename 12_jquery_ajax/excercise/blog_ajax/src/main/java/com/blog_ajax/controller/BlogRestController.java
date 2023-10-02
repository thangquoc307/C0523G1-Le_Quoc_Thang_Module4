package com.blog_ajax.controller;

import com.blog_ajax.model.BlogEntity;
import com.blog_ajax.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    IBlogService blogService;
    @GetMapping("/show")
    public ResponseEntity<Page<BlogEntity>> showBlog(@RequestParam(defaultValue = "0", required = false) int page){
        Pageable pageable = PageRequest.of(page,2, Sort.by(Sort.Direction.DESC, "releaseDate"));
        Page<BlogEntity> blogEntityPage = blogService.showBlogPage(pageable);
        if (blogEntityPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogEntityPage, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<BlogEntity>> searchByTitle(@RequestParam String keyword){
        List<BlogEntity> list = blogService.searchByTitle(keyword);
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
