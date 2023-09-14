package com.service;

import com.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private Repository repository;
    public String translate(String word){
        return repository.translate(word);
    }
}
