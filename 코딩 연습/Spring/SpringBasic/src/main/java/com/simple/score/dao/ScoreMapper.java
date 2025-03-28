package com.simple.score.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.*;
import com.simple.command.ScoreVO;

@Mapper // 매퍼임을 명시
public interface ScoreMapper {

	
	String getTime();
	
	//select, update, delete에도 모두 동일하게 적용됨
	int insertOne(String name); // 매개변수가 한개(#{name})
	int insertTwo(ScoreVO vo); // 매개변수가 DTO일 때(#{getter명})
	int insertThree(Map<String,Object> map); // 매개변수가 map (#{key값})
	int insertFour(@Param("name")String name,
				   @Param("kor")String kor,
				   @Param("eng")String eng); // 매개변수가 여러개면 @Param("이름") 사용
	
	ScoreVO selectOne(int sno);
	HashMap<String, Object> selectTwo(int sno);
	List<ScoreVO> selectThree();
	List<HashMap<String,Object>> selectFour();
	
	//update메서드
	int update(ScoreVO vo);
	
	int delete(String sno);
}
