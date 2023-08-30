package com.seclore.main.repository.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.seclore.main.domain.Member;
//import com.seclore.main.repository.book.BookRowMapper;

@Component
public class MemberRepository implements MemberRepositoryInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String GET_ALL_MEMBER="select * from member_details";
	private static final String GET_MEMBER_BY_ID="select * from member_details where id=?";
	private static final String UPDATE_MEMBER_ISSUE_COUNT_BY_ID="update member_details set issue_count=issue_count+? where id=?";
	private static final String ADD_MEMBER="insert into member_details(id, name, type, status, issue_count) values(?,?,?,?,?)";

	@Override
	public Member getMemberById(int id) {
		try{
			return jdbcTemplate.queryForObject(GET_MEMBER_BY_ID, new MemberRowMapper(), id);
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public boolean addMember(Member m) {
		try{
			Object[] args= {m.getId(), m.getName(), m.getType(), m.getStatus(), m.getIssueCount()};
			int rowsUpdated = jdbcTemplate.update(ADD_MEMBER, args);
			return rowsUpdated > 0;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<Member> getAllMembers() {
		try{
			return jdbcTemplate.query(GET_ALL_MEMBER, new MemberRowMapper());
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public boolean updateIssueCount(int id, int val) {
		try{
			Object[] args= {val, id};
			int rowsUpdated = jdbcTemplate.update(UPDATE_MEMBER_ISSUE_COUNT_BY_ID, args);
			return rowsUpdated > 0;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}


}
