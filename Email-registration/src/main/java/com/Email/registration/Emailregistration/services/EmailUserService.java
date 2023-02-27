package com.Email.registration.Emailregistration.services;

import com.Email.registration.Emailregistration.data.dto.request.MessageRequest;
import com.Email.registration.Emailregistration.data.dto.response.MessageResponse;
import com.Email.registration.Emailregistration.data.model.EmailUser;

public interface EmailUserService {
    MessageResponse sendMessage(MessageRequest messageRequest);
    EmailUser login(String password);
    String signOut();

    /*
    * login
    * sign out*/
}
