<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>joinForm</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- ajax를 위한 CDN 방식 라이브러리 -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#joinForm")
				.submit(
						function() {
							if ($("#pw").val() !== $("#pw2").val()) {
								alert("비밀번호가 다릅니다.");
								$("#pw").val("").focus();
								$("#pw2").val("");
								return false;
							} else if ($("#pw").val().length < 8) {
								alert("비밀번호는 8자 이상으로 설정해야 합니다.");
								$("#pw").val("").focus();
								$("#pw2").val("");
								return false;
							} else if ($.trim($("#pw").val()) !== $("#pw")
									.val()
									|| $.trim($("#nickname").val()) !== $(
											"#nickname").val()
									|| $.trim($("#userEmail").val()) !== $(
											"#userEmail").val()) {
								alert("공백은 입력이 불가능합니다.");
								return false;
							}
							alert("인증 메일을 발송 하였습니다. 메일 인증을 진행해주세요!");
						})

		/* 이메일 체크 */

		//input에 입력된 값이 변화가 있을때 alert 을 띄운다.
		$("input[name='userEmail']").on("change", function() {
			var userEmail = $('#userEmail').val();

			//ajax 호출

			$.ajax({
				//Default datatype : JS ON
				async : true,
				type : 'POST',
				data : JSON.stringify({
					// 좌항 - 변수 , 우항 - 입력된 데이터 의미
					'userEmail' : userEmail
				}),
				//요청 url
				url : "/emailCheck",
				//controller에서 성공적으로 return 받을시 실행되는 메소드를 입력합니다.
				dataType : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(cnt) {
					if (userEmail == "") {
						$("#chktext").css("color", "gray");
						$("#chktext").text("이메일을 입력해주세요.");

						$("#chktext2").html("");
					} else if (cnt == 0) {
						$("#chktext2").css("color", "blue");
						$("#chktext2").text("사용 가능한 이메일 입니다.");
						$("#chktext").html("");
						$("#joinBtn").removeAttr("disabled");
					} else {
						$("chktext").css("color", "red");
						$("#chktext").text("이미 사용중인 이메일 입니다.");
						$("#chktext2").html("");
						$("#joinBtn").attr("disabled", "disabled");

					}

				},
				//에러 발생 시 실행되는 메소드
				error : function(error) {

					alert("error :" + error);

				}
			});
		});
	});

	/*닉네임 체크  */

	$(function() {
		//input에 입력된 값이 변화가 있을때 alert 을 띄운다.
		$("input[name='nickname']").on("change", function() {
			var nickname = $('#nickname').val();

			//ajax 호출

			$.ajax({
				//Default datatype : JS ON
				async : true,
				type : 'POST',
				data : JSON.stringify({
					// 좌항 - 변수 , 우항 - 입력된 데이터 의미
					'nickname' : nickname
				}),
				//요청 url
				url : "/nickCheck",
				//controller에서 성공적으로 return 받을시 실행되는 메소드를 입력합니다.
				dataType : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(cnt) {
					if (nickname == "") {
						$("#chktext").css("color", "gray");
						$("#nickchktext").text("닉네임을 입력해주세요.");

						$("#nickchktext2").html("");
					} else if (cnt == 0) {
						$("#nickchktext2").css("color", "blue");
						$("#nickchktext2").text("사용 가능한 닉네임 입니다.");
						$("#nickchktext").html("");
						$("#joinBtn").removeAttr("disabled");
					} else {
						$("#nickchktext").css("color", "red");
						$("#nickchktext").text("이미 사용중인 닉네임 입니다.");
						$("#nickchktext2").html("");
						$("#joinBtn").attr("disabled", "disabled");

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
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4">
			<div class="w3-center w3-large w3-margin-top">
				<a><img
					src="${pageContext.request.contextPath}/images/Bobbing-logo.png"
					style="height: 80px; margin-left: 10px;" /></a> <br> <br>
				<h3>밥빙 회원가입 테스트</h3>
			</div>
			<div>

				<form id="joinForm" action="/join" method="post">
					<!-- 세션에 저장한 카카오 아이디를 가져옴 -->
					<input type="hidden" name="kakao_id" value="${kakao_id}" />

					<p>
						<label>Email</label><br> <input type="text" class="w3-input"
							name="userEmail" id="userEmail" placeholder="Email"
							required="required"> <span id="chktext"
							class="w3-text-red"></span> <span id="chktext2"
							class="w3-text-blue"></span>
					</p>

					<p>
						<label>NickName</label><br> <input type="text"
							class="w3-input" name="nickname" id="nickname"
							placeholder="NinckName" required="required"> <span
							id="nickchktext" class="w3-text-red"></span> <span
							id="nickchktext2" class="w3-text-blue"></span>
					</p>
					<p>
						<label>Password</label><br> <input type="password"
							class="w3-input" name="password" id="pw" placeholder="Password"
							required="required">
					</p>
					<p>
						<label>Confirm</label><br> <input type="password"
							class="w3-input" id="pw2" placeholder="Cofirm"
							required="required">
					</p>
					<p>
						<button type="submit" id="joinBtn"
							class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-round">JOIN</button>
						<br>
						<button type="button" onclick="history.go(-1);"
							class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-margin-bottom w3-round">CANCLE</button>
					</p>
				</form>
			</div>
		</div>
	</div>

</body>
</html>