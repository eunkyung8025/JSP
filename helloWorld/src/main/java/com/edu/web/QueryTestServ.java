package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/html/queryTest")
public class QueryTestServ extends HttpServlet {

	@Override
	//doGet= get 처리방식이 지정되어 있음
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out= resp.getWriter();
		
		//값을 입력받기
		String id=req.getParameter("id");// parameter:id 값을 반환
		String pwd=req.getParameter("pwd");// parameter:pwd 값을 반환
		String name=req.getParameter("name");// parameter:name 값을 반환
		String[] hobby=req.getParameterValues("hobby");// parameter:hobby 값을 반환
		String gender=req.getParameter("gender");
		String religion=req.getParameter("religion");
		String introduction=req.getParameter("introduction");
		
		out.print("<h3>입력받은 값</h3>");
		out.print("<p>ID: "+id+"</p>");
		out.print("<p>비밀번호: "+pwd+"</p>");
		out.print("<p>이름: "+name+"</p>");
		out.print("<p>취미: <ul>");
		for(String hob : hobby) {
			out.print("<li>"+hob+"</li>");
		}
		out.print("</ul>");	
		out.print("<p>성별: "+gender+"</p>");
		out.print("<p>종교: "+religion+"</p>");				
		out.print("<p>자기소개: "+introduction+"</p>");				
		out.print("질의문자열: "+req.getQueryString());
		out.close();
		
	}
	
	@Override
	//doPost= post 처리방식이 지정되어 있음
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out= resp.getWriter();
		
		//값을 입력받기

//		String id=req.getParameter("id");// parameter:id 값을 반환
//		String pwd=req.getParameter("pwd");// parameter:pwd 값을 반환
//		String name=req.getParameter("name");// parameter:name 값을 반환
//		String[] hobby=req.getParameterValues("hobby");// parameter:hobby 값을 반환
//		String gender=req.getParameter("gender");
//		String religion=req.getParameter("religion");
//		String introduction=req.getParameter("introduction");
//		
//		out.print("<h3>입력받은 값</h3>");
//		out.print("<p>ID: "+id+"</p>");
//		out.print("<p>비밀번호: "+pwd+"</p>");
//		out.print("<p>이름: "+name+"</p>");
//		out.print("<p>취미: <ul>");
//		for(String hob : hobby) {
//			out.print("<li>"+hob+"</li>");
//		}
//		out.print("</ul>");	
//		out.print("<p>성별: "+gender+"</p>");
//		out.print("<p>종교: "+religion+"</p>");				
//		out.print("<p>자기소개: "+introduction+"</p>");

		ServletInputStream sis=req.getInputStream(); //post 방식일 경우에만 들어오는 정보를 
		int len=req.getContentLength();//데이터크기
		byte [] buf = new byte[len]; //스트링에 들어온 값을 buf 배열에 담아줌
		sis.readLine(buf, 0, len); //넘어온 스트링을 처음부터 끝까지 담겠다.
		String querystring=new String(buf);
		out.print("<p id='querystring'>"+ querystring+"</p>");
		sis.close();
		out.close();
		
	}
	
	
}
