<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String idCheck = request.getParameter("idCheck");
	
	
	//id와 pw가 동일하면 로그인 성공
	if(id.equals(pw)) {
		//쿠키 생성!
		Cookie cookie = new Cookie("userId", id);
		cookie.setMaxAge(1800);
		response.addCookie(cookie);
		
		if(idCheck != null) {
			Cookie rememberMe = new Cookie("rememberMe", id);
			rememberMe.setMaxAge(8760000);
			response.addCookie(rememberMe);
		}
		
		
		
		response.sendRedirect("cookie_ex01_welcome.jsp");
	} else {
		response.sendRedirect("cookie_ex01.jsp");
	}

	

%>