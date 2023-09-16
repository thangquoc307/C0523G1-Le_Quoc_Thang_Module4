package com.service;
import com.model.EmailSetup;

public interface IService {
    EmailSetup show();
    void edit(EmailSetup newEmailSetup);
}
