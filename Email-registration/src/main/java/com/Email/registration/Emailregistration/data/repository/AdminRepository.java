package com.Email.registration.Emailregistration.data.repository;

import com.Email.registration.Emailregistration.data.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
