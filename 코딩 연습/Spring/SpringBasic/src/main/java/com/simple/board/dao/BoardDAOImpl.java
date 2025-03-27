package com.simple.board.dao;

import org.springframework.stereotype.Repository;

import java.util.*;
import com.simple.command.BoardVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {

	private List<BoardVO> list= new ArrayList<>();
	
	@Override
	public void register(BoardVO vo) {
		System.out.println("등록 dao 호출");
		list.add(vo);
	}

	@Override
	public List<BoardVO> selectList() {
		System.out.println("select dao 호출");
		return list;
	}

	@Override
	public void delete(String idx) {
		System.out.println("삭제 dao 호출");
		list.remove(Integer.parseInt(idx));
	}

}
