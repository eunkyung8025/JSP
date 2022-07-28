<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberDelete.jsp</title>
</head>
<body>
	
	<h3>삭제할 회원검색</h3>
	<p>${error }</p>
	<form action="${pageContext.request.contextPath }/memberSearch.do" method="post">
		아이디 : <input type="text" name="id"><br>
		<input type="hidden" name="job" value="delete">
		<input type="submit" value="조회">
	</form>
		<!-- 검색된 아이디의 내용 삭제 기능  -->
	<c:set var="vo" value="${member }" />
	<c:choose>
		<c:when test="${!empty vo }"> 
			<form action="${pageContext.request.contextPath }/memberDelete.do" method="post">
			<p>${vo.name }의 정보를 삭제하시겠습니까? </p><br>
			<input type="submit" value="네">
			<input type="hidden" name="id" value="${vo.id }">
			<input type="hidden" name="name" value="${vo.name }">
			<a href="${pageContext.request.servletContext.contextPath }/home.jsp"><input type="button" value="아니오"></a>
			</form>
		</c:when>
		<c:otherwise>
			<p>${result }</p>
		</c:otherwise>
	</c:choose>
</body>
</html>