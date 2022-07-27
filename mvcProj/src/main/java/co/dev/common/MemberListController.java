package co.dev.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;

public class MemberListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		MemberService service=MemberService.getInstance();
		
		req.setAttribute("list", service.memberList());
		
		Utils.forward(req, resp, "memberResult/memberListOutput.jsp");
		
		
//		RequestDispatcher rd=req.getRequestDispatcher("memberResult/memberListOutput.jsp");
//		try {
//			rd.forward(req, resp);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
		}

	}


