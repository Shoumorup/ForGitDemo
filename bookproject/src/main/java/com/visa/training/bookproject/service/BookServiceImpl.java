package com.visa.training.bookproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.training.bookproject.dal.BookRepository;
import com.visa.training.bookproject.domain.Book;

//This class will have business logic.
@Service
@Transactional
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository dao;
	@Override
	public int addNewBook(Book b) {
		Book created = dao.save(b);
		int	id = created.getId();
		
		return id;
	}

	@Override
	public Book findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Book> findAll() {
		return dao.findAll();
	}

	@Override
	public void deleteBook(int id) {
		Book b =dao.findById(id);
		if(b.getReleaseYear()>1500)
			throw new IllegalArgumentException("Can't remove when Release Year >1500");
		else dao.deleteById(id);//Need to write down methods in CrudRepository
	}
	
	@Override
	public void updateBook(Book toBeUpdated,int id) {
		Book p =dao.findById(id);
		if(p == null) throw new IllegalArgumentException("Book does not exist!");
		p.setName(toBeUpdated.getName());
		p.setAuthor(toBeUpdated.getAuthor());
		p.setCategory(toBeUpdated.getCategory());
		p.setReleaseYear(toBeUpdated.getReleaseYear());
				
		Book updated = dao.save(p);		
	}	
}
