package com.myweb.util.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.users.model.UsersDTO;


@WebFilter({
	"/notice/modify.board",
	"/notice/update.board",
	"/notice/delete.board"
})
public class BoardAuthenticationFilter implements Filter{
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		/*
		 * 필터 - 게시글수정, 삭제에 대한 필터(내가 작성한 글만 수정, 삭제가 가능함)
		 * 현재 세션에 값 = 작성자 동일한 경우 (삭제 수정) 이 가능
		 * 
		 * 1. 글쓰기작성자를 고정값으로(세션값)
		 * 2. 수정 삭제 요청이 들어올때는, 작성자에 대한 정보를 반드시 넘기고 == 현재 세션과 비교
		 */
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		request.setCharacterEncoding("utf-8");
		HttpSession session= request.getSession();
		
		if(session.getAttribute("userDTO")==null) {
			response.sendRedirect(request.getContextPath()+"/users/login.users");
			return;
		}
		
		UsersDTO dto = (UsersDTO)session.getAttribute("userDTO");
		String email = dto.getEmail(); // 현재 로그인된 사람의 이메일
		
		String writer = request.getParameter("email");
		
		System.out.println("세션값:"+email);
		System.out.println("작성자값: "+writer);
		
		// 작성자가 없거나, 작성자와 세션값이 일치하지 않는 경우에 목록으로 이동
		if(writer==null || !writer.equals(email)) {
			
			String path = request.getContextPath() + "/notice/list.board";
			
			response.setContentType("text/html; charset=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('권한이 없습니다.');");
			out.println("location.href='"+ path +"';");
			out.println("</script>");
			
			return;
		}
		chain.doFilter(request, response);
	}
}
