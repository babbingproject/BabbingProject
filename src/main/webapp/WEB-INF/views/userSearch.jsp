<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="common/css/stylesJoin2.css" rel="stylesheet">
<link href="common/css/wpwInfo.css" rel="stylesheet">

<!-- ajax를 위한 CDN 방식 라이브러리 -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#searchBtn2").submit(function() {
			if ($.trim($("#user_email").val()) !== $("#user_email").val()) {
				alert("아이디를 입력해주세요");
				return false;
			}

		})
		//input에 입력된 값이 변화가 있을때 alert 을 띄운다.
		$("input[name='user_email']").on("change", function() {
			var user_email = $('#user_email').val();

			//ajax 호출

			$.ajax({
				//Default datatype : JS ON
				async : true,
				type : 'POST',
				data : JSON.stringify({
					// 좌항 - 변수 , 우항 - 입력된 데이터 의미
					'user_email' : user_email
				}),
				//요청 url
				url : "/emailCheck",
				//controller에서 성공적으로 return 받을시 실행되는 메소드를 입력합니다.
				dataType : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(cnt) {
					if (user_email == "") {
						$("#chktext").css("color", "gray");
						$("#chktext").text("이메일을 입력해주세요.");

						$("#chktext2").html("");
					} else if (cnt == 0) {
						$("chktext").css("color", "red");
						$("#chktext").text("회원가입을 먼저 진행해주세요!");
						$("#chktext2").html("");
						$("#joinBtn").attr("disabled", "disabled");
					} else {
						$("#chktext2").css("color", "blue");
						$("#chktext2").text("회원님 비밀번호 변경 가능합니다!");
						$("#chktext").html("");
						$("#joinBtn").removeAttr("disabled");

					}

				},
				//에러 발생 시 실행되는 메소드
				error : function(error) {

					alert("error :" + error);

				}
			});
		});
	});
</script>
</head>
<body>


	<div class="w3-center">
		<div id="logoBack">
			<a href="index"><img src="images/Bobbing-logo.png" alt="밥빙 logo" /></a>
		</div>

	</div>

	<div class="w3-content w3-container w3-margin-top w3-center">

		<div class="w3-container w3-card-4">
			<br> <br>
			<h4>비밀번호를 잃어버리셨나요?</h4>
			<p id="pwInfo">
				회원 가입시 사용한 이메일 주소를 입력하시면<br> 비밀번호 재설정 안내 메일을 보내드립니다.
			</p>
		</div>
		<form action="user/searchPassword" id="searchBtn2" method="post">

			<p>
				<input type="text" class="w3-input" name="user_email"
					id="user_email" placeholder="example@naver.com" required="required">
				<!-- 쿠기에 저장된 벨류(아이디값)을 꺼내옵니다. 서비스에서 쿠키지정 ->컨르롤러로 벨류 전달 -->
				<span id="chktext" class="w3-text-red"></span> <span id="chktext2"
					class="w3-text-blue"></span>

			</p>
			<button type="submit" id="joinBtn"
				class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-round">안내 메일전송</button>
			

		</form>
	</div>

</body>
</html>