<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ����������!</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<div style="margin: 100px;">
		<div class="w3-content w3-container w3-margin-top">
			<div class="w3-container w3-card-4">
				<div class="w3-center w3-large w3-margin-top">
					<a><img
						src="${pageContext.request.contextPath}/images/Bobbing-logo.png"
						style="height: 80px; margin-left: 10px;" /></a> <br> <br>
					<h3>�ȳ��ϼ���, ${param.user_email} ��</h3>
					<br>
					<p>ȯ���մϴ�! ������� �پ��� ü���� ��ȸ�� ��������!</p>
					<br>
					<p>ȸ�������� ���������� �̷�� �����ϴ�.</p>
					<br>
					<p>�α��� �Ͻø� Ȩ������ ���� ��� ���񽺸� �̿��Ͻ� �� �ֽ��ϴ�.</p>
					<br> <a
						class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-round"
						href="${pageContext.request.contextPath}/">���� �������� �̵��ϱ�</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>