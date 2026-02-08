package com.bookstore.online_book_store.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.online_book_store.model.Book;

@Repository
public interface  Book_Repository  extends JpaRepository<Book,Long>{

}
