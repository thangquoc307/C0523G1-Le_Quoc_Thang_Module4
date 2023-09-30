package com.blogresrful.dto;

import com.blogresrful.model.CategoryEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class BlogDto implements Validator {
    private Integer id;
    private String content;
    private String author;

    private CategoryEntity category;

    public BlogDto() {
    }

    public BlogDto(Integer id, String content, String author, CategoryEntity category) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
