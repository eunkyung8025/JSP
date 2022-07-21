package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//사용자가 /second.do를 요청하면 해당 클래스가 실행됨
@WebServlet("/second.do")
public class SecondServlet extends HttpServlet {
	
	@Override
	//응답요청을 HttpServletRequest가 실행해줌?
	//init 실행되고 다음 요청을 위해 request로 만들고
	//응답정보를 만들어주는 reponse객체를 만듬
	//응답 정보에다가 출력스트림을 생성해줌
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//출력해주는 페이지의 응답 타입을 지정해줌(html파일형태, 글자형태 UTF-8)
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter(); //출력 스트림
		out.print("<h3>안녕하세요. 서블릿입니다.</h3>");
	}
}
