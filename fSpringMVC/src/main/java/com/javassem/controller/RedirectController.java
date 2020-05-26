package com.javassem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RedirectController {
	
	@RequestMapping("/select.do")
	public ModelAndView select() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirectResult");
		mv.addObject("info", "여기는 목록보기입니다.");
		return mv;
	}
	
	@RequestMapping("/insert.do")
	public String insert() {
		System.out.println("실제로 DB에 입력함");
		return "redirect:select.do";
	}
	
}
