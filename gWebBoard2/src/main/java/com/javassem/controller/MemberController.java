package com.javassem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@ResponseBody
	@RequestMapping(value="/idCheck.do", produces="application/text; charset=utf-8")
	public String idCheck(MemberVO vo) {
		MemberVO result = memberService.idCheck_Login(vo);
		String message = "ID 사용 가능합니다.";
		if(result!=null) message = "중복된 아이디가 존재합니다.";
		return message;
//		Spring에서 String을 리턴하면 뷰페이지 지정이 되어 버림
//		무조건 뷰페이지 지정되어서 화면이 변경됨
	}
}
