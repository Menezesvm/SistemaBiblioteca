package com.developer.springweb.estudos.service;

import com.developer.springweb.estudos.model.Author;
import com.developer.springweb.estudos.repository.AuthorRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

	@Autowired
	public AuthorRepository repository;

	public List<Author> findAll() {
		return repository.findAll();
	}

	public Author findById(Long id) {
		Optional<Author> obj = repository.findById(id);
		return obj.get();
	}

}
