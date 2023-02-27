package com.Email.registration.Emailregistration.services;

import com.Email.registration.Emailregistration.data.dto.request.MessageRequest;
import com.Email.registration.Emailregistration.data.dto.response.MessageResponse;
import com.Email.registration.Emailregistration.data.model.AppUser;
import com.Email.registration.Emailregistration.data.model.EmailUser;
import com.Email.registration.Emailregistration.data.repository.EmailUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class EmailUserServiceImpl implements EmailUserService{
    private final EmailUserRepository emailUserRepository;
    private final ModelMapper modelMapper;

    @Override
    public MessageResponse sendMessage(MessageRequest messageRequest) {
        AppUser userDetails = modelMapper.map(messageRequest, AppUser.class);
        userDetails.setCreatedAt(LocalDateTime.now().toString());

        EmailUser emailUser = EmailUser.builder().build();
        EmailUser savedEmailuser = emailUserRepository.save(emailUser);

        return MessageResponse.builder()
                .code(HttpStatus.CREATED.value())
                .id(savedEmailuser.getId())
                .isSent(true)
                .message("Message sent successfully")
                .build();
    }

    @Override
    public EmailUser login(String password) {
        return null;
    }

    @Override
    public String signOut() {
        return null;
    }
}
