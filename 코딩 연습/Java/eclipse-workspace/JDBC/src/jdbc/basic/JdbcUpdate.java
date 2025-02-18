package jdbc.basic;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcUpdate {
	public static void main(String[] args) {
		
		/*
		 * 업데이트도 insert와 동일하게 처리
		 * 
		 * 회원번호,이름,주소를 입력받아서 해당 회원의 이름과 주소를 변경
		 * 만약에 회원번호가 없으면 "회원번호가 업습니다." 출력
		 */
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "HR";
		String upw = "HR";
		
		String s_sql = "SELECT * FROM MEMBERS WHERE MNO=?";
		String sql = "UPDATE MEMBERS NAME=?,ADDRESS=? WHERE MNO=?";
		
		System.out.print("회원번호>>");
		int mno =Integer.parseInt(sc.nextLine());
		// 회원번호 있는지 확인
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,uid,upw);
			
			pstmt=conn.prepareStatement(s_sql);
			pstmt.setInt(1, mno);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {

				
				System.out.print("회원이름>>");
				String name = sc.nextLine();
				
				System.out.print("회원주소>>");
				String address = sc.nextLine();
				
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, name);
				pstmt.setString(2, address);
				pstmt.setInt(3, mno);
				
				if(pstmt.executeUpdate()==1) {
					System.out.println("정보 업데이트 완료");
				}else {
					System.out.println("업데이트 실패");
				}
				
				
			}else {
				System.out.println("회원번호가 없습니다");
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
