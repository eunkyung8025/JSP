package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/local")
public class LocalTestServlet extends HttpServlet {
	String str;
	//필드 밖에 선언해주는게 전역변수로 쓰겟다는 것
	
	//하나의 창에서 실행이 될때 다른 창에서 실행이 되면 값이 바뀌어 출력됨
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		str = req.getParameter("msg");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out= resp.getWriter();
		out.print("<h2>처리결과(전역변수)</h2>");
		
		int num=0;
		while(num++<10) {
			out.print(str+" : "+num+"<br>");
			out.flush(); //캐시를 비움
			try {
				Thread.sleep(1000); //1초 간격으로 실행되도록
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		} out.print("<h2>Done : "+str+"</h2>");
	}
}
