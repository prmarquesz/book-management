package com.bookmanagement.infra.persistence.repositories;

import com.bookmanagement.infra.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
   UserDetails findByUsername(String username);
}
