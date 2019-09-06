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
			if ($.trim($("#user_email").val()) !== $("#user_email").val()) {
				alert("���̵� �Է����ּ���");
				return false;
			}

		})
		//input�� �Էµ� ���� ��ȭ�� ������ alert �� ����.
		$("input[name='user_email']").on("change", function() {
			var user_email = $('#user_email').val();

			//ajax ȣ��

			$.ajax({
				//Default datatype : JS ON
				async : true,
				type : 'POST',
				data : JSON.stringify({
					// ���� - ���� , ���� - �Էµ� ������ �ǹ�
					'user_email' : user_email
				}),
				//��û url
				url : "/emailCheck",
				//controller���� ���������� return ������ ����Ǵ� �޼ҵ带 �Է��մϴ�.
				dataType : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(cnt) {
					if (user_email == "") {
						$("#chktext").css("color", "gray");
						$("#chktext").text("�̸����� �Է����ּ���.");

						$("#chktext2").html("");
					} else if (cnt == 0) {
						$("chktext").css("color", "red");
						$("#chktext").text("ȸ�������� ���� �������ּ���!");
						$("#chktext2").html("");
						$("#joinBtn").attr("disabled", "disabled");
					} else {
						$("#chktext2").css("color", "blue");
						$("#chktext2").text("��밡���մϴ�!!");
						$("#chktext").html("");
						$("#joinBtn").removeAttr("disabled");

					}

				},
				//���� �߻� �� ����Ǵ� �޼ҵ�
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
				<h3>��й�ȣ ã��</h3>
				<p>ȸ�� ���Խ� ����� �̸��� �ּҸ� �Է��Ͻø�</p>
				<p>��й�ȣ �缳�� �ȳ� ������ �����帳�ϴ�.</p>
			</div>
			<form action="user/searchPassword" id="searchBtn2" method="post">

				<p>
					<input type="text" class="w3-input" name="user_email"
						id="user_email" placeholder="example@naver.com"
						required="required">
					<!-- ��⿡ ����� ����(���̵�)�� �����ɴϴ�. ���񽺿��� ��Ű���� ->�����ѷ��� ���� ���� -->
					<span id="chktext" class="w3-text-red"></span> <span id="chktext2"
						class="w3-text-blue"></span>

				</p>
				<button type="submit" id="joinBtn"
					class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-round">����</button>
				<button type="button" onclick="history.go(-1);"
					class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-margin-bottom w3-round">���</button>
				
			</form>
		</div>
	</div>
</body>
</html>