package co.edu.service;

import java.util.List;

import co.edu.dao.CartDAO;
import co.edu.vo.CartVO;

public class CartService {

	
	private static CartService instance=new CartService();
	CartDAO dao=new CartDAO();
	
	private CartService() {}
	
	public static CartService getInstance() {
		return instance;
	}
	
	// cart 목록.
	   public List<CartVO> cartList() {
	      return dao.cartList();
	   }
	   
	// 수량변경
	   public void updateCart(int no, int qty) {
		   dao.updateCart(no, qty);
	   }
	
}
