package jdbc.basic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;


public class JdbcInsert {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);

		
		// 이름, 주소 입력
		System.out.print("이름>>");
		String name = sc.nextLine();
		
		System.out.print("주소>>");
		String address = sc.nextLine();
		
		
		Connection conn = null;  //연결객체
		PreparedStatement pstmt = null;  //sql을 실행하기 위한 객체 
		
		
		//String url = "jdb:oracle:thin:@아이피주소:포트번호:데이터베이스명";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "HR";
		String upw = "HR";
		
		String sql = "INSERT INTO MEMBERS(MNO,NAME,ADDRESS) VALUES(MEMBERS_SEQ.NEXTVAL,?,?)";
		
		// DriverManager.getConnection("DB주소", "유저명", "비밀번호");
		try {
			// 자바 sql패키지는 SQLException예외를 던지고 있어서, try~catch문 안에서 실행
			
			// 1. 드라이버 클래스 준비
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. 커넥션 생성
			//conn = DriverManager.getConnection("DB주소", "유저명", "비밀번호");
			conn = DriverManager.getConnection(url, uid, upw);
			
			// 3. statement객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 4. ? 값을 채움 - ?는 순서대로 1~n번 할당 , setString(),setDouble(),setInt()
			pstmt.setString(1, name);
			pstmt.setString(2, address);
			
			// 5. 실행
			// select구문은 executeQuery()
			// insert,delete,update구문은 executeUpdate()
			
			int result = pstmt.executeUpdate(); // 반환이 정수
			
			
			if(result ==1) { // 1이면 성공
				System.out.println("정상 입력 되었습니다.");
			}else { // 0이면 실패
				System.out.println("입력 실패입니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				
			}catch(Exception e2) {
				
			}
		}
	} 
}
