package com.simple.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.board.dao.BoardDAO;
import com.simple.command.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	
	@Autowired
	@Qualifier("boardDAO")
	private BoardDAO boardDAO;

	@Override
	public void register(BoardVO vo) {
		System.out.println("등록 service 호출");
		boardDAO.register(vo);
	}

	@Override
	public List<BoardVO> selectList() {
		System.out.println("select service 호출");
		return boardDAO.selectList();
	}

	@Override
	public void delete(String idx) {
		System.out.println("삭제 service 호출");
		boardDAO.delete(idx);
	}
}
