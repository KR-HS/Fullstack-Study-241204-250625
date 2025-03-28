package com.simple.util.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect  // AOP설정
@Component // 컴포넌트 스캔이 읽어서 빈으로 생성
public class LogAdvice {
	
	
	@Before("execution(* com.simple.score.service.ScoreServiceImpl*.*(..))")
	public void beforeLog() {
		System.out.println("메서드 동작 전에 실행됨");
	}

	@Before("execution(* com.simple.score.service.ScoreServiceImpl*.*(..))")
	public void afterLog() {
		System.out.println("메서드 동작후에 실행됨");
	}
	
	@AfterThrowing(pointcut= "execution(* com.simple.score.service.ScoreServiceImpl*.*(..))", throwing="e")
	public void errorLog(Exception e) {
		System.out.println("에러 발생시 실행:" + e);
	}
}
