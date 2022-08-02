package co.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import co.edu.vo.BoardVO;
import co.edu.vo.Criteria;

public class BoardDAO {

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
	
	public void addBoard(BoardVO vo) {
		String sql = "insert into test_board (seq, title, writer, content,write_date,visit_cnt) "
				+ "values (board_seq.nextval, ?, ?, ?,sysdate,0)";
		connect();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			
			int r=pstmt.executeUpdate();
			System.out.println(r+"건 입력");
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	
	//리스트 출력
	
	public List<BoardVO> getList() {
		String sql="select * from test_board order by 1";
		List<BoardVO> list= new ArrayList<>();
		connect();
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setWriteDate(rs.getString("write_date"));
				vo.setContent(rs.getString("content"));
				vo.setVisitCnt(rs.getInt("visit_cnt"));
				
				list.add(vo);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		} return list;
		
		
	}
	
	//페이징 처리
	
						//한페이지당 보여주고 싶은 갯수 amount, 페이지 수pageNum
	public List<BoardVO> getListPaging(Criteria cri) {
		List<BoardVO> listPage = new ArrayList<>();
		String sql= "select seq,title, content, writer, write_date, visit_cnt "
				+ "from (select rownum rn, seq, title, content, writer, write_date, visit_cnt "
				+ "          from (select seq,title, content, writer, write_date, visit_cnt "
				+ "                    from test_board "
				+ "                    order by seq desc) "
				+ "        where rownum <=?)" //1:1~10
				+ "where rn >?";

		connect();
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getAmount() * cri.getPageNum()); //10*2
			pstmt.setInt(2, cri.getAmount() * (cri.getPageNum()-1)); //10
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));
				board.setContent(rs.getString("content"));
				board.setVisitCnt(rs.getInt("visit_cnt"));
				
				listPage.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return listPage;
		
		
	}
}
