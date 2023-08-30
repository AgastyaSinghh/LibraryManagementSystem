package com.seclore.main.repository.issue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.seclore.main.domain.Issue;

@Component
public class IssueRepository implements IssueRepositoryInterface {
	
	private static final String GET_ALL_ACTIVE_ISSUES="select * from issue_details where return_date is null";
	private static final String GET_ISSUE_BY_ID="select * from issue_details where srl_no=?";
	private static final String NEW_ISSUES="insert into issue_details(member_id, book_id, issue_date, due_date) values(?,?,?,?)";
	private static final String UPDATE_ISSUES="update issue_details set return_date=? where srl_no=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private IssueRowMapper issueRowMapper;
	
	@Override
	public List<Issue> getAllActiveIssues() {
		try {
			return jdbcTemplate.query(GET_ALL_ACTIVE_ISSUES, issueRowMapper);
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

	@Override
	public boolean addIssue(Issue i) {
		Object[] args= {i.getMember().getId(), i.getBook().getId(), i.getIssueDate(), i.getDueDate()};
		try {
			int rowsUpdated = jdbcTemplate.update(NEW_ISSUES, args); 
			return rowsUpdated>0;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean updateIssue(Issue i) {
		try {
			Object[] args= {i.getReturnDate().toLocalDate().toString(), i.getIssueId()};
			System.out.println(""+args[0] +"\n"+  args[1]);
			int rowsUpdated = jdbcTemplate.update(UPDATE_ISSUES, args); 
			return rowsUpdated>0;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Issue getIssueById(int id) {
		try {
			return jdbcTemplate.queryForObject(GET_ISSUE_BY_ID, issueRowMapper, id);
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

}
