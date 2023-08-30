package com.seclore.main.service.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seclore.main.domain.Book;
import com.seclore.main.repository.book.BookRepositoryInterface;

@Component
public class BookService implements BookServiceInterface {
	@Autowired
	private BookRepositoryInterface bookRepository;
	
	@Override
	public List<Book> getAllBooks() {
		return bookRepository.getAllBooks();
	}

	@Override
	public Book getBookById(int id) {
		Book b = bookRepository.getBookById(id);
//		if(b.isIssuable() == false) return null;
		return b;
	}

	@Override
	public boolean addBook(Book b) {
		return bookRepository.addBook(b);
	}

	@Override
	public boolean markIssuable(int id, boolean b) {
		return bookRepository.updateIssuable(id, b);
	}

}
