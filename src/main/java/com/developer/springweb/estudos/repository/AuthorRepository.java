package com.developer.springweb.estudos.repository;

import com.developer.springweb.estudos.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
