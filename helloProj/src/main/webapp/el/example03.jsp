<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tst.board.BoardVO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String param = request.getParameter("msg");
	%>
	<c:catch var="ex">
		<%
		if(param.equals("add")) {
			out.print(param);	
		}
		%>
	</c:catch>
	<c:out value="${ex }"></c:out>
</body>
</html>