<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el/addMember.jsp</title>
</head>
<body>

	<form action = "example02.jsp" method="get">
		글제목: <input type="text" name="title"><br>
		글내용: <textarea name="content" cols="30" rows="3"></textarea><br>
		작성자: <input type="text" name="writer"><br>
		<input type="submit" value="등록">	
		<a href="BoardList.jsp">
	<input type="submit" value="목록 보기"></a>	
	</form>
</body>
</html>