package co.edu.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Controller;
import co.edu.service.BoardService;
import co.edu.vo.BoardVO;

public class AddBoardControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		RequestDispatcher rd= req.getRequestDispatcher("board/addBoard.tiles");
		
		rd.forward(req, resp);
		
	}

}
