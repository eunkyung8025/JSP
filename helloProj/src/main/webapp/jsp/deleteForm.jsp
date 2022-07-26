<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	
	String bno= request.getParameter("bno");
		
	%>
	<form action="delete.jsp">
	<input type="hidden" name="bno" value="<%=bno %>">
	"삭제하시겠습니까?"
	<input type="submit" value="예">
	<a href="boardList.jsp"><input type="button" value="아니오"></a>
	
	
	
	
	 
	
	</form>
</body>
</html>