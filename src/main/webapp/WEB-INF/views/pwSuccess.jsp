<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>비밀번호즉시변경</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- ajax를 위한 CDN 방식 라이브러리 -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#modify").submit(
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
					} 
					alert("신규 비밀번호로 변경 완료되었습니다!");
				})
	});
</script>
</head>
<body>
	<div style="margin: 100px;">
		<div class="w3-content w3-container w3-margin-top">
			<div class="w3-container w3-card-4">
				<div class="w3-center w3-large w3-margin-top">
					<a><img
						src="${pageContext.request.contextPath}/images/Bobbing-logo.png"
						style="height: 80px; margin-left: 10px;" /></a> <br> <br>
					<h3>비밀번호를 변경하시겠어요?</h3>
					<p>새로운 비밀번호를 입력해주세요</p>
					<div>
						<form id="modify" action="/pwUpdate" method="post">

							<p>
								<input type="hidden" value="${sessionScope.signedUser }"
									name="userEmail"> <input type="password"
									class="w3-input" name="password" id="pw" placeholder="새 비밀번호"
									required="required">
							</p>
							<p>
								<input type="password" class="w3-input" id="pw2"
									placeholder="비밀번호 확인" required="required">
							</p>
							<p>
								<button type="submit" id="modify"
									class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-round">비밀번호
									변경</button>
								<br>
						</form>
					</div>
				</div>
				<br> <a href="${pageContext.request.contextPath}/">메인 페이지로
					이동하기</a>
			</div>
		</div>

	</div>
</body>
</html>