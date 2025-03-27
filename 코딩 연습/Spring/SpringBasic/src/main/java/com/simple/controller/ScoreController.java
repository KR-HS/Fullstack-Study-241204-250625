package com.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import com.simple.command.ScoreVO;
import com.simple.score.service.ScoreService;
import com.simple.score.service.ScoreServiceImpl;

@Controller
@RequestMapping("/score")
public class ScoreController {

	// 1st
	// private ScoreService scoreService = new ScoreServiceImpl();
	
	// 2nd - ScoreServiceImpl클래스를 빈으로 등록하고, 자바 문서에서 오토와이어드 넣어도됨
	
	@Autowired
	@Qualifier("scoreService")
	private ScoreService scoreService;
	
	@RequestMapping("/scoreList")
	public String scoreList(Model model) {
		
		// select 해서 결과를 model에 담아서 화면으로 가져감
		List<ScoreVO> list = scoreService.getList();
		
		model.addAttribute("list",list);
		
		return "score/scoreList";
	}
	
	@RequestMapping("/scoreRegist")
	public String scoreRegist() {
		
		return "score/scoreRegist";
	}
	
	@RequestMapping("/scoreResult")
	public String scoreResult() {
		
		return "score/scoreResult";
	}
	
	@RequestMapping(value="scoreForm",method=RequestMethod.POST)
	public String scoreForm(ScoreVO vo) {
		
		// 등록..
//		ScoreService scoreService = new ScoreServiceImpl();
		
		
		scoreService.regist(vo);
		
		return "redirect:/score/scoreResult";
	}
	
	@RequestMapping("/scoreDelete")
	public String scoreDelete(@RequestParam("sno") String sno) {
		scoreService.delete(sno);
		
		return "redirect:/score/scoreList";
	}
}
