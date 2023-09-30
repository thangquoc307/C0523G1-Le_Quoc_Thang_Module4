package com.blogresrful.service;

import com.blogresrful.model.CategoryEntity;

import java.util.List;

public interface ICategoryService {
    void createCategory(CategoryEntity categoryEntity) throws IllegalAccessException;
    List<CategoryEntity> showAllCategory();
    void updateCategory(CategoryEntity categoryEntity) throws IllegalAccessException;
    void deleteCategoryById(Integer id) throws IllegalAccessException;
    CategoryEntity getCategoryById(Integer id);
}
