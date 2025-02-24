<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	String bno = request.getParameter("bno");

	//bno기반으로 데이터베이스에서 값을 조회한다.
	//..생략..

	
	//조회한 결과를 ex03_result에 출력.
	request.setAttribute("address", "서울시");
	request.setAttribute("name", "홍길동");
	
	//자바코드로 포워드 이동
	RequestDispatcher dp = request.getRequestDispatcher("forward_ex03_result.jsp");
	dp.forward(request, response);
	
	

%>