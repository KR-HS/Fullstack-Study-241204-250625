package com.myweb.users.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UsersService {

	void join(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException;
	void login(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException;
	void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException;
	void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException;
			
	
}
