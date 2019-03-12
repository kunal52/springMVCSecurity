package com.cts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.entity.Book;
import com.cts.service.BookService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/list")
	public String listAllBooks(Model model)
	{
		System.out.println("List Books");
		List<Book>books=bookService.getBooksList();
		System.out.println("Book List"+books);
		model.addAttribute("books", books);
		return "booklist";
	}
	
	@GetMapping("/showform")
	public String showAddForm(Model model)
	{
		Book book=new Book();
		model.addAttribute("book",book);
		return "addBook";
	}
	
	@GetMapping("/update")
	public String showUpdateForm(@RequestParam("id")int id,Model model)
	{
		Book book=new Book();
		Book book2 = bookService.getBook(id);
	//	System.out.println(book2);
		book.setId(id);
		model.addAttribute("book",book);
		return "addBook";
	}
	
	
	@PostMapping("/savebook")
	public String addBook(@ModelAttribute("book")Book book)
	{
		System.out.println(book);
		bookService.createBook(book);
		return "redirect:/book/list";
	}
	
	@GetMapping("/delete")
	public String deleteBook(@RequestParam("id")int id)
	{
		bookService.deleteBook(id);
		return "redirect:/book/list";
	}
	
	
}
