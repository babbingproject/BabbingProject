
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>
</head>
<body>
	임시 메인화면 입니다. 여기까지 오나요? 로그인 성공
	<h3>안녕하세요, ${sessionScope.loginId } 님</h3>

	<form action="/">
		<button>home</button>
	</form>
	<h1><%=session.getAttribute("signedUser")%>님 <small>반갑습니다.</small>
	</h1>
	<a href="logout">로그아웃</a>
	
	 ${sessionScope.loginId }
</body>
</html>