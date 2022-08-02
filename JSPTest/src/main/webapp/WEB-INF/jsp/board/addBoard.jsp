<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<h3>게시글 등록화면입니다.</h3>
	<form action ="insertBoard.do" method="post">
		제목 : <input type="text" name="title"><br>
		글쓴이 : <input type="text" name="writer"><br>
		내용 : <input type="text" name="content"><br>
		
		<input type="submit" name="등록">
	
	</form>
</body>
</html>