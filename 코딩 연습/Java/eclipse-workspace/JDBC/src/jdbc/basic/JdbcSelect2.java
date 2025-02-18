package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class JdbcSelect2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 회원의 mno를 입력받아서, 해당 mno에 회원정보만 출력하는 jdbc프로그램을 작성
		 * mno가 없으면, "mno는 없습니다"로 출력
		 */
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "HR";
		String upw = "HR";
		
		String sql = "SELECT * FROM MEMBERS WHERE mno=?";
		
		System.out.print("사용자 아이디 입력>>");
		int id = Integer.parseInt(sc.nextLine());
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url,uid,upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			
			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				int mno = rs.getInt("mno");
				String name = rs.getString("name");
				String address = rs.getString("address");
				Date regdate = rs.getTimestamp("regdate");
				
				System.out.println(mno+", "+name+", "+address+", "+regdate);
			}else System.out.println("회원번호는 없습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}
		}
		
	}
}
