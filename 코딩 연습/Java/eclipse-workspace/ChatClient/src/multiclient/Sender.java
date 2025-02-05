package multiclient;
import java.io.*;
import java.net.Socket;
public class Sender extends Thread{

	private Socket socket;
	
	public Sender(Socket socket) {
		this.socket=socket;
	}
	
	@Override
	public void run() {
		
		try {
			// 사용자에게 입력받아서, 서버로 output함
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			//서버로 전송할 output
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			
			while(true) {
				String message =br.readLine();
				
				
				if(message.equals("exit")) {
					break;
				}
				out.println(message);//소켓에 메시지 전송
				out.flush();
			}
			br.close();
			out.close();
			socket.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
