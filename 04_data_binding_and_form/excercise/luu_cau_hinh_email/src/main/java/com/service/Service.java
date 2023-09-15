package com.service;

import com.model.EmailSetup;
import com.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    Repository repository;
    public EmailSetup show(){
        return repository.show();
    }
    public void edit(EmailSetup newEmailSetup) {
        repository.edit(newEmailSetup);
    }
}
