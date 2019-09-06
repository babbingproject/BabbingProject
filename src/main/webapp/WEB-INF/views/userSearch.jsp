<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>비밀번호 찾기</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- ajax를 위한 CDN 방식 라이브러리 -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#searchBtn2").submit(function() {
			if ($.trim($("#inputEmail_2").val()) !== $("#inputEmail_2").val()) {
				alert("아이디를 입력해주세요");
				return false;
			}
			alert("비밀번호 변경 메일을 발송 하였습니다!");
		})
	});
</script>
</head>
<body>

	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4">
			<div class="w3-center w3-large w3-margin-top">
				<a><img
					src="${pageContext.request.contextPath}/images/Bobbing-logo.png"
					style="height: 80px; margin-left: 10px;" /></a> <br> <br>
				<h3>비밀번호 찾기</h3>
				<p>회원 가입시 사용한 이메일 주소를 입력하시면</p>
				<p>비밀번호 재설정 안내 메일을 보내드립니다.</p>
			</div>
			<form action="user/searchPassword" id="searchBtn2" method="post">

				<p>
					<input type="text" class="w3-input" name="user_email"
						id="inputEmail_2" placeholder="example@naver.com"
						required="required">
					<!-- 쿠기에 저장된 벨류(아이디값)을 꺼내옵니다. 서비스에서 쿠키지정 ->컨르롤러로 벨류 전달 -->
					<span id="spanLoginCheck" class="w3-text-red"></span>
				</p>
				<input type="submit" id="searchBtn2"
					class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-margin-bottom w3-round"
					value="확인">
				<!-- <button id="searchBtn2" type="button" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round">확인</button> -->
				<button type="button" onclick="history.go(-1);"
					class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-margin-bottom w3-round">취소</button>

			</form>
		</div>
	</div>
</body>
</html>