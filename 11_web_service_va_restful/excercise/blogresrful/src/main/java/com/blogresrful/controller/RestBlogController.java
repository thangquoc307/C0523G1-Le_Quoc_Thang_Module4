package com.blogresrful.controller;

import com.blogresrful.model.BlogEntity;
import com.blogresrful.model.CategoryEntity;
import com.blogresrful.service.IBlogService;
import com.blogresrful.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class RestBlogController {
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IBlogService iBlogService;
    @GetMapping("/category")
    public ResponseEntity<List<CategoryEntity>> getCategoryList(){
        List<CategoryEntity> list = iCategoryService.showAllCategory();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }
    @GetMapping("/blog")
    public ResponseEntity<List<BlogEntity>> getBlogList(){
        List<BlogEntity> list = iBlogService.showAllBlog();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }
    @GetMapping("category/{id}")
    public ResponseEntity<List<BlogEntity>> getBlogListByCategory(@PathVariable int id){
        List<BlogEntity> list = iBlogService.getBlogByCategory(id);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }
    @GetMapping("blog/{id}")
    public ResponseEntity<BlogEntity> getBlogById(@PathVariable int id){
        BlogEntity blog = iBlogService.getBlogById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
    }
}
