package com.Email.registration.Emailregistration.data.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MessageResponse {
    private Long id;
    private String message;
    private int code;
    private boolean isSent;

}
