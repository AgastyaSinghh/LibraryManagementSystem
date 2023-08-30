package com.seclore.main.repository.book;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.seclore.main.domain.Book;

public class BookRowMapper implements RowMapper<Book> {

	
	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String title = rs.getString("title");
		String author = rs.getString("author");
		boolean issuable = rs.getBoolean("issueable");
		return new Book(id, title, author, issuable);
	}

}
