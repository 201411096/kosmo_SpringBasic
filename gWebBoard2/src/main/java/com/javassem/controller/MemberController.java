package com.javassem.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javassem.dao.MemberDAO;
import com.javassem.domain.MemberVO;


@Controller
@RequestMapping("/user")
public class MemberController {

	@RequestMapping("/{url}.do")
	public String regist(@PathVariable String url) {
		return "user/"+url;
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
