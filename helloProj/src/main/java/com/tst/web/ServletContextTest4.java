package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tst.common.ShareObject;

@WebServlet("/context4")
public class ServletContextTest4 extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		ServletContext sc = this.getServletContext(); 
		//어떤 타입이건 다 받아들이기 위해 object타입으로 받아옴
		ShareObject obj1 = (ShareObject) sc.getAttribute("data"); //가져오는 타입이 맞게끔 설정
		resp.getWriter().print("count : "+obj1.getCount()+", str : "+obj1.getStr()+"<br>");
	
		
		sc.getAttribute("data2");
		ShareObject obj2 = (ShareObject) sc.getAttribute("data2"); //값이 지정되어 있지 않으면 null값이 반환됨
		resp.getWriter().print("count : "+obj2.getCount()+", str : "+obj2.getStr());

	}
}
