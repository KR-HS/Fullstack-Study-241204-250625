package com.simple.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.MemberVO;

import org.springframework.web.bind.annotation.Mapping;

@Controller
@RequestMapping("/request") // 모든 메서드 요청 경로 앞에 /request가 붙음
public class RequestController {

	// ex01화면 요청
//	@RequestMapping("/ex01")
//	public String ex01() {
//		
//		return "request/ex01";
//	}

	// void형으로 화면 연결 - 요청경로가 나가는 경로
	@RequestMapping("/ex01")
	public void ex01() {

	}

	// basic01
	@RequestMapping(value = "/basic01", method = RequestMethod.GET) // get요청만 허용
	// @RequestMapping(value="/basic01",method=RequestMethod.POST) // post요청만 허용
	// @RequestMapping("/basic01") // 둘다 허용
	// @Mapping("/basic01") // get요청만 허용
	// @PostMapping("/basic01") // post요청만 허용
	public void basic() {

		System.out.println("basic01요청");
	}

	// 완전히 동일한 기능이 있으면, 요청을 {} 하나로 묶어서 사용할 수 있음
	@RequestMapping({ "/basic02", "/basic03" })
	public void basic02() {
		System.out.println("basic02~03 요청 실행됨");
	}

	// ex02화면 요청
	@RequestMapping("/ex02")
	public String ex02() {
		return "request/ex02";
	}

	// 1st
//	@RequestMapping(value="/param",method=RequestMethod.POST)
//	public String param(HttpServletRequest request) {
//		
//		String id = request.getParameter("id"); // 단일값
//		String[] inter = request.getParameterValues("inter");
//		
//		System.out.println(id);
//		System.out.println(Arrays.toString(inter));
//		
//		return "request/ex02_success";
//	}

	// 2nd - @ReuqestParam어노테이션으로 단일값 받기
	// @RequestParam은 클라이언트에서 반드시 파라미터값을 넘겨야 함. 그렇지 않으면 거절당함
	// required옵션이 필수 여부 지정
	// defaultValue가 파라미터가 없을 때 기본값 정의
//	@RequestMapping(value="/param",method=RequestMethod.POST)
//	public String param(@RequestParam("id") String id,@RequestParam("pw") String pw, @RequestParam(value= "name",required=true) String name,@RequestParam(value="inter",required=false,defaultValue="")List<String> inter) {
//		System.out.println(id);
//		System.out.println(inter);
//		
//		return "request/ex02_success";
//	}

	// 3nd - 폼의 name값이 vo의 setter와 일치해야 함 멤버변수)
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String param(MemberVO vo) {
		System.out.println(vo.toString());

		return "request/ex02_success";
	}

	@RequestMapping("/quiz01")
	public String quiz01() {
		return "/request/req_quiz01";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "id", required = false, defaultValue = "") String id,
			@RequestParam(value = "pw", required = false, defaultValue = "") String pw) {
		if (id.equals("abc123") && pw.equals("xxx123"))
			return "request/req_quiz01_ok";

		return "request/req_quiz01_no";

	}

}
