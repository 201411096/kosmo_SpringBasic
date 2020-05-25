package spring.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/start.do")	// start.do함수가 들어올경우에만 mapping을 함
	public void start() { // 함수 이름은 상관없음
		System.out.println("start 요청되었습니다.");
	}
}
