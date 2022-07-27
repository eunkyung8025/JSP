<%@page import="co.edu.common.MemberVO"%>
<%@page import="co.edu.common.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("passwd");
	String name = request.getParameter("name");
	String mail = request.getParameter("mail");
	
	//멤버 서비스 객체를 받아올 것임
	MemberVO vo= new MemberVO();
	vo.setId(id);
	vo.setName(name);
	vo.setMail(mail);
	vo.setPasswd(pw);
	
	
	MemberService service=MemberService.getInstance();
	service.memberAdd(vo);
	
	request.setAttribute("member",vo);
	
	//처리결과 : memberOutput.jsp로 넘기기
	RequestDispatcher rd= request.getRequestDispatcher("memberOutput.jsp");
	rd.forward(request,response);
%>