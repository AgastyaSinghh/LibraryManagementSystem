package com.seclore.main.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seclore.main.domain.Member;
import com.seclore.main.repository.member.MemberRepositoryInterface;

@Component
public class MemberService implements MemberServiceInterface {
	@Autowired
	private MemberRepositoryInterface memberRepository;

	@Override
	public List<Member> getAllMembers() {
		// TODO add checks
		return memberRepository.getAllMembers();
	}

	@Override
	public Member getMemberById(int id) {
		// TODO add checks
		return memberRepository.getMemberById(id);
	}

	@Override
	public boolean addMember(Member m) {
		// TODO add checks
		return memberRepository.addMember(m);
	}

	@Override
	public void decrementIssue(int id) {
		memberRepository.updateIssueCount(id, 1);
	}

	@Override
	public void incrementIssue(int id) {
		memberRepository.updateIssueCount(id, -1);
		
	}

}
