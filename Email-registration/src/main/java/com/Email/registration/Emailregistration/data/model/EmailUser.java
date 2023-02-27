package com.Email.registration.Emailregistration.data.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class EmailUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private AppUser userDetails;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToOne
    private Address address;
    private String emailAddress;
    private Date dateOfBirth;
    private int age;
}
