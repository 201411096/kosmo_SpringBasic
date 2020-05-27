package com.javassem.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

		//
		@RequestMapping("/{step}.do")
		public String viewPage(@PathVariable String step) {
			return step;
		}
	
		// 글 목록 검색
		@RequestMapping("/getBoardList.do")
		public ModelAndView getBoardList(BoardVO vo, HttpSession session) {
			String userId = (String) session.getAttribute("userName");
			ModelAndView mv = new ModelAndView();
			if(userId==null || userId=="") {
				System.out.println("null일 경우 출력:" + userId);
				mv.setViewName("user/userLogin");
//				mv.setViewName("../index");
			}
			else {
				System.out.println("null이 아닐 경우 출력 : " +userId);
				mv.addObject("boardList", boardService.getBoardList(vo));
				mv.setViewName("getBoardList");	
			}
			return mv;
		}
		
//		// 글 목록 검색
//		@RequestMapping("/getBoardList.do")
//		public void getBoardList(BoardVO vo, Model model, HttpSession session) {
//			model.addAttribute("boardList", boardService.getBoardList(vo));
//			// ViewResolver를 지정하지 않으면 아래처럼 페이지명 지정
//			// return "views/getBoardList.jsp"; // View 이름 리턴
//		}
	
		// 글 등록
		@RequestMapping(value = "/saveBoard.do")
		public String insertBoard(BoardVO vo) throws IOException {
			boardService.insertBoard(vo);
			return "redirect:/getBoardList.do";
		}

		// 글 수정
		@RequestMapping("/updateBoard.do")
		public String updateBoard(@ModelAttribute("board") BoardVO vo) {
			boardService.updateBoard(vo);
			return "redirect:/getBoardList.do";
		}

		// 글 삭제
		@RequestMapping("/deleteBoard.do")
		public String deleteBoard(BoardVO vo) {
			boardService.deleteBoard(vo);
			return "redirect:/getBoardList.do";
		}

		// 글 상세 조회
		@RequestMapping("/getBoard.do")
		public void getBoard(BoardVO vo, Model model) {
			model.addAttribute("board", boardService.getBoard(vo)); // Model 정보 저장			
		}

	}
