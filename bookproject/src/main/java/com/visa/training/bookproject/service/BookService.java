package com.visa.training.bookproject.service;

import java.util.List;

import com.visa.training.bookproject.domain.Book;

public interface BookService {
	
	public int addNewBook(Book p);
	public Book findById(int id);
	public List<Book> findAll();
	public void deleteBook(int id);
	public void updateBook(Book toBeUpdated,int id);
}
