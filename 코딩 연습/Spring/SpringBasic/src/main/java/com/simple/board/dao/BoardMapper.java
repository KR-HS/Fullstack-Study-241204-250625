package com.simple.board.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.*;

import com.simple.command.BoardVO;
import com.simple.command.ScoreVO;

@Mapper // 매퍼임을 명시
public interface BoardMapper {

	
	int insert(BoardVO vo);
	int update(ScoreVO vo);
	int delete(String bno);
	
	List<BoardVO> selectAll();
	BoardVO selectOne(String bno);
}
