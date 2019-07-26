package com.visa.training.bookproject.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.visa.training.bookproject.domain.Book;
import com.visa.training.bookproject.service.BookService;

@RestController
public class BookRestController {
	
	@Autowired
	BookService service;
	
	@RequestMapping(value="/api/books",method=RequestMethod.GET)
	public List<Book> getAll(){
		return service.findAll();
	}
	
	@RequestMapping(value="/api/books/{id}",method=RequestMethod.GET)
	public ResponseEntity<Book> getById(@PathVariable("id")int id)
	{
		Book b = service.findById(id);
		
		if(b != null)
		{
			return new ResponseEntity<Book>(b, HttpStatus.OK);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/api/books", method=RequestMethod.POST)
	public ResponseEntity createBook(@RequestBody Book toBeCreated)
	{
		toBeCreated.getChapters().forEach(c->c.setBook(toBeCreated));
		try
		{
			int id = service.addNewBook(toBeCreated);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/api/books/"+id));
			return new ResponseEntity<>(headers, HttpStatus.CREATED);
		}
		catch(IllegalArgumentException e)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/api/books/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Book> deleteById(@PathVariable("id")int id)
	{
		Book b = service.findById(id);
		
		if(b != null)
		{
			service.deleteBook(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
	public ResponseEntity updateBook(@RequestBody Book toBeUpdated,@PathVariable("id")int id)
	{
		try
		{
			service.updateBook(toBeUpdated,id);
			HttpHeaders headers = new HttpHeaders();
			return new ResponseEntity<>(headers, HttpStatus.CREATED);
		}
		catch(IllegalArgumentException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
