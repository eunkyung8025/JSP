<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="vo" value ="${member }"></c:set>
	<p><c:out value="${vo.name }"></c:out>님 가입이 완료되었습니다.</p>
	

</body>
</html>