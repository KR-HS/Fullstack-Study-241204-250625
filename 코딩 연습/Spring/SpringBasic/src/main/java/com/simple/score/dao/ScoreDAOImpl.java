package com.simple.score.dao;

import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;

@Repository("scoreDAO") // 컴포넌트스캔에 읽힘
public class ScoreDAOImpl implements ScoreDAO {

	@Autowired
	private DataSource ds;
	
	// 디비라고 가정
	private List<ScoreVO> list = new ArrayList<>();
	
	
	@Override
	public void regist(ScoreVO vo) {
		list.add(vo); // insert라고 가정
		System.out.println(vo.toString());
	}


	@Override
	public List<ScoreVO> getList() {
		return list;
	}


	@Override
	public void delete(int sno) {
		list.remove(sno);
	}

}
