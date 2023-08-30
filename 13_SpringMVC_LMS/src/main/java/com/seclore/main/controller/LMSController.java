package com.seclore.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.seclore.main.domain.Book;
import com.seclore.main.domain.Issue;
import com.seclore.main.domain.Member;
import com.seclore.main.service.book.BookServiceInterface;
import com.seclore.main.service.issue.IssueServiceInterface;
import com.seclore.main.service.member.MemberServiceInterface;

@Controller
@RequestMapping("lms")
public class LMSController {
	@Autowired
	private IssueServiceInterface issueService;
	
	@Autowired
	private MemberServiceInterface memberService;
	
	@Autowired
	private BookServiceInterface bookService;
	
	@RequestMapping("/")
	public ModelAndView getAllActiveIssues() {
		List<Issue> activeIssueList = issueService.getAllActiveIssues();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("issueList", activeIssueList);
		modelAndView.setViewName("lmshome");
		return modelAndView;
	}

	@GetMapping("/return/{issueId}")
	public ModelAndView returnBook(@PathVariable int issueId) {
		Issue i = issueService.getIssuesById(issueId);
		// marks the book returned - TODO change method name
		// issueService.updateIssue(i);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("issue", i);
		modelAndView.setViewName("returnbook");
		return modelAndView;
	}

	@PostMapping("/return")
	public String returnBook(Issue i) {
		// marks the book returned - TODO change method name
		issueService.updateIssue(i);
		return "redirect:";
	}

	
	@RequestMapping("/new")
	public ModelAndView showNewIssueRequestPage3() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("issue", new Issue());
		modelAndView.setViewName("issue_book_step3");
		return modelAndView;
	}
	
	@RequestMapping("/getmember")
	public ModelAndView showNewIssueWithMember(Issue i) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("Hit");
		Member m = memberService.getMemberById(i.getMember().getId());
		i.setMember(m);
		modelAndView.addObject("issue", i);
		System.out.println("Member set");
		modelAndView.setViewName("issue_book_step3");
		return modelAndView;
	}
	@RequestMapping("/getbook")
	public ModelAndView showNewIssueWithBook(Issue i) {
		ModelAndView modelAndView = new ModelAndView();
		Book b = bookService.getBookById(i.getBook().getId());
		i.setBook(b);
		modelAndView.addObject("issue", i);
		System.out.println("Book set");
		modelAndView.setViewName("issue_book_step3");
		return modelAndView;
	}

	@RequestMapping("/add")
	public String addRequest(Issue i) {
		System.out.println("inside add request");
		issueService.addIssue(i);
		return "redirect:";
	}
}
