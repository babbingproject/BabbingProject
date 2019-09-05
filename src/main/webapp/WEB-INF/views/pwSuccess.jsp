<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��й�ȣ��ú���</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- ajax�� ���� CDN ��� ���̺귯�� -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#modify").submit(
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
					} 
					alert("�ű� ��й�ȣ�� ���� �Ϸ�Ǿ����ϴ�!");
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
					<h3>��й�ȣ�� �����Ͻðھ��?</h3>
					<p>���ο� ��й�ȣ�� �Է����ּ���</p>
					<div>
						<form id="modify" action="/pwUpdate" method="post">

							<p>
								<input type="hidden" value="${sessionScope.signedUser }"
									name="userEmail"> <input type="password"
									class="w3-input" name="password" id="pw" placeholder="�� ��й�ȣ"
									required="required">
							</p>
							<p>
								<input type="password" class="w3-input" id="pw2"
									placeholder="��й�ȣ Ȯ��" required="required">
							</p>
							<p>
								<button type="submit" id="modify"
									class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-round">��й�ȣ
									����</button>
								<br>
						</form>
					</div>
				</div>
				<br> <a href="${pageContext.request.contextPath}/">���� ��������
					�̵��ϱ�</a>
			</div>
		</div>

	</div>
</body>
</html>