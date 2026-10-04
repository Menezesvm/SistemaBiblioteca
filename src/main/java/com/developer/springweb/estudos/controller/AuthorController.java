package com.developer.springweb.estudos.controller;

import com.developer.springweb.estudos.model.Author;
import com.developer.springweb.estudos.model.User;
import com.developer.springweb.estudos.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

	@Autowired
	private AuthorService service;

	@GetMapping
	public ResponseEntity<List<Author>> findALL() {
		List<Author> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Author> findById(@PathVariable Long id) {
		Author obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
