package com.developer.springweb.estudos.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_loan")
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Books book;

	private Date loanDate;
	private Date loanEndDate;
	private String status;

	public Loan() {
	}

	public Loan(Long id, User client, Books book, Date loanDate, Date loanEndDate, String status) {
		this.id = id;
		this.client = client;
		this.book = book;
		this.loanDate = loanDate;
		this.loanEndDate = loanEndDate;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public Date getLoanEndDate() {
		return loanEndDate;
	}

	public void setLoanEndDate(Date loanEndDate) {
		this.loanEndDate = loanEndDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;

		Loan loan = (Loan) o;
		return id.equals(loan.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
