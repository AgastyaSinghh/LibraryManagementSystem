package com.seclore.main.repository.member;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.seclore.main.domain.Member;

public class MemberRowMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {

		int id = rs.getInt("id");
		String name = rs.getString("name");
		String type = rs.getString("type");
		String status = rs.getString("status");
		int issueCount = rs.getInt("issue_count");
		return new Member(id, name, type, status, issueCount);
		
	}

}
