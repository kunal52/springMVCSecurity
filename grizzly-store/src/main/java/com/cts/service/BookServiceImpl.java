package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.dao.BookDAO;
import com.cts.entity.Book;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO bookDao;
	
	@Override
	@Transactional
	public List<Book> getBooksList() {
		// TODO Auto-generated method stub
		return bookDao.listBooks();
	}

	@Override
	@Transactional
	public void createBook(Book book) {
		bookDao.saveBook(book);
		
	}

	@Override
	@Transactional
	public void deleteBook(@RequestParam("id")int id) {
		bookDao.deleteBook(id);
		
	}

	@Override
	@Transactional
	public Book getBook(int id) {
		bookDao.getBook(id);
		return null;
	}

	

}
