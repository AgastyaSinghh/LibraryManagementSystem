package com.seclore.main.service.issue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seclore.main.domain.Issue;
import com.seclore.main.repository.issue.IssueRepositoryInterface;
import com.seclore.main.service.book.BookServiceInterface;
import com.seclore.main.service.member.MemberServiceInterface;

@Component
public class IssueService implements IssueServiceInterface {
	@Autowired
	private IssueRepositoryInterface issueRepository;
	@Autowired
	private MemberServiceInterface memberService;
	@Autowired
	private BookServiceInterface bookService;

	@Override
	public List<Issue> getAllActiveIssues() {
		return issueRepository.getAllActiveIssues();
	}

	@Override
	public Issue getIssuesById(int id) {
		return issueRepository.getIssueById(id);
		//TODO add checks
	}

	@Override
	public boolean addIssue(Issue i) {
		// TODO add checks; refactor
		memberService.incrementIssue(i.getMember().getId());
		bookService.markIssuable(i.getBook().getId(), false);
		return issueRepository.addIssue(i);
	}

	@Override
	public boolean updateIssue(Issue i) {
		// TODO add checks; refactor
		 
		memberService.decrementIssue(i.getMember().getId());
		bookService.markIssuable(i.getBook().getId(), true);
		boolean success = issueRepository.updateIssue(i);
		System.out.println(success);
		return success;
	}

}
