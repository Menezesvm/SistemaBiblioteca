package com.developer.springweb.estudos.controller;

import com.developer.springweb.estudos.model.Author;
import com.developer.springweb.estudos.model.Books;
import com.developer.springweb.estudos.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BooksController {

	@Autowired
	private BooksService service;

	@GetMapping
	public ResponseEntity<List<Books>> findALL() {
		List<Books> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Books> findById(@PathVariable Long id) {
		Books obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
