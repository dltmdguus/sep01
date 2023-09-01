package com.zoe.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoe.web.entity.JBoard;
import com.zoe.web.entity.Member;
import com.zoe.web.service.*;

@Controller
public class BoardController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BoardService boardService;

	
	@GetMapping("/board")
	public String board(Model model) {
		List<JBoard> list = boardService.findAll();
		model.addAttribute("list", list);
		return "board";
	}
	
	@GetMapping("/write")
	public String write() {
		return "write";
	}
	
	@PostMapping("/write")
	public String write(JBoard jBoard, HttpSession session){
		if(session.getAttribute("id") != null) {
			Member member = memberService.findByMid((String)session.getAttribute("id"));
			jBoard.setMember(member);
			boardService.save(jBoard);
			
		}
		return "redirect:/board";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam(name="bno", required = true) int bno, Model model) {
		JBoard detail = boardService.findByBno(bno);
		model.addAttribute("detail", detail);
		return "detail";
		
	}
	
}
