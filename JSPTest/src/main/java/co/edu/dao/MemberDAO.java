package co.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;

import org.apache.tomcat.jdbc.pool.DataSource;

import co.edu.vo.MemberVO;

public class MemberDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public void connect() {
		try {
			InitialContext ic= new InitialContext();
			DataSource ds=(DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn=ds.getConnection();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void disconnect() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn !=null) conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace(); //catch구문은 비워두면 안됨. 
		}
	}
	
	//게시글 등록
	
	public void addMember(MemberVO vo) {
		String sql = "insert into test_member values (?,?,?,?)";
		connect();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAddress());
			
			int r=pstmt.executeUpdate();
			System.out.println(r+"건 입력");
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	
	//회원조회
	
	public MemberVO searchMember (String id) {
		String str= "select * from test_member where id=?";
		connect();
		try {
			pstmt=conn.prepareStatement(str);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
