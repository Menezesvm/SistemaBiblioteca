package com.developer.springweb.estudos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_books")
public class Books implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id")
	public Author AuthorId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category categoryId;

	private String title;
	private String ISBN;
	private Integer quantity;


	@ManyToMany
	@JoinTable(
			name = "tb_books_category",
			joinColumns = @JoinColumn(name = "book_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id")
	)
	private Set<Category> categories = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "book")
	private Set<Loan> loans = new HashSet<>();

	public Books() {
	}

	public Books(Long id, Author authorId, Category categoryId, String title, String ISBN, Integer quantity) {
		this.id = id;
		AuthorId = authorId;
		this.categoryId = categoryId;
		this.ISBN = ISBN;
		this.title = title;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAuthorId() {
		return AuthorId.getId();
	}

	public void setAuthorId(Author authorId) {
		AuthorId = authorId;
	}

	public Long getCategoryId() {
		return categoryId.getId();
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public Set<Loan> getLoans() {
		return loans;
	}

	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;

		Books books = (Books) o;
		return id.equals(books.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
