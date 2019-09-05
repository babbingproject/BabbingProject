<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원인증성공!</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<div style="margin: 100px;">
		<a><img
			src="${pageContext.request.contextPath}/images/Bobbing-logo.png"
			style="height: 80px; margin-left: 10px;" /></a> <br> <br>
		<h3>안녕하세요, ${param.userEmail} 님</h3>
		<br>
		<p>환영합니다! 밥빙에서 다양한 체험의 기회를 얻으세요!</p>
		<br>
		<p>회원가입이 정상적으로 이루어 졌습니다.</p>
		<br>
		<p>로그인 하시면 홈페이지 내의 모든 서비스를 이용하실 수 있습니다.</p>
		<br> <a href="${pageContext.request.contextPath}/">메인 페이지로
			이동하기</a>
	</div>
</body>
</html>