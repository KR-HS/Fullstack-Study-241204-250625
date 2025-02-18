package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class JdbcSelect3 {
	public static void main(String[] args) {
		
		/*
		 * 테이블은 employees, departments
		 * 
		 * 회원번호를 입력받아서, 이 회원의 이름, 부서아이디, 부서명, 급여를 출력하는 join문장 작성
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "HR";
		String upw = "HR";
		
		String sql = "SELECT CONCAT(FIRST_NAME,CONCAT(' ',LAST_NAME)) 이름, D.DEPARTMENT_ID 부서아이디, DEPARTMENT_NAME 부서명,SALARY 급여"+
		" FROM EMPLOYEES E"+
		" LEFT JOIN DEPARTMENTS D"+
		" ON E.DEPARTMENT_ID = D.DEPARTMENT_ID WHERE EMPLOYEE_ID=?";
		
		
		System.out.print("회원 조회>>");
		int userId  = Integer.parseInt(sc.nextLine());
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn =DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,userId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("이름");
				int dep_id = rs.getInt("부서아이디");
				String dep_name = rs.getString("부서명");
				int salary = rs.getInt("급여");
				
				System.out.println("이름:"+name+", 부서아이디:"+dep_id+", 부서명:"+dep_name+", 급여:"+salary);
			}else {
				System.out.println("해당회원은 존재하지 않습니다.");
			}
			
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
