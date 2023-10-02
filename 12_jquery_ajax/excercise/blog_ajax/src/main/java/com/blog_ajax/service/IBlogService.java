package com.blog_ajax.service;

import com.blog_ajax.model.BlogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<BlogEntity> showAllBlog();
    Page<BlogEntity> showBlogPage(Pageable pageable);
    List<BlogEntity> searchByTitle(String keyword);
}
