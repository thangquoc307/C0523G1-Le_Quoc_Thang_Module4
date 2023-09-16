package com.repository;

import com.model.EmailSetup;

public interface IRepository {
    EmailSetup show();
    void edit(EmailSetup newEmailSetup);
}
