package com.developer.springweb.estudos.repository;

import com.developer.springweb.estudos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
