package com.developer.springweb.estudos.service;

import com.developer.springweb.estudos.model.User;
import com.developer.springweb.estudos.repository.UserRepository;
import com.developer.springweb.estudos.service.exceptions.ControllerNotFoundException;
import com.developer.springweb.estudos.service.exceptions.ValidationException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	public UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return null;
	}
	public User insert(User user) {
		return repository.save(user);
	}
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ControllerNotFoundException(id);
		} catch (ValidationException e) {
			throw new ValidationException(e.getMessage());
		}
	}
	public User update(Long id, User obj) {
		try{
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException(e);
		}

	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPassword(obj.getPassword());
		entity.setRegister(obj.getRegister());
	}
}
