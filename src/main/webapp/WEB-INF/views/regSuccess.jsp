<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ����������!</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<div style="margin: 100px;">
		<a><img
			src="${pageContext.request.contextPath}/images/Bobbing-logo.png"
			style="height: 80px; margin-left: 10px;" /></a> <br> <br>
		<h3>�ȳ��ϼ���, ${param.userEmail} ��</h3>
		<br>
		<p>ȯ���մϴ�! ������� �پ��� ü���� ��ȸ�� ��������!</p>
		<br>
		<p>ȸ�������� ���������� �̷�� �����ϴ�.</p>
		<br>
		<p>�α��� �Ͻø� Ȩ������ ���� ��� ���񽺸� �̿��Ͻ� �� �ֽ��ϴ�.</p>
		<br> <a href="${pageContext.request.contextPath}/">���� ��������
			�̵��ϱ�</a>
	</div>
</body>
</html>