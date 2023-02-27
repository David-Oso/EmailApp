package com.Email.registration.Emailregistration.services;

import com.Email.registration.Emailregistration.data.dto.request.RegisterRequest;
import com.Email.registration.Emailregistration.data.dto.response.RegisterResponse;
import com.Email.registration.Emailregistration.data.model.EmailUser;

import java.util.List;

public interface AdminService {
    RegisterResponse registerEmailAccount(RegisterRequest adminRequest);
    EmailUser findEmailUserById(Long id);
    void saveEmailUser(EmailUser emailUser);
    void deleteEmailUserById(Long id);
    void deleteALlEmailUsers();
    Long countEmailUsers();
    List<EmailUser> getAllEmailUser();
    String createEmailGenerator(EmailUser emailUser);
    EmailUser findEmailUserNameThatContains(String name);

}
