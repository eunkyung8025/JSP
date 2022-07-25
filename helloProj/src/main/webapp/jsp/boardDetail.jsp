<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardDetail.jsp</title>
</head>
<body>
<table border="1">

  <%
  	//파라미터를 읽어서 BoardDAO에서 단건조회 기능을 사용해서 화면에 출력하도록 구현하세요
  	String bno=request.getParameter("id");
  	BoardDAO dao= new BoardDAO();
  	BoardVO vo=dao.getBoard(Integer.parseInt(bno)); //"3"=>3
	
  %>

  <!-- 글번호, 제목, 내용, 작성자, 작성일자, 조회수 ★ 까지 다 나오도록 추가..  -->
	<thead>

	<tr><th>글번호</th><td><%=vo.getBoardId() %></td></tr>
	<tr><th>제목</th><td><%=vo.getTitle() %></td></tr>
	<tr><th>내용</th><td><%=vo.getContent() %></td></tr>
	<tr><th>작성자</th><td><%=vo.getWriter() %></td></tr>
	<tr><th>작성일시</th><td><%=vo.getCreateDate() %></td></tr>
	<tr><th>조회수</th><td><%=vo.getCnt() %></td></tr>

	</thead>
	
	</table>
	
	<a href="boardList.jsp">글목록으로</a>
	
</body>
</html>