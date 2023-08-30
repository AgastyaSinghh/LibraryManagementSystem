package com.seclore.main.service.book;

import java.util.List;

import com.seclore.main.domain.Book;

public interface BookServiceInterface {
	public List<Book> getAllBooks();
	public Book getBookById(int id);
	public boolean addBook(Book b);
	public boolean markIssuable(int id, boolean b);
}
