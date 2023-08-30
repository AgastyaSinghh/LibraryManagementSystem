package com.seclore.main.repository.member;

import java.util.List;

import com.seclore.main.domain.Member;

public interface MemberRepositoryInterface {
	public List<Member> getAllMembers();
	public Member getMemberById(int id);
	public boolean addMember(Member m);
	public boolean updateIssueCount(int id, int i);
}
