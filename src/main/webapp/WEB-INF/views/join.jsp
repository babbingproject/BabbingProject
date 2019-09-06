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
<!-- ajax�� ���� CDN ��� ���̺귯�� -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#joinForm")
				.submit(
						function() {
							if ($("#pw").val() !== $("#pw2").val()) {
								alert("��й�ȣ�� �ٸ��ϴ�.");
								$("#pw").val("").focus();
								$("#pw2").val("");
								return false;
							} else if ($("#pw").val().length < 8) {
								alert("��й�ȣ�� 8�� �̻����� �����ؾ� �մϴ�.");
								$("#pw").val("").focus();
								$("#pw2").val("");
								return false;
							} else if ($.trim($("#pw").val()) !== $("#pw")
									.val()
									|| $.trim($("#nickname").val()) !== $(
											"#nickname").val()
									|| $.trim($("#userEmail").val()) !== $(
											"#userEmail").val()) {
								alert("������ �Է��� �Ұ����մϴ�.");
								return false;
							}
							alert("���� ������ �߼� �Ͽ����ϴ�. ���� ������ �������ּ���!");
						})

		/* �̸��� üũ */

		//input�� �Էµ� ���� ��ȭ�� ������ alert �� ����.
		$("input[name='userEmail']").on("change", function() {
			var userEmail = $('#userEmail').val();

			//ajax ȣ��

			$.ajax({
				//Default datatype : JS ON
				async : true,
				type : 'POST',
				data : JSON.stringify({
					// ���� - ���� , ���� - �Էµ� ������ �ǹ�
					'userEmail' : userEmail
				}),
				//��û url
				url : "/emailCheck",
				//controller���� ���������� return ������ ����Ǵ� �޼ҵ带 �Է��մϴ�.
				dataType : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(cnt) {
					if (userEmail == "") {
						$("#chktext").css("color", "gray");
						$("#chktext").text("�̸����� �Է����ּ���.");

						$("#chktext2").html("");
					} else if (cnt == 0) {
						$("#chktext2").css("color", "blue");
						$("#chktext2").text("��� ������ �̸��� �Դϴ�.");
						$("#chktext").html("");
						$("#joinBtn").removeAttr("disabled");
					} else {
						$("chktext").css("color", "red");
						$("#chktext").text("�̹� ������� �̸��� �Դϴ�.");
						$("#chktext2").html("");
						$("#joinBtn").attr("disabled", "disabled");

					}

				},
				//���� �߻� �� ����Ǵ� �޼ҵ�
				error : function(error) {

					alert("error :" + error);

				}
			});
		});
	});

	/*�г��� üũ  */

	$(function() {
		//input�� �Էµ� ���� ��ȭ�� ������ alert �� ����.
		$("input[name='nickname']").on("change", function() {
			var nickname = $('#nickname').val();

			//ajax ȣ��

			$.ajax({
				//Default datatype : JS ON
				async : true,
				type : 'POST',
				data : JSON.stringify({
					// ���� - ���� , ���� - �Էµ� ������ �ǹ�
					'nickname' : nickname
				}),
				//��û url
				url : "/nickCheck",
				//controller���� ���������� return ������ ����Ǵ� �޼ҵ带 �Է��մϴ�.
				dataType : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(cnt) {
					if (nickname == "") {
						$("#chktext").css("color", "gray");
						$("#nickchktext").text("�г����� �Է����ּ���.");

						$("#nickchktext2").html("");
					} else if (cnt == 0) {
						$("#nickchktext2").css("color", "blue");
						$("#nickchktext2").text("��� ������ �г��� �Դϴ�.");
						$("#nickchktext").html("");
						$("#joinBtn").removeAttr("disabled");
					} else {
						$("#nickchktext").css("color", "red");
						$("#nickchktext").text("�̹� ������� �г��� �Դϴ�.");
						$("#nickchktext2").html("");
						$("#joinBtn").attr("disabled", "disabled");

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
				<h3>��� ȸ������ �׽�Ʈ</h3>
			</div>
			<div>

				<form id="joinForm" action="/join" method="post">
					<!-- ���ǿ� ������ īī�� ���̵� ������ -->
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