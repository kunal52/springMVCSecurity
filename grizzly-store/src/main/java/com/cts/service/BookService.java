package com.cts.service;

import java.util.List;

import com.cts.entity.Book;

public interface BookService {

	 List<Book> getBooksList();
	 void createBook(Book book);
	 void deleteBook(int id);
	 Book getBook(int id);
	
}
