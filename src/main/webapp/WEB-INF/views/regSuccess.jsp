<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원인증성공!</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<div style="margin: 100px;">
		<div class="w3-content w3-container w3-margin-top">
			<div class="w3-container w3-card-4">
				<div class="w3-center w3-large w3-margin-top">
					<a><img
						src="${pageContext.request.contextPath}/images/Bobbing-logo.png"
						style="height: 80px; margin-left: 10px;" /></a> <br> <br>
					<h3>안녕하세요, ${param.user_email} 님</h3>
					<br>
					<p>환영합니다! 밥빙에서 다양한 체험의 기회를 얻으세요!</p>
					<br>
					<p>회원가입이 정상적으로 이루어 졌습니다.</p>
					<br>
					<p>로그인 하시면 홈페이지 내의 모든 서비스를 이용하실 수 있습니다.</p>
					<br> <a
						class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-round"
						href="${pageContext.request.contextPath}/">메인 페이지로 이동하기</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>