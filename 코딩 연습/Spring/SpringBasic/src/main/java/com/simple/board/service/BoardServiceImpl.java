package com.simple.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.board.dao.BoardDAO;
import com.simple.board.dao.BoardMapper;
import com.simple.command.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	
//	@Autowired
//	@Qualifier("boardDAO")
//	private BoardDAO boardDAO;

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public void register(BoardVO vo) {
		System.out.println("등록 service 호출");
		boardMapper.insert(vo);
	}

	@Override
	public List<BoardVO> selectList() {
		System.out.println("select service 호출");
		return boardMapper.selectAll();
	}

	@Override
	public void delete(String bno) {
		System.out.println("삭제 service 호출");
		boardMapper.delete(bno);
	}
}
