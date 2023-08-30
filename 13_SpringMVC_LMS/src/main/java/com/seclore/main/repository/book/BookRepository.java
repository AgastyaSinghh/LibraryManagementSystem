package com.seclore.main.repository.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.seclore.main.domain.Book;

@Component
public class BookRepository implements BookRepositoryInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String GET_ALL_BOOK="select * from book_details";
	private static final String GET_BOOK_BY_ID="select * from book_details where id=?";
	private static final String UPDATE_BOOK_ISSUE_STATUS_BY_ID="update book_details set issueable=? where id=?";
	private static final String ADD_BOOK="insert into book_details(id, title, author, issueable) values(?,?,?,?)";

	@Override
	public Book getBookById(int id) {
		try{
			Book b = jdbcTemplate.queryForObject(GET_BOOK_BY_ID, new BookRowMapper(), id);
			return b;
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public boolean addBook(Book b) {
		try{
			Object[] args= {b.getId(), b.getTitle(), b.getAuthor(), b.isIssuable()};
			int rowsUpdated = jdbcTemplate.update(ADD_BOOK, args);
			return rowsUpdated > 0;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<Book> getAllBooks() {
		try{
			return jdbcTemplate.query(GET_ALL_BOOK, new BookRowMapper());
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public boolean updateIssuable(int id, boolean b) {
		try{
			Object[] args= {b, id};
			int rowsUpdated = jdbcTemplate.update(UPDATE_BOOK_ISSUE_STATUS_BY_ID, args);
			return rowsUpdated > 0;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

}
