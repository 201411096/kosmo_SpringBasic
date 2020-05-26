package com.javassem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("/getBoardList.do")
	public void getBoardList(BoardVO vo , Model model) {
		//검색기능 때문에 BoardVO를 매개변수로 지정했지만 지금은 필요없음
		List<BoardVO> list = service.getBoardList(vo);
		model.addAttribute("boardList", list);
	}
}
