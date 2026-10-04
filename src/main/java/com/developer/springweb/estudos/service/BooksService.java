package com.developer.springweb.estudos.service;

import com.developer.springweb.estudos.model.Author;
import com.developer.springweb.estudos.model.Books;
import com.developer.springweb.estudos.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

	@Autowired
	public BooksRepository repository;

	public List<Books> findAll() {
		return repository.findAll();
	}

	public Books findById(Long id) {
		Optional<Books> obj = repository.findById(id);
		return obj.get(); }
}
