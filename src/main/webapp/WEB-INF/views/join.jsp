<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>

<link href="common/css/stylesJoin.css" rel="stylesheet">

<!-- ajax를 위한 CDN 방식 라이브러리 -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#joinForm").submit(
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
					} else if ($.trim($("#pw").val()) !== $("#pw").val()
							|| $.trim($("#nickname").val()) !== $("#nickname")
									.val()
							|| $.trim($("#user_email").val()) !== $(
									"#user_email").val()) {
						alert("공백은 입력이 불가능합니다.");
						return false;
					}

				})

		/* 이메일 체크 */

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
	<!-- Cookie가 비어있지 않을 때 checked 속성을 줌 -->
	<c:if test="${not empty cookie.user_check}">
		<c:set value="checked" var="checked" />
	</c:if>
	<form id="joinForm" action="/join" method="post">
	<div id="background">
		<div id="total">
			<div id="Layer4">
				<img src="images/Layer4.png">
			</div>
			<div id="RoundedRectangle744">
				<img src="images/RoundedRectangle744.png">
			</div>
			<div id="Shape740copy2">
				<img src="images/Shape740copy2.png">
			</div>
			<div id="Shape740copy">
				<img src="images/Shape740copy.png">
			</div>
			<div id="layer_5">
				<img src="images/layer_5.png">
			</div>
			<div id="layer_6">
				<img src="images/layer_6.png">
			</div>
			<div id="layer_7">
				<img src="images/layer_7.png">
			</div>
			<div id="copy">
				<img src="images/copy.png">
			</div>
			<div id="copy2">
				<a href="${pageContext.request.contextPath}/"><img
					src="images/copy2.png"></a>
			</div>
			<div id="layer_10">
				<img src="images/layer_10.png">
			</div>
			<div id="layer_11">
				<img src="images/layer_11.png">
			</div>
			<div id="layer_12">
				<img src="images/layer_12.png">
			</div>
			<div id="layer_13">
				<a href="${pageContext.request.contextPath}/joinForm"><img
					src="images/layer_13.png"></a>
			</div>
			<div id="layer_14">
				<input id="user_email" type="text" required="required"
					placeholder="이메일" />
			</div>
			<div id="layer_15">
				<input type="text" id="nickName" required="required"
					placeholder="닉네임" />
			</div>
			<div id="layer_16">
				<img src="images/layer_16.png">
			</div>
			<div id="copy_0">
				<img src="images/copy_0.png">
			</div>
			<div id="layer_616">
				<input type="password" id="password" required="required"
					placeholder="비밀번호(8자리이상)" />
			</div>
			<div id="layer_19">
				<input type="password" id="password2" required="required"
					placeholder="비밀번호 확인" />
			</div>
			<div id="layer_20">
				<span id="chktext" class="w3-text-red"></span> <span id="chktext2">afdad</span>
			</div>
			<div id="layer_616_0">
				<img src="images/layer_616_0.png">
			</div>
			<div id="layer_22">
				<img src="images/layer_22.png">
			</div>
			<div id="layer_23">
				<img src="images/layer_23.png">
			</div>
		</div>
	</div>
	</form>
</body>
</html>