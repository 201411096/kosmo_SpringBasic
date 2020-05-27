package com.javassem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javassem.domain.MemberVO;
import com.javassem.service.MemberService;


@Controller
@RequestMapping("/user")
public class MemberController {

	@RequestMapping("/{url}.do")
	public String regist(@PathVariable String url) {
		return "user/"+url;
	}
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/userInsert.do")
	public ModelAndView insert(MemberVO vo) {
		int result = memberService.userInsert(vo);
		String message = "가입되지 않았습니다.";
		if(result == 1)
			message = vo.getUserName() + "님 가입을 축하드립니다.";
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/userJoin_ok");
		mv.addObject("message", message);
		mv.addObject("result", result);
		return mv;
	}
	
//	@RequestMapping("/userJoin.do")
//	public void regist() {
//		
//	} // WEB-INF/views/ + user/userJoin + .jsp
//	
//	@RequestMapping("/userLogin.do")
//	public void login() {
//		
//	}
}
