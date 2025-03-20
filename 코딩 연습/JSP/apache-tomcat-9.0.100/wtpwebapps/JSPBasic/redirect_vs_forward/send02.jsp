<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//리퀘스트에 값을 강제로 저장하는 방법
	request.setAttribute("date", new Date());

	
	response.sendRedirect("send03.jsp");

%>