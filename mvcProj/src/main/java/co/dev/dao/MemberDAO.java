package co.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import co.dev.vo.MemberVO;

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
	
	//입력 처리 메소드
	public void insertMember(MemberVO vo) {
		String sql="insert into member(id, name, passwd, mail) values (?, ?, ?, ?)";
		connect();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPasswd());
			pstmt.setString(4, vo.getMail());
			
			int r = pstmt.executeUpdate();
			System.out.println(r+"건 입력.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		
	}
	
	//리스트 출력구문
	public List<MemberVO> getList() {
		String sql="select * from member order by 1";
		List<MemberVO> list = new ArrayList<>();
		connect();
		try {
			pstmt=conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setMail(rs.getString("mail"));
				vo.setName(rs.getString("name"));
				vo.setPasswd(rs.getString("passwd"));
				list.add(vo);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}	
	
	//단건조회 
	public MemberVO searchMember (String id) {
		String str= "select * from member where id=?";
		connect();
		try {
			pstmt=conn.prepareStatement(str);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setMail(rs.getString("mail"));
				vo.setName(rs.getString("name"));
				vo.setPasswd(rs.getString("passwd"));
				
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
		
	}
	
	//수정 메소드 추가
	public void updateMember(MemberVO vo) {
		String sql = "update member set name = ? passwd=? mail=? where id= ?";
		
		connect();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getMail());
			pstmt.setString(4, vo.getId());
			int r = pstmt.executeUpdate();
			System.out.println(r+"건 변경.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
			
		}
		
	}
	
	//삭제 메소드 추가
	public boolean deleteMember(String id) {
		String sql= "delete from member where id= ?";
		connect();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int r=pstmt.executeUpdate();
			System.out.println(r+"건 삭제.");
			if (r!=0) {
				return true;
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
		
	}
}
