package com.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import com.simple.board.service.BoardService;
import com.simple.command.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		List<BoardVO> list = boardService.selectList();
		
		model.addAttribute("list",list);
		
		return "board/boardList";
	}
	@RequestMapping("/boardRegister")
	public void boardRegister() {
	}

	@RequestMapping("/boardResult")
	public void boardResult() {
	}
	@RequestMapping(value="/boardRegisterForm",method=RequestMethod.POST)
	public String boardRegisterForm(BoardVO vo) {
		System.out.println("등록 컨트롤러 호출");
		
		boardService.register(vo);
		
		return "board/boardResult";
	}
	
	@RequestMapping("boardDelete")
	public String boardDelete(@RequestParam("idx")String idx) {
		boardService.delete(idx);
		
		return "redirect:/board/boardList";
	}
	
	
}
