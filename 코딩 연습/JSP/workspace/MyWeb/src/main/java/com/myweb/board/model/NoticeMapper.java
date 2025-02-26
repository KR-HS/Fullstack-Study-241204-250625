package com.myweb.board.model;

import java.util.ArrayList;

public interface NoticeMapper {
	
	// 메서드 선언 - 메서드명 xml구현체가 동일한 이름으로 사용
	String getTime();
	// 마이바티스의 매개변수는 기본이 1개(DTO, MAP 타입)을 사용
	int regist(BoardDTO dto);
	ArrayList<BoardDTO> getList();
	BoardDTO getContent(String bno);
}
