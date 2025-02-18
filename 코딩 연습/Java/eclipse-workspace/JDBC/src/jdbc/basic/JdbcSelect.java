package jdbc.basic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class JdbcSelect {
	public static void main(String args[]) {
		
		// 모든 회원 정보를 번호순으로 내림차순 해서 조회
		
		Connection conn = null; // 연결객체
		PreparedStatement pstmt = null; // sql을 실행하기 위한 객체 
		ResultSet rs = null; // sql을 실행한 결과를 반환 받을 객체
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "HR";
		String upw = "HR";
		
		
		String sql = "SELECT * FROM MEMBERS ORDER BY MNO DESC";
		
		try {
			
			// 1. 드라이버 클래스
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. 커넥션 객체 생성
			conn = DriverManager.getConnection(url,uid,upw);
			
			// 3. preparedstatement객체
			pstmt = conn.prepareStatement(sql);
			
			// 4. 실행
			rs = pstmt.executeQuery();
			
			
			// select문의 결과값에 다음행이 있다면 true반환
			while(rs.next()) {
				/*
				 * select의 실행 결과를 하나씩 읽어서 처리할 프로그램 코드 작성
				 * getString()
				 * getInt()
				 * getDouble()
				 * getDate,getTimestamp()
				 */
				int mno = rs.getInt("mno"); // 컬럼명
				String name = rs.getString("name");
				String address = rs.getString("address");
				Date regdate = rs.getTimestamp("regdate");
				
				
				System.out.println(mno+", "+name+", "+address+", "+regdate);
				
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
				
			}catch(Exception e2) {
		}
		
		}
	}
}