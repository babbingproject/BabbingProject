<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��й�ȣ ã��</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- ajax�� ���� CDN ��� ���̺귯�� -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#searchBtn2").submit(function() {
			if ($.trim($("#inputEmail_2").val()) !== $("#inputEmail_2").val()) {
				alert("���̵� �Է����ּ���");
				return false;
			}
			alert("��й�ȣ ���� ������ �߼� �Ͽ����ϴ�!");
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
				<h3>��й�ȣ ã��</h3>
				<p>ȸ�� ���Խ� ����� �̸��� �ּҸ� �Է��Ͻø�</p>
				<p>��й�ȣ �缳�� �ȳ� ������ �����帳�ϴ�.</p>
			</div>
			<form action="user/searchPassword" id="searchBtn2" method="post">

				<p>
					<input type="text" class="w3-input" name="user_email"
						id="inputEmail_2" placeholder="example@naver.com"
						required="required">
					<!-- ��⿡ ����� ����(���̵�)�� �����ɴϴ�. ���񽺿��� ��Ű���� ->�����ѷ��� ���� ���� -->
					<span id="spanLoginCheck" class="w3-text-red"></span>
				</p>
				<input type="submit" id="searchBtn2"
					class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-margin-bottom w3-round"
					value="Ȯ��">
				<!-- <button id="searchBtn2" type="button" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round">Ȯ��</button> -->
				<button type="button" onclick="history.go(-1);"
					class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-margin-bottom w3-round">���</button>

			</form>
		</div>
	</div>
</body>
</html>