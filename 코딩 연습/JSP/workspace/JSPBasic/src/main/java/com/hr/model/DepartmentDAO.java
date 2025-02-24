package com.hr.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DepartmentDAO {
	/*
	 * DAO는 클래스는 여러개 만들필요 없이, 객체가 한개만 생성되도록
	 * singleton클래스로 생성
	 */
	//1. 나자신의 객체를 1개 생성한다.
	private static DepartmentDAO instance = new DepartmentDAO();
	//2. 외부에서 생성자를 호출할수 없도록 private막는다
	private DepartmentDAO() {
		
		try {
			InitialContext context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//3. 외부에서 객체를 요구할 때, instance를 반환합니다.
	public static DepartmentDAO getInstance() {
		return instance;
	}
	
	//커넥션풀을 사용할 dataSource클래스
	private DataSource dataSource;
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "HR";
	private String upw = "HR";
	
	//메서드로 Database에 접근해서 값을 처리.
	//부서아이디를 받아서, 부서정보를 반환하는 메서드
	public DepartmentDTO getDepartmentInfo(String departmentId) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
		
		//반환할 DTO생성
		DepartmentDTO dto = new DepartmentDTO();
		
		try {
			//1.드라이버 클래스 로드
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.conn
			//conn = DriverManager.getConnection(url, uid, upw);
			conn = dataSource.getConnection();
			
			//3.pstmt
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, departmentId);
			//3.실행
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				//1행에 대한 처리
				String departmentName = rs.getString("department_name");
				int managerId = rs.getInt("manager_id");
				int locationId = rs.getInt("location_id");
				
				dto.setDepartmentId( Integer.parseInt(departmentId)  );
				dto.setDepartmentName(departmentName);
				dto.setManagerId(managerId);
				dto.setLocationId(locationId);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
			}
		}
		
		return dto;
	}
	
	
	
	
	
	
	
	
}
