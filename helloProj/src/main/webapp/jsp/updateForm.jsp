<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm.jsp</title>
</head>
<body>
	<%
		String bno=request.getParameter("bno"); //request:내장객체
		BoardDAO dao=new BoardDAO();
		BoardVO vo = dao.getBoard(Integer.parseInt(bno));
		
		String condition="";
		String loginId= (String) session.getAttribute("loginId");
		if(!(loginId!=null && loginId.equals(vo.getWriter()))) {
			condition="disabled";
		}
	%>
	<form action="update.jsp">
	<table border="1">
		<tr><th>글번호</th><td><input type="text" name="bid" value="<%=vo.getBoardId() %>" readonly></td></tr>
		<tr><th>제목</th><td><input type="text" name="btitle" value="<%=vo.getTitle() %>"></td></tr>
		<tr><th>내용</th><td><input type="text" name="bcontent" value="<%=vo.getContent() %>"></td></tr>
		<tr><td colspan="2"><input type="submit" value="수정" <%=condition %>></td></tr>
	
	</table>
	</form>
</body>
</html>