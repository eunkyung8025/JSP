package co.edu.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Controller;
import co.edu.service.BoardService;

public class BoardListControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardService service=BoardService.getInstance();
		
		req.setAttribute("list", service.boardList());
		RequestDispatcher rd=req.getRequestDispatcher("board/boardListOutput.tiles");
		
		rd.forward(req, resp);
		
	}

}
