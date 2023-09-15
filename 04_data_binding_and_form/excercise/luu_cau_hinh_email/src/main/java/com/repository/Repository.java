package com.repository;

import com.model.EmailSetup;

@org.springframework.stereotype.Repository
public class Repository {
    private static EmailSetup emailSetup = new EmailSetup(1,25,true,"chữ ký");

    public EmailSetup show(){
        return emailSetup;
    }
    public void edit(EmailSetup newEmailSetup){
        emailSetup = newEmailSetup;
    }
}
