<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>inserCom.jsp</title>
</head>
<body>
	<c:set var="user" value="${loginId }"></c:set>
	<c:if test="${empty user }">
		<c:redirect url="loginForm.jsp"></c:redirect>
	</c:if>

	
	<form action= "insertComForm.jsp">
		댓글 내용: <textarea name="commentContent" rows="3" cols="50"></textarea><br>
		작성자 : <input type="text" name="id" value="${user }" readonly><br>
		<input type="submit" value="등록">
		<a href="BoardList.jsp">
		<input type="submit" value="목록보기"></a>
	</form>	

</body>
</html>