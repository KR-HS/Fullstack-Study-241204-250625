<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션삭제
	session.invalidate();
	//다시로그인페이지로
	response.sendRedirect("login.jsp");
%>