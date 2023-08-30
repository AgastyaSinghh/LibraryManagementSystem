package com.seclore.main.repository.book;

import java.util.List;

import com.seclore.main.domain.Book;

public interface BookRepositoryInterface {
	public List<Book> getAllBooks();
	public Book getBookById(int id);
	public boolean addBook(Book b);
	public boolean updateIssuable(int id, boolean b);
}
