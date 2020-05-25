package spring.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/start.do")	// start.do url이 들어올경우에만 mapping을 함
	public ModelAndView start() { // 함수 이름은 상관없음, 일반적으로 요청이름과 맞춰주려고함(위에 url이랑 맞춰주려고 하는듯)
		System.out.println("start 요청되었습니다.");
		
		ModelAndView mv = new ModelAndView();
//		mv.setViewName("/WEB-INF/view/hello.jsp"); // 그 다음으로 이동할 페이지 설정
		mv.setViewName("hello"); // common-servlet에서 접두사 접미사 지정해둠
		mv.addObject("message", "즐거운 스프링22");
		return mv;
	}
}
