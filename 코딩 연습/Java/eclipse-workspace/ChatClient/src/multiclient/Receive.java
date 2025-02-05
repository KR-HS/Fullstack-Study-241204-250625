package multiclient;

import java.io.*;
import java.net.Socket;

public class Receive extends Thread{
	private Socket socket;

	public Receive(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			
			while(true) {
				String message = br.readLine();
				
				System.out.println(message);
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

