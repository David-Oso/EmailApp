package com.Email.registration.Emailregistration.data.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Date {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int day;
    private int month;
    private int year;
}
