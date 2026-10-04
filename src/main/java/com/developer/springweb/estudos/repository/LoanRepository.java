package com.developer.springweb.estudos.repository;

import com.developer.springweb.estudos.model.Loan;
import com.developer.springweb.estudos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
