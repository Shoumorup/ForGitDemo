package com.visa.training.bookproject.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.visa.training.bookproject.domain.Book;


@Repository
public interface BookRepository extends CrudRepository<Book,Integer>{
	
	public Book findById(int id);
	public List<Book> findAll();

}
