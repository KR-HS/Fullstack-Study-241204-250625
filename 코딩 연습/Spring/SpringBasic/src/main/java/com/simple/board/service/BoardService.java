package com.simple.board.service;

import com.simple.command.BoardVO;
import java.util.*;

public interface BoardService {

	
	void register(BoardVO vo);
	List<BoardVO> selectList();
	void delete(String idx);
	
}
