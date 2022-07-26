<%@page import="com.tst.board.BoardDAO"%>
<%@page import="com.tst.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String bid= request.getParameter("bno");

	BoardDAO dao=new BoardDAO();
	dao.deleteBoard(Integer.parseInt(bid));
	
	out.print("deleted.");
	response.sendRedirect("boardList.jsp");


%>