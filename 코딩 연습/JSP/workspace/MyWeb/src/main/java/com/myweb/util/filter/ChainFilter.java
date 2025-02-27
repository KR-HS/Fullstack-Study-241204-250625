package com.myweb.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


// 1. filter인터페이스를 사속받고 어노테이션으로 실행시킬 경로를 등록

@WebFilter("/*")
public class ChainFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("필터 1번 실행됨");
		
		
		chain.doFilter(request, response); // 다음 필터 or 서블릿으로 이동
		
	}
	
	
}
