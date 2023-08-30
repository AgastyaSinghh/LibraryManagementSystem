package com.seclore.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seclore.main.domain.Member;
import com.seclore.main.service.member.MemberServiceInterface;

@Controller
@RequestMapping("lms/member")
public class MemberController {
	@Autowired
	private MemberServiceInterface memberService;
	
	@RequestMapping("/")
	public ModelAndView getAllMembers() {
		List<Member> memberList = memberService.getAllMembers();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("memberList", memberList);
		modelAndView.setViewName("membershome");
		return modelAndView;
	}

	@RequestMapping("new")
	public ModelAndView showAddMemberPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("member", new Member());
		modelAndView.setViewName("newmember");
		return modelAndView;
	}

	@RequestMapping("add")
	public String addMember(Member m) {
		System.out.println("Member added: " + m);
		memberService.addMember(m);
		return "redirect:";
	}
}
