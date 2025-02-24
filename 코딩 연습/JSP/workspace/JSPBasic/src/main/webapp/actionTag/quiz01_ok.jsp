<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	앞에서 넘어온 국어, 수학점수의 평균을 구합니다.
	평균이 60점 이상이면 success페이지로 이동해서
	"name 님의 평균 xx점 합격입니다" 출력합니다.
	
	평균이 60미만이면 fail페이지로 이동해서
	"name 님의 평균 xx점 불합격입니다" 출력합니다 
	
	조건 - 세션을 사용하지 않음
	*/
	request.setCharacterEncoding("utf-8");
	
	String name = request.getParameter("name");
	String kor = request.getParameter("kor");
	String math = request.getParameter("math");
	
	int k = Integer.parseInt(kor);
	int m = Integer.parseInt(math);
	
	double avg = (k + m) / 2.0;
	
	//다음페이지에서 name, avg값이 필요함
	request.setAttribute("name", name);
	request.setAttribute("avg", avg);
	
	if(avg >= 60) {
		request.getRequestDispatcher("quiz01_success.jsp").forward(request, response);
	} else {
		request.getRequestDispatcher("quiz01_fail.jsp").forward(request, response);
	}
	
	
	


%>