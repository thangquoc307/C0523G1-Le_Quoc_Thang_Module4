package com.blogresrful.service;

import com.blogresrful.model.BlogEntity;
import com.blogresrful.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository iBlogRepository;
    @Override
    @Transactional
    public void createBlog(BlogEntity blog) throws IllegalAccessException {
        if (iBlogRepository.findById(blog.getId()) == null){
            iBlogRepository.save(blog);
        } else {
            throw new IllegalAccessException("This Blog is Exist");
        }
    }

    @Override
    public List<BlogEntity> showAllBlog() {
        return iBlogRepository.findAll();
    }

    @Override
    @Transactional
    public void updateBlog(BlogEntity blog) throws IllegalAccessException {
        if (iBlogRepository.findById(blog.getId()) == null){
            iBlogRepository.save(blog);
        } else {
            throw new IllegalAccessException("This Blog is delete before");
        }
    }

    @Override
    @Transactional
    public void deleteBlogById(Integer id) throws IllegalAccessException {
        if (iBlogRepository.findById(id) == null){
            iBlogRepository.deleteById(id);
        } else {
            throw new IllegalAccessException("This Blog is delete before");
        }
    }

    @Override
    public BlogEntity getBlogById(Integer id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public List<BlogEntity> getBlogByCategory(Integer id) {
        return iBlogRepository.getBlogEntitiesByCategory_Id(id);
    }
}
