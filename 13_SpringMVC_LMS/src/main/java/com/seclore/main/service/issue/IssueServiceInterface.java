package com.seclore.main.service.issue;

import java.util.List;

import com.seclore.main.domain.Issue;

public interface IssueServiceInterface {
	public List<Issue> getAllActiveIssues();
	public Issue getIssuesById(int id);
	public boolean addIssue(Issue i);
	public boolean updateIssue(Issue i);
}
