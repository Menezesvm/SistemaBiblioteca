package com.developer.springweb.estudos.service;

import com.developer.springweb.estudos.model.Books;
import com.developer.springweb.estudos.model.Loan;
import com.developer.springweb.estudos.model.User;
import com.developer.springweb.estudos.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

	@Autowired
	public LoanRepository repository;

	public List<Loan> findAll() {
		return repository.findAll();
	}
	public Loan findById(Long id) {
		Optional<Loan> obj = repository.findById(id);
		return obj.get(); }

}
