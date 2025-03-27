package com.simple.board.dao;

import java.util.List;

import com.simple.command.BoardVO;

public interface BoardDAO {

	void register(BoardVO vo);

	List<BoardVO> selectList();

	void delete(String idx);

}
