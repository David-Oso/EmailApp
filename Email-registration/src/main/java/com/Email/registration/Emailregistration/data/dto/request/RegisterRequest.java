package com.Email.registration.Emailregistration.data.dto.request;

import lombok.*;

@Builder
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class RegisterRequest {
    private Long emailId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String phoneNumber;
    private String emailAddress;
}
