package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ResultVO;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	@RequestMapping("/quiz01")
	public String quiz01() {
		
		return "quiz/quiz01";
	}
	
	@RequestMapping("/join")
	public ModelAndView join(@ModelAttribute("id")String id,@ModelAttribute("pw")String pw
			,@ModelAttribute("name")String name,@ModelAttribute("email")String email) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",id);
		mv.addObject("pw",pw);
		mv.addObject("name",name);
		mv.addObject("email",email);
		mv.setViewName("quiz/quiz01_ok");
		return mv;
	}
	
	@RequestMapping("/quiz02")
	public String quiz02() {
		
		return "quiz/quiz02";
	}
	
	@RequestMapping("/result")
	public String result() {
		return "quiz/result";
	}
	
	@RequestMapping("/resultForm")
	public String resultForm(ResultVO vo, RedirectAttributes ra) {
		String msg=vo.getYear()+"년-"+vo.getMonth()+"월-"+vo.getDay()+"일 "+vo.getMsg();
		ra.addFlashAttribute("msg",msg);
		return "redirect:/quiz/result";
	}
	

}
