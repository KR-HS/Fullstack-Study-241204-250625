package com.simple.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.command.MemberVO;
import com.simple.command.ScoreVO;
import com.simple.score.dao.ScoreMapper;
import java.util.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml")
public class MybatisTest {
	
	@Autowired
	private ScoreMapper scoreMapper;
	
//	@Test
//	public void test01() {
//		String time = scoreMapper.getTime();
//		
//		System.out.println(time);
//	}
	
	//INSERT
//	@Test
//	public void test02() {
//		int result = scoreMapper.insertOne("홍길동");
//		
//		System.out.println("성공실패:"+result);
//	}
	
//	@Test
//	public void test03() {
//		ScoreVO vo = new ScoreVO(0,"이순신","10","20","30");
//		int result = scoreMapper.insertTwo(vo);
//		
//		System.out.println("성공실패:"+result);
//	}
	
//	@Test
//	public void test04() {
//		Map<String, Object> map = new HashMap<>();
//		
//		map.put("name","홍길동");
//		map.put("kor","100");
//		map.put("eng","100");
//		map.put("math","100");
//		int result = scoreMapper.insertThree(map);
//		
//		System.out.println("성공실패:"+result);
//	}
	
//	@Test
//	public void test05() {
//		int result = scoreMapper.insertFour("강감찬", "100", "99");
//		
//		System.out.println(result);
//	}
	
//	@Test
//	public void test06(){
////		ScoreVO vo = scoreMapper.selectOne(3);
//		
////		Map<String,Object> map = scoreMapper.selectTwo(3);
////		List<ScoreVO> list = scoreMapper.selectThree();
//		List<HashMap<String,Object>> list = scoreMapper.selectFour();
//		System.out.println(list.toString());
//	}
	
	@Test
	public void test07() {
		//vo를 통해서 업데이트 할 값을 전달 받고, 1번의 점수를 update하는 sql문을 작성
		// 업데이트 여부는 정수형으로 받아오는 mybatis구문을 작성
		ScoreVO vo = new ScoreVO(1,"name1","95","96","97");
		int result = scoreMapper.update(vo);
		System.out.println("result:"+result);
	}
}
