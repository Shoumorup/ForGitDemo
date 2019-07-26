package com.visa.training.bookproject.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="chapter")
public class Chapter {
	
	@Id 
	@Column(name="chapter_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name="chapter_index")
	int index;
	@Column(name="chapter_name")
	String name;
	int numPages;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	@JsonIgnore
	Book book;
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Chapter() {
		// TODO Auto-generated constructor stub
	}	

	public Chapter(int index, String name, int numPages) {
		super();
		this.index = index;
		this.name = name;
		this.numPages = numPages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumPages() {
		return numPages;
	}

	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}

	@Override
	public String toString() {
		return "Chapter [id=" + id + ", index=" + index + ", name=" + name + ", numPages=" + numPages + "]";
	}
}
