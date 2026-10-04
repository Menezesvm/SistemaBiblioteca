package com.developer.springweb.estudos.config;

import com.developer.springweb.estudos.model.User;
import com.developer.springweb.estudos.repository.AuthorRepository;
import com.developer.springweb.estudos.repository.CategoryRepository;
import com.developer.springweb.estudos.repository.LoanRepository;
import com.developer.springweb.estudos.repository.UserRepository;
import com.developer.springweb.estudos.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("teste")
public class Testeconfig implements CommandLineRunner {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BooksService booksService;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User us1 = new User(null, "Ana Luiza de Lima", "Analu@gmail.com", Instant.parse("2026-09-26T22:36:20Z"),"12345678");
		User us2 = new User(null, "Vinícius Menezes", "Menezes@gmail.com", Instant.parse("2026-09-26T22:38:20Z"),"12344321");
		User us3 = new User(null, "Flávia da Silva", "Flima@gmail.com", Instant.parse("2026-09-26T22:38:20Z"),"12345687");

		userRepository.saveAll(Arrays.asList(us1, us2, us3));

	}
}
