package com.valtech.training.first.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int price;
	private int year;
	
	@ManyToOne @JoinColumn(name = "publisher_id")
	private Publisher publisher;
	
	@ManyToMany(targetEntity = Author.class,fetch = FetchType.LAZY)
	@JoinTable(name="book_author",
	joinColumns = @JoinColumn(name="book_id",referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="author_id",referencedColumnName = "id"))
    private List<Author> authors;


	public Book() {
	}

	public Book(int id, String name, int price, int year, Publisher publisher) {
		this.name = name;
		this.price = price;
		this.year = year;
		this.publisher = publisher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	
	
	
	

}
