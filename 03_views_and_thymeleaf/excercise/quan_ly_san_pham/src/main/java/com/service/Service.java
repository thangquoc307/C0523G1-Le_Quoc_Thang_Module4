package com.service;

import com.model.Product;
import com.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service

public class Service {
    @Autowired
    private static Repository repository;
    public List<Product> showAll(){
        return repository.showAll();
    }
    public void create(Product product){
        repository.create(product);
    }
    public void edit(int index, Product product){
        repository.edit(index, product);
    }
    public void delete(int index){
        repository.delete(index);
    }
    public Product detail(int index){
        return repository.detail(index);
    }
    public List<Product> search(String keyword){
        return repository.search(keyword);
    }
}
