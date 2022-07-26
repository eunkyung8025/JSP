package com.tst.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logProc")
public class LogInOutServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//응답정보의 컨텐트 타입부터 지정
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out=resp.getWriter();
		//파라미터 이름 = form 태그의 name 속성
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		if(id.isEmpty() || pwd.isEmpty()) {
			//id 값이나 pwd값이 비어있으면
			out.print("ID와 비밀번호를 입력해주세요.");
			return ;
		} 
		HttpSession session = req.getSession();
		if(session.isNew() || session.getAttribute("id")==null) {
			//세션이 새로만들어졌거나 (=세션이 있을 경우) 혹은
			  //세션이 있으나 id를 불러왔을 때 세션 값이 null일 경우
			session.setAttribute("id", id);
			//id라는 값을 지정하겠다 (setAttribute하겠다)
			out.print("로그인을 완료했습니다.");
			resp.sendRedirect("jsp/boardList.jsp");
			
			//RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/jsp/boardList.jsp");
			//rd.forward(req, resp);
	
			
			
		} else {
			//세션이 없을 경우
			out.print("현재 로그인 중입니다.");
			
		}
			
		}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession(false);
		if(session!=null && session.getAttribute("id")!=null) {
			//이미 로그인되어 있으면
			session.invalidate(); //세션 삭제
			out.print("로그아웃 완료했습니다.");
			
		} else {
			out.print("현재 로그인 상태가 아닙니다.");
			
		}
	}
}
