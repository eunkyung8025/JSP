package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//파라메터를 통해 값을 넘기면 섹션을 생성, 변경, 삭제할 수 있음
		
		resp.setContentType("text/html; charset=utf-8");
		HttpSession session =null;  //타입 HttpSession
		String param = req.getParameter("p");
		String msg = null;
		
		//생성, 변경, 삭제
		if (param.equals("create")) {
			session = req.getSession(); //생성된 세션값이 있으면 session반환, 
			                  //없으면 새로 생성 후 새롭게 생성된 세션값 반환
			if (session.isNew()) {
				//isNew(): 이번요청에 의해 만들어진 값인지 확인하는 메소드. 맞으면 true 반환
				msg = "새로운 세션 객체 생성";
			} else {
				msg = "기존 세션 객체 반환";
			}
		}
			else if(param.equals("delete")) {
				session=req.getSession(false); //생성된 세션이 있으면 세션 반환, 없으면 null
				if(session!=null) {
					session.invalidate(); //세션 삭제
					msg = "세션 객체 삭제.";
					
				} else { 
					msg = "삭제할 세션 객체 없음.";
				}
			} else if(param.equals("add")) {
				session= req.getSession(true);
				session.setAttribute("msg", "메세지 추가함.");
				msg = "세션 객체에 속성 지정함.";
			} else if (param.equals("get")) {
				session=req.getSession(false);//세션 없으면 null
				if(session!=null) {
					String str = (String) session.getAttribute("msg");
					msg=str;
				} else {
					msg = "데이터를 추출할 세션 없음.";
					}
				
			} else if(param.equals("remove")) {
				//세션이 있을 경우에만 속성을 삭제
				session=req.getSession(false); //세션객체가 없으면 null을 반환
				if(session !=null) {
					session.removeAttribute("msg");
					msg="세션 객체의 속성을 삭제함.";
				} else {
					msg="속성을 제거할 세션 객체가 없습니다.";
				}
			}
		
		resp.getWriter().print("처리결과: "+msg);	
		//출력값에 한글이 포함되어있으면 응답 타입에다 타입을 설졍해줘야함 (resp.setContentType)
		} 
	}



