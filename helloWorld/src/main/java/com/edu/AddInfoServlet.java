package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddInfoServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out=resp.getWriter();
		out.print("<h3>추가적인 정보</h3>");
		out.print("<p>Request Method: "+req.getMethod()); //주소표시줄에 엔터치는 것은 get방식?!
		out.print("<p>Path Info: "+req.getPathInfo()); 
		out.print("<p>Path Translated: "+req.getPathTranslated()); //요청하는 페이지의 정보
		out.print("<p>Query String: "+req.getQueryString()); 
		out.print("<p>Content Length: "+req.getContentLength()); 
		out.print("<p>Content Type: "+req.getContentType()); //요청정보의 컨텐트타입
		
		out.close();
		}

}
