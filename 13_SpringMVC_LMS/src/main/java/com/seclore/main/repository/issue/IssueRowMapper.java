package com.seclore.main.repository.issue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.seclore.main.domain.Book;
import com.seclore.main.domain.Issue;
import com.seclore.main.domain.Member;
import com.seclore.main.service.book.BookServiceInterface;
import com.seclore.main.service.member.MemberServiceInterface;

@Component
public class IssueRowMapper implements RowMapper<Issue> {
	@Autowired
	private BookServiceInterface bookService;
	
	@Autowired
	private MemberServiceInterface memberService;

	@Override
	public Issue mapRow(ResultSet rs, int rowNum) throws SQLException {
		int issueId = rs.getInt("srl_no");
		int memberId = rs.getInt("member_id");
		int bookId = rs.getInt("book_id");
		LocalDate issueDate = null;
		try {
			issueDate = rs.getDate("issue_date").toLocalDate();
		} catch (Exception e) {
		}

		LocalDate dueDate = null;
		try {
			dueDate = rs.getDate("due_date").toLocalDate();
		} catch (Exception e) {
		}

		LocalDate returnDate = null;
		try {
			issueDate = rs.getDate("return_date").toLocalDate();
		} catch (Exception e) {
		}

		Member m = memberService.getMemberById(memberId);
		Book b = bookService.getBookById(bookId);
		return new Issue(issueId, m, b, issueDate, dueDate, returnDate);
	}

}
