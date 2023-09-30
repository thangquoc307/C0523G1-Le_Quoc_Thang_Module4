package com.blogresrful.service;

import com.blogresrful.model.BlogEntity;

import java.util.List;

public interface IBlogService {
    void createBlog(BlogEntity blog) throws IllegalAccessException;
    List<BlogEntity> showAllBlog();
    void updateBlog(BlogEntity blog) throws IllegalAccessException;
    void deleteBlogById(Integer id) throws IllegalAccessException;
    BlogEntity getBlogById(Integer id);
    List<BlogEntity> getBlogByCategory(Integer id);
}
