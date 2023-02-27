package com.Email.registration.Emailregistration.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private AppUser userDetails;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<EmailUser> emailUsers;

}
