package multiserver;

import java.util.*;
import java.io.*;
import java.net.*;
public class ClientManager extends Thread{
	private Socket socket;
	private PrintWriter out;
	
	public ClientManager(Socket socket,PrintWriter out) {
		this.socket= socket;
		this.out=out;
	}
	
	@Override
	public void run() {
		
		try {
			//데이터 받기 연습
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			while(true) {
				String message=br.readLine();
				System.out.println(message);
				
				if(message==null) {
					InetAddress address =socket.getInetAddress();
					System.out.println(address.getHostName()+"님이 퇴장을 했습니다.");
					break;
				}
				// 메시지 보내기 - 서버에 연결된 모든 사람한테 메세지를 보냄
				for(int i=0;i<MainServer.list.size();i++) {
					PrintWriter out = MainServer.list.get(i);
					out.println(message); // 상대방에게 메세지 전달
					out.flush();
					
				}
					
			}
			// 종료되는 시점에 list에 해당 PrintWriter 제거
			MainServer.list.remove(out);
			
			System.out.println("인원:"+MainServer.list.size());
			br.close();
			out.close();
			socket.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
