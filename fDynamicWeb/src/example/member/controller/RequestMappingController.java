package example.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import example.member.model.MemberVO;

@Controller
@RequestMapping("/board") 
public class RequestMappingController {
	@RequestMapping(value={"/a.do", "/b.do"})
	public String test() {
		System.out.println("a.do와 b.do 요청합니다.");
		return "hello";
	}
	//return형이 String 인 경우 : 뷰 페이지를 지정
	
	@RequestMapping(value="/c.do", params= {"id=kim"})	// param이 id=kim인 경우에만 됨
	public void test2(String id) { // 쿼리스트링으로 넘어오는 값들은 parameter로 잡으면 됨
		System.out.println("c.do 요청 [" + id + "]");
	}
	//return형이 void인 경우 : 요청과 동일한 이름의 뷰페이지를 지정
	@RequestMapping(value="/request.do", method=RequestMethod.POST) // POST인 경우에만 받아옴
	public void test3(MemberVO vo) { // 폼 태그에서 보낸 id name age 를 받아서 vo로 받아옴(***** VO의 멤버변수와 변수이름이 같아야 하는듯 *****)
		System.out.println("request.do요청 : " + vo.getName());
		
	}
}
