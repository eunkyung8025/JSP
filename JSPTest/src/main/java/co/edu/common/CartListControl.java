package co.edu.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.edu.service.CartService;
import co.edu.vo.CartVO;

public class CartListControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/json;charset=utf-8");
		
		// dAO메소드 등록하고, MemberService메소드도 등록해야함
		// json 형태로 반환.
		
		CartService service=CartService.getInstance();
		List<CartVO> cartList=service.cartList();
		
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(cartList));
	}

}
