package co.edu.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.service.CartService;

public class CartUpdateControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String no = req.getParameter("no");
		String qty=req.getParameter("gty");
		
		CartService service = CartService.getInstance();
		service.updateCart(Integer.parseInt(no), Integer.parseInt(qty));
		
		resp.getWriter().print("success");
		
	}

}
