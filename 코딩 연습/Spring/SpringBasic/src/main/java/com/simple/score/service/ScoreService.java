package com.simple.score.service;

import java.util.*;
import com.simple.command.ScoreVO;

public interface ScoreService {
	void regist(ScoreVO vo); // insert용도
	List<ScoreVO> getList(); // select용도
	void delete(String sno);
	
}
