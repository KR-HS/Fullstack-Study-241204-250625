package com.myweb.board.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.myweb.board.model.BoardDTO;
import com.myweb.board.model.NoticeMapper;
import com.myweb.util.mybatis.MyBatisUtil;

public class BoardServiceImpl implements BoardService{
	
	
	// sqlSessionFactory 객체 생성
	private SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
	
	@Override
	public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String regdate = request.getParameter("regdate");
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println(regdate);
		System.out.println(email);
		System.out.println(title);
		System.out.println(content);
		
		// 마이바티스 영역  = DAO를 대신함
		SqlSession sql = sqlSessionFactory.openSession(true);
		NoticeMapper board = sql.getMapper(NoticeMapper.class);
		
		BoardDTO dto = new BoardDTO(0, email, title, content, regdate);
	
		int result = board.regist(dto);
		sql.close();
		// System.out.println(result);
		response.sendRedirect("list.board");
	}

	@Override
	public void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SqlSession sql = sqlSessionFactory.openSession(true);
		NoticeMapper board = sql.getMapper(NoticeMapper.class);
		List<BoardDTO> list = board.getList();
		sql.close();
		request.setAttribute("list", list);
	}

	@Override
	public void getContent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SqlSession sql = sqlSessionFactory.openSession(true);
		NoticeMapper board = sql.getMapper(NoticeMapper.class);
		String bno = request.getParameter("bno");
		System.out.println(bno);
		
		BoardDTO content = board.getContent(bno);
		sql.close();
		request.setAttribute("content", content);
		
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SqlSession sql = sqlSessionFactory.openSession(true);
		NoticeMapper board = sql.getMapper(NoticeMapper.class);
		Map<String,String> map = new HashMap<>();
		String bno = request.getParameter("bno");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		map.put("bno", bno);
		map.put("title", title);
		map.put("content", content);
		
		int result = board.update(map);
		sql.close();
		if(result ==1) { // 성공
			// 상세내역으로 이동
			response.setContentType("text/html; charset=utf-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정 되었습니다.');");
			out.println("location.href='getContent.board?bno="+bno+"';");
			out.println("</script>");
			
		}else { // 실패
			// 목록화면 이동
			response.sendRedirect("list.board");
		}
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. bno값을 얻음
		 * 2. 삭제는 insert,update와 같음 delete태그를 쓰면됨
		 * 3. 삭제 진행후 목록으로 이동
		 */
		
		SqlSession sql = sqlSessionFactory.openSession(true);
		NoticeMapper board = sql.getMapper(NoticeMapper.class);
		
		
		String bno = request.getParameter("bno");
		
		int result = board.delete(bno);
		sql.close();
		if(result ==1 ) {
			response.setContentType("text/html; charset=utf-8;");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('삭제 성공!');location.href='list.board'; </script>");
			// response.sendRedirect("list.board");
		}else {
			response.setContentType("text/html; charset=utf-8;");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('삭제 실패'); location.href='getContent.board?bno="+bno+"';</script>");
		}
	}

}
