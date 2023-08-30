package com.seclore.main.service.member;

import java.util.List;

import com.seclore.main.domain.Member;

public interface MemberServiceInterface {
	public List<Member> getAllMembers();
	public Member getMemberById(int id);
	public boolean addMember(Member m);
	public void decrementIssue(int id);
	public void incrementIssue(int id);
}
