<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- ajax�� ���� CDN ��� ���̺귯�� -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {

		$('#loginBtn').click(function() {
							var userEmail = $('#userEmail').val();
							var pw = $('#inputPassword').val();
							var remember_us = $('#remember_us').is(':checked');
							 $.ajax({
								 
										async : true,
										type : 'POST',
										url : "/logincon",
										data : {
											userEmail : userEmail,
											password : pw,
											remember_userId : remember_us
										},
										success : function(result) {
											if (result == 0) { //�α��� ���н�
												$("#spanLoginCheck").text("�α��� ������ ��Ȯ�� �Է����ּ���.");
												
											} else if (result == -2) { //�������� �ʾҴٸ�?
												console.log(result);
												$('#spanLoginCheck').text(
														'�̸��� ������ ���ּž� �մϴ�!');
											} else if (result == -3) { // ���̵� ������̶��?
												location.href = '${pageContext.request.contextPath}/user/redundant?userEmail='
														+ userEmail
														+ '&password='
														+ password
														+ '&remember_userId='
														+ remember_us;
											} else { //�α��� ������
												location.href = '${pageContext.request.contextPath}/loginss'; //��Ʈ�ѷ��� ȣ���ؼ� ȭ����ȯ
											}
										}
									}); 
						});
	});
</script>	
</head>
<body>
	<!-- Cookie�� ������� ���� �� checked �Ӽ��� �� -->
	<c:if test="${not empty cookie.user_check}">
		<c:set value="checked" var="checked" />
	</c:if>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4">
			<div class="w3-center w3-large w3-margin-top">
				<h3>��� �α��� �׽�Ʈ</h3>
			</div>
			<div>
				 <form  id="login" method="post">
				<!-- <form id="login" method="post"> -->

					<!-- ���ǿ� ������ īī�� ���̵� ������ -->
					<input type="hidden" name="kakao_id" value="${kakao_id}" />
					<p>
						<label>Email</label><br> <input type="text" class="w3-input"
							name="userEmail" id="userEmail" placeholder="Email"
							value="${cookie.user_check.value}" required="required">
						<!-- ��⿡ ����� ����(���̵�)�� �����ɴϴ�. ���񽺿��� ��Ű���� ->�����ѷ��� ���� ���� -->
						<span id="spanLoginCheck"
							class="w3-text-red"></span> 
					</p>
					<p>
						<label>Password</label><br> <input type="password"
							class="w3-input" name="password" id="inputPassword"
							placeholder="Password" required="required"> <span
							id="spanLoginCheck" class="w3-text-red"></span>
					</p>
					<p>
						<label class="font-weight-bold text-white"> <input
							type="checkbox"  id="remember_us" name="remember_userId"
							${checked}> �̸��� ����ϱ� <!-- ���� �������� ���� checked�� ����ǰų� �ȵǰ� �մϴ�. -->
						</label>
					</p>
					<p>
						 <input type="button" id="loginBtn"
							class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round"
							  value="LOGIN"> 
						<a
							class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round"
							href="${pageContext.request.contextPath}/joinForm">JOIN</a>
							<a
							class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round"
							href="${pageContext.request.contextPath}/">HOME</a>
					</p>
					<a href="${pageContext.request.contextPath}/userSearch">&nbsp;
						��й�ȣ ã��</a>
				</form>
				<!-- �Ҽ� �α��� ����  -->
				<div class="form-group socialimage" id="facebookBtn">
					<a href=""> <img
						src="${pageContext.request.contextPath}/images/facebook_big.png"
						width="25%" height="100%" />
					</a>
				</div>
				<div class="form-group socialimage" id="kakaoBtn">
					<a
						href="https://kauth.kakao.com/oauth/authorize?client_id=85f4a0fdfed755ce3d9b2b081af17f44&redirect_uri=http://localhost:8080/MS/kakaologin&response_type=code">
						<img id="socialimage"
						src="${pageContext.request.contextPath}/images/kakao_account_login_btn_medium_narrow (1).png"
						height="100%" align="middle" />
					</a>
				</div>
				<div class="w3-margin-top w3-margin-bottom" id="naverBtn">
					<a href=""> <img
						src="${pageContext.request.contextPath}/images/���̹� ���̵�� �α���_�ϼ���_Green.PNG"
						width="25%" align="middle" height="100%" />
					</a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>