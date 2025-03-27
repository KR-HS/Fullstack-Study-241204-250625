package com.simple.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.score.dao.ScoreDAO;

@Service("scoreService") // @Service어노테이션을 붙이고, 패키지를 읽어서 빈으로 만드는 전략
public class ScoreServiceImpl implements ScoreService{

	@Autowired
	@Qualifier("scoreDAO")
	private ScoreDAO scoreDAO;
	
	@Override()
	public void regist(ScoreVO vo) {
		scoreDAO.regist(vo);
	}

	@Override
	public List<ScoreVO> getList() {
//		List<ScoreVO> list = scoreDAO.getList();
//		return list;
		return scoreDAO.getList();
	}

	@Override
	public void delete(String sno) {
		scoreDAO.delete(Integer.parseInt(sno));
	}

}
