package com.simple.ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
//		Chef chef = new Chef();
//		Hotel hotel = new Hotel(chef);
		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("application-context.xml");
		
		//1st
		//Hotel hotel = (Hotel)ctx.getBean("hotel");
		
		//2nd
		//Hotel hotel = ctx.getBean( Hotel.class );
		
		Hotel hotel = ctx.getBean("hotel", Hotel.class); //이름, 타입
		hotel.getChef().cooking(); 
		
		
		
		
		
	}
}
