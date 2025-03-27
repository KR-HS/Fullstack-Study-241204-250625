package com.simple.score.dao;

import java.util.List;

import com.simple.command.ScoreVO;

public interface ScoreDAO {
	void regist(ScoreVO vo); // insert
	List<ScoreVO> getList(); // select
	void delete(int sno);
}
