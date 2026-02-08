package com.bookstore.online_book_store.model.repo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.online_book_store.model.Book;
import com.bookstore.online_book_store.model.repo.Book_Repository;

@Service
public class BookService {
	@Autowired
	 private Book_Repository bookrepository;
	
	
	public List<Book> getAllBooks()
	{
		 return bookrepository.findAll();
	}
	
	public void  saveBook(Book book)
	{
		bookrepository.save(book);
	}
	public Optional<Book> getBookById(Long Id)
	{
		 return bookrepository.findById(Id);
	}
	 public void deleteBook(Long id) {
	        bookrepository.deleteById(id);
	}

}
