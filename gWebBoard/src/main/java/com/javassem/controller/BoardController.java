package com.javassem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	} // view page : getBoardList.jsp
	
//	@RequestMapping("/insertBoard.do")
//	public void insertBoard() {		
//	}
	@RequestMapping("/{step}.do")
	public String insertBoard(@PathVariable String step) { //requestMapping으로 넘어온 파라미터를 지정
		return step;
	}
	@RequestMapping("/saveBoard.do")
	public String saveBoard(BoardVO vo) {
		service.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	@RequestMapping("/getBoard.do")
//	public void getBoard(String seq) { // BoardVO에 seq가 존재하기때문에 BoardVO로 받아도 됨
	public void getBoard(BoardVO vo, Model m) {
		m.addAttribute("board", service.getBoard(vo));
	}
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		service.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
	@RequestMapping("/updateBoard.do")
	public void updateBoard(BoardVO vo, Model m) {
		m.addAttribute("board", service.getBoard(vo));
	}
	@RequestMapping("/updateBoardContent.do")
	public String updateBoardContent(BoardVO vo) {
		service.updateBoard(vo);
		return "redirect:getBoardList.do";
	}
}
