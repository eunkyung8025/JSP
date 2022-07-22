package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet{

	//(1) 생성(생성자)
	//(2) ServletConfig 생성(서블릿에 선언되어 있는 파라미터값을 불러오기 위한 객체)
	//(3) init()객체의 매개값으로 Servlet Config를 담음
	//(4)service(rq,rs)
	
	
	//필드영역에서 선언해주어 init, doGet에서 함께 쓰임
	String id;
	String pw;
	
	//생성자
	public InitParamServlet() {
		System.out.println("InitParamServlet() 호출.");
	}
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		id = config.getInitParameter("id");
		pw = config.getInitParameter("password");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.print("<h3>서블릿 초기변수 설정<h3>");
		out.print("<p> ID: "+id+"</p>");
		out.print("<p> 비번: "+pw+"</p>");

		
	}
}
