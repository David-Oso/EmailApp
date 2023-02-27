package com.Email.registration.Emailregistration.services;

import com.Email.registration.Emailregistration.data.dto.request.RegisterRequest;
import com.Email.registration.Emailregistration.data.dto.response.RegisterResponse;
import com.Email.registration.Emailregistration.data.model.AppUser;
import com.Email.registration.Emailregistration.data.model.EmailUser;
import com.Email.registration.Emailregistration.data.repository.AdminRepository;
import com.Email.registration.Emailregistration.data.repository.EmailUserRepository;
import com.Email.registration.Emailregistration.exception.EmailException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class AdminServiceImpl implements AdminService{
    private final AdminRepository adminRepository;
    private final ModelMapper modelMapper;
    private EmailUserRepository emailUserRepository;

    @Override
    public RegisterResponse registerEmailAccount(RegisterRequest adminRequest) {
        AppUser emailUserDetails = modelMapper.map(adminRequest, AppUser.class);
        emailUserDetails.setCreatedAt(LocalDateTime.now().toString());

        EmailUser emailUser = EmailUser.builder().build();

        EmailUser savedeMailUser = emailUserRepository.save(emailUser);
        return RegisterResponse.builder()
                .code(HttpStatus.CREATED.value())
                .id(savedeMailUser.getId())
                .isSuccess(true)
                .message("Email account created successfully for "+
                        emailUserDetails.getFirstName()+" " + emailUserDetails.getLastName())
                .build();
    }

    @Override
    public EmailUser findEmailUserById(Long id) {
        return emailUserRepository.findById(id).get();
    }

    @Override
    public void saveEmailUser(EmailUser emailUser) {
        emailUserRepository.save(emailUser);
    }

    @Override
    public void deleteEmailUserById(Long id) {
        emailUserRepository.deleteById(id);
    }

    @Override
    public void deleteALlEmailUsers() {
        emailUserRepository.deleteAll();
    }

    @Override
    public Long countEmailUsers() {
        return emailUserRepository.count();
    }

    @Override
    public List<EmailUser> getAllEmailUser() {
        return emailUserRepository.findAll();
    }

    @Override
    public String createEmailGenerator(EmailUser emailUser) {
        SecureRandom randomNumbers = new SecureRandom();
        String numbers = randomNumbers.ints(3, 0, 9)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(""));
        String emailEnd = "@gmail.com";
        String userName = emailUser.getUserDetails().getLastName()
                +""+emailUser.getUserDetails().getFirstName()+numbers ;
        emailUser.setEmailAddress(userName+""+emailEnd);
        return emailUser.getEmailAddress();
    }

    @Override
    public EmailUser findEmailUserNameThatContains(String name) {
        List<EmailUser> allUsers = emailUserRepository.findAll();
        for(EmailUser user: allUsers){
            if(user.getUserDetails().getFirstName().contains(name) ||
            user.getUserDetails().getLastName().contains(name)){
                return  user;
            }
            else try {
                throw new EmailException
                        ("Email user name that contains "+name+" not found...\n" +
                                "invalid input entered!!!");
            } catch (EmailException exception) {
                throw new RuntimeException(exception.getMessage());
            }
        }
        return null;
    }


}
