package com.seclore.main.domain;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Issue {
	private int issueId;
	private Member member;
	private Book book;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dueDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate issueDate;
	private Date returnDate;

	public Issue() {
		this.member = new Member();
		this.book = new Book();
		System.out.println("DEFAULT CONSTRUCTOR CALLED");
	}

	public Issue(int issueId, Member member, Book book, LocalDate issueDate, LocalDate dueDate, LocalDate returnDate) {
		super();
		this.issueId = issueId;
		this.member = member;
		this.book = book;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		if(returnDate!=null) this.returnDate = Date.valueOf(returnDate);
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate.toLocalDate();
	}

	public void setIssueDate(String s) {
		this.issueDate = LocalDate.parse(s);
	}
	
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(String s) {
		this.dueDate = LocalDate.parse(s);
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate.toLocalDate();
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "Issue [issueId=" + issueId + ", member=" + member + ", book=" + book + ", issueDate=" + issueDate
				+ ", dueDate=" + dueDate + ", returnDate=" + returnDate + "]";
	}

}
