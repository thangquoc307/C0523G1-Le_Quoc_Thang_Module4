package com.service;

import com.model.EmailSetup;
import com.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service implements IService{
    @Autowired
    private IRepository repository;
    public EmailSetup show(){
        return repository.show();
    }
    public void edit(EmailSetup newEmailSetup) {
        repository.edit(newEmailSetup);
    }
}
