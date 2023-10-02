package com.blog_ajax.service;

import com.blog_ajax.model.BlogEntity;
import com.blog_ajax.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public List<BlogEntity> showAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public Page<BlogEntity> showBlogPage(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<BlogEntity> searchByTitle(String keyword) {
        return blogRepository.findBlogEntityByTitleContaining(keyword);
    }
}
