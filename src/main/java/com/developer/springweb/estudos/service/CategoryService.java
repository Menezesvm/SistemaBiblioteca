package com.developer.springweb.estudos.service;

import com.developer.springweb.estudos.model.Books;
import com.developer.springweb.estudos.model.Category;
import com.developer.springweb.estudos.model.User;
import com.developer.springweb.estudos.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

	@Autowired
	public CategoryRepository repository;


	public List<Category> findAll() {
		return repository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get(); }
}

