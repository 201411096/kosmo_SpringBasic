package example.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelController {
	@RequestMapping(value="/model.do")
	public void test(Model m) {
		m.addAttribute("message", "팀원님들 뭐 하실래요");
		m.addAttribute("addr", "가산시");
	}
	/* 기본적으로 view에게 데이터를 넘기는 방법
	 * 
	 * 1. ModelAndView 객체 이용
	 * 2. Map 객체 (자바의 HashMap)
	 * 3. Model 객체 ********** ModelAndView 혹은 HashMap처럼 return으로 넘기는 게 아니고 인자로 지정함 **********
	 * 4. ModelAttribute 이용
	 */
}
