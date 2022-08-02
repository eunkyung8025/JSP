package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Controller;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.vo.MemberVO;

public class MemberJoinControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 회원가입화면: 회원가입 후 첫페이지로 이동.
			
		MemberService service=MemberService.getInstance();
		
		String id=req.getParameter("id");
		String pw=req.getParameter("passwd");
		String nm=req.getParameter("name");
		String add=req.getParameter("address");
		
		MemberVO vo = new MemberVO ();
		service.addMember(vo);
		
		HttpUtil.forward(req, resp, "index.jsp");
	
	}

}
