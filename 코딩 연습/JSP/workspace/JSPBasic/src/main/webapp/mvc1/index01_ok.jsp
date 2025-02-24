<%@page import="com.hr.model.DepartmentDTO"%>
<%@page import="com.hr.model.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//vc역할을 하고있음

	String departmentId = request.getParameter("departmentId");
	//model로 연결
	
	//DAO객체 생성
	DepartmentDAO dao = DepartmentDAO.getInstance();
	//부서정보
	DepartmentDTO dto = dao.getDepartmentInfo(departmentId);	
	
	//dto를 request에 저장함
	request.setAttribute("dto", dto);
	
	//dto에 값이 있으면, 부서정보페이지로 이동, 없으면 다시 원본페이지로 이동
	if(dto.getDepartmentName() == null) {
%>
	<script>
		alert("부서정보가 없습니다");
		history.back(); //뒤로가기
	</script>
<%		
	} else {
		request.getRequestDispatcher("index01_result.jsp").forward(request, response);	
	}
	
%>