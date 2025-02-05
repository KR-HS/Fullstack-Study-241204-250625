package multiserver;

import java.util.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
	
	// <소켓>
	public static ArrayList<PrintWriter> list = new ArrayList<>();
	
	
	public static void main(String args[]) {
		//서버
		try {
			ServerSocket serverSocket = new ServerSocket(8181);
			
			while(true) {
				System.out.println("****연결 대기중****");
				Socket clientSocket = serverSocket.accept();
				System.out.println("****연결 성공****");
				
				// 다중 클라이언트 연결을 위해서 연결들어오는 socket객체를 리스트로 관리
				PrintWriter pt = new PrintWriter(clientSocket.getOutputStream());
				list.add(pt);
				
				ClientManager manager = new ClientManager(clientSocket,pt); // 소켓, 프린트라이터객체
				manager.start();
				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
