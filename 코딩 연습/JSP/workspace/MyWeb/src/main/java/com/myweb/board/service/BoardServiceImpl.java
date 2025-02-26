package com.myweb.board.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		// System.out.println(result);
		response.sendRedirect("list.board");
	}

	@Override
	public void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SqlSession sql = sqlSessionFactory.openSession(true);
		NoticeMapper board = sql.getMapper(NoticeMapper.class);
		
		List<BoardDTO> list = board.getList();
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
		request.setAttribute("content", content);
		
	}

}
