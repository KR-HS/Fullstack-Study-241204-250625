package com.simple.controller;


import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.MemberVO;


@Controller
@RequestMapping("/response")
public class ResponseController {

	//ex01화면
	@RequestMapping("/ex01")
	public String ex01() {
		return "response/ex01";
	}
	
	//ex01_ok화면
	
	// Model객체 - request.setAttribute와 유사
//	@RequestMapping("/ex01_ok")
//	public String ex01_ok(Model model) {
//		
//		model.addAttribute("name","홍길동");
//		model.addAttribute("serverTime",new Date());
//		return "response/ex01_ok";
//	}
	
	//ModelAndView객체
//	@RequestMapping("/ex01_result")
//	public ModelAndView ex01_ok() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("name","홍길동");
//		mv.addObject("serverTime",new Date());
//		mv.setViewName("response/ex01_ok"); // 뷰에 대한 정보
//		return mv;
//	}
	
	//ModelAttribute
	// 화면에서 id를 받고, id라는 이름으로 데이터를 넘김
//	@RequestMapping("ex01_result")
//	public String ex01_result(@ModelAttribute("nick") String nick) {
//		
//		System.out.println(nick);
//		return "response/ex01_result";
//	}

	// 화면에서 vo에 맵핑되는 값을 받고, myData라는 이름으로 데이터를 넘김
	@RequestMapping("/ex01_result")
	public String ex01_result(@ModelAttribute("myData") MemberVO vo ) {
		
		System.out.println(vo.toString());
		return "response/ex01_result";
	}
	
	/////////////////////////////////////////////////////////////////////
	// 스프링에서 redirect -> 다시 컨트롤러를 태울떄 사용
	
	//화면처리
	@RequestMapping("/redirect_join")
	public String redirect_join() {
		return "response/redirect_join";
	}
	
	@RequestMapping("/joinForm")
	public String joinForm(MemberVO vo,RedirectAttributes ra) {
		
		// 가입에 대한 처리
		
		// 리다이렉트시에는 Model을 사용할 수 없음
		// 리다이렉트시 1회성 데이터를 보낼 수 있음
		ra.addFlashAttribute("msg","회원가입을 축하합니다.");
		// 홈 화면으로
		return "redirect:/"; //다시 컨트롤러를 태움
	}
}
