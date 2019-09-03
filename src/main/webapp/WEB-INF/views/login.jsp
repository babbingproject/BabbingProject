<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- ajax를 위한 CDN 방식 라이브러리 -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {

		$('#loginBtn').click(function() {
							var userEmail = $('#userEmail').val();
							var pw = $('#inputPassword').val();
							var remember_us = $('#remember_us').is(':checked');
							 $.ajax({
								 
										async : true,
										type : 'POST',
										url : "/logincon",
										data : {
											userEmail : userEmail,
											password : pw,
											remember_userId : remember_us
										},
										success : function(result) {
											if (result == 0) { //로그인 실패시
												$("#spanLoginCheck").text("로그인 정보를 정확히 입력해주세요.");
												
											} else if (result == -2) { //인증하지 않았다면?
												console.log(result);
												$('#spanLoginCheck').text(
														'이메일 인증을 해주셔야 합니다!');
											} else if (result == -3) { // 아이디가 사용중이라면?
												location.href = '${pageContext.request.contextPath}/user/redundant?userEmail='
														+ userEmail
														+ '&password='
														+ password
														+ '&remember_userId='
														+ remember_us;
											} else { //로그인 성공시
												location.href = '${pageContext.request.contextPath}/loginss'; //컨트롤러를 호출해서 화면전환
											}
										}
									}); 
						});
	});
</script>	
</head>
<body>
	<!-- Cookie가 비어있지 않을 때 checked 속성을 줌 -->
	<c:if test="${not empty cookie.user_check}">
		<c:set value="checked" var="checked" />
	</c:if>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4">
			<div class="w3-center w3-large w3-margin-top">
				<h3>밥빙 로그인 테스트</h3>
			</div>
			<div>
				 <form  id="login" method="post">
				<!-- <form id="login" method="post"> -->

					<!-- 세션에 저장한 카카오 아이디를 가져옴 -->
					<input type="hidden" name="kakao_id" value="${kakao_id}" />
					<p>
						<label>Email</label><br> <input type="text" class="w3-input"
							name="userEmail" id="userEmail" placeholder="Email"
							value="${cookie.user_check.value}" required="required">
						<!-- 쿠기에 저장된 벨류(아이디값)을 꺼내옵니다. 서비스에서 쿠키지정 ->컨르롤러로 벨류 전달 -->
						<span id="spanLoginCheck"
							class="w3-text-red"></span> 
					</p>
					<p>
						<label>Password</label><br> <input type="password"
							class="w3-input" name="password" id="inputPassword"
							placeholder="Password" required="required"> <span
							id="spanLoginCheck" class="w3-text-red"></span>
					</p>
					<p>
						<label class="font-weight-bold text-white"> <input
							type="checkbox"  id="remember_us" name="remember_userId"
							${checked}> 이메일 기억하기 <!-- 위에 벨류값에 따라 checked가 실행되거나 안되게 합니다. -->
						</label>
					</p>
					<p>
						 <input type="button" id="loginBtn"
							class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round"
							  value="LOGIN"> 
						<a
							class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round"
							href="${pageContext.request.contextPath}/joinForm">JOIN</a>
							<a
							class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round"
							href="${pageContext.request.contextPath}/">HOME</a>
					</p>
					<a href="${pageContext.request.contextPath}/userSearch">&nbsp;
						비밀번호 찾기</a>
				</form>
				<!-- 소셜 로그인 시작  -->
				<div class="form-group socialimage" id="facebookBtn">
					<a href=""> <img
						src="${pageContext.request.contextPath}/images/facebook_big.png"
						width="25%" height="100%" />
					</a>
				</div>
				<div class="form-group socialimage" id="kakaoBtn">
					<a
						href="https://kauth.kakao.com/oauth/authorize?client_id=85f4a0fdfed755ce3d9b2b081af17f44&redirect_uri=http://localhost:8080/MS/kakaologin&response_type=code">
						<img id="socialimage"
						src="${pageContext.request.contextPath}/images/kakao_account_login_btn_medium_narrow (1).png"
						height="100%" align="middle" />
					</a>
				</div>
				<div class="w3-margin-top w3-margin-bottom" id="naverBtn">
					<a href=""> <img
						src="${pageContext.request.contextPath}/images/네이버 아이디로 로그인_완성형_Green.PNG"
						width="25%" align="middle" height="100%" />
					</a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>