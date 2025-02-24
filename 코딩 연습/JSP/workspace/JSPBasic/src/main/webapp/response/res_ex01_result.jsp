<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//데이터를 받는 페이지, 자바코드만 필요함 == servlet으로 변경가능

	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String age = request.getParameter("age");

	int a = Integer.parseInt(age);
	
	if(a >= 20) {
		//주류구매 페이지로 이동
		response.sendRedirect("res_ex01_success.jsp");
	} else {
		//실패페이지로 이동
		response.sendRedirect("res_ex01_fail.jsp");
	}
	
%>    
