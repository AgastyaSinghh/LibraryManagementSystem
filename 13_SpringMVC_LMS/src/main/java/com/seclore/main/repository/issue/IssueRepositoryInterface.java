package com.seclore.main.repository.issue;

import java.util.List;

import com.seclore.main.domain.Issue;

public interface IssueRepositoryInterface {
	public List<Issue> getAllActiveIssues();
	public Issue getIssueById(int id);
	public boolean addIssue(Issue i);
	public boolean updateIssue(Issue i);
}
