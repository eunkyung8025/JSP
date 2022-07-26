<%@page import="com.tst.comment.CommentDAO"%>
<%@page import="com.tst.comment.CommentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%


	String commentContent = request.getParameter("commentContent");
	String id = request.getParameter("id");
	
	CommentVO vo= new CommentVO();
	vo.setCommentContent(commentContent);
	vo.setId(id);
	
	CommentDAO dao= new CommentDAO();
	dao.insertComment(vo);
	
	response.sendRedirect("boardList.jsp");
	

%>    