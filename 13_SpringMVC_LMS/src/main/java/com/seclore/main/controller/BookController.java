package com.seclore.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seclore.main.domain.Book;
import com.seclore.main.service.book.BookServiceInterface;

@Controller
@RequestMapping("lms/book")
public class BookController {
	@Autowired
	private BookServiceInterface bookService;
	
	@RequestMapping("/")
	public ModelAndView getAllBook() {
		List<Book> bookList = bookService.getAllBooks();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("bookList", bookList);
		modelAndView.setViewName("bookshome");
		return modelAndView;
	}

	@RequestMapping("new")
	public ModelAndView showAddBookPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("book", new Book());
		modelAndView.setViewName("newbook");
		return modelAndView;
	}

	@RequestMapping("add")
	public String addBook(Book b) {
		System.out.println("Book added" + b);
		bookService.addBook(b);
		return "redirect:";
	}
}
