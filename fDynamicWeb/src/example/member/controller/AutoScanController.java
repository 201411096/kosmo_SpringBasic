package example.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import example.member.model.MemberVO;

@Controller
public class AutoScanController {
	
	@Autowired
	private MemberVO memberVO;
	
	@RequestMapping("/autoScan.do")
	public ModelAndView test() {
		System.out.println("autoScan.do 요청 들어옴");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("01_autoScan"); // /WEB-INF/view/01_autoScan.jsp
		mv.addObject("vo", memberVO);
		
		return mv;
	}
}
