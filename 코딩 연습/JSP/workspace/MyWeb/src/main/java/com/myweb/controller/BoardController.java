package com.myweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.board.service.BoardService;
import com.myweb.board.service.BoardServiceImpl;
import com.myweb.users.service.UsersService;
import com.myweb.users.service.UsersServiceImpl;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());

		System.out.println("요청경로 : "+command);


		// 사용할 서비스 선언
		BoardService service = new BoardServiceImpl();
		
		if(command.equals("/notice/regist.board")) { // 글 작성화면
			
			// 시나리오 - 글 등록을 하려면 회원인 사람만 할 수 있음
			//HttpSession session = request.getSession();
			//if(session.getAttribute("dao")==null) {
			//	response.sendRedirect("login.users");
			//	return;
			//}
			
			request.getRequestDispatcher("notice_write.jsp").forward(request, response);
		}
		else if(command.equals("/notice/registForm.board")) { // 글 등록
			service.regist(request, response);
		}
		else if(command.equals("/notice/list.board")) { // 글 목록
			service.getList(request,response);
			request.getRequestDispatcher("notice_list.jsp").forward(request, response);
		}
		else if(command.equals("/notice/getContent.board")) { //글 상세
			service.getContent(request,response);
			request.getRequestDispatcher("notice_view.jsp").forward(request, response);
		}
		else if(command.equals("/notice/modify.board")) { // 글 수정 화면
			service.getContent(request,response);
			request.getRequestDispatcher("notice_modify.jsp").forward(request, response);
		}
		else if(command.equals("/notice/update.board")) { //글 수정
			service.update(request,response);
		}
		else if(command.equals("/notice/delete.board")) { // 글 삭제 요청
			service.delete(request,response);
		}
	}
}
