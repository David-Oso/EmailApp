package com.Email.registration.Emailregistration.data.repository;

import com.Email.registration.Emailregistration.data.model.EmailUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailUserRepository extends JpaRepository<EmailUser, Long> {
}
