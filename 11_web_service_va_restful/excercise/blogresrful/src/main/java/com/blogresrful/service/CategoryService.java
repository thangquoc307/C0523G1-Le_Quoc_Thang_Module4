package com.blogresrful.service;

import com.blogresrful.model.CategoryEntity;
import com.blogresrful.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Override
    @Transactional
    public void createCategory(CategoryEntity categoryEntity) throws IllegalAccessException {
        if (getCategoryById(categoryEntity.getId()) == null){
            iCategoryRepository.save(categoryEntity);
        } else {
            throw new IllegalAccessException("This Category is Exist");
        }
    }

    @Override
    public List<CategoryEntity> showAllCategory() {
        return iCategoryRepository.findAll();
    }

    @Override
    @Transactional
    public void updateCategory(CategoryEntity categoryEntity) throws IllegalAccessException {
        if (getCategoryById(categoryEntity.getId()) != null){
            iCategoryRepository.save(categoryEntity);
        } else {
            throw new IllegalAccessException("This Category is Delete Before");
        }
    }

    @Override
    @Transactional
    public void deleteCategoryById(Integer id) throws IllegalAccessException {
        if (getCategoryById(id) != null){
            iCategoryRepository.deleteById(id);
        } else {
            throw new IllegalAccessException("This Category is Delete Before");
        }
    }

    @Override
    public CategoryEntity getCategoryById(Integer id) {
        return iCategoryRepository.findById(id).get();
    }
}
