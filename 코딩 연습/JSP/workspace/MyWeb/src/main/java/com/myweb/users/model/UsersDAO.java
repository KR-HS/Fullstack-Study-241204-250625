package com.myweb.users.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.myweb.util.JdbcUtil;


public class UsersDAO {
	/*
	 * DAO는 클래스는 여러개 만들필요 없이, 객체가 한개만 생성되도록
	 * singleton클래스로 생성
	 */
	//1. 나자신의 객체를 1개 생성한다.
	private static UsersDAO instance = new UsersDAO();
	//2. 외부에서 생성자를 호출할수 없도록 private막는다
	private UsersDAO() {
		
		try {
			InitialContext context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//3. 외부에서 객체를 요구할 때, instance를 반환합니다.
	public static UsersDAO getInstance() {
		return instance;
	}
	
	//커넥션풀을 사용할 dataSource클래스
	private DataSource dataSource;
	
	
	// 아이디 중복체크 메서드
	public int idDuplicationCheck(String email) {
		
		int result=0;
		
		String sql = "SELECT * FROM USERS WHERE EMAIL=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		try {			
			conn=dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) result=1; // 1 = 중복
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return result;
	}
		
	// 회원가입 메서드
	public void join(UsersDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO USERS(EMAIL,NAME,PW,PHONE,GENDER,SNS_YN) VALUES(?,?,?,?,?,?)";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getEmail() );
			pstmt.setString(2,dto.getName() );
			pstmt.setString(3, dto.getPw());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5,dto.getGender() );
			pstmt.setString(6, dto.getSnsYn());
			
			pstmt.executeUpdate(); // insert, update, delete
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 여기 들어가는 코드는 똑같음
			JdbcUtil.close(conn, pstmt, null);
		}
	}
	
	
	// 로그인 메서드
	public UsersDTO login(String email, String pw) {
		UsersDTO dto =null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM USERS WHERE EMAIL=? AND PW=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String gender = rs.getString("gender");
				String snsYn = rs.getString("sns_yn");
				Timestamp regDate = rs.getTimestamp("regdate");
				
				dto=new UsersDTO(email,name,null,phone,gender,snsYn,regDate);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return dto;
	}
	
	// 정보 수정 메서드
	public int modify(String name,String gender, String phone, String snsYn,String email) {
		int result =0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE USERS SET NAME=?,GENDER=?,PHONE=?,SNS_YN=? WHERE EMAIL=?";
		
		try {
			conn = dataSource.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, gender);
			pstmt.setString(3, phone);
			pstmt.setString(4, snsYn);
			pstmt.setString(5, email);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
		
		return result;
	}
	
	// id에 해당하는 값 가져오기
	public UsersDTO getInfo(String email) {
		UsersDTO dto =null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM USERS WHERE EMAIL=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String gender = rs.getString("gender");
				String snsYn = rs.getString("sns_yn");
				Timestamp regDate = rs.getTimestamp("regdate");
				
				dto=new UsersDTO(email,name,null,phone,gender,snsYn,regDate);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return dto;
	}
	
	// 회원탈퇴
		public int delete(String email) {
			int result = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			String sql = "DELETE FROM USERS WHERE EMAIL=?";
			try {
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, email);
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JdbcUtil.close(conn, pstmt, null);
			}
			return result;
		}
}
