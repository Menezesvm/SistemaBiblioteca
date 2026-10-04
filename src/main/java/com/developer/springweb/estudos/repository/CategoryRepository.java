package com.developer.springweb.estudos.repository;

import com.developer.springweb.estudos.model.Category;
import com.developer.springweb.estudos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
