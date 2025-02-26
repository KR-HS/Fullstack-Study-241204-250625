package com.myweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.users.service.UsersService;
import com.myweb.users.service.UsersServiceImpl;

@WebServlet("*.users")
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsersController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());

		System.out.println("요청경로 : "+command);
		
		
		// 사용할 서비스 선언
		UsersService service = new UsersServiceImpl();
		
		//MVC2의 기본 이동방식은 forward 방식
		if(command.equals("/users/join.users")) {
			
			//mvc2 방식에서 이동
			request.getRequestDispatcher("join.jsp").forward(request, response);
		
		}else if(command.equals("/users/joinForm.users")) {
			service.join(request, response);
			
		}else if(command.equals("/users/login.users")) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if(command.equals("/users/loginForm.users")) {
			// 로그인 처리
			service.login(request, response);
		}
		else if(command.equals("/users/mypage.users")) { // 마이페이지
			request.getRequestDispatcher("mypage.jsp").forward(request, response);
		}
		else if(command.equals("/users/modifyform.users")) { // 정보수정
			service.modify(request,response);
		}
		else if(command.equals("/users/delete.users")) { // 회원탈퇴
			service.delete(request,response);
		}
		
	}

}
