package com.zoe.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.zoe.web.entity.Member;
import com.zoe.web.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Member member, HttpSession session) {
		//Member(mno=0, mname=null, mid=pororo, mpw=01234567, mjoindate=null)
		System.out.println(member);
		
		int count = memberService.count(member);
		if(count == 1) {
			Member result = memberService.findByMidAndMpw(member.getMid(), member.getMpw());
			System.out.println("name : " + result);
			session.setAttribute("id", result.getMid());
			session.setAttribute("name", result.getMname());
			
			//name : Member(mno=1, mname=null, mid=pororo, mpw=01234567, mjoindate=2023-09-01)
			return "redirect:/index";
		} else {
			return "login";
		}

	}

}