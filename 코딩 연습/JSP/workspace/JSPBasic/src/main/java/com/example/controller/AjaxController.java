package com.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AjaxController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring( contextPath.length() );
		
		if(command.equals("/ajax/test.ajax")) {
			//get방식 ajax요청하는 방법
			System.out.println(request.getParameter("name") );
			System.out.println(request.getParameter("age") );
			//데이터베이스 처리.........
			
			//요청이 들어온 곳으로 응답이 날아감
//			response.setContentType("text/plain; charset=UTF-8;"); //응답보내는 데이터에 대한 타입(mine type)
//			response.getWriter().write("왜 불렀어?");
			
			response.setContentType("application/json; charset=UTF-8;");
			response.getWriter().write("{\"key\":\"왜불럿어?\"}"); //JSON유형으로 데이터를 만듬 or 외부lib (Gson등등)
			
		}
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring( contextPath.length() );
		
		if(command.equals("/ajax/example.ajax")) {
			
			System.out.println(request.getParameter("id"));
			System.out.println(request.getParameter("name"));
			

			response.setContentType("application/json; charset=UTF-8;");
			response.getWriter().write("{\"key\":\"post방식에서응답\"}"); //JSON유형으로 데이터를 만듬 or 외부lib (Gson등등)
			
		}
		
		
	}

	
	
	
	
}
