package com.myweb.users.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.users.model.UsersDAO;
import com.myweb.users.model.UsersDTO;
import com.myweb.util.JdbcUtil;

public class UsersServiceImpl implements UsersService{

	@Override
	public void join(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		String emailPrev = request.getParameter("email_prev");
		String emailNext = request.getParameter("email_next");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String snsYn  = request.getParameter("sns_yn");
		if(snsYn==null) snsYn="N";
		String email = emailPrev + "@"+emailNext;
		
		//System.out.println(emailPrev);
		//System.out.println(emailNext);
		//System.out.println(name);
		//System.out.println(pw);
		//System.out.println(phone);
		//System.out.println(gender);
		//System.out.println(snsYn);
		
		UsersDAO dao = UsersDAO.getInstance();
		
		int result = dao.idDuplicationCheck(email);
		
		if(result==1) {
			// msg를 화면에 보냄
			request.setAttribute("msg","이미 존재하는 아이디입니다.");
			request.getRequestDispatcher("join.jsp").forward(request, response);
			
		}else {
			UsersDTO dto = new UsersDTO(email,name,pw,phone,gender,snsYn,null);
			dao.join(dto);
			
			//mvc2방식에서는 리다이렉트는 다시 컨트롤러를 태워서 이동할 때 사용
			response.sendRedirect("login.users");
		}
	}

	@Override
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		UsersDAO dao = UsersDAO.getInstance();
		UsersDTO dto = dao.login(id, pw);
		
		if(dto==null) { // 로그인 실패
			request.setAttribute("msg","로그인 실패");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else { // 로그인 성공
			// 현재 브라우저의 세션은 request에서 얻을 수 있음
			HttpSession session = request.getSession();
			session.setAttribute("userDTO",dto);
			
			response.sendRedirect("../index.jsp");
		}
		
	}

	@Override
	public void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * update 테이블명 set 업데이트할값 where pk=?
		 * 
		 *  1. 화면에서 넘어온 값을 받음(이름, 성별, 휴대폰, 수신여부
		 *  2. email값은 세션에서 얻음
		 *  3. DAO는 modify() 메서드를 생성하고 업데이트진행
		 *  4. DAO 성공시 1을 반환하고, 실패시 0을 반환
		 *  5. 서비스에서는 정보수정성공시에 메인페이지로 이동, 실패시 마이페이지로 이동
		 */
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String snsYn = request.getParameter("snsYn");
		HttpSession session = request.getSession();
		UsersDTO dto = ((UsersDTO)session.getAttribute("userDTO"));
		String email = dto.getEmail();
		
		
		
		UsersDAO dao = UsersDAO.getInstance();
		int result = dao.modify(name,gender,phone,snsYn,email);
		
		if(result==1) {
			dto = new UsersDTO(email,name,null,phone,gender,snsYn,null);
			// dto = dao.getInfo(email);
			
			session.setAttribute("userDTO", dto);
			
			// 화면에 메시지를 보내는 또다른 방법(out객체 사용)
			response.setContentType("text/html; charset=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('정보 수정완료');");
			out.println("location.href='/MyWeb/index.jsp';");
			out.println("</script>");
			//response.sendRedirect("../index.jsp");
		}else {
			request.setAttribute("msg", "정보수정 실패");
			request.getRequestDispatcher("mypage.jsp").forward(request, response);
		}
		
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. delete from 테이블명 where 키=?
		 * 2. 이메일은 세션이 있음
		 * 3. 이메일을 얻어서 dao에서 삭제를 진행
		 * 4. 삭제 성공시 세션을 삭제하고 메인페이지, 실패시 마이페이지 이동
		 */
		UsersDAO dao = UsersDAO.getInstance();
		HttpSession session = request.getSession();
		String email = ((UsersDTO)session.getAttribute("userDTO")).getEmail();
		int result = dao.delete(email);
		if(result==1) {
			session.removeAttribute("userDTO");
			response.setContentType("text/html; charset=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제성공')");
			out.println("location.href='/MyWeb/index.jsp';");
			out.println("</script>");
		}else {
			response.sendRedirect("/users/mypage.users");
		}
		
	}

	
}
