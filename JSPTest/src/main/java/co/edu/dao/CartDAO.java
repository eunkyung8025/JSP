package co.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import co.edu.vo.CartVO;

public class CartDAO {

	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
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
	
	//CART에 들어있는 전체 데이터를 가져오기
	
	public List<CartVO> cartList() {
		
		List<CartVO> cartList= new ArrayList<>();
		String sql= "select * from cart";
		
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				CartVO cart = new CartVO();
				cart.setNo(rs.getInt("no"));
				cart.setProductNm(rs.getString("product_nm"));
				cart.setPrice(rs.getInt("price"));
				cart.setQty(rs.getInt("qty"));
				
				cartList.add(cart);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
			
		} return cartList;
		
	}
	
	// CART 업데이트
	
	   public void updateCart(int no, int qty) {
		      String sql = "update cart set qty = " + qty + " where no = " + no;
		      try {
		         connect();
		         stmt = conn.createStatement();
		         int r = stmt.executeUpdate(sql);
		         if (r>0) {
		            System.out.println(r+"건 수정.");
		         }
		      } catch(SQLException e) {
		         e.printStackTrace();
		      } finally {
		         disconnect();
		      }
		   }
}
