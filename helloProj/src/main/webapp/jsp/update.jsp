<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String id = request.getParameter("bid");
	String title = request.getParameter("btitle");
	String content = request.getParameter("bcontent");
	
	BoardVO vo = new BoardVO();
	vo.setBoardId(Integer.parseInt(id));
	vo.setTitle(title);
	vo.setContent(content); //파라메타로 들어온 값을 담아서 updateBoard메소드 실행
	
	BoardDAO dao = new BoardDAO();
	dao.updateBoard(vo);
	
	//응답객체가 가지고 있는 
	response.sendRedirect("boardList.jsp");
	
			
%>